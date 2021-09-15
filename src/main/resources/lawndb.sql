-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: lawndb
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
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agent` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (1,'agent1@gmail.com','(111)111-1111','John Doe','agent-1'),(2,'agent2@gmail.com','(222)222-2222','James Smith','agent-2'),(3,'agent3@gmail.com','(333)333-3333','Jackson Michael','agent-3'),(4,'agent4@gmail.com','(444)444-4444','Jane Doe','agent-4');
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite`
--

DROP TABLE IF EXISTS `favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite` (
  `id` int NOT NULL AUTO_INCREMENT,
  `property_id` int NOT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1nbbl8ows3xxgl9hy6r4ht5iy` (`userid`),
  CONSTRAINT `FK1nbbl8ows3xxgl9hy6r4ht5iy` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite`
--

LOCK TABLES `favorite` WRITE;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` VALUES (1,0,34),(5,1,35),(6,0,36);
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` int NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `propertyid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKag4kark2o0kdtrdhrqpu02dml` (`propertyid`),
  CONSTRAINT `FKag4kark2o0kdtrdhrqpu02dml` FOREIGN KEY (`propertyid`) REFERENCES `property` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'miami-fl-69864586.jpg',0),(2,'sweetwater-fl-73290357.jpg',1),(3,'sweetwater-fl-73290316.jpg',2),(4,'sweetwater-fl-73290335.jpg',3),(5,'miami-fl-74897471.jpg',4),(6,'sweetwater-fl-69513506.jpg',5),(7,'miami-fl-72037850.jpg',6),(8,'miami-fl-70138976.jpg',7),(9,'miami-fl-72225303.jpg',8),(10,'miami-fl-69514693.jpg',9),(11,'miami-fl-69513818.jpg',10),(12,'miami-fl-61687315.jpg',11),(13,'sweetwater-fl-75274723.jpg',12),(14,'coral-gables-fl-72784324.jpg',13),(15,'south-miami-fl-74219406.jpg',14),(16,'miami-fl-61313067.jpg',15),(17,'coral-gables-fl-70069845.jpg',16),(18,'miami-fl-74051517.jpg',17),(19,'doral-fl-69514773.jpg',18),(20,'medley-fl-74870304.jpg',19),(21,'doral-fl-69512912.jpg',20),(22,'miami-fl-73974993.jpg',21),(23,'miami-fl-72907009.jpg',22),(24,'miami-fl-71538184.jpg',23),(25,'miami-fl-70817838.jpg',24),(26,'miami-fl-74867624.jpg',25),(27,'coconut-grove-fl-70439225.jpg',26),(28,'miami-fl-69516131.jpg',27),(29,'miami-fl-69513580.jpg',28),(30,'miami-fl-69515371.jpg',29);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `price` int NOT NULL,
  `size` float NOT NULL,
  `agentid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8nkcqij168tq8l128qhl94k6y` (`agentid`),
  CONSTRAINT `FK8nkcqij168tq8l128qhl94k6y` FOREIGN KEY (`agentid`) REFERENCES `agent` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (0,'sw 136 st kendall fl 33186',3500000,3.67,3),(1,'9840 sw 104th st miami fl 33176',800000,1.59,4),(2,'sw 122 st south miami heights fl 33196',585000,5,2),(3,'9101 sw 120th ave miami fl 33186',665000,0.5,2),(4,'8860 sw 126th st miami fl 33176',269000,0.1,2),(5,'sw 122 ave miami fl 33035',170000,10,1),(6,'18396 sw 158th st miami fl 33187',2750000,6,3),(7,'180 sw 147 ave miami fl 33177',3500000,11,4),(8,'15820 sw 89 ave palmetto bay fl 33157',459000,0.36,2),(9,'10330 sw 178th st miami fl 33157',570000,0.64,2),(10,'10030 w indigo st west perrine fl 33157',477900,0.33,3),(11,'sw 188 st sw 152 ave miami fl 33187',235000,1.23,1),(12,'28 st sw 158 ct sweetwater fl 33185',50000,0.15,4),(13,'14650 sw 179 ave miami fl 33196',750000,4.81,2),(14,'188 st sw 152 ave miami fl 33187',65000,0.35,3),(15,'sw 38 st and sw 158 ave miami fl 33185',289000,1.85,3),(16,'19300 sw 152 miami fl 33196',1550000,15,3),(17,'158 ave sw 36 st miami fl 33185',125000,0.49,1),(18,'sw 44 street lot miami fl 33185',100000,0.5,3),(19,'sw 34 st and sw 158 ave miami fl 33185',93000,0.51,1),(20,'169 ave miami fl 33185',500000,5,4),(21,'sw 163 ave miami fl 33185',34500,0.17,3),(22,'14300 sw 200th st miami fl 33177',650000,5.2,3),(23,'169 ave miami fl 33185',500000,5,1),(24,'sw 136th street 207th ave miami fl 33196',349000,4.7,2),(25,'169 ave miami fl 33185',500000,5,4),(26,'14402 sw 16th st miami fl 33184',550000,0.37,2),(27,'148 sw krome ave miami fl 33196',2200000,4.25,1),(28,'miami fl 33185',1000000,10,2),(29,'sw 30 st sw 160 ave miami fl 33185',63000,0.3,1);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'In what city were you born?'),(2,'What is the name of your favorite pet?'),(3,'What is your mother\'s maiden name?'),(4,'What high school did you attend?'),(5,'What is the name of your first school?'),(6,'What was the make of your first car?'),(7,'What was your favorite food as a child?'),(8,'Where did you meet your spouse?'),(9,'What is your favorite color?'),(10,'What is your favorite sports team?');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_question`
--

DROP TABLE IF EXISTS `security_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `security_question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `correct_answer` varchar(255) DEFAULT NULL,
  `questionid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK233dn130h5de88pf7n77otmkm` (`questionid`),
  KEY `FK3o8hlt0fmdtg1bnyxwon19vc6` (`userid`),
  CONSTRAINT `FK233dn130h5de88pf7n77otmkm` FOREIGN KEY (`questionid`) REFERENCES `question` (`id`),
  CONSTRAINT `FK3o8hlt0fmdtg1bnyxwon19vc6` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_question`
--

LOCK TABLES `security_question` WRITE;
/*!40000 ALTER TABLE `security_question` DISABLE KEYS */;
INSERT INTO `security_question` VALUES (1,'1',1,34),(2,'2',4,34),(3,'3',7,34),(4,'1',3,35),(5,'2',5,35),(6,'3',7,35),(7,'test1',3,36),(8,'test2',4,36),(9,'test3',9,36);
/*!40000 ALTER TABLE `security_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `enabled` bit(1) NOT NULL,
  `locked` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (34,_binary '',_binary '\0','$2a$10$sCueQIZP9RoDATZpY6s6ieIHvU0DwZrTw10pjb5.hYqKogJL3cgfO','USER','rsuar123!'),(35,_binary '',_binary '\0','$2a$10$HpVYppRHF5Wb3xgduQL9M.Wfz5oGDmIsOFRxq7NCeo8fFoqTGZcNa','USER','alex123!'),(36,_binary '',_binary '\0','$2a$10$g9MevqbqhIVSMQ/j5M31h.ATabK3dNnYRPMl0TrecZCpEG4tDyl6C','USER','mike123!');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_sequence`
--

DROP TABLE IF EXISTS `user_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_sequence`
--

LOCK TABLES `user_sequence` WRITE;
/*!40000 ALTER TABLE `user_sequence` DISABLE KEYS */;
INSERT INTO `user_sequence` VALUES (37);
/*!40000 ALTER TABLE `user_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-15 12:18:16
