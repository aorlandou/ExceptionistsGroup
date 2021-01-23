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
INSERT INTO `account` VALUES ('6908078956','Konstantinos','Varnavas','2345','Kallithea','Male','5/1/1999',NULL),('6940047470','Aliki','Orlandou','hi7','Marousi','Female','14/12/2001','positive'),('6942919191','Ioanna','Chalari','345','Filothei-Psychiko','Female','17/9/2001','recovered'),('6945678909','Eleftheria','Papadopoulou','234','Elliniko-Argyroupoli','Female','17/8/1996','positive'),('6955300531','Konstantina','Zouni','gk5','Chalandri ','Female','12/5/2001','negative'),('6957120942','Georgia','Manioudaki','45ti','Elliniko-Argyroupoli','Female','11/8/2001',NULL),('6974620230','Eleni','Alexandri','123','Papagou-Cholargos','Female','12/7/2001',NULL),('6980867107','Erika','Mpairami','234','Agios Dimitrios','Female','16/3/2001','recovered'),('6987588406','Sofia','Styllou','234','Spetses','Female','24/10/2001','positive');
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
INSERT INTO `friends` VALUES ('6980867107','6974620230'),('6942919191','6980867107'),('6987588406','6942919191'),('6987588406','6974620230'),('6945678909','6974620230'),('6945678909','6980867107'),('6908078956','6974620230'),('6940047470','6980867107'),('6940047470','6987588406'),('6940047470','6942919191'),('6955300531','6942919191'),('6955300531','6940047470'),('6955300531','6945678909'),('6957120942','6945678909'),('6957120942','6942919191'),('6980867107','6908078956'),('6980867107','6987588406'),('6980867107','6957120942');
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
INSERT INTO `notification` VALUES ('6974620230','16-01-2021 10:10 μμ Your friend Mpairami Erika has been tested possitive for COVID-19'),('6980867107','16-01-2021 10:17 μμ Your friend Chalari Ioanna has been tested possitive for COVID-19'),('6974620230','16-01-2021 10:17 μμ One person from Mpairami Erika friend list has been tested possitive for COVID-19 '),('6980867107','16-01-2021 10:28 μμ Your friend Chalari Ioanna has recovered from COVID-19 '),('6942919191','16-01-2021 10:29 μμ Your friend Styllou Sofia has been tested possitive for COVID-19'),('6974620230','16-01-2021 10:29 μμ Your friend Styllou Sofia has been tested possitive for COVID-19'),('6980867107','16-01-2021 10:29 μμ One person from Chalari Ioanna friend list has been tested possitive for COVID-19 '),('6974620230','21-01-2021 01:17 μμ Your friend Papadopoulou Eleftheria has been tested possitive for COVID-19'),('6980867107','21-01-2021 01:17 μμ Your friend Papadopoulou Eleftheria has been tested possitive for COVID-19'),('6974620230','21-01-2021 01:17 μμ One person from Mpairami Erika friend list has been tested possitive for COVID-19 '),('6980867107','21-01-2021 02:32 μμ Your friend Orlandou Aliki has been tested possitive for COVID-19'),('6987588406','21-01-2021 02:32 μμ Your friend Orlandou Aliki has been tested possitive for COVID-19'),('6942919191','21-01-2021 02:32 μμ Your friend Orlandou Aliki has been tested possitive for COVID-19'),('6974620230','21-01-2021 02:32 μμ One person from Mpairami Erika friend list has been tested possitive for COVID-19 '),('6942919191','21-01-2021 02:32 μμ One person from Styllou Sofia friend list has been tested possitive for COVID-19 '),('6974620230','21-01-2021 02:32 μμ One person from Styllou Sofia friend list has been tested possitive for COVID-19 '),('6980867107','21-01-2021 02:32 μμ One person from Chalari Ioanna friend list has been tested possitive for COVID-19 '),('6942919191','21-01-2021 02:35 μμ Your friend Zouni Konstantina has been tested negative for COVID-19 '),('6940047470','21-01-2021 02:35 μμ Your friend Zouni Konstantina has been tested negative for COVID-19 '),('6945678909','21-01-2021 02:35 μμ Your friend Zouni Konstantina has been tested negative for COVID-19 '),('6974620230','21-01-2021 03:00 μμ Your friend Mpairami Erika has been tested possitive for COVID-19'),('6908078956','21-01-2021 03:00 μμ Your friend Mpairami Erika has been tested possitive for COVID-19'),('6974620230','21-01-2021 03:00 μμ One person from Varnavas Konstantinos friend list has been tested possitive for COVID-19 '),('6974620230','21-01-2021 03:35 μμ Your friend Mpairami Erika has been tested possitive for COVID-19'),('6908078956','21-01-2021 03:35 μμ Your friend Mpairami Erika has been tested possitive for COVID-19'),('6987588406','21-01-2021 03:35 μμ Your friend Mpairami Erika has been tested possitive for COVID-19'),('6974620230','21-01-2021 03:35 μμ One person from Varnavas Konstantinos friend list has been tested possitive for COVID-19 '),('6942919191','21-01-2021 03:35 μμ One person from Styllou Sofia friend list has been tested possitive for COVID-19 '),('6974620230','21-01-2021 03:35 μμ One person from Styllou Sofia friend list has been tested possitive for COVID-19 '),('6974620230','21-01-2021 04:35 μμ Your friend Mpairami Erika has recovered from COVID-19 '),('6908078956','21-01-2021 04:35 μμ Your friend Mpairami Erika has recovered from COVID-19 '),('6987588406','21-01-2021 04:35 μμ Your friend Mpairami Erika has recovered from COVID-19 '),('6957120942','21-01-2021 04:35 μμ Your friend Mpairami Erika has recovered from COVID-19 ');
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

-- Dump completed on 2021-01-23 15:38:05
