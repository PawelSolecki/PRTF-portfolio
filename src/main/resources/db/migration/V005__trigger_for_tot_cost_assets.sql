-- Function to update total_cost in assets
CREATE OR REPLACE FUNCTION update_asset_total_cost()
    RETURNS TRIGGER AS
$$
BEGIN
    -- Handle DELETE: reverse the effect of the old transaction
    IF (TG_OP = 'DELETE') THEN
        IF OLD.type = 'BUY' THEN
            UPDATE assets
            SET total_cost = total_cost - (OLD.quantity * OLD.price_per_unit),
                last_updated = NOW()
            WHERE id = OLD.asset_id;
        ELSIF OLD.type = 'SELL' THEN
            UPDATE assets
            SET total_cost = total_cost + (OLD.quantity * (total_cost / total_quantity)),
                last_updated = NOW()
            WHERE id = OLD.asset_id;
        END IF;
        RETURN OLD;

        -- Handle INSERT: apply the new transaction
    ELSIF (TG_OP = 'INSERT') THEN
        IF NEW.type = 'BUY' THEN
            UPDATE assets
            SET total_cost = total_cost + (NEW.quantity * NEW.price_per_unit),
                last_updated = NOW()
            WHERE id = NEW.asset_id;
        ELSIF NEW.type = 'SELL' THEN
            UPDATE assets
            SET total_cost = total_cost - (NEW.quantity * (total_cost / total_quantity)),
                last_updated = NOW()
            WHERE id = NEW.asset_id;
        END IF;
        RETURN NEW;

        -- Handle UPDATE: reverse the old transaction, apply the new one
    ELSIF (TG_OP = 'UPDATE') THEN
        IF OLD.type = 'BUY' THEN
            UPDATE assets
            SET total_cost = total_cost - (OLD.quantity * OLD.price_per_unit)
            WHERE id = OLD.asset_id;
        ELSIF OLD.type = 'SELL' THEN
            UPDATE assets
            SET total_cost = total_cost + (OLD.quantity * (total_cost / total_quantity))
            WHERE id = OLD.asset_id;
        END IF;

        IF NEW.type = 'BUY' THEN
            UPDATE assets
            SET total_cost = total_cost + (NEW.quantity * NEW.price_per_unit),
                last_updated = NOW()
            WHERE id = NEW.asset_id;
        ELSIF NEW.type = 'SELL' THEN
            UPDATE assets
            SET total_cost = total_cost - (NEW.quantity * (total_cost / total_quantity)),
                last_updated = NOW()
            WHERE id = NEW.asset_id;
        END IF;
        RETURN NEW;
    END IF;
END;
$$ LANGUAGE plpgsql;

-- Trigger for the transactions table
CREATE TRIGGER trigger_update_asset_total_cost
    AFTER INSERT OR UPDATE OR DELETE
    ON transactions
    FOR EACH ROW
EXECUTE FUNCTION update_asset_total_cost();