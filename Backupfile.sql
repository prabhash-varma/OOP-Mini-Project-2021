-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: oops
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `Cid` varchar(15) NOT NULL,
  `Cname` varchar(15) DEFAULT NULL,
  `Cprice` bigint DEFAULT NULL,
  `Cmileage` int DEFAULT NULL,
  `Cavail` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Cid`),
  UNIQUE KEY `Cid_UNIQUE` (`Cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES ('c101','datsun',10000,22,'yes'),('c102','tata',11000,20,'yes'),('c103','toyota',10000,23,'yes'),('c104','hyundai',16000,19,'yes'),('c105','figo',1200,13,'yes '),('c106','audi',22000,16,'yes'),('c107','kia',19000,14,'yes'),('c108','mahindra',16000,22,'yes'),('c109','skoda',15000,12,'yes'),('c110','swift',12000,14,'yes'),('c111','figo',1200,13,'yes '),('c112','audi',12000,12,'yes'),('c113','benz',20000,12,'yes'),('c114','datsun',10000,22,'yes'),('c115','tata',11000,20,'yes'),('c116','toyota',10000,23,'yes'),('c117','hyundai',16000,19,'yes'),('c118','audi',22000,16,'yes'),('c119','kia',19000,14,'yes'),('c120','tata',13000,22,'yes'),('c121','skoda',15000,12,'yes'),('c122','swift',12000,14,'yes'),('c123','figo',1200,13,'yes '),('c124','toyota',10000,23,'yes'),('c125','hyundai',16000,19,'yes'),('c126','audi',22000,16,'yes'),('c127','kia',19000,14,'yes'),('c128','toyota',10000,23,'yes'),('c129','hyundai',16000,19,'yes');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-05 19:09:47
