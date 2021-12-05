-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: codeforces
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contest`
--

DROP TABLE IF EXISTS `contest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contest` (
  `ContestID` int NOT NULL,
  `Author` varchar(100) DEFAULT NULL,
  `Division` int DEFAULT NULL,
  `StartTime` varchar(100) DEFAULT NULL,
  `EndTime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ContestID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contest`
--

LOCK TABLES `contest` WRITE;
/*!40000 ALTER TABLE `contest` DISABLE KEYS */;
INSERT INTO `contest` VALUES (1334,'Robert',2,'12-02-1995','31-10-1998'),(1739,'Trixi',0,'08-05-2003','26-08-2021'),(1787,'Karolina',2,'23-06-1994','22-12-2020'),(2344,'Lelah',2,'15-03-1910','16-04-2020'),(2788,'Arlina',3,'18-07-2019','04-03-2020'),(2845,'Reshma',1,'01-01-2000','04-12-2002'),(3383,'Cindelyn',0,'06-07-1915','21-06-2021'),(4477,'Alisha',0,'23-11-1961','13-06-2021'),(4478,'Divya',0,'30-10-1990','23-06-1994'),(4670,'Rosanne',0,'16-09-1990','16-11-2020'),(4794,'Ivett',1,'19-03-1920','08-02-2021'),(4866,'Alleen',3,'13-08-1947','03-10-2020'),(4889,'Kush',3,'30-06-1980','11-02-1998'),(5265,'Faisal',1,'06-09-1970','11-05-2013'),(5297,'Valeda',1,'20-03-1955','25-02-2020'),(5478,'Mithish',3,'12-11-1990','20-03-1995'),(5585,'Nonnah',2,'16-11-1963','12-07-2021'),(5745,'Iseabal',3,'11-08-1965','05-11-2020'),(7090,'Lulita',2,'31-10-1904','22-01-2021'),(7224,'Carilyn',2,'04-12-1958','24-11-2020'),(7934,'Madalyn',3,'11-05-2013','16-07-2020'),(8152,'Cecile',0,'08-01-1985','21-04-2021'),(8946,'Livvyy',2,'17-05-2002','30-07-2019'),(9374,'Kelly',0,'06-01-1969','20-08-2020'),(9396,'Dari',0,'11-02-1998','11-04-2021'),(9632,'Priya',2,'10-10-1989','16-09-1990'),(9633,'Rahul',0,' 14-01-2009','06-07-2007'),(9642,'Radha',3,'08-08-2008','18-07-2019'),(9753,'Valera',1,'30-07-1966','29-04-2020'),(9768,'Drucie',3,'22-07-2012','17-08-2020');
/*!40000 ALTER TABLE `contest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problem`
--

DROP TABLE IF EXISTS `problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problem` (
  `ProblemID` varchar(50) NOT NULL,
  `Author` varchar(255) DEFAULT NULL,
  `ProblemRating` int DEFAULT NULL,
  `ContestID` int DEFAULT NULL,
  PRIMARY KEY (`ProblemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problem`
--

LOCK TABLES `problem` WRITE;
/*!40000 ALTER TABLE `problem` DISABLE KEYS */;
INSERT INTO `problem` VALUES ('10252','Ernesta',2208,5417),('11848','Rahul',5795,9633),('13367','Annaliese',1968,2575),('14785','Priya',5250,9632),('16642','Taffy',2662,3434),('18228','Gilligan',1720,9272),('23491','Kush',3116,4889),('25581','Cassondra',1471,7084),('33047','Oona',2048,3439),('37381','Carly',1594,8071),('38186','Jinny',2720,2367),('40190','Rubie',1470,5238),('43714','Xylina',1965,7017),('43779','Eolanda',1465,6322),('45743','Valera',1987,6739),('48405','Reshma',1166,2845),('51236','Mithish',3874,5478),('53778','Debee',935,7925),('64279','Robert',1962,1334),('64332','Margarette',2813,5499),('64845','Aili',2853,5994),('70288','Raina',1154,2343),('75703','Willetta',2065,9539),('78159','Leeanne',1618,2712),('79039','Lesly',1182,1728),('80763','Radha',6744,9642),('90775','Roberta',2602,5562),('93385','Faisal',9244,5265),('97404','Divya',9684,4478),('99381','Livvyy',1829,8946);
/*!40000 ALTER TABLE `problem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submission`
--

DROP TABLE IF EXISTS `submission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submission` (
  `SubmissionID` int NOT NULL,
  `ContestID` int DEFAULT NULL,
  `ProblemID` varchar(50) DEFAULT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `Verdict` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SubmissionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submission`
--

LOCK TABLES `submission` WRITE;
/*!40000 ALTER TABLE `submission` DISABLE KEYS */;
INSERT INTO `submission` VALUES (11848,6744,'13259','Tybie','AC'),(12015,7313,'99757','Jenilee','TLE'),(19245,6503,'86106','Tarra','AC'),(22001,7344,'54838','Modestia','TLE'),(23491,8403,'43896','Evaleen','AC'),(48405,9684,'97453','Dacia','WA'),(50076,5250,'83004','Leanna','AC'),(50951,9244,'33463','Riannon','WA'),(51236,5795,'39649','Shel','WA'),(59475,2845,'58963','Reshma','AC'),(61791,8946,'49568','Livvyy','AC'),(61883,4889,'54789','Kush','AC'),(61975,1334,'78965','Robert','AC'),(62066,4478,'12365','Divya','WA'),(62158,9642,'14785','Radha','WA'),(62341,9633,'95632','Rahul','AC'),(62432,5265,'24785','Faisal','WA'),(62524,5478,'56998','Mithish','WA'),(62615,9632,'22225','Priya','AC'),(64279,1829,'27512','Aurelie','AC'),(66325,3276,'45857','Jorry','AC'),(74125,9244,'90184','Louella','TLE'),(77844,7916,'68508','Marita','AC'),(80763,1962,'65277','Myriam','WA'),(80771,6238,'37849','Lily','AC'),(93385,1166,'82587','Elora','AC'),(93960,6349,'82774','Brana','TLE'),(97404,3116,'87743','Hyacinthe','AC'),(99107,3874,'26517','Lacie','TLE'),(99381,8665,'82116','Addia','TLE');
/*!40000 ALTER TABLE `submission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `UserID` varchar(50) NOT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Rating` int DEFAULT NULL,
  `MaxRating` int DEFAULT NULL,
  `Organisation` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `Contribution` int DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1000','Winifred',674,2399,'Madelene','Dunedin','Luxembourg',64),('1001','Amelia',94,1850,'Dorcy','Perth','Samoa',31),('1002','Ayn',257,2389,'Phyllis','Pristina','Zambia',52),('1003','Rosaline',311,1146,'Ehrman','Nashville','RWANDA',12),('1004','Lindie',432,1386,'Maroney','Jinan','Comoros',62),('1005','Eve',89,2317,'Leffen','Berlin','Haiti',12),('1006','Correy',147,2168,'Emanuel','Hargeisa','Korea',43),('1007','Paulita',552,1995,'Ovid','Hiroshima','Guinea',32),('1008','Libbie',547,820,'Margret','Puerto Rico','Bulgaria',52),('1009','Henriette',53,2056,'Brackely','Christchurch','Georgia',13),('1010','Elbertina',545,1741,'Land','Kandy','Sri Lanka',58),('1011','Fayre',203,1186,'Euridice','Campinas','Croatia',79),('1012','Corry',493,1557,'Waldron','Rochester','France',49),('1013','Bibby',170,1040,'Zitvaa','Melekeok','Cambodia',26),('1014','Fawne',5,1931,'Nedrud','Chisinau','Grenada',41),('1015','Tori',124,1042,'Pernick','Ankara','Thailand',69),('1016','Aaren',291,1877,'Berne','Nuul','Greenland',45),('1017','Georgetta',666,1267,'Ricarda','Thies','Mauritius',7),('1018','Rosaline',457,835,'Willie','Abu Dhabi','Jamaica',21),('1019','Livvyy',98,2150,'Sacken','Phuket','RWANDA',92),('1020','Kush',95,1500,'Google','Kota','Georgia',43),('1021','Robert',23,988,'Amazon','London','Sri Lanka',32),('1022','Divya',11,56,'Amazon','Berlin','Croatia',52),('1023','Radha',48,56,'Google','Hargeisa','France',13),('1024','Reshma',895,74,'Tesla','Hiroshima','Cambodia',58),('1025','Rahul',237,899,'Microsoft','Puerto Rico','Grenada',79),('1026','Faisal',666,748,'HTC','Christchurch','Thailand',49),('1027','Mithish',0,555,'Redmi','Kandy','Greenland',26),('1028','Priya',946,145,'Samsung','Jaipur','Mauritius',41),('1029','Arya',899,697,'XIY','Gwadar','Sri Lanka',69);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `UserID` varchar(50) DEFAULT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Rating` int DEFAULT NULL,
  `MaxRating` int DEFAULT NULL,
  `Organisation` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `Contribution` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('1','viper',750,800,'IIIT','Hyd','India',23),('3','zyzz',1500,1500,'IIIT','Pune','India',100),('4','kush',2300,1200,'none','jaipur','india',120);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-05 22:23:05
