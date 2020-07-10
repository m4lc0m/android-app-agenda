CREATE DATABASE  IF NOT EXISTS `agenda` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `agenda`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: agenda
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `evento_tempolibero`
--

DROP TABLE IF EXISTS `evento_tempolibero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_tempolibero` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `descrizione` varchar(250) NOT NULL,
  `luogo` varchar(250) NOT NULL,
  `note` varchar(250) NOT NULL,
  `data_evento` varchar(250) NOT NULL,
  `ora_evento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento_tempolibero`
--

LOCK TABLES `evento_tempolibero` WRITE;
/*!40000 ALTER TABLE `evento_tempolibero` DISABLE KEYS */;
INSERT INTO `evento_tempolibero` VALUES (1,'tempo_libero_1','tempo libero 1','milano','niente','2016-08-04','10.00'),(2,'tempo_libero_2','tempo libero 2','roma','niente','2016-09-07','11.00'),(3,'tempo_libero_3','tempo libero 3','roma','niente','2016-09-22','17.00');
/*!40000 ALTER TABLE `evento_tempolibero` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-11 16:38:16
