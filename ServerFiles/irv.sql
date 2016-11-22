-- MySQL dump 10.13  Distrib 5.7.15, for osx10.11 (x86_64)
--
-- Host: localhost    Database: irv_project
-- ------------------------------------------------------
-- Server version	5.7.15

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
-- Table structure for table `AccessRoles`
--

DROP TABLE IF EXISTS `AccessRoles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AccessRoles` (
  `email` varchar(254) NOT NULL,
  `accessrole` varchar(45) NOT NULL DEFAULT 'voterStd',
  `accessroleid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`accessroleid`),
  KEY `fk_accessroles_voteremail_idx` (`email`),
  CONSTRAINT `fk_accessroles_voteremail` FOREIGN KEY (`email`) REFERENCES `Voters` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AccessRoles`
--

LOCK TABLES `AccessRoles` WRITE;
/*!40000 ALTER TABLE `AccessRoles` DISABLE KEYS */;
INSERT INTO `AccessRoles` VALUES ('admin@fake.com','adminStd',1),('fake10@fake.com','voterStd',2),('fake1@fake.com','voterStd',3),('fake2@fake.com','voterStd',4),('fake3@fake.com','voterStd',5),('fake4@fake.com','voterStd',6),('fake5@fake.com','voterStd',7),('fake6@fake.com','voterStd',8),('fake7@fake.com','voterStd',9),('fake8@fake.com','voterStd',10),('fake9@fake.com','voterStd',11),('irvingmichael@gmail.com','voterStd',12),('fake2@fake.com','voterStd',120),('fake2@fake.com','voterStd',121),('fake2@fake.com','voterStd',122),('fake2@fake.com','voterStd',123),('fake2@fake.com','voterStd',124);
/*!40000 ALTER TABLE `AccessRoles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AuthTokens`
--

DROP TABLE IF EXISTS `AuthTokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AuthTokens` (
  `Token` char(64) NOT NULL,
  `TokenId` int(11) NOT NULL AUTO_INCREMENT,
  `Created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`TokenId`),
  UNIQUE KEY `AuthTokens_TokenId_uindex` (`TokenId`)
) ENGINE=InnoDB AUTO_INCREMENT=306 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AuthTokens`
--

LOCK TABLES `AuthTokens` WRITE;
/*!40000 ALTER TABLE `AuthTokens` DISABLE KEYS */;
INSERT INTO `AuthTokens` VALUES ('KfykAB49x7755YW9owXYrmSk63fXd1nElx93BRjJkmleOt8XMv4rSbhYSh0YrlR8',298,'2016-11-17 19:09:48'),('7Dw3MO1iFM4thqWUISVVH6q78UAyNBvLKKl3XR2Z9BVmCpQuTv6Hov13Aeo5omlo',299,'2016-11-17 19:09:48'),('dOIyOhXSfljz5xOGr2ejchtzLp5MNCyqeOevMAJjzcGx5UNd1ER5b4pPqSr5OpHe',300,'2016-11-17 19:09:48'),('vS3YlR797M8XsX0svq41P9qZ6pCrHyQEY2aoZXDmkFWyn8WbHg2DmYCcMXjObdSR',301,'2016-11-17 19:09:48'),('6EFIBgyzWhfNNoy7hOjsATGwbyUHEJQbkkoFGmKessD1X8VKbrAxKYwLdVKG6VFo',302,'2016-11-17 19:10:00'),('Orb1WXT7liShbBencmlaY9L1TubgKnQNJFCGmsZdEeX6WcZtExZYAU7BDXmnmjwb',303,'2016-11-17 19:10:00'),('E0PN83pHuXrxv3k5bwOYSdjNpWIl7UmuqWqnc3wklwQdTLLLV8Zns3L1osBgc8fE',304,'2016-11-17 19:10:00'),('pxaCYv5y3Pp9wK8ilMs8Nsm2d2hwpE3wJnYUwY8zOcToVtLDwcfIQKKNdSLxMLhw',305,'2016-11-17 19:10:00');
/*!40000 ALTER TABLE `AuthTokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Choices`
--

DROP TABLE IF EXISTS `Choices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Choices` (
  `choiceid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` text,
  `pollid` int(11) DEFAULT NULL,
  PRIMARY KEY (`choiceid`),
  KEY `fk_pollid_choices_idx` (`pollid`),
  CONSTRAINT `fk_pollid_choices` FOREIGN KEY (`pollid`) REFERENCES `Polls` (`pollid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Choices`
--

LOCK TABLES `Choices` WRITE;
/*!40000 ALTER TABLE `Choices` DISABLE KEYS */;
INSERT INTO `Choices` VALUES (1,'Choice A','This is choice A',1),(2,'Choice B','This is choice B',1),(3,'Choice C','This is choice C',1),(4,'Choice D','This is choice D',1),(80,'test api create poll choice 1 name','test api create poll choice 1 description',4),(81,'test api create poll choice 2 name','test api create poll choice 2 description',4),(82,'test api create poll choice 3 name','test api create poll choice 3 description',4),(83,'test api create poll choice 4 name','test api create poll choice 4 description',4);
/*!40000 ALTER TABLE `Choices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Polls`
--

DROP TABLE IF EXISTS `Polls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Polls` (
  `pollid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` text,
  `pollcode` char(8) NOT NULL,
  `available` tinyint(1) NOT NULL DEFAULT '0',
  `votingopen` timestamp NULL DEFAULT NULL,
  `votingclosed` timestamp NULL DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `winner` int(11) DEFAULT '-1',
  `status` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pollid`),
  KEY `fk_voterid_polls_idx` (`creator`),
  CONSTRAINT `fk_voterid_polls` FOREIGN KEY (`creator`) REFERENCES `Voters` (`voterid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Polls`
--

LOCK TABLES `Polls` WRITE;
/*!40000 ALTER TABLE `Polls` DISABLE KEYS */;
INSERT INTO `Polls` VALUES (1,'Test Poll','This is a test poll.','abcdefgh',1,'2016-10-03 22:50:58',NULL,1,1,2),(2,'test api create poll name','api create poll test description','BVGts8Hf',0,NULL,NULL,11,0,0),(3,'test api create poll name','api create poll test description','DRuuGLPW',0,NULL,NULL,11,0,0),(4,'test api create poll name','api create poll test description','ns8tfJB8',0,NULL,NULL,11,0,0),(26,'TestTile','This is a test description.','zjOdr0si',0,NULL,NULL,1,-1,0);
/*!40000 ALTER TABLE `Polls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Voters`
--

DROP TABLE IF EXISTS `Voters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Voters` (
  `voterid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `email` varchar(254) NOT NULL,
  `securedby` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`voterid`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `index_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Voters`
--

LOCK TABLES `Voters` WRITE;
/*!40000 ALTER TABLE `Voters` DISABLE KEYS */;
INSERT INTO `Voters` VALUES (1,'One','TestVoter','fake1@fake.com','1cf311c819be2d73ab4a3c8cb5327418c4f9e30cb17adb4c9330272fcc8e984c'),(2,'Two','TestVoter','fake2@fake.com','testpass'),(3,'Three','TestVoter','fake3@fake.com','1cf311c819be2d73ab4a3c8cb5327418c4f9e30cb17adb4c9330272fcc8e984c'),(4,'Four','TestVoter','fake4@fake.com','1cf311c819be2d73ab4a3c8cb5327418c4f9e30cb17adb4c9330272fcc8e984c'),(5,'Five','TestVoter','fake5@fake.com','1cf311c819be2d73ab4a3c8cb5327418c4f9e30cb17adb4c9330272fcc8e984c'),(6,'Six','TestVoter','fake6@fake.com','1cf311c819be2d73ab4a3c8cb5327418c4f9e30cb17adb4c9330272fcc8e984c'),(7,'Seven','TestVoter','fake7@fake.com','voterpass'),(8,'Eight','TestVoter','fake8@fake.com','voterpass'),(9,'Nine','TestVoter','fake9@fake.com','voterpass'),(10,'Ten','TestVoter','fake10@fake.com','voterpass'),(11,'Aaron','Anderson','irvingmichael@gmail.com','voterpass'),(12,'Admin','Istration','admin@fake.com','adminpass'),(13,'test','voter','fake11@fake.com',NULL),(18,'test','voter','fake12@fake.com',NULL),(23,'TestFirst','TestLast','testemail@fake.com',NULL);
/*!40000 ALTER TABLE `Voters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VotersPolls`
--

DROP TABLE IF EXISTS `VotersPolls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VotersPolls` (
  `voterid` int(11) NOT NULL,
  `pollid` int(11) NOT NULL,
  `notify` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pollid`,`voterid`,`notify`),
  KEY `fk_voterid_voters_idx` (`voterid`),
  KEY `fk_pollid_polls_idx` (`pollid`),
  CONSTRAINT `fk_pollid_polls` FOREIGN KEY (`pollid`) REFERENCES `Polls` (`pollid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_voterid_voters` FOREIGN KEY (`voterid`) REFERENCES `Voters` (`voterid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VotersPolls`
--

LOCK TABLES `VotersPolls` WRITE;
/*!40000 ALTER TABLE `VotersPolls` DISABLE KEYS */;
INSERT INTO `VotersPolls` VALUES (1,1,0),(1,3,0),(1,26,0),(2,1,0),(3,1,0),(4,1,0),(5,1,0),(6,1,0),(7,1,0),(8,1,0),(9,1,0),(10,1,0);
/*!40000 ALTER TABLE `VotersPolls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Votes`
--

DROP TABLE IF EXISTS `Votes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Votes` (
  `voteid` int(11) NOT NULL AUTO_INCREMENT,
  `pollid` int(11) DEFAULT NULL,
  `voterid` int(11) DEFAULT NULL,
  `choiceid` int(11) DEFAULT NULL,
  `rank` int(11) NOT NULL,
  `votecast` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`voteid`),
  KEY `fk_choice-id_choices_idx` (`choiceid`),
  KEY `fk_poll-id_choices_idx` (`pollid`),
  KEY `fk_voter-id_choices_idx` (`voterid`),
  CONSTRAINT `fk_choiceid_votes` FOREIGN KEY (`choiceid`) REFERENCES `Choices` (`choiceid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pollid_votes` FOREIGN KEY (`pollid`) REFERENCES `Polls` (`pollid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_voterid_votes` FOREIGN KEY (`voterid`) REFERENCES `Voters` (`voterid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Votes`
--

LOCK TABLES `Votes` WRITE;
/*!40000 ALTER TABLE `Votes` DISABLE KEYS */;
INSERT INTO `Votes` VALUES (1,1,1,1,1,'2016-10-03 22:58:21'),(2,1,1,2,2,'2016-10-03 22:58:21'),(3,1,1,3,3,'2016-10-03 22:58:21'),(4,1,1,4,4,'2016-10-03 22:58:21'),(5,1,2,2,1,'2016-10-03 22:58:21'),(6,1,2,1,2,'2016-10-03 22:58:21'),(7,1,2,3,3,'2016-10-03 22:58:21'),(8,1,2,4,4,'2016-10-03 22:58:21'),(9,1,3,2,1,'2016-10-03 22:58:21'),(10,1,3,1,2,'2016-10-03 22:58:21'),(11,1,3,3,3,'2016-10-03 22:58:21'),(12,1,3,4,4,'2016-10-03 22:58:21'),(13,1,4,2,1,'2016-10-03 22:58:21'),(14,1,4,1,2,'2016-10-03 22:58:21'),(15,1,4,3,3,'2016-10-03 22:58:21'),(16,1,4,4,4,'2016-10-03 22:58:21'),(17,1,5,3,1,'2016-10-03 22:58:21'),(18,1,5,4,2,'2016-10-03 22:58:21'),(19,1,5,1,3,'2016-10-03 22:58:21'),(20,1,5,2,4,'2016-10-03 22:58:21'),(21,1,6,2,1,'2016-10-03 22:58:21'),(22,1,6,3,2,'2016-10-03 22:58:21'),(23,1,6,4,3,'2016-10-03 22:58:21'),(24,1,6,1,4,'2016-10-03 22:58:21'),(25,1,7,1,1,'2016-10-03 22:58:21'),(26,1,7,2,2,'2016-10-03 22:58:21'),(27,1,7,3,3,'2016-10-03 22:58:21'),(28,1,7,4,4,'2016-10-03 22:58:21'),(29,1,8,4,1,'2016-10-03 22:58:21'),(30,1,8,1,2,'2016-10-03 22:58:21'),(31,1,8,3,3,'2016-10-03 22:58:21'),(32,1,8,2,4,'2016-10-03 22:58:21'),(33,1,9,2,1,'2016-10-03 22:58:21'),(34,1,9,3,2,'2016-10-03 22:58:21'),(35,1,9,1,3,'2016-10-03 22:58:21'),(36,1,9,4,4,'2016-10-03 22:58:21'),(37,1,10,1,1,'2016-10-03 22:58:21'),(38,1,10,2,2,'2016-10-03 22:58:21'),(39,1,10,3,3,'2016-10-03 22:58:21'),(40,1,10,4,4,'2016-10-03 22:58:21'),(41,1,11,1,1,'2016-11-11 21:28:05'),(42,1,11,2,2,'2016-11-11 21:28:05'),(43,1,11,3,4,'2016-11-11 21:28:05'),(44,1,11,4,4,'2016-11-11 21:28:05'),(45,1,11,1,1,'2016-11-11 21:29:09'),(46,1,11,2,2,'2016-11-11 21:29:09'),(47,1,11,3,4,'2016-11-11 21:29:09'),(48,1,11,4,4,'2016-11-11 21:29:09'),(49,1,11,1,1,'2016-11-11 21:29:53'),(50,1,11,2,2,'2016-11-11 21:29:53'),(51,1,11,3,4,'2016-11-11 21:29:53'),(52,1,11,4,4,'2016-11-11 21:29:53'),(53,1,11,1,1,'2016-11-11 21:30:02'),(54,1,11,2,2,'2016-11-11 21:30:02'),(55,1,11,3,4,'2016-11-11 21:30:02'),(56,1,11,4,4,'2016-11-11 21:30:02'),(57,1,11,1,1,'2016-11-11 21:32:01'),(58,1,11,2,2,'2016-11-11 21:32:01'),(59,1,11,3,4,'2016-11-11 21:32:01'),(60,1,11,4,4,'2016-11-11 21:32:01'),(61,1,11,1,1,'2016-11-11 21:32:37'),(62,1,11,2,2,'2016-11-11 21:32:37'),(63,1,11,3,4,'2016-11-11 21:32:37'),(64,1,11,4,4,'2016-11-11 21:32:37'),(65,1,11,1,1,'2016-11-11 21:40:37'),(66,1,11,2,2,'2016-11-11 21:40:37'),(67,1,11,3,4,'2016-11-11 21:40:37'),(68,1,11,4,4,'2016-11-11 21:40:37'),(69,1,11,1,1,'2016-11-15 06:16:53'),(70,1,11,2,2,'2016-11-15 06:16:53'),(71,1,11,3,4,'2016-11-15 06:16:53'),(72,1,11,4,4,'2016-11-15 06:16:53'),(73,1,11,1,1,'2016-11-15 20:53:42'),(74,1,11,2,2,'2016-11-15 20:53:42'),(75,1,11,3,4,'2016-11-15 20:53:42'),(76,1,11,4,4,'2016-11-15 20:53:42'),(77,1,11,1,1,'2016-11-15 21:02:58'),(78,1,11,2,2,'2016-11-15 21:02:58'),(79,1,11,3,4,'2016-11-15 21:02:58'),(80,1,11,4,4,'2016-11-15 21:02:58'),(81,1,11,1,1,'2016-11-15 21:03:28'),(82,1,11,2,2,'2016-11-15 21:03:28'),(83,1,11,3,4,'2016-11-15 21:03:28'),(84,1,11,4,4,'2016-11-15 21:03:28'),(85,1,11,1,1,'2016-11-15 21:05:41'),(86,1,11,2,2,'2016-11-15 21:05:41'),(87,1,11,3,4,'2016-11-15 21:05:41'),(88,1,11,4,4,'2016-11-15 21:05:41'),(89,1,11,1,1,'2016-11-15 21:11:57'),(90,1,11,2,2,'2016-11-15 21:11:57'),(91,1,11,3,4,'2016-11-15 21:11:57'),(92,1,11,4,4,'2016-11-15 21:11:57'),(93,1,11,1,1,'2016-11-15 21:13:27'),(94,1,11,2,2,'2016-11-15 21:13:27'),(95,1,11,3,4,'2016-11-15 21:13:27'),(96,1,11,4,4,'2016-11-15 21:13:27'),(97,1,11,1,1,'2016-11-17 16:17:30'),(98,1,11,2,2,'2016-11-17 16:17:30'),(99,1,11,3,4,'2016-11-17 16:17:30'),(100,1,11,4,4,'2016-11-17 16:17:30'),(101,1,11,1,1,'2016-11-17 16:18:16'),(102,1,11,2,2,'2016-11-17 16:18:16'),(103,1,11,3,4,'2016-11-17 16:18:16'),(104,1,11,4,4,'2016-11-17 16:18:16'),(105,1,11,1,1,'2016-11-17 16:18:52'),(106,1,11,2,2,'2016-11-17 16:18:52'),(107,1,11,3,4,'2016-11-17 16:18:52'),(108,1,11,4,4,'2016-11-17 16:18:52'),(109,1,11,1,1,'2016-11-17 16:19:32'),(110,1,11,2,2,'2016-11-17 16:19:32'),(111,1,11,3,4,'2016-11-17 16:19:32'),(112,1,11,4,4,'2016-11-17 16:19:32'),(113,1,11,1,1,'2016-11-17 19:09:48'),(114,1,11,2,2,'2016-11-17 19:09:48'),(115,1,11,3,4,'2016-11-17 19:09:48'),(116,1,11,4,4,'2016-11-17 19:09:48'),(117,1,11,1,1,'2016-11-17 19:10:00'),(118,1,11,2,2,'2016-11-17 19:10:00'),(119,1,11,3,4,'2016-11-17 19:10:00'),(120,1,11,4,4,'2016-11-17 19:10:00');
/*!40000 ALTER TABLE `Votes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-21 16:12:32
