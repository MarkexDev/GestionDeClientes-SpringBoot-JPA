INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Marcos','Garcia','marcosgarcia@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Jennifer','Suarez','jennni@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Maria','Lopez','mariaaaLop@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Monica','Cervantes','cervantezMonica@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Carlos','Torres','torresdiez@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Genaro','Pacheco','geenn@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Diana','Lara','dianitalara@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Mauricio','Contreras','mauu2023@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Michelle','Hernandez','michellehrz23@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Carlos','Trejo','cazafantasmas@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Kristell','Gonzales','kristy235@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Jose','Alvarez','pepepepe346@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Juan','Morales','moralesjuan3456@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Monica','Suarez','mony456er@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Ximena','Mendez','ximeeena346@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Luis','Suarez','futbolito234s@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Esteban','Dido','estebanprogrammer@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Maria','Rosales','rosales345ex@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Guadalupe','Estevez','lupeeeetz@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Andres','Astilleros','andresastilleros@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Ana','Garcia','anitaagrc@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Crissed','Suarez','crissedacademy@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Enrique','Iglesias','enriquemusic@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Brayan','Ockenel','ockenelorg@example.com','2023-11-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Lucy','Sanz','lucyinterprice@example.com','2023-11-03', '');

/*Elementos para la tabla Productos*/
INSERT INTO productos(nombre, precio, create_at) VALUES ('Panasonic Pantalla LCD', 25990, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Sony Camara Digital DSC-W320B', 17890, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Smartphone Poco X5 PRO', 5200, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Bocina Kaiser Model 345', 3450, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Laptop Lenovo Legion 5', 22500, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Impresora Brother E-2345', 6700, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Smartphone iphone 13', 15900, NOW());

/*Elementos para la tabla Facturas*/
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura equipos de oficina', '', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura de celulares', 'Venta a coppel', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (4, 2, 3);
