-- Insertando datos de prueba para la tabla City
INSERT INTO city (name) VALUES ('New York');
INSERT INTO city (name) VALUES ('Los Angeles');
INSERT INTO city (name) VALUES ('Chicago');

-- Insertando datos de prueba para la tabla Product Range
INSERT INTO product_ranges (name, description, image) VALUES ('Electronics', 'Electronic devices and gadgets', 'electronics.jpg');
INSERT INTO product_ranges (name, description, image) VALUES ('Furniture', 'Home and office furniture', 'furniture.jpg');
INSERT INTO product_ranges (name, description, image) VALUES ('Clothing', 'Men and women clothing', 'clothing.jpg');

-- Insertando datos de prueba para la tabla Status
INSERT INTO status (status_name) VALUES ('Pending');
INSERT INTO status (status_name) VALUES ('Shipped');
INSERT INTO status (status_name) VALUES ('Delivered');

-- Insertando datos de prueba para la tabla Payment Method
INSERT INTO payment_method (method_name) VALUES ('Credit Card');
INSERT INTO payment_method (method_name) VALUES ('PayPal');
INSERT INTO payment_method (method_name) VALUES ('Bank Transfer');

-- Insertando datos de prueba para la tabla Address
INSERT INTO address (address_line1, address_line2, city_code_d) VALUES ('123 Main St', 'Apt 1', 1);
INSERT INTO address (address_line1, address_line2, city_code_d) VALUES ('456 Elm St', NULL, 2);
INSERT INTO address (address_line1, address_line2, city_code_d) VALUES ('789 Oak St', 'Suite 5', 3);

-- Insertando datos de prueba para la tabla Office
INSERT INTO office (address_code_o) VALUES (1);
INSERT INTO office (address_code_o) VALUES (2);
INSERT INTO office (address_code_o) VALUES (3);

-- Insertando datos de prueba para la tabla Employee
INSERT INTO employee (first_name, last_name1, last_name2, email, office_code) VALUES ('John', 'Doe', 'Smith', 'john.doe@example.com', 1);
INSERT INTO employee (first_name, last_name1, last_name2, email, office_code) VALUES ('Jane', 'Roe', 'Johnson', 'jane.roe@example.com', 2);
INSERT INTO employee (first_name, last_name1, last_name2, email, office_code) VALUES ('Alice', 'Brown', NULL, 'alice.brown@example.com', 3);

-- Insertando datos de prueba para la tabla Customer
INSERT INTO customer (first_name, last_name1, last_name2, email, city_code_c, address_code_c, sales_rep_employee_code) VALUES ('Michael', 'Smith', 'Jones', 'michael.smith@example.com', 1, 1, 1);
INSERT INTO customer (first_name, last_name1, last_name2, email, city_code_c, address_code_c, sales_rep_employee_code) VALUES ('Emily', 'Davis', 'Wilson', 'emily.davis@example.com', 2, 2, 2);
INSERT INTO customer (first_name, last_name1, last_name2, email, city_code_c, address_code_c, sales_rep_employee_code) VALUES ('David', 'Clark', 'Taylor', 'david.clark@example.com', 3, 3, 3);

-- Insertando datos de prueba para la tabla Phone
INSERT INTO phones (number, customer_code_ph, office_code_ph) VALUES (1234567890, 1, 3);
INSERT INTO phones (number, customer_code_ph, office_code_ph) VALUES (987654321, 2, 2);
INSERT INTO phones (number, customer_code_ph, office_code_ph) VALUES (555555555, NULL, 1);

-- Insertando datos de prueba para la tabla Payment
INSERT INTO payment (payment_date, total, payment_method_code, customer_code_pa) VALUES ('2024-08-01', 150.00, 1, 1);
INSERT INTO payment (payment_date, total, payment_method_code, customer_code_pa) VALUES ('2024-08-02', 250.00, 2, 2);
INSERT INTO payment (payment_date, total, payment_method_code, customer_code_pa) VALUES ('2024-08-03', 100.00, 3, 3);

-- Insertando datos de prueba para la tabla n_order
INSERT INTO n_order (order_date, expected_date, delivery_date, customer_code_or, comment, status_code_or) VALUES ('2024-08-01', '2024-08-05', NULL, 1, 'Urgent order', 1);
INSERT INTO n_order (order_date, expected_date, delivery_date, customer_code_or, comment, status_code_or) VALUES ('2024-08-02', '2024-08-06', '2024-08-05', 2, 'Standard order', 2);
INSERT INTO n_order (order_date, expected_date, delivery_date, customer_code_or, comment, status_code_or) VALUES ('2024-08-03', '2024-08-07', NULL, 3, 'Special request', 3);

-- Insertando datos de prueba para la tabla product
INSERT INTO products (name, stock_quantity, sale_price, product_description, range_code, dimensions) VALUES ('Smart TV', 50, 899.99, '55-inch Smart TV with 4K resolution and HDR', 1, '55 inches');
INSERT INTO products (name, stock_quantity, sale_price, product_description, range_code, dimensions) VALUES ('Gaming Monitor', 25, 299.99, '27-inch monitor with 144Hz refresh rate and 1ms response time', 1, '27 inches');
INSERT INTO products (name, stock_quantity, sale_price, product_description, range_code) VALUES ('Wireless Mouse', 120, 49.99, 'Ergonomic wireless mouse with adjustable DPI settings', 2);

-- Insertando datos de prueba para la tabla Order Detail
INSERT INTO order_detail (product_id_order, order_id_product, quantity, unit_price) VALUES (1, 1, 2, 50.00);
INSERT INTO order_detail (product_id_order, order_id_product, quantity, unit_price) VALUES (2, 2, 1, 150.00);
INSERT INTO order_detail (product_id_order, order_id_product, quantity, unit_price) VALUES (3, 3, 3, 75.00);

INSERT INTO users (enabled, password, username) VALUES (1, "$2a$10$8bZuKCxVocfyuJBSYr/13etINGRhMjYGizlPzG3yDnTqzAVqTFTbG", 'duvan'), (1, "$2a$10$8bZuKCxVocfyuJBSYr/13etINGRhMjYGizlPzG3yDnTqzAVqTFTbG", 'alexis'),(1, "$2a$10$8bZuKCxVocfyuJBSYr/13etINGRhMjYGizlPzG3yDnTqzAVqTFTbG", 'maritza');
INSERT INTO roles (name) VALUES ('ROLE_USER'),('ROLE_ADMIN'),('ROLE_MANAGER');
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1),(1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1),(2, 3),(2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 2),(3, 1);