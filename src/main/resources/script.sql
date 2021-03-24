CREATE TABLE person (
id serial primary key,
name varchar(128)
)

ALTER TABLE person add column product_id integer references product(id);

INSERT INTO person (name, product_id) VALUES ('Arina', '1');
INSERT INTO person (name, product_id) VALUES ('Maria', '4');
INSERT INTO person (name, product_id) VALUES ('Alexey', '5');
INSERT INTO person (name, product_id) VALUES ('Ivan', '6');

INSERT INTO product (name, price) VALUES ('coat', '5000');
INSERT INTO product (name, price) VALUES ('shoes', '3000');
INSERT INTO product (name, price) VALUES ('shirt', '2500');
INSERT INTO product (name, price) VALUES ('trousers', '4000');

SELECT * FROM person LEFT JOIN product ON person.product_id = product.id;