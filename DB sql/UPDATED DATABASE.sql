-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: account
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `phone` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `municipality` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `birthdate` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('1234','admin','admin','admin','Acharnes','Other','1/1/2019',NULL),('56478','kjsbckj','jkabkv','123','Athens','male','12/13/1302','positive'),('61298387','Sakis','Loizos','we','Marousi','Male','3/3/1990','positive'),('6789203','Elena','Saranti','1234','Nea Erithraia','female','13/2/2001',NULL),('67902','Akis','Sakoulidis','23','Kifissia','female','12/3/2001',NULL),('68p238e20','Katerina','Sotiriou','34','Ekali','Female','13/6/1998',NULL),('6940047470','Aliki','Orlandou','12','hmhvkkjkb','female','14/12/2001','positive'),('6942919191','Ioanna','Chalara','345','Psychiko','female','17/9/2001','positive'),('6945977627','Kostantinos','Orlandos','12345','Marousi','male','12/11/1960','negative'),('6947652980','Christos','Aggelopoulos','123','Metamorfosi','Male','19/8/1985',NULL),('6955300531','Konstantina','Zouni','12345','Chalandri','female','9/5/2001',NULL),('69704638','Santra','Aloni','345','    Filothei-Psychiko','Female','9/3/1995',NULL),('697089564','jbciuvwe','wiubbiuv','234','Nea Erithraia','male','12/4/2015',NULL),('6977362135','Katerina','Ramniali','1234','Marousi','female','6/12/1962','negative'),('821u1001','Akis','Petrou','hi','Athens','Male','13/5/1990',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friends` (
  `phone` varchar(45) NOT NULL,
  `friendphone` varchar(45) NOT NULL,
  KEY `phonenumber_idx` (`phone`),
  KEY `friendph_idx` (`friendphone`),
  CONSTRAINT `friendph` FOREIGN KEY (`friendphone`) REFERENCES `account` (`phone`) ON DELETE CASCADE,
  CONSTRAINT `phonenumber` FOREIGN KEY (`phone`) REFERENCES `account` (`phone`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
INSERT INTO `friends` VALUES ('697089564','6940047470'),('697089564','6955300531'),('6942919191','6940047470'),('6942919191','6955300531'),('6940047470','6955300531'),('6940047470','6977362135'),('1234','6940047470'),('6940047470','6977362135'),('6940047470','1234'),('6940047470','61298387'),('6940047470','67902'),('6940047470','68p238e20'),('6940047470','6945977627'),('6940047470','6947652980'),('6940047470','69704638'),('6940047470','697089564');
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `phone` varchar(45) NOT NULL,
  `notification` varchar(400) NOT NULL,
  KEY `notphone_idx` (`phone`),
  CONSTRAINT `notphone` FOREIGN KEY (`phone`) REFERENCES `account` (`phone`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES ('6955300531','Your friend Orlandou Aliki has been tested possitive for coronavirus 10-12-2020 06:52 μμ'),('6940047470','Your friend Themistokleous Fotis has been tested possitive for coronavirus 10-12-2020 06:57 μμ'),('6955300531','One persone from Themistokleous Fotis friend\'s list has been tested possitive for coronavirus 10-12-2020 06:57 μμ'),('6940047470','Your friend Themistokleous Fotis has been tested possitive for coronavirus 10-12-2020 07:19 μμ'),('6955300531','One person from Themistokleous Fotis friend\'s list has been tested possitive for coronavirus 10-12-2020 07:19 μμ'),('6940047470','Your friend Themistokleous Fotis has been tested possitive for coronavirus 10-12-2020 07:31 μμ'),('6955300531','One person from Orlandou Aliki friend\'s list has been tested possitive for coronavirus 10-12-2020 07:31 μμ'),('6940047470','Your friend Chalara Ioanna has been tested possitive for coronavirus 10-12-2020 07:35 μμ'),('6955300531','Your friend Chalara Ioanna has been tested possitive for coronavirus 10-12-2020 07:35 μμ'),('6955300531','One person from Orlandou Aliki friend\'s list has been tested possitive for coronavirus 10-12-2020 07:35 μμ'),('6940047470','Your friend Chalara Ioanna has been tested possitive for coronavirus 10-12-2020 07:41 μμ'),('6955300531','Your friend Chalara Ioanna has been tested possitive for coronavirus 10-12-2020 07:41 μμ'),('6955300531','One person from Orlandou Aliki friend\'s list has been tested possitive for coronavirus 10-12-2020 07:41 μμ'),('6977362135','One person from Orlandou Aliki friend\'s list has been tested possitive for coronavirus 10-12-2020 07:41 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 23-12-2020 01:19 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 23-12-2020 01:19 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:51 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:51 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:51 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:51 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:51 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:51 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:52 μμ'),('6955300531','Your friend Orlandou Aliki has been tested possitive for COVID-19 27-12-2020 04:55 μμ'),('6977362135','Your friend Orlandou Aliki has been tested possitive for COVID-19 27-12-2020 04:55 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:56 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 04:56 μμ'),('6955300531','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 05:52 μμ'),('6977362135','Your friend Orlandou Aliki has recovered from COVID-19 27-12-2020 05:52 μμ'),('6955300531','Your friend Orlandou Aliki has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('6977362135','Your friend Orlandou Aliki has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('6977362135','Your friend Orlandou Aliki has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('1234','Your friend Orlandou Aliki has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('61298387','Your friend Orlandou Aliki has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('67902','Your friend Orlandou Aliki has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('68p238e20','Your friend Orlandou Aliki has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('6945977627','Your friend Orlandou Aliki has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('6947652980','Your friend Orlandou Aliki has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('69704638','Your friend Orlandou Aliki has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('697089564','Your friend Orlandou Aliki has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('6940047470','One person from admin admin friend list has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('6940047470','One person from wiubbiuv jbciuvwe friend list has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('6955300531','One person from wiubbiuv jbciuvwe friend list has been tested possitive for COVID-19 29-12-2020 01:59 μμ'),('6955300531','Your friend Orlandou Aliki<html><br /> has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('6977362135','Your friend Orlandou Aliki<html><br /> has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('6977362135','Your friend Orlandou Aliki<html><br /> has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('1234','Your friend Orlandou Aliki<html><br /> has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('61298387','Your friend Orlandou Aliki<html><br /> has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('67902','Your friend Orlandou Aliki<html><br /> has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('68p238e20','Your friend Orlandou Aliki<html><br /> has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('6945977627','Your friend Orlandou Aliki<html><br /> has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('6947652980','Your friend Orlandou Aliki<html><br /> has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('69704638','Your friend Orlandou Aliki<html><br /> has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('697089564','Your friend Orlandou Aliki<html><br /> has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('6940047470','One person from admin admin<html><br /> friend list has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('6940047470','One person from wiubbiuv jbciuvwe<html><br /> friend list has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ'),('6955300531','One person from wiubbiuv jbciuvwe<html><br /> friend list has been tested possitive for COVID-19</html> 29-12-2020 02:20 μμ');
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'account'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-14 19:26:52
