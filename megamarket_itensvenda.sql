CREATE DATABASE  IF NOT EXISTS `megamarket` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `megamarket`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: megamarket
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Table structure for table `itensvenda`
--

DROP TABLE IF EXISTS `itensvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itensvenda` (
  `produto_cod` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `vendas_id` int(11) NOT NULL,
  `valor_unit` varchar(45) DEFAULT NULL,
  `valor_total` varchar(45) DEFAULT NULL,
  KEY `fk_itensvenda_produto1_idx` (`produto_cod`),
  KEY `fk_itensvenda_vendas1_idx` (`vendas_id`),
  CONSTRAINT `fk_itensvenda_produto1` FOREIGN KEY (`produto_cod`) REFERENCES `produto` (`cod`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_itensvenda_vendas1` FOREIGN KEY (`vendas_id`) REFERENCES `vendas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='								';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itensvenda`
--

LOCK TABLES `itensvenda` WRITE;
/*!40000 ALTER TABLE `itensvenda` DISABLE KEYS */;
INSERT INTO `itensvenda` VALUES (3,1,2,NULL,NULL),(1,2,20,NULL,NULL),(1,1,2,NULL,NULL),(3,1,3,NULL,NULL),(1,1,3,NULL,NULL),(2,10,21,'',''),(2,10,21,'',''),(2,10,21,'',''),(2,10,21,'',''),(2,10,21,'',''),(2,10,21,'',''),(2,10,21,'',''),(3,3,24,'10','100.0'),(3,3,24,'3','30.0'),(3,3,24,'99999','999990.0'),(3,3,24,'9','90.0'),(1,10,29,'10','100.0'),(2,2,29,'3','6.0'),(2,3,29,'3','9.0'),(2,3,29,'3','9.0'),(2,3,29,'3','9.0'),(1,10,31,'10','100.0'),(2,5,32,'3','15.0'),(3,1,32,'99999','99999.0'),(1,10,33,'10','100.0'),(1,10,33,'10','100.0'),(1,10,34,'10','100.0'),(1,10,35,'10','100.0'),(1,15,36,'10','150.0'),(2,3,36,'3','9.0'),(24,2,37,'500','1000.0');
/*!40000 ALTER TABLE `itensvenda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-13 12:18:03
