CREATE table category(

id IDENTITY,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY (id)


);

INSERT INTO category (name, description, image_url, is_active) values('Mobile', 'this the discription of Mobile','CAT_3.png', 'true');




CREATE TABLE user_detail (
id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
password VARCHAR(50),
email VARCHAR(100),
contact_number VARCHAR(15),
CONSTRAINT pk_user_id PRIMARY KEY(id),

);

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('shrutika', 'mohite', 'ADMIN', 'true', 'admin', 'shrutikamohite@gmail.com', '123456789');

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('prashant', 'desai', 'SUPPLIER', 'true', 'supplier', 'prashantdesai@gmail.com', '123456789');

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('chinu', 'mohite', 'SUPPLIER', 'true', 'Supplier', 'chinumohite@gmail.com', '123456789');


CREATE TABLE product(

id identity,
code varchar(50),
name varchar(50),
brand varchar(50),
description varchar(300),
unit_price decimal(10,2),
quantity int,
is_active boolean,
category_id int,
supplier_id int,
purchases int default 0,
views int,
constraint pk_product_id primary key (id),
constraint fk_product_catgory_id foreign key (category_id) references category (id),
constraint fk_product_supplier_id foreign key (supplier_id) references user_detail (id),

);

insert into product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, puechases)
values('*********','iphone 5s', 'apple', 'this is one of the best phone', '10000', '5', 'true', '111', '222', '3');

insert into product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, puechases)
values('*********','iphone 6s', 'apple', 'this is one of the best phone', '15000', '5', 'true', '333', '444', '2');

insert into product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, puechases)
values('*********','iphone 7s', 'apple', 'this is one of the best phone', '20000', '5', 'true', '555', '666', '1');





