CREATE DATABASE  IF NOT EXISTS `urban_glow` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `urban_glow`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: urban_glow
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `owner_table`
--

DROP TABLE IF EXISTS `owner_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owner_table` (
  `ownerid` int NOT NULL AUTO_INCREMENT,
  `ownername` varchar(45) NOT NULL,
  `owneremail` varchar(45) NOT NULL,
  `ownerpass` varchar(45) NOT NULL,
  `ownerphoto` varchar(500) NOT NULL,
  `shopphoto` varchar(500) NOT NULL,
  `shopname` varchar(45) NOT NULL,
  `shopdesc` varchar(1000) NOT NULL,
  `cityid` int NOT NULL,
  `latitude` varchar(100) NOT NULL,
  `longitude` varchar(100) NOT NULL,
  `starttime` varchar(45) NOT NULL,
  `endtime` varchar(45) NOT NULL,
  `experience` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'Pending',
  PRIMARY KEY (`ownerid`),
  KEY `cityid_idx` (`cityid`),
  CONSTRAINT `cityid` FOREIGN KEY (`cityid`) REFERENCES `city` (`cityid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner_table`
--

LOCK TABLES `owner_table` WRITE;
/*!40000 ALTER TABLE `owner_table` DISABLE KEYS */;
INSERT INTO `owner_table` VALUES (1,'Kiara Kapoor','kiara@gmail.com','2345','owner_uploads/Female_Owner.jpg','owner_uploads/Blush_glow1.png','Blush & Glow','It offers modern beauty and grooming services in a Stylish Environment.It is known for professional makeup, skincare and hair styling',3,'26.9124','75.7873','10','19','6','Approved'),(2,'Soumil','soumil@gmail.com','8070','owner_uploads/Male_Owner.jpg','owner_uploads/Noor_Beauty1.png','Noor Beauty Lounge','It delivers elegant beauty and relaxation services in a sophisticated environment. It is recongnized for premium skincare, spa therapies and refined self care experiences.',3,'26.9074','75.7906','11','17','9','Approved'),(10,'Samaira','samaira@gmail.com','5678','owner_uploads/Female_Owner2.jpg','owner_uploads/cc1salon.png','Crown & curls','It is a salon specializing in modern hairstyling, grooming and luxury treatments. It stands out for contemporary trends and professsional care for everyone',4,'24.5854','73.7125','9','17','7','Approved'),(12,'Vivan','vivan@gmail.com','9090','owner_uploads/Male_Owner.jpg','owner_uploads/cc_salon.png','Elite Glow Salon','It is a premium salon combining beauty, grooming, and wellness services under one roof.Konwn for its modern ambience and expert professionals, the salon provides a complete luxury experience',6,'17.3850','78.4867','10','17','7','Approved'),(15,'Ananya Sharma','ananya@gmail.com','2790','owner_uploads/Female_Owner.jpg','owner_uploads/velvet_glow.png','Velvet Glow Salon','It is a Luxury beauty salon offering premium hair styling, skincare, bridal makeup, and relaxing spa services in a modern elegant ambiance.',14,'30.7333','76.7794','10','18','8','Approved'),(18,'Aanya Mehra','aanya@gmail.com','7090','owner_uploads/Female_Owner.jpg','owner_uploads/Serene Glow Salon.png','Serene Glow Salon','Step into Serene Glow Salon, where elegance meets relaxation in a beautifully calming space designed to refresh your mind and enhance your natural beauty.\r\n\r\nFrom luxurious beauty treatments to personalized self-care experiences, every service is delivered with comfort, care, and premium attention to detail.',3,'26.603000568863383','75.22334671125283','08:59','7:00 PM','8','Approved'),(19,'Sanjana Khosla','sanjana@gmail.com','4090','owner_uploads/Female_Owner2.jpg','owner_uploads/Pink Whisper Salon.png','Pink whisper Salon','Pink Whisper Salon is a dreamy beauty destination designed with soft elegance, luxurious aesthetics, and a calming atmosphere that makes every visit feel special.\r\n\r\nFrom flawless makeovers to relaxing self-care treatments, every service is crafted to enhance your confidence while giving you a premium salon experience.',4,'24.636181990996988','73.16669845685828','09:00','6:00 PM','9','Approved'),(20,'Sakshi Arora','sakshi@gmail.com','2080','owner_uploads/Female_Owner.jpg','owner_uploads/cbbsalon.png','Crystal Bloom Beauty','Crystal Bloom Beauty is a modern luxury salon designed with soft pastel elegance, calming interiors, and a beautifully refreshing atmosphere that feels both premium and relaxing.\r\n\r\nFrom expert hair styling and radiant beauty services to personalized self-care treatments, every experience is crafted with comfort, care, and attention to detail.\r\n',4,'24.53401240954953','73.14840927228797','09:00','5:30 AM','11','Approved'),(21,'Amaira Sharma','amaira@gmail.com','3050','owner_uploads/Female_Owner.jpg','owner_uploads/moonstone.png','Moonstone Beauty','Moonstone Beauty is a luxurious self-care destination designed with soft elegance, modern sophistication, and a calm atmosphere that instantly feels refreshing and premium.\r\n\r\nFrom expert beauty services and flawless styling to relaxing pampering experiences, every treatment is thoughtfully crafted to make you feel confident, radiant, and cared for.\r\n\r\nWith serene interiors, glowing aesthetics, and a graceful contemporary vibe, Moonstone Beauty offers the perfect escape to relax, refresh, and shine beautifully.',6,'17.45661167362037','78.14173889369704','08:30','07:00','10','Approved');
/*!40000 ALTER TABLE `owner_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-18 15:50:31
