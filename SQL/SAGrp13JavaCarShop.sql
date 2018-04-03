CREATE DATABASE  IF NOT EXISTS `sa45grp13ca` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sa45grp13ca`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sa45grp13ca
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `licenseplateno` varchar(45) NOT NULL,
  `custname` varchar(45) DEFAULT NULL,
  `custcontact` int(11) DEFAULT NULL,
  PRIMARY KEY (`licenseplateno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='				';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES ('EV3097B','Nathaniel Wong',91606970),('GBE6508M','Rowland Koh',95930525),('GX873M','David Barker',93787270),('GZ2421L','Roslyn Ho',91755796),('PA9788G','Anthony Tong Jiahao',99785792),('SBF8388Z','Koh Mei Yun Devina',91475565),('SCQ6876A','Chia Bee Yian Diana',95448310),('SCV2883D','Luke Choy',94410641),('SDN730E','Olivia George',92482337),('SDZ7888A','Michael Mok',82104324),('SEP1','Halimah Yacob',99917364),('SFC111B','Emma Chan',95695129),('SGH7838D','Lena Khor',98764050),('SGL5335E','Samson Lieu',93622405),('SGQ7J','Charles Krishnan',98803587),('SGX331K','Danish Kadir',82737804),('SHC532X','Esther Teoh',91079519),('SJK3868S','Salma Ibrahim',94264015),('SJM7095T','Zhang Han Alvira',89277801),('SJQ1223J','Chang Pek Kay Dahlia',91956970),('SJS1990S','Kim Eng',90028634),('SJU3126Y','Caleb Eng',94250094),('SJU6770S','Dorothy Khoo',86464599),('SKG2946R','Margie Yeo Wan Xin',97082713),('SKM135X','Esther Khim',96513822),('SKP1771L','Jeffery Yeoh',98695737),('SKZ9854B','Brian Soin',85850995),('SLA7694D','Shum Bee San Imelda',83021416),('SLD1697U','Ian Hong',82230183),('SLE3681X','Jacyntha Wee',81603761),('SLF1142T','Angelina Toy',99348943),('SLG7096Z','Thia Bok Ai',98659605),('SLK6273P','Bradley Kwok',87819828),('SLL9084T','Darian Chang',90033485),('SLM8832C','Leon Leow Kah Hwee',98503983),('SLR6121H','Russ Poh',92953242),('SLU4427Z','Matt Lee',92172374),('YL6859R','Nettie Ang',84979650);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localinventorylist`
--

DROP TABLE IF EXISTS `localinventorylist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localinventorylist` (
  `partnumber` int(11) NOT NULL,
  `storeqty` int(11) DEFAULT NULL,
  PRIMARY KEY (`partnumber`),
  CONSTRAINT `partnumber` FOREIGN KEY (`partnumber`) REFERENCES `productdata` (`partnumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localinventorylist`
--

LOCK TABLES `localinventorylist` WRITE;
/*!40000 ALTER TABLE `localinventorylist` DISABLE KEYS */;
INSERT INTO `localinventorylist` VALUES (10001,5),(10002,1),(10003,5),(10004,1),(10005,2),(10006,12),(10007,4),(10008,3),(10010,7),(10011,6),(10012,8),(10013,12),(10014,44),(10015,2),(10017,5),(10018,3),(10019,8),(10020,5),(10021,3),(10022,5),(10023,12),(10024,17),(10025,10),(10026,11),(10027,1),(10028,0),(10029,34),(10030,3),(10031,5),(10032,3),(10033,2);
/*!40000 ALTER TABLE `localinventorylist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdata`
--

DROP TABLE IF EXISTS `productdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productdata` (
  `partnumber` int(11) NOT NULL AUTO_INCREMENT,
  `partname` varchar(45) DEFAULT NULL,
  `unitprice` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `dimension` double DEFAULT NULL,
  `supplierid` int(11) DEFAULT NULL,
  `reorderpoint` int(11) DEFAULT NULL,
  `minorder` int(11) DEFAULT NULL,
  `shelflocation` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`partnumber`),
  KEY `supplierid_idx` (`supplierid`),
  CONSTRAINT `supplierid` FOREIGN KEY (`supplierid`) REFERENCES `suppliers` (`supplierid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10034 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdata`
--

LOCK TABLES `productdata` WRITE;
/*!40000 ALTER TABLE `productdata` DISABLE KEYS */;
INSERT INTO `productdata` VALUES (10001,'ToyotaChassis',4000,'CarChasis','black',4000,101,10,5,'4','Part Replacement'),(10002,'MichilinCarTyre',150,'tyre','black',600,103,200,150,'7','Tyres'),(10003,'TransmissionShaft',600,'TransmissionShaft','black',2000,103,20,10,'7','Part Replacement'),(10004,'TyreRim',300,'TyreRim','silver',500,120,40,20,'5','Tyres'),(10005,'RadiatorFluid',80,'RadiatorFluid','orange',100,121,100,40,'8','Car Engine'),(10006,'MotorFluid',80,'MotorFluid','yellow',100,130,100,40,'8','Car Engine'),(10007,'CarSeat',100,'seat','grey',1200,135,200,50,'9','Part Replacement'),(10008,'WindScreen',900,'windscreen','transparent',1800,138,100,50,'6','Part Replacement'),(10009,'RearViewMirror',150,'RearViewMirror','green',300,134,20,10,'5','Accessories'),(10010,'sideMirror',150,'sideMirror','green',300,128,20,10,'5','Accessories'),(10011,'WindScreenWiper',20,'wiper','black',1200,122,100,20,'6','Part Replacement'),(10012,'ToyotaEngine',10000,'engine','silver',700,132,10,1,'5','Car Engine'),(10013,'Seatbelt',50,'seatbelt','grey ',1000,139,110,50,'5','Accessories'),(10014,'Legs',500,'Rubber-coated ','Beige',50,106,10,5,'3','Tyres'),(10015,'Sound System - 1500',1650.5,'Sound System','Black',30,119,5,10,'1','Audio'),(10016,'Mighty Glue',50,'For repairing tyres','Bluish White',10,125,40,50,'1','Tyre Maintenance'),(10017,'CloudMove',650,'light wheels','Grey',100,110,12,12,'4','Tyres'),(10018,'DinoGuard',130,'sprayon protection','Red',13.5,129,50,100,'2','Car Care'),(10019,'Windscreen CX130',300,'for Honda Vezel(3rd Party)','Transparent',130,111,2,1,'5','Part Replacement'),(10020,'Bag Organizer',26,'for side of driver seat','Brown',35,102,10,5,'2','Accessories'),(10021,'PaperThin Glue',10.35,'for sideview mirrors','White',5,128,10,30,'1','Car Repairs'),(10022,'WideView Mirror',30,'backview mirror','Black',25,119,5,2,'2','Accessories'),(10023,'SpeedZeng',400,'engine oil','white',30,119,3,1,'2','Car Engine'),(10024,'BANO',25,'lubricants','yellow',8,106,25,3,'2','Car Engine'),(10025,'M4',15,'light bulb','tea',2,105,10,5,'4','Car Repairs'),(10026,'BADYEAR',130,'tyre for Lamborghini','black',30,127,8,2,'5','Tyres'),(10027,'BRIDGE',180,'tyre','black',30,107,20,4,'3','Tyres'),(10028,'SPARK',105,'spark plug','silver',6,116,20,1,'2','Car Repairs'),(10029,'STONE',95,'battery','grey',25,129,6,1,'1','Car Repairs'),(10030,'WOODEN',6,'seat accessories','blue',5,103,18,4,'4','Accessories'),(10031,'TTS',12,'Shampoo','pink',3,120,30,2,'2','Accessories'),(10032,'SPEED',110,'spark pads','red',12,114,12,2,'3','Part Replacement'),(10033,'RAZERR',800,'horns for luxury car','gold',8,108,18,4,'2','Accessories');
/*!40000 ALTER TABLE `productdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staffdetails`
--

DROP TABLE IF EXISTS `staffdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staffdetails` (
  `staffid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`staffid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffdetails`
--

LOCK TABLES `staffdetails` WRITE;
/*!40000 ALTER TABLE `staffdetails` DISABLE KEYS */;
INSERT INTO `staffdetails` VALUES (1,'ThetThet','ROLE_ADMIN'),(2,'Danny Hardy','ROLE_STAFF'),(3,'Nicklos','ROLE_STAFF'),(4,'Emiley Cooper','ROLE_ADMIN'),(5,'Megan Polish','ROLE_STAFF'),(6,'Billy Robinson','ROLE_STAFF'),(7,'Zara Cole','ROLE_ADMIN'),(8,'Sam Smith','ROLE_ADMIN'),(9,'Shawn Mendes','ROLE_ADMIN');
/*!40000 ALTER TABLE `staffdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppliers` (
  `supplierid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `contact` int(11) DEFAULT NULL,
  PRIMARY KEY (`supplierid`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (101,'LIM AUTO PARTS PTE LTD','19 Kaki Bukit Place Eunos Techpark','SINGAPORE',90437889),(102,'REPAIR MECH PTE LTD','68 Orchard Rd, # 03-73A, Plaza Singapura','SINGAPORE',74839204),(103,'BUDGET AUTOPARTS PTE LTD','20 Kramat Lane 04-07, United House','SINGAPORE',85043052),(104,'REUSE USED AUTO PTE LTD','38 woodlands industrial park e1 07-11','SINGAPORE',95039104),(105,'ZAERKS MECHANIC PTE LTD','545B Balestier Rd','SINGAPORE',99483092),(106,'JOJOEL TUNING PTE LTD','15 Yishun Industrial Street 1, #03-33 WIN 5','SINGAPORE',84250329),(107,'CYCLE&CARRIAGE PTE LTD','BLK 15 WOODLANDS LOOP 02 -48','MALAYSIA',88805432),(108,'EUROSPORTS  PTE LTD','Queensway #03-48, Queensway Shopping Centre','MALAYSIA',90785748),(109,'PORSCHE CENTRE SINGAPORE','25 Mandai Estate #07-10 Innovation Place','INDONESIA',88095748),(110,'AUTO EUROKARS PTE LTD','1 George Street #17-06 One George Street','VIETNAM',99009432),(111,'I-MOTORING SINGAPORE','119 Genting Lane 04-00 Industrial Building','THAILAND',88885904),(112,'HITECH AUTO PTE LTD','14 Scotts Road #03-81 FAR EAST PLAZA','ICELAND',81129094),(113,'YOLKSWAGEN AUTO SINGAPORE','Blk 13 Woodlands Street 19, #12-13','CHINA',89095894),(114,'SPEEDO MOTORING PTE LTD','8 Geylang East Lane','INDIA',99847584),(115,'SLOWDO MOTORING PTE LTD','Blk 384 Lorong 5 Chong Pang, #08-38','CHINA',89950494),(116,'QUICK RESPONSE PTE LTD','Blk 21 Lorong 6 Queenstown, #11-03','MALAYSIA',89807854),(117,'Abstergo Entertainment','Monteriggioni, 53035 Province of Siena','Italy',17218617),(118,'Normanton Beaver','Harneey','Swiden',38971021),(119,'Melady Cooperation','Neus Venon','Hurber',1730129),(120,'Pilot Pen','21/23 Tampines Industrial Avenue 5','Singapore',67892121),(121,'Ubisoft','1 Fusionopolis Walk Solaris #09-01/02','Singapore',64083000),(122,'Bethesda','30 Chai Chee St, Singapore 468979','Singapore',64445891),(123,'Sumsamg','Chehova St','Korea',2393495),(124,'Alibaba','969 West Cost','China',58502088),(125,'Nubian\'s Goat\'s Milk','21 Choa Chu Kang North 6','Singapore',561231908),(126,'Sushi Tatsusho','Fukuoka Prefecture, Fukuoka, Chuo','Takasago',925223390),(127,'NetEase','Keyun Rd Zhongshan Ave Motorway Interchange','China',2085105163),(128,'Blizzard Entertainment','Prudential Tower30 Cecil Street','America',92231018),(129,'Moonlight Cake House',', Jalan Indah 16/12, Taman Bukit Indah','Malaysia',2329922),(130,'Pilot Pen','21/23 Tampines Industrial Avenue 5','Singapore',67892121),(131,'Ubisoft','1 Fusionopolis Walk Solaris #09-01/02','Singapore',64083000),(132,'Bethesda','30 Chai Chee St, Singapore 468979','Singapore',64445891),(133,'Sumsamg','Chehova St Condion','Korea',2393495),(134,'Alibaba','969 West','China',58502088),(135,'Nubian\'s Goat\'s Milk','21 Choa Chu Kang North 6','Singapore',561231908),(136,'Sushi Tatsusho','Fukuoka Prefecture, Fukuoka, Chuo','Takasago',925223390),(137,'NetEase','Keyun Rd Zhongshan Ave Motorway Interchange','China',2085105163),(138,'Blizzard Entertainment','Prudential Tower30 Cecil Street,','America',92231018),(139,'Moonlight Cake House',', Jalan Indah 16/12, Taman Bukit Indah','Malaysia',2329922);
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `transid` int(11) NOT NULL AUTO_INCREMENT,
  `staffid` int(11) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `licenseplateno` varchar(45) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`transid`),
  KEY `licenseplateno_idx` (`licenseplateno`),
  KEY `staffid_idx` (`staffid`),
  CONSTRAINT `licenseplateno` FOREIGN KEY (`licenseplateno`) REFERENCES `car` (`licenseplateno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `staffidconstraint` FOREIGN KEY (`staffid`) REFERENCES `staffdetails` (`staffid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactiondetails`
--

DROP TABLE IF EXISTS `transactiondetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactiondetails` (
  `transid` int(11) DEFAULT NULL,
  `partnumber` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  KEY `transid_idx` (`transid`),
  KEY `partnumber_idx` (`partnumber`),
  CONSTRAINT `partnumberconstraint` FOREIGN KEY (`partnumber`) REFERENCES `productdata` (`partnumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `transid` FOREIGN KEY (`transid`) REFERENCES `transaction` (`transid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactiondetails`
--

LOCK TABLES `transactiondetails` WRITE;
/*!40000 ALTER TABLE `transactiondetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactiondetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlogin`
--

DROP TABLE IF EXISTS `userlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userlogin` (
  `userid` varchar(45) NOT NULL,
  `staffid` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `userid_UNIQUE` (`userid`),
  KEY `staffid_idx` (`staffid`),
  CONSTRAINT `staffid` FOREIGN KEY (`staffid`) REFERENCES `staffdetails` (`staffid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlogin`
--

LOCK TABLES `userlogin` WRITE;
/*!40000 ALTER TABLE `userlogin` DISABLE KEYS */;
INSERT INTO `userlogin` VALUES ('billy',6,'$2a$10$LhbMH4Dya10Iqe7NJ2RpUuF2kCJBcWC/gtihd9QYj0qKUErX6OFYS'),('danny',2,'$2a$10$LhbMH4Dya10Iqe7NJ2RpUuF2kCJBcWC/gtihd9QYj0qKUErX6OFYS'),('emiley',4,'$2a$10$LhbMH4Dya10Iqe7NJ2RpUuF2kCJBcWC/gtihd9QYj0qKUErX6OFYS'),('megan',5,'$2a$10$LhbMH4Dya10Iqe7NJ2RpUuF2kCJBcWC/gtihd9QYj0qKUErX6OFYS'),('nicklos',3,'$2a$10$LhbMH4Dya10Iqe7NJ2RpUuF2kCJBcWC/gtihd9QYj0qKUErX6OFYS'),('sam',8,'$2a$10$LhbMH4Dya10Iqe7NJ2RpUuF2kCJBcWC/gtihd9QYj0qKUErX6OFYS'),('shawn',9,'$2a$10$LhbMH4Dya10Iqe7NJ2RpUuF2kCJBcWC/gtihd9QYj0qKUErX6OFYS'),('thetthet',1,'$2a$10$LhbMH4Dya10Iqe7NJ2RpUuF2kCJBcWC/gtihd9QYj0qKUErX6OFYS'),('zara',7,'$2a$10$LhbMH4Dya10Iqe7NJ2RpUuF2kCJBcWC/gtihd9QYj0qKUErX6OFYS');
/*!40000 ALTER TABLE `userlogin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-13 15:09:02
