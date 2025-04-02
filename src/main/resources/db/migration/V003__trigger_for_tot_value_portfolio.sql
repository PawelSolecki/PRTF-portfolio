CREATE OR REPLACE FUNCTION update_portfolio_total_value()
    RETURNS TRIGGER AS
$$
DECLARE
    portfolio_uuid UUID;
BEGIN
    IF (TG_OP = 'DELETE') THEN
        portfolio_uuid := OLD.portfolio_id;
    ELSE
        portfolio_uuid := NEW.portfolio_id;
    END IF;

    UPDATE portfolios
    SET total_value = (SELECT COALESCE(SUM(total_quantity * price_per_unit), 0)
                       FROM assets
                       WHERE portfolio_id = portfolio_uuid),
        updated_at  = NOW()
    WHERE id = portfolio_uuid;

    RETURN NULL;
END;
$$ language plpgsql;

CREATE TRIGGER trigger_update_portfolio_value
    AFTER INSERT OR UPDATE OR DELETE
    ON assets
    FOR EACH ROW
EXECUTE FUNCTION update_portfolio_total_value();