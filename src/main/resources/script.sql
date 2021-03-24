CREATE TABLE person (
id serial primary key,
name varchar(128)
)

ALTER TABLE product add column person_id integer references person(id);

INSERT INTO person (name) VALUES ('Arina');
INSERT INTO person (name) VALUES ('Maria');
INSERT INTO person (name) VALUES ('Alexey');
INSERT INTO person (name) VALUES ('Ivan');

INSERT INTO product (name, price) VALUES ('coat', '5000');
INSERT INTO product (name, price) VALUES ('shoes', '3000');
INSERT INTO product (name, price) VALUES ('shirt', '2500');
INSERT INTO product (name, price) VALUES ('trousers', '4000');
INSERT INTO product (name, price) VALUES ('snikers', '4500');
INSERT INTO product (name, price) VALUES ('shirt', '2500');

CREATE TABLE person_product (
person_id integer REFERENCES person(id),
product_id integer REFERENCES product(id)
)

INSERT INTO person_product (person_id, product_id) VALUES ('1', '13');
INSERT INTO person_product (person_id, product_id) VALUES ('3', '18');
INSERT INTO person_product (person_id, product_id) VALUES ('4', '15');
INSERT INTO person_product (person_id, product_id) VALUES ('5', '13');
INSERT INTO person_product (person_id, product_id) VALUES ('1', '16');
INSERT INTO person_product (person_id, product_id) VALUES ('4', '17');

