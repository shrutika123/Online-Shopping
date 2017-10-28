CREATE table category(

id IDENTITY,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY (id)


);

INSERT INTO category (name, description, image_url, is_active) values('Mobile', 'this the discription of Mobile','Mobile-Phones.jpg', 'true');

INSERT INTO category (name, description, image_url, is_active) values('Laptop', 'this the discription of Laptop','laptop.png', 'true');

INSERT INTO category (name, description, image_url, is_active) values('Television', 'this the discription of Television','television.jpg', 'true');




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
views int default 0,
constraint pk_product_id primary key (id),
constraint fk_product_category_id foreign key (category_id) references category (id),
constraint fk_product_supplier_id foreign key (supplier_id) references user_detail (id),

);

insert into product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
values('M_1','Samsung Galaxy J2', 'Samsung', '1 GB RAM | 8 GB ROM | Expandable Upto 128 GB', '10000', '5', 'true', '1', '2', '0','0');


insert into product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
values('L_1','HP 15 Core i3 6th Gen ', 'HP', 'Intel Core i3 Processor (6th Gen)
8 GB DDR4 RAM
DOS Operating System
1 TB HDD', '31000', '5', 'true', '2', '2', '0','0');


insert into product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
values('T_1','Samsung 80cm (32 inch)', 'Samsung', '10 W Speaker Output Optimal sound
1366 x 768 HD Ready - Great picture quality
60 Hz : Standard refresh rate for blur-free picture quality
2 x HDMI : For set top box and consoles
1 x USB : Get content from USB drives', '20000', '5', 'true', '3', '2', '0','0');




