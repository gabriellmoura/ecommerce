DROP TABLE IF EXISTS inventory;
CREATE TABLE IF NOT EXISTS inventory (id INT NOT NULL AUTO_INCREMENT, product_id INT NOT NULL UNIQUE, quantity INT NOT NULL default 0, PRIMARY KEY (id, product_id));