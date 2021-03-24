CREATE TABLE person (
id serial primary key,
name varchar(128)
)

ALTER TABLE product add column person_id integer references person(id);

INSERT INTO person (name) VALUES ('Arina');
INSERT INTO person (name) VALUES ('Maria');
INSERT INTO person (name) VALUES ('Alexey');
INSERT INTO person (name) VALUES ('Ivan');

INSERT INTO product (name, price, person_id) VALUES ('coat', '5000', '1');
INSERT INTO product (name, price, person_id) VALUES ('shoes', '3000', '2');
INSERT INTO product (name, price, person_id) VALUES ('shirt', '2500', '3');
INSERT INTO product (name, price, person_id) VALUES ('trousers', '4000', '4');

SELECT * FROM product LEFT JOIN person ON product.person_id = person.id;