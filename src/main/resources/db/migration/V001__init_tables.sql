CREATE TABLE portfolios
(
    id          UUID PRIMARY KEY,
    owner_id    UUID           NOT NULL,
    name        VARCHAR(150)   NOT NULL,
    total_value NUMERIC(19, 4) NOT NULL,
    created_at  TIMESTAMP(6)   NOT NULL,
    updated_at  TIMESTAMP(6)   NOT NULL
);

CREATE TABLE assets
(
    id             UUID PRIMARY KEY,
    portfolio_id   UUID           NOT NULL,
    name           VARCHAR(150)   NOT NULL,
    broker         VARCHAR(50),
    currency       VARCHAR(10)    NOT NULL,
    market         VARCHAR(50),
    ticker         VARCHAR(10),
    type           VARCHAR(20)    NOT NULL CHECK (type IN ('STOCK', 'BOND', 'COMMODITY', 'CRYPTO', 'ETF', 'MUTUAL_FUND')),
    total_quantity NUMERIC(19, 4) NOT NULL,
    last_updated   TIMESTAMP(6)   NOT NULL,
    CONSTRAINT fk_assets_portfolio FOREIGN KEY (portfolio_id) REFERENCES portfolios (id) ON DELETE CASCADE
);

CREATE TABLE transactions
(
    id             UUID PRIMARY KEY,
    asset_id       UUID           NOT NULL,
    type           VARCHAR(10)    NOT NULL CHECK (type IN ('BUY', 'SELL')),
    quantity       NUMERIC(19, 4) NOT NULL,
    price_per_unit NUMERIC(19, 4) NOT NULL,
    date           TIMESTAMP(6)   NOT NULL,
    CONSTRAINT fk_transactions_asset FOREIGN KEY (asset_id) REFERENCES assets (id) ON DELETE CASCADE
);

CREATE TABLE portfolio_allocations
(
    id            UUID PRIMARY KEY,
    portfolio_id  UUID           NOT NULL,
    asset_type    VARCHAR(20)    NOT NULL CHECK (asset_type IN ('STOCK', 'BOND', 'COMMODITY', 'CRYPTO', 'ETF', 'MUTUAL_FUND')),
    percentage    NUMERIC(19, 4) NOT NULL,
    CONSTRAINT fk_portfolio_allocations_portfolio FOREIGN KEY (portfolio_id) REFERENCES portfolios (id) ON DELETE CASCADE
)