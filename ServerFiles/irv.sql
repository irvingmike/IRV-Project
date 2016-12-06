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
) ENGINE=InnoDB AUTO_INCREMENT=274 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AccessRoles`
--

LOCK TABLES `AccessRoles` WRITE;
/*!40000 ALTER TABLE `AccessRoles` DISABLE KEYS */;
INSERT INTO `AccessRoles` VALUES ('admin@fake.com','adminStd',1),('fake10@fake.com','voterStd',2),('fake1@fake.com','voterStd',3),('fake2@fake.com','voterStd',4),('fake3@fake.com','voterStd',5),('fake4@fake.com','voterStd',6),('fake5@fake.com','voterStd',7),('fake6@fake.com','voterStd',8),('fake7@fake.com','voterStd',9),('fake8@fake.com','voterStd',10),('fake9@fake.com','voterStd',11),('irvingmichael@gmail.com','voterStd',272),('irvingmichael@gmail.com','voterStd',273);
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
) ENGINE=InnoDB AUTO_INCREMENT=685 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Choices`
--

LOCK TABLES `Choices` WRITE;
/*!40000 ALTER TABLE `Choices` DISABLE KEYS */;
INSERT INTO `Choices` VALUES (1,'Choice A','This is choice A',1),(2,'Choice B','This is choice B',1),(3,'Choice C','This is choice C',1),(4,'Choice D','This is choice D',1),(420,'Luke Skywalker',NULL,37),(421,'Han Solo',NULL,37),(422,'Darth Vader',NULL,37),(423,'Jar Jar Binks',NULL,37),(424,'Watto',NULL,37),(425,'Rey',NULL,37),(426,'BB-8',NULL,37),(427,'Princess Leia',NULL,37),(428,'R2-D2',NULL,37),(429,'Chewbacca',NULL,37),(430,'C-3PO',NULL,37),(431,'Bacon',NULL,38),(432,'Pizza',NULL,38),(433,'Tacos',NULL,38),(434,'Brussel Sprouts',NULL,38),(435,'Fish Bladder Jelly',NULL,38),(436,'McDonalds',NULL,39),(437,'Taco Bell',NULL,39),(438,'KFC',NULL,39),(439,'Mac\'s',NULL,39),(440,'Wendy\'s',NULL,39),(441,'La Brioche',NULL,39),(442,'Graze',NULL,39),(443,'iPhone 8',NULL,40),(444,'iPhone 7s',NULL,40),(445,'iPhone 7',NULL,40),(446,'iPhone 6s',NULL,40),(447,'iPhone 6',NULL,40),(448,'Nokia 3310',NULL,40),(449,'Blocker',NULL,41),(450,'Sir Fluffington the Third',NULL,41),(451,'Wiskers Mousington',NULL,41),(452,'Fluffers Wiskerton',NULL,41),(453,'Bob',NULL,41),(454,'Lady Fluffalumpagus',NULL,41),(455,'Tien',NULL,41),(456,'Arie',NULL,41),(457,'Lillith',NULL,41),(458,'Country',NULL,42),(459,'Western',NULL,42),(460,'Christmas',NULL,43),(461,'Halloween',NULL,43),(462,'New Years',NULL,43),(463,'Thanksgiving',NULL,43),(464,'Rosh Hashanah',NULL,43),(465,'Ramadan',NULL,43),(466,'Basant',NULL,43),(467,'Easter',NULL,43),(468,'Diwali',NULL,43),(469,'Eid al-Adha',NULL,43),(585,'Citizen Kane',NULL,44),(586,'The Godfather',NULL,44),(587,'Casablanca',NULL,44),(588,'Raging Bull',NULL,44),(589,'Singin\' in the Rain',NULL,44),(590,'Gone with the Wind',NULL,44),(591,'Lawrence of Arabia',NULL,44),(592,'Schindler\'s List',NULL,44),(593,'Vertigo',NULL,44),(594,'The Wizard of Oz',NULL,44),(595,'City Lights',NULL,44),(596,'The Searchers',NULL,44),(597,'Star Wars',NULL,44),(598,'Psycho',NULL,44),(599,'2001: A Space Odyssey',NULL,44),(600,'Sunset Blvd.',NULL,44),(601,'The Graduate',NULL,44),(602,'The General',NULL,44),(603,'On the Waterfront',NULL,44),(604,'It\'s a Wonderful Life',NULL,44),(605,'Chinatown',NULL,44),(606,'Some like It Hot',NULL,44),(607,'The Grapes of Wrath',NULL,44),(608,'E.T. The Extra-terrestrial',NULL,44),(609,'To Kill a Mockingbird',NULL,44),(610,'Mr. Smith Goes to Washington',NULL,44),(611,'High Noon',NULL,44),(612,'All about Eve',NULL,44),(613,'Double Indemnity',NULL,44),(614,'Apocalypse Now',NULL,44),(615,'The Maltese Falcon',NULL,44),(616,'The Godfather Part Ii',NULL,44),(617,'One Flew over the Cuckoo\'s Nest',NULL,44),(618,'Snow White and the Seven Dwarfs',NULL,44),(619,'Annie Hall',NULL,44),(620,'The Bridge on the River Kwai',NULL,44),(621,'The Best Years of Our Lives',NULL,44),(622,'The Treasure of the Sierra Madre',NULL,44),(623,'Dr. Strangelove',NULL,44),(624,'The Sound of Music',NULL,44),(625,'King Kong',NULL,44),(626,'Bonnie and Clyde',NULL,44),(627,'Midnight Cowboy',NULL,44),(628,'The Philadelphia Story',NULL,44),(629,'Shane',NULL,44),(630,'It Happened One Night',NULL,44),(631,'A Streetcar Named Desire',NULL,44),(632,'Rear Window',NULL,44),(633,'Intolerance',NULL,44),(634,'West Side Story',NULL,44),(635,'Taxi Driver',NULL,44),(636,'The Deer Hunter',NULL,44),(637,'M*a*s*h',NULL,44),(638,'North by Northwest',NULL,44),(639,'Jaws',NULL,44),(640,'Rocky',NULL,44),(641,'The Gold Rush',NULL,44),(642,'Nashville',NULL,44),(643,'Duck Soup',NULL,44),(644,'Sullivan\'s Travels',NULL,44),(645,'American Graffiti',NULL,44),(646,'Cabaret',NULL,44),(647,'Network',NULL,44),(648,'The African Queen',NULL,44),(649,'Raiders of the Lost Ark',NULL,44),(650,'Who\'s Afraid of Virginia Woolf?',NULL,44),(651,'Unforgiven',NULL,44),(652,'Tootsie',NULL,44),(653,'A Clockwork Orange',NULL,44),(654,'Saving Private Ryan',NULL,44),(655,'The Shawshank Redemption',NULL,44),(656,'Butch Cassidy and the Sundance Kid',NULL,44),(657,'The Silence of the Lambs',NULL,44),(658,'In the Heat of the Night',NULL,44),(659,'Forrest Gump',NULL,44),(660,'All the President\'s Men',NULL,44),(661,'Modern Times',NULL,44),(662,'The Wild Bunch',NULL,44),(663,'The Apartment',NULL,44),(664,'Spartacus',NULL,44),(665,'Sunrise',NULL,44),(666,'Titanic',NULL,44),(667,'Easy Rider',NULL,44),(668,'A Night at the Opera',NULL,44),(669,'Platoon',NULL,44),(670,'12 Angry Men',NULL,44),(671,'Bringing up Baby',NULL,44),(672,'The Sixth Sense',NULL,44),(673,'Swing Time',NULL,44),(674,'Sophie\'s Choice',NULL,44),(675,'Goodfellas',NULL,44),(676,'The French Connection',NULL,44),(677,'Pulp Fiction',NULL,44),(678,'The Last Picture Show',NULL,44),(679,'Do the Right Thing',NULL,44),(680,'Blade Runner',NULL,44),(681,'Yankee Doodle Dandy',NULL,44),(682,'Toy Story',NULL,44),(683,'Ben-hur',NULL,44),(684,'LotR: The Fellowship of the Ring',NULL,44);
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
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Polls`
--

LOCK TABLES `Polls` WRITE;
/*!40000 ALTER TABLE `Polls` DISABLE KEYS */;
INSERT INTO `Polls` VALUES (1,'Test Poll','This is a test poll.','abcdefgh',0,'2016-10-03 22:50:58',NULL,34,-1,1),(37,'Favorite Stars Wars Characters','Tell us what you favorite Star Wars character is!','25kIEQyt',0,NULL,NULL,34,-1,0),(38,'What is your Favorite Food?','Bacon is obviously the answer','HhVZweTf',0,NULL,NULL,2,-1,2),(39,'Where should we eat lunch?','Where should Madison College have bought us lunch from for the show today?','WNaFMLLx',0,NULL,NULL,34,-1,0),(40,'Which is the Best Cell Phone?','Here we have listed all the cells phone fit to won. Which is your favorite?','XrU8pXOL',0,NULL,NULL,1,-1,0),(41,'Best Kittens Names','We have a new kitten!! Pics to come. Help us choose the name!','LfYgL86H',0,NULL,NULL,3,-1,2),(42,'What is the best type of music?','','7oBGz8kJ',0,NULL,NULL,3,-1,0),(43,'Which is the most popular holiday?','My birthday was not included in this list as it would have obviously been the only choice.','3qysb2SF',0,NULL,NULL,34,-1,0),(44,'Best Movie of All Time','This list is taken from AFI\'s Top 100 list.','fbxBj4L2',0,NULL,NULL,34,-1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Voters`
--

LOCK TABLES `Voters` WRITE;
/*!40000 ALTER TABLE `Voters` DISABLE KEYS */;
INSERT INTO `Voters` VALUES (1,'One','TestVoter','fake1@fake.com','1cf311c819be2d73ab4a3c8cb5327418c4f9e30cb17adb4c9330272fcc8e984c'),(2,'Two','TestVoter','fake2@fake.com','testpass'),(3,'Three','TestVoter','fake3@fake.com','1cf311c819be2d73ab4a3c8cb5327418c4f9e30cb17adb4c9330272fcc8e984c'),(4,'Four','TestVoter','fake4@fake.com','1cf311c819be2d73ab4a3c8cb5327418c4f9e30cb17adb4c9330272fcc8e984c'),(5,'Five','TestVoter','fake5@fake.com','1cf311c819be2d73ab4a3c8cb5327418c4f9e30cb17adb4c9330272fcc8e984c'),(6,'Six','TestVoter','fake6@fake.com','1cf311c819be2d73ab4a3c8cb5327418c4f9e30cb17adb4c9330272fcc8e984c'),(7,'Seven','TestVoter','fake7@fake.com','voterpass'),(8,'Eight','TestVoter','fake8@fake.com','voterpass'),(9,'Nine','TestVoter','fake9@fake.com','voterpass'),(10,'Ten','TestVoter','fake10@fake.com','voterpass'),(12,'Admin','Istration','admin@fake.com','713bfda78870bf9d1b261f565286f85e97ee614efe5f0faf7c34e7ca4f65baca'),(34,NULL,NULL,'irvingmichael@gmail.com','c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646');
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
INSERT INTO `VotersPolls` VALUES (1,1,0),(2,1,0),(3,1,1),(4,1,0),(5,1,1),(6,1,0),(7,1,1),(8,1,0),(9,1,1),(10,1,0),(34,1,0),(34,37,0),(34,38,0),(34,39,0),(34,40,0),(34,41,0),(34,42,0),(34,43,0),(34,44,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Votes`
--

LOCK TABLES `Votes` WRITE;
/*!40000 ALTER TABLE `Votes` DISABLE KEYS */;
INSERT INTO `Votes` VALUES (1,1,1,1,1,'2016-10-03 22:58:21'),(2,1,1,2,2,'2016-10-03 22:58:21'),(3,1,1,3,3,'2016-10-03 22:58:21'),(4,1,1,4,4,'2016-10-03 22:58:21'),(5,1,2,2,1,'2016-10-03 22:58:21'),(6,1,2,1,2,'2016-10-03 22:58:21'),(7,1,2,3,3,'2016-10-03 22:58:21'),(8,1,2,4,4,'2016-10-03 22:58:21'),(9,1,3,2,1,'2016-10-03 22:58:21'),(10,1,3,1,2,'2016-10-03 22:58:21'),(11,1,3,3,3,'2016-10-03 22:58:21'),(12,1,3,4,4,'2016-10-03 22:58:21'),(13,1,4,2,1,'2016-10-03 22:58:21'),(14,1,4,1,2,'2016-10-03 22:58:21'),(15,1,4,3,3,'2016-10-03 22:58:21'),(16,1,4,4,4,'2016-10-03 22:58:21'),(17,1,5,3,1,'2016-10-03 22:58:21'),(18,1,5,4,2,'2016-10-03 22:58:21'),(19,1,5,1,3,'2016-10-03 22:58:21'),(20,1,5,2,4,'2016-10-03 22:58:21'),(21,1,6,2,1,'2016-10-03 22:58:21'),(22,1,6,3,2,'2016-10-03 22:58:21'),(23,1,6,4,3,'2016-10-03 22:58:21'),(24,1,6,1,4,'2016-10-03 22:58:21'),(25,1,7,1,1,'2016-10-03 22:58:21'),(26,1,7,2,2,'2016-10-03 22:58:21'),(27,1,7,3,3,'2016-10-03 22:58:21'),(28,1,7,4,4,'2016-10-03 22:58:21'),(29,1,8,4,1,'2016-10-03 22:58:21'),(30,1,8,1,2,'2016-10-03 22:58:21'),(31,1,8,3,3,'2016-10-03 22:58:21'),(32,1,8,2,4,'2016-10-03 22:58:21'),(33,1,9,2,1,'2016-10-03 22:58:21'),(34,1,9,3,2,'2016-10-03 22:58:21'),(35,1,9,1,3,'2016-10-03 22:58:21'),(36,1,9,4,4,'2016-10-03 22:58:21'),(37,1,10,1,1,'2016-10-03 22:58:21'),(38,1,10,2,2,'2016-10-03 22:58:21'),(39,1,10,3,3,'2016-10-03 22:58:21'),(40,1,10,4,4,'2016-10-03 22:58:21');
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

-- Dump completed on 2016-12-06 14:00:54
