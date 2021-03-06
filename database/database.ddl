-- creating Database
create database FTP111;

-- using the Database
use FTP111;

-- VENDOR TABLE

 CREATE TABLE `vendor` (
  `VEN_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `VEN_PASSWORD` varchar(50) NOT NULL,
  `VEN_FEEDBACK` varchar(500) DEFAULT NULL,
  `VEN_PHONE` varchar(50) NOT NULL,
  `VEN_ACCOUNT_NO` int(10) unsigned NOT NULL,
  `VEN_BALANCE` double DEFAULT '2000',
  `VEN_EMAIL` varchar(40) NOT NULL,
  PRIMARY KEY (`VEN_ID`),
  UNIQUE KEY `VEN_ACCOUNT_NO` (`VEN_ACCOUNT_NO`)
);



-- CUSTOMER TABLE


CREATE TABLE `customer` (
  `CUS_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CUS_NAME` varchar(50) NOT NULL,
  `CUS_PWD` varchar(50) NOT NULL,
  `CUS_PHONE` varchar(50) NOT NULL,
  `CUS_EMAIL` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CUS_ID`),
  UNIQUE KEY `CUS_EMAIL` (`CUS_EMAIL`)
);

-- ORDERS TABLE
 

CREATE TABLE `orders` (
  `ORD_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CUS_ID` int(10) unsigned NOT NULL,
  `WAL_TRAN_ID` int(10) unsigned NOT NULL,
  `VEN_ID` int(10) unsigned NOT NULL,
  `ORD_TOTAL_PRICE` double unsigned NOT NULL DEFAULT '0',
  `ORD_STATUS` enum('REJECTED','APPROVED','PENDING','PARTIAL') DEFAULT 'PENDING',
  `ORD_DATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ORD_ID`),
  KEY `WAL_TRAN_ID_FK` (`WAL_TRAN_ID`),
  KEY `VEN_ID_FK3` (`VEN_ID`),
  KEY `CUS_ID_FK1` (`CUS_ID`),
  CONSTRAINT `CUS_ID_FK1` FOREIGN KEY (`CUS_ID`) REFERENCES `customer` (`CUS_ID`),
  CONSTRAINT `VEN_ID_FK3` FOREIGN KEY (`VEN_ID`) REFERENCES `vendor` (`VEN_ID`),
  CONSTRAINT `WAL_TRAN_ID_FK` FOREIGN KEY (`WAL_TRAN_ID`) REFERENCES `wallet` (`WAL_TRAN_ID`)
);






-- MENU TABLE

 CREATE TABLE `menu` (
  `MEN_ITEM_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MEN_FOOD_TYPE` enum('SOUTH','NORTH') NOT NULL,
  `MEN_VEG_NON_VEG` enum('VEG','NON_VEG') NOT NULL,
  `MEN_ITEM_NAME` varchar(50) NOT NULL,
  `MEN_CALORIES` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`MEN_ITEM_ID`)
);




-- WALLET TABLE

 CREATE TABLE `wallet` (
  `WAL_TRAN_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `WAL_PAYMENT_METHOD` enum('NET_BANKING','DEBIT_CARD','PAYTM','CREDIT_CARD') DEFAULT 'CREDIT_CARD',
  `WAL_CURRENT_BALANCE` double unsigned DEFAULT '2000',
  `CUS_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`WAL_TRAN_ID`),
  KEY `CUS_ID_FK` (`CUS_ID`),
  CONSTRAINT `CUS_ID_FK` FOREIGN KEY (`CUS_ID`) REFERENCES `customer` (`CUS_ID`)
) ;





-- MENU_VENDOR TABLE

CREATE TABLE `menu_vendor` (
  `MEN_ITEM_ID` int(10) unsigned NOT NULL,
  `VEN_ID` int(10) unsigned NOT NULL,
  `MEN_VEN_PRICE` double NOT NULL,
  `MEN_VEN_RATING` int(10) unsigned DEFAULT NULL,
  KEY `VEN_ID_FK` (`VEN_ID`),
  KEY `MEN_ITEM_ID_FK1` (`MEN_ITEM_ID`),
  CONSTRAINT `MEN_ITEM_ID_FK1` FOREIGN KEY (`MEN_ITEM_ID`) REFERENCES `menu` (`MEN_ITEM_ID`),
  CONSTRAINT `VEN_ID_FK` FOREIGN KEY (`VEN_ID`) REFERENCES `vendor` (`VEN_ID`)
) ;



-- ORDER_ITEM TABLE

CREATE TABLE `order_item` (
  `CUS_ID` int(10) unsigned NOT NULL,
  `Ord_Item_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Men_Item_Id` int(10) unsigned NOT NULL,
  `Ven_Id` int(10) unsigned NOT NULL,
  `Ord_Id` int(10) unsigned DEFAULT NULL,
  `ORD_QUANTITY` int(10) unsigned DEFAULT NULL,
  `Ord_Item_Price` double unsigned NOT NULL,
  `ORD_STATUS` enum('REJECTED','APPROVED','PENDING') DEFAULT 'PENDING',
  PRIMARY KEY (`Ord_Item_Id`),
  KEY `Men_Item_Id_FK7` (`Men_Item_Id`),
  KEY `Ord_Id_FK5` (`Ord_Id`),
  KEY `CUS_ID_FK4` (`CUS_ID`),
  CONSTRAINT `CUS_ID_FK4` FOREIGN KEY (`CUS_ID`) REFERENCES `customer` (`CUS_ID`),
  CONSTRAINT `Men_Item_Id_FK7` FOREIGN KEY (`Men_Item_Id`) REFERENCES `menu` (`MEN_ITEM_ID`),
  CONSTRAINT `Ord_Id_FK5` FOREIGN KEY (`Ord_Id`) REFERENCES `orders` (`ORD_ID`)
); 

