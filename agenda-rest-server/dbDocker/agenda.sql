CREATE DATABASE  IF NOT EXISTS `agenda` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `agenda`;


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


DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `id_login` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  PRIMARY KEY (`id_login`),
  UNIQUE KEY `userName` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'francesco','0581938f0767a65b373cea80e905c25f'),(2,'admin','21232f297a57a5a743894a0e4a801fc3');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



DROP TABLE IF EXISTS `evento_casa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_casa` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `descrizione` varchar(250) NOT NULL,
  `luogo` varchar(250) NOT NULL,
  `note` varchar(250) NOT NULL,
  `data_evento` varchar(250) NOT NULL,
  `ora_evento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `evento_casa` WRITE;
/*!40000 ALTER TABLE `evento_casa` DISABLE KEYS */;
INSERT INTO `evento_casa` VALUES (1,'casa_1','casa 1','roma','niente','2016-08-11','12.00'),(2,'casa_2','casa 2','napoli','niente','2016-09-02','13.00'),(3,'casa_3','casa 3','bgh','hgy','2017-07-05','16.57');
/*!40000 ALTER TABLE `evento_casa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;




DROP TABLE IF EXISTS `evento_amici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_amici` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `descrizione` varchar(250) NOT NULL,
  `luogo` varchar(250) NOT NULL,
  `note` varchar(250) NOT NULL,
  `data_evento` varchar(250) NOT NULL,
  `ora_evento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `evento_amici` WRITE;
/*!40000 ALTER TABLE `evento_amici` DISABLE KEYS */;
INSERT INTO `evento_amici` VALUES (1,'amici_1','amici 1','napoli','niente','2016-09-29','10.30'),(2,'sport_23','sport 2','benevento','niente','2016-10-01','19.00'),(3,'amici_3','amici 3','napoli','niente','2016-11-24','09.30');
/*!40000 ALTER TABLE `evento_amici` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



DROP TABLE IF EXISTS `evento_famiglia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_famiglia` (
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


LOCK TABLES `evento_famiglia` WRITE;
/*!40000 ALTER TABLE `evento_famiglia` DISABLE KEYS */;
INSERT INTO `evento_famiglia` VALUES (1,'famiglia_1','famiglia 1','roma','niente','2017-02-14','12.00'),(2,'famiglia_2','famiglia 2','napoli','niente','2017-05-01','11.04'),(3,'famiglia_3','famiglia 3','benevento','niente','2017-10-01','09.04');
/*!40000 ALTER TABLE `evento_famiglia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



DROP TABLE IF EXISTS `evento_lavoro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_lavoro` (
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


LOCK TABLES `evento_lavoro` WRITE;
/*!40000 ALTER TABLE `evento_lavoro` DISABLE KEYS */;
INSERT INTO `evento_lavoro` VALUES (1,'work_1','lavoro 1','roma','niente','2017-05-14','09.00'),(2,'work_2','lavoro 2','napoli','niente','2016-12-06','08.00'),(3,'work_3','lavoro  3','napoli','niente','2017-10-06','08.00');
/*!40000 ALTER TABLE `evento_lavoro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



DROP TABLE IF EXISTS `evento_sport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_sport` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `descrizione` varchar(250) NOT NULL,
  `luogo` varchar(250) NOT NULL,
  `note` varchar(250) NOT NULL,
  `data_evento` varchar(250) NOT NULL,
  `ora_evento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `evento_sport` WRITE;
/*!40000 ALTER TABLE `evento_sport` DISABLE KEYS */;
INSERT INTO `evento_sport` VALUES (1,'sport_1','sport 1','benevento','niente','2016-08-01','18.00'),(2,'sport_2','sport 2','benevento','niente','2016-09-01','19.00'),(3,'sport_3','sport 3','benevento','niente','2017-03-15','20.00'),(4,'sport_4','sport 4','benevento','niente','2017-06-21','20.00');
/*!40000 ALTER TABLE `evento_sport` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



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
