CREATE OR REPLACE FUNCTION update_asset_quantity()
    RETURNS TRIGGER AS
$$
BEGIN
    -- Obsługa DELETE: cofnij efekt starej transakcji
    IF (TG_OP = 'DELETE') THEN
        IF OLD.type = 'BUY' THEN
            UPDATE assets
            SET total_quantity = total_quantity - OLD.quantity,
                last_updated   = NOW()
            WHERE id = OLD.asset_id;
        ELSIF OLD.type = 'SELL' THEN
            UPDATE assets
            SET total_quantity = total_quantity + OLD.quantity,
                last_updated   = NOW()
            WHERE id = OLD.asset_id;
        END IF;
        RETURN OLD;

        -- Obsługa INSERT: zastosuj nową transakcję
    ELSIF (TG_OP = 'INSERT') THEN
        IF NEW.type = 'BUY' THEN
            UPDATE assets
            SET total_quantity = total_quantity + NEW.quantity,
                last_updated   = NOW()
            WHERE id = NEW.asset_id;
        ELSIF NEW.type = 'SELL' THEN
            UPDATE assets
            SET total_quantity = total_quantity - NEW.quantity,
                last_updated   = NOW()
            WHERE id = NEW.asset_id;
        END IF;
        RETURN NEW;

        -- Obsługa UPDATE: cofnij starą transakcję, zastosuj nową
    ELSIF (TG_OP = 'UPDATE') THEN
        -- Cofnij starą transakcję na starym asset_id
        IF OLD.type = 'BUY' THEN
            UPDATE assets
            SET total_quantity = total_quantity - OLD.quantity,
                last_updated   = NOW()
            WHERE id = OLD.asset_id;
        ELSIF OLD.type = 'SELL' THEN
            UPDATE assets
            SET total_quantity = total_quantity + OLD.quantity,
                last_updated   = NOW()
            WHERE id = OLD.asset_id;
        END IF;

        -- Zastosuj nową transakcję na nowym asset_id
        IF NEW.type = 'BUY' THEN
            UPDATE assets
            SET total_quantity = total_quantity + NEW.quantity,
                last_updated   = NOW()
            WHERE id = NEW.asset_id;
        ELSIF NEW.type = 'SELL' THEN
            UPDATE assets
            SET total_quantity = total_quantity - NEW.quantity,
                last_updated   = NOW()
            WHERE id = NEW.asset_id;
        END IF;
        RETURN NEW;
    END IF;
END;
$$ language plpgsql;

-- Utwórz trigger dla wszystkich operacji na tabeli transactions
CREATE TRIGGER trigger_update_asset_quantity
    AFTER INSERT OR UPDATE OR DELETE
    ON transactions
    FOR EACH ROW
EXECUTE FUNCTION update_asset_quantity();