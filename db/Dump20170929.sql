-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cmp_mccarran
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.26-MariaDB

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
-- Table structure for table `divisions`
--

DROP TABLE IF EXISTS `divisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `divisions` (
  `div_PK` int(11) NOT NULL AUTO_INCREMENT,
  `div_name` varchar(32) DEFAULT NULL,
  `div_location` int(11) NOT NULL,
  PRIMARY KEY (`div_PK`),
  KEY `div_location` (`div_location`),
  CONSTRAINT `divisions_ibfk_1` FOREIGN KEY (`div_location`) REFERENCES `stations` (`stn_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `divisions`
--

LOCK TABLES `divisions` WRITE;
/*!40000 ALTER TABLE `divisions` DISABLE KEYS */;
INSERT INTO `divisions` VALUES (1,'1st Recon',2),(2,'5th Army ',4),(3,'Heavy Infantry',14),(4,'Field Preparations',1),(5,'NCRMP',4),(6,'NCRFA',4);
/*!40000 ALTER TABLE `divisions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enlisted`
--

DROP TABLE IF EXISTS `enlisted`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enlisted` (
  `ppl_PK` int(11) NOT NULL AUTO_INCREMENT,
  `ppl_fname` varchar(32) DEFAULT NULL,
  `ppl_lname` varchar(32) DEFAULT NULL,
  `ppl_rank` varchar(32) DEFAULT NULL,
  `ppl_division` int(11) DEFAULT NULL,
  PRIMARY KEY (`ppl_PK`),
  KEY `ppl_division` (`ppl_division`),
  CONSTRAINT `enlisted_ibfk_1` FOREIGN KEY (`ppl_division`) REFERENCES `divisions` (`div_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enlisted`
--

LOCK TABLES `enlisted` WRITE;
/*!40000 ALTER TABLE `enlisted` DISABLE KEYS */;
INSERT INTO `enlisted` VALUES (26,'Angela','Williams','PFC',2),(27,'Gene','Sterling','CPL',2),(28,'James','Hsu','COL',1),(29,'Walter','Hornsby','CPL',2),(30,'William','Farber','CPL',2),(31,'Robert','Dhatri','MAJ',1),(32,'Daniel','Contreras','LT',4),(33,'Thomas','Hildern','LT',1),(34,'Kyle','Edwards','SGT',4),(35,'Andy','Kimball','MAJ',5),(36,'James','Merish','COL',4),(37,'Jake','Erwin','LT',3),(38,'Craig','Boone','LT',1),(39,'Davey','Crenshaw','CPL',4),(40,'Rebecca','Lineholm','SGT',3),(41,'Robert','Gomez','CPT',2),(42,'Edna','Monroe','PFC',4),(43,'Andy','Nellis','COL',6),(44,'Andrew','Hannigan','PFC',5),(45,'Astor','Hayes','PVT',3),(46,'Layla','Henriksen','PFC',4),(47,'Teresa','Lutz','PFC',3),(48,'Liza','O\'Hare','CPL',6),(49,'Manny','Vargas','CPT',1),(50,'Mikayla','Gleeson','PVT',6),(51,'Lee','Oliver','PVT',2),(52,'Roger','Hanson','LT',5),(54,'Thomas','Jackson','CPL',1),(55,'Tim','Rogers','PVT',4),(56,'Ronnie','Zant','PFC',3),(57,'James','Garret','LT',6);
/*!40000 ALTER TABLE `enlisted` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stations`
--

DROP TABLE IF EXISTS `stations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stations` (
  `stn_PK` int(11) NOT NULL AUTO_INCREMENT,
  `stn_name` varchar(32) DEFAULT NULL,
  `stn_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`stn_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stations`
--

LOCK TABLES `stations` WRITE;
/*!40000 ALTER TABLE `stations` DISABLE KEYS */;
INSERT INTO `stations` VALUES (1,'Camp_Golf',1),(2,'Camp_Forlorn',1),(3,'Camp_Guardian',0),(4,'Camp_McCarran',1),(5,'Camp_Searchlight',0),(6,'Ranger_Alpha',1),(7,'Ranger_Bravo',1),(8,'Ranger_Delta',1),(9,'Ranger_Echo',1),(10,'Ranger_Foxtrot',1),(11,'Outpost_Helios',1),(12,'Outpost_Mojave',1),(13,'Bitter_Springs',1),(14,'Hoover_Dam',1);
/*!40000 ALTER TABLE `stations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-29 14:29:10
