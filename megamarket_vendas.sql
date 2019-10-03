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
-- Table structure for table `vendas`
--

DROP TABLE IF EXISTS `vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meio_pagamento` varchar(30) DEFAULT NULL,
  `cpf_cliente` varchar(15) DEFAULT NULL,
  `funcionario_cod` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vendas_funcionario1_idx` (`funcionario_cod`),
  CONSTRAINT `fk_vendas_funcionario1` FOREIGN KEY (`funcionario_cod`) REFERENCES `funcionario` (`cod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='									';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendas`
--

LOCK TABLES `vendas` WRITE;
/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
INSERT INTO `vendas` VALUES (2,'Cartão de Crédito','222.222.222-22',18),(3,'Dinheiro','111.111.111-11',18),(20,'m','11464646',18),(21,'Cartão de Crédito','546.456.456-48',18),(22,'Cartão de Crédito','544.644.644-66',18),(23,'Cartão de Débito','023.123.145-34',18),(24,'','   .   .   -  ',30),(25,'Ticket Alimentação','654.646.464-54',30),(26,'Cartão de Débito','514.646.464-64',30),(27,'Dinheiro','454.464.565-46',30),(28,'Cartão de Crédito','564.464.466-46',18),(29,'Dinheiro','546.464.464-64',18),(30,'Dinheiro','546.465.465-45',18),(31,'Dinheiro','546.464.644-46',18),(32,'Dinheiro','455.445.645-64',18),(33,'Cartão de Crédito','564.446.446-46',18),(34,'Dinheiro','546.456.456-46',18),(35,'Dinheiro','544.444.444-44',18),(36,'Dinheiro','564.464.564-56',18),(37,'Cartão de Crédito','525.257.225-72',30);
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-13 12:18:07
