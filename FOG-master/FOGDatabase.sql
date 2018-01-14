


DROP DATABASE IF EXISTS fog;
CREATE DATABASE fog;
USE fog;
DROP TABLE IF EXISTS Customer;

CREATE TABLE Customer (

customerID int AUTO_INCREMENT PRIMARY KEY,
usertype int (255),
firstName varchar(255),
lastName varchar(255),
username varchar (255),
password varchar(255),
address varchar(255),
zipcode int(255),
email varchar(255),
phoneNumber varchar(255)
);


DROP TABLE IF EXISTS Admin;
CREATE TABLE Admin(

adminID int AUTO_INCREMENT PRIMARY KEY,
usertype int(255),
username varchar(255),
password varchar(255)
);


DROP TABLE IF EXISTS Products;
CREATE TABLE Products(

productID int auto_increment PRIMARY KEY,
category varchar(255),
subCategory varchar(255),
productName varchar(255),
productHeight varchar(255),
productLength varchar(255),
productPrice int (100)
);


DROP TABLE IF EXISTS Carport;
CREATE TABLE Carport(

carportID int auto_increment PRIMARY KEY,
carportName varchar(250),
carportWidth int,
carportLength int,
carportHeight int, 
roofSlope int,
woodID int,
woodPrice int,
plankHeight int,
plankLength int,
woodColorID int(100),
totalPlankAmount int,
plankScrewAmount int,
eaveID int,
eavePrice int,
eaveWidth int,
eaveLength int,
eaveColorID int(100),
eaveAmount int,
eaveScrewAmount int,
totalScrewAmount int,
totalPrice int,




FOREIGN KEY (woodID) REFERENCES Products (productID),
FOREIGN KEY (eaveID) REFERENCES Products (productID),
FOREIGN KEY (woodColorID) REFERENCES Products (productID),
FOREIGN KEY (eaveColorID) REFERENCES Products (productID)
);

INSERT INTO Customer VALUES (0,2,'Walter','White','Test','1234','Røvballehus','8585','Walter-white@gmail.com','85858585');


DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders(
orderID int auto_increment PRIMARY KEY,
customerID int,


FOREIGN KEY (customerID) REFERENCES Customer (customerID)
ON DELETE CASCADE
);

DROP TABLE IF EXISTS OrderDetails;

CREATE TABLE OrderDetails(
orderDetailID int auto_increment PRIMARY KEY,
carportID int,
orderID int,
quantity int,
totalPrice int,
orderTotalPrice int,
orderStatus ENUM ('godkendt','afventer','afvist') DEFAULT 'afventer',
orderDate datetime NOT NULL DEFAULT NOW(),

FOREIGN KEY (orderID) REFERENCES Orders (orderID)
ON DELETE CASCADE,
FOREIGN KEY (carportID) REFERENCES Carport(carportID)

);


INSERT INTO Admin VALUES (0,1,'admin','1234');


INSERT into Products VALUES (0, 'Træ', 'Træsort/planker', 'Felwood', 10, 50, 100);
INSERT into Products VALUES (0, 'Træ', 'Træsort/planker', 'Starwood', 10, 50 ,25);
INSERT into Products VALUES (0, 'Træ', 'Træsort/planker', 'Simple wood', 10, 50 ,5);
INSERT into Products VALUES (0, 'Træ', 'Træsort/planker', 'Elijah Wood', 10, 50, 1);
INSERT into Products VALUES (0, 'Træ', 'Træsort/planker', 'Woody Allen', 10, 50, 666);
INSERT into Products VALUES (0, 'Træ', 'Træsort/planker', 'Woody Harrelson', 10, 50, 35);
INSERT into Products VALUES (0, 'Træ', 'Træsort/planker', 'Natalie Wood', 10, 50, 5);

INSERT into Products VALUES (0, 'Farve', 'Maling', 'Rød', 0, 0, 0);
INSERT into Products VALUES (0, 'Farve', 'Maling', 'Gul', 0, 0 ,0);
INSERT into Products VALUES (0, 'Farve', 'Maling', 'Grøn', 0 ,0 ,0);
INSERT into Products VALUES (0, 'Farve', 'Maling', 'Hvid', 0, 0, 0);
INSERT into Products VALUES (0, 'Farve', 'Maling', 'Sort',0, 0 ,0);
INSERT into Products VALUES (0, 'Farve', 'Maling', 'Lilla med grønne Nicholai-striber',0, 0, 0);

INSERT into Products VALUES (0, 'Tagplader', 'Tagplade type', 'Patrick Eaves',25 ,25 ,85);
INSERT into Products VALUES (0, 'Tagplader', 'Tagplade type', 'Avalon',50, 50, 2);
INSERT into Products VALUES (0, 'Tagplader', 'Tagplade type', 'Limewood',20, 20, 100);
INSERT into Products VALUES (0, 'Tagplader', 'Tagplade type', 'eavesdropping',30, 30, 150);
INSERT into Products VALUES (0, 'Tagplader', 'Tagplade type', 'Something',5, 5, 7);

              