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
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `cod` int(11) NOT NULL,
  `cargo` varchar(30) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `idade` int(11) DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `uf` varchar(15) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (12,'Caixa','Ester',16,'034.564.646-46','São Paulo','03545-645','ester@gmail.com','(11)65456-4464','Rua 123','São Paulo'),(18,'Big Boss','Guilherme',15,'196.846.854-68','São Paulo','01564-564','gui@hotmail.com','(11)70707-070','Rua 123','São Paulo'),(20,'fdosjio','duhaiuhdi',18,'641.654.685-46','Acre','56146-498','dssds','(96)85468-4986',NULL,NULL),(30,'Gerente','Guii',18,'035.468.468-48','Acre','01646-818','dakhgsdia','(13)51645-6466','sdiahdia','sp'),(555,'Gerente','Duda',14,'147.425.225-77','fdgddfggfd','74587-585','fdgdfgdfgf','(11)55585-858','tdghdfgdg','fdgddfggfd');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-13 12:18:00
