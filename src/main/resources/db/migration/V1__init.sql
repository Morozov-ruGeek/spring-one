BEGIN;

DROP TABLE IF EXISTS products_category CASCADE;
CREATE TABLE products_category (id bigserial PRIMARY KEY, title VARCHAR(255));
INSERT INTO products_category (title) VALUES
('Food'),
('Household chemicals'),
('Clothing');

DROP TABLE IF EXISTS products_info CASCADE;
CREATE TABLE products_info (id bigserial PRIMARY KEY, title VARCHAR(255), price int, category_id bigint, FOREIGN KEY (category_id) REFERENCES products_category(id));
INSERT INTO products_info (title, price, category_id) VALUES
('Milk', 80, 1),
('Bread', 90, 1),
('Chees', 40, 3),
('T-short', 75, 3),
('Jeans', 70, 3),
('Soap', 90, 2);

COMMIT;