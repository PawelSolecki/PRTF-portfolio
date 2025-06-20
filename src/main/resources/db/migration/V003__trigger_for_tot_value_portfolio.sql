CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

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

    -- Delete existing total values for the portfolio
    DELETE FROM portfolio_total_values
    WHERE portfolio_id = portfolio_uuid;

    -- Insert updated total values for each currency
    INSERT INTO portfolio_total_values (id, portfolio_id, currency, value)
    SELECT
        uuid_generate_v4(),
        portfolio_id,
        currency,
        COALESCE(SUM(total_quantity * price_per_unit), 0) AS value
    FROM assets
    WHERE portfolio_id = portfolio_uuid
    GROUP BY portfolio_id, currency;

    -- Update the portfolio's updated_at timestamp
    UPDATE portfolios
    SET updated_at = NOW()
    WHERE id = portfolio_uuid;

    RETURN NULL;
END;
$$ language plpgsql;

-- Update the trigger to use the modified function
CREATE TRIGGER trigger_update_portfolio_value
    AFTER INSERT OR UPDATE OR DELETE
    ON assets
    FOR EACH ROW
EXECUTE FUNCTION update_portfolio_total_value();