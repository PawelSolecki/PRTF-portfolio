DO
$$
    BEGIN
        IF current_setting('app.mock_data', true) = 'true' THEN



            INSERT INTO public.portfolios (id, owner_id, name, created_at, updated_at)
            VALUES ('483ba27f-80b3-4336-bd8b-eee6c1929aa9', '5f2d4a8d-3028-48a7-b389-e68ab9be020e', 'Long term',
                    '2025-08-08 08:03:26.445798', '2025-08-08 09:39:28.261495'),
                   ('56d536dd-c9a4-448e-b9fd-1705830f7ac5', '5f2d4a8d-3028-48a7-b389-e68ab9be020e', 'Short term',
                    '2025-08-08 08:03:59.164169', '2025-08-08 09:46:48.497965');


            INSERT INTO public.assets (id, portfolio_id, name, broker, currency, market, ticker, type,
                                       total_quantity, price_per_unit, last_updated, total_cost)
            VALUES ('8bbfba2a-a196-448d-a877-d2f01d5ac341', '483ba27f-80b3-4336-bd8b-eee6c1929aa9',
                    'iShares Core S&P 500', 'XTB', '0', 'LSE', 'CSPX', 'ETF', 20.0000, 460.0000,
                    '2025-08-08 09:36:14.525105', 7875.0000),
                   ('758fe388-b0d1-4406-83b4-c0bef8708e7d', '483ba27f-80b3-4336-bd8b-eee6c1929aa9', 'złoto', '-', '0',
                    'METALS', 'AU', 'COMMODITY', 3.5000, 2000.0000, '2025-08-08 09:39:28.260336', 6580.0000),
                   ('a9b6405b-414f-43d3-8449-0e79871d96ea', '56d536dd-c9a4-448e-b9fd-1705830f7ac5', 'CD Projekt',
                    'mBank', '2', 'GPW', 'CDR', 'STOCK', 50.0000, 160.0000, '2025-08-08 09:45:36.340202', 7500.0000),
                   ('ec4c2e2e-0626-49c5-a401-e167a70d29f5', '56d536dd-c9a4-448e-b9fd-1705830f7ac5', 'Bitcoin',
                    'Binance', '0', 'CRYPTO', 'BTC', 'CRYPTO', 0.2000, 40000.0000, '2025-08-08 09:46:48.488496',
                    7000.0000);


            INSERT INTO public.portfolio_allocations (id, portfolio_id, asset_type, percentage)
            VALUES ('fbf34ee6-9c5b-4a7f-ad0d-9a8f558261e6', '483ba27f-80b3-4336-bd8b-eee6c1929aa9', 'COMMODITY',
                    50.0000),
                   ('b43c77ed-e748-46f3-9198-89c372cae79a', '483ba27f-80b3-4336-bd8b-eee6c1929aa9', 'ETF', 50.0000),
                   ('87869ea0-ae62-4205-9f38-04835968c432', '56d536dd-c9a4-448e-b9fd-1705830f7ac5', 'STOCK', 20.0000),
                   ('4bf33af4-adcc-45c7-a3a4-0f28782a1195', '56d536dd-c9a4-448e-b9fd-1705830f7ac5', 'CRYPTO', 80.0000);


            INSERT INTO public.portfolio_total_values (id, portfolio_id, currency, value)
            VALUES ('286ae0a3-64d9-420b-8360-29f8b3b4cce4', '483ba27f-80b3-4336-bd8b-eee6c1929aa9', 0, 16200.0000),
                   ('0aa25d24-3b51-48f0-94cf-0c7e551361b3', '56d536dd-c9a4-448e-b9fd-1705830f7ac5', 0, 8000.0000),
                   ('a8e5f322-f0a0-45fd-a0db-7b510e284681', '56d536dd-c9a4-448e-b9fd-1705830f7ac5', 2, 8000.0000);



            INSERT INTO public.transactions (id, asset_id, type, quantity, price_per_unit, date)
            VALUES ('7342fe1c-4d34-40e9-96b2-84b49f7c9c25', '8bbfba2a-a196-448d-a877-d2f01d5ac341', 'BUY', 15.0000,
                    400.0000, '2023-04-10 12:00:00'),
                   ('08fe8e51-a3d0-40fe-be10-48478fbd82dd', '8bbfba2a-a196-448d-a877-d2f01d5ac341', 'BUY', 10.0000,
                    450.0000, '2024-02-15 12:00:00'),
                   ('894f00b0-5f8c-40dd-b951-3ec095629c5b', '8bbfba2a-a196-448d-a877-d2f01d5ac341', 'SELL', 5.0000,
                    450.0000, '2025-12-01 12:00:00'),
                   ('28508354-0a04-483d-955b-adbb037d2ae4', '758fe388-b0d1-4406-83b4-c0bef8708e7d', 'BUY', 2.0000,
                    1850.0000, '2023-05-03 12:00:00'),
                   ('a4b3173e-501a-4a12-a319-f565c8fc6222', '758fe388-b0d1-4406-83b4-c0bef8708e7d', 'BUY', 1.5000,
                    1920.0000, '2025-03-01 12:00:00'),
                   ('4d274daf-3e74-46d7-853d-1710218a6309', 'a9b6405b-414f-43d3-8449-0e79871d96ea', 'BUY', 50.0000,
                    150.0000, '2024-07-04 12:00:00'),
                   ('cdb3bb63-9879-437c-b919-09c40a3083b9', 'ec4c2e2e-0626-49c5-a401-e167a70d29f5', 'BUY', 0.2000,
                    35000.0000, '2024-10-04 12:00:00');


        END
            IF;
    END
$$;
