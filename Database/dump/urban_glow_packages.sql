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
-- Table structure for table `packages`
--

DROP TABLE IF EXISTS `packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `packages` (
  `packageid` int NOT NULL AUTO_INCREMENT,
  `ownerid` int NOT NULL,
  `packagename` varchar(100) NOT NULL,
  `packagedesc` varchar(500) NOT NULL,
  `packagephoto` varchar(500) NOT NULL,
  `price` varchar(45) NOT NULL,
  `offerprice` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`packageid`),
  KEY `ownerid_idx` (`ownerid`),
  CONSTRAINT `ownerid` FOREIGN KEY (`ownerid`) REFERENCES `owner_table` (`ownerid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packages`
--

LOCK TABLES `packages` WRITE;
/*!40000 ALTER TABLE `packages` DISABLE KEYS */;
INSERT INTO `packages` VALUES (15,1,'Nail Art & Extensions','Luxury nail care with elegant nail art, gel polish, acrylic extensions, chrome finishes, and premium manicure styling for a flawless feminine look.','owner_uploads/Nail_art.png','1999','999','Service'),(16,1,'Haircut & Styling','Professional haircut and styling services including layers, trims, blow-dry styling, smooth finishing, and modern salon looks for a fresh and elegant appearance.','owner_uploads/Haircut.png','2299','1599','Service'),(17,1,'Bridal Package','Bridal Package for Women lorem100 ipsum Package includes • Professional bridal makeup\r • HD flawless base\r • Elegant bridal hairstyle\r • Eye makeup with lashes\r • Saree/Dupatta draping\r • Basic touch-up support','owner_uploads/bridalpackage_1.png','16999','15999','Package'),(21,10,'Makeup','Luxury makeup service designed to enhance your natural beauty with flawless base makeup, perfectly defined eyes, elegant contouring, soft glam finishes, and long-lasting premium products for a radiant and sophisticated look.','owner_uploads/Makeup.png','2999','2599','Service'),(22,10,'Hair Spa','Relaxing hair spa treatment with deep scalp cleansing, nourishing hair mask application, soothing massage therapy, and premium hair care products designed to restore softness, shine, strength, and healthy-looking silky hair.\r\n','owner_uploads/HairSpa.png','2499','1799','Service'),(23,10,'Manicure','Premium manicure service including nail shaping, cuticle care, gentle exfoliation, relaxing hand massage, nourishing treatment, and elegant nail finishing for soft, healthy, and beautifully groomed hands.','owner_uploads/Manicure.png','1799','1399','Service'),(24,10,'Royal Beauty Package','Royal Beauty Package includes a complete luxury pampering experience with premium facial treatments, relaxing hair spa, HD makeup, manicure, pedicure, hair styling, clean-up & detan, eyebrow shaping, soothing head massage, and advanced skin care services for a flawless glow from head to toe.','owner_uploads/RoyalBeautyPkg.png','11999','9999','Package'),(25,2,'Facial','Luxury facial treatment designed to deeply cleanse, hydrate, brighten, and rejuvenate the skin using premium skincare products, relaxing massage techniques, and nourishing therapies for a fresh, radiant, and healthy glow.','owner_uploads/facial.png','1699','1299','Service'),(26,2,'Pedicure','Relaxing pedicure service including foot soak, nail shaping, cuticle care, exfoliation, moisturizing treatment, and gentle massage to leave your feet soft, refreshed, healthy, and beautifully groomed.p','owner_uploads/Pedicure.png','1499','1000','Service'),(27,2,'Smoothening & Spa Combo','Smoothening & Spa Combo includes advanced hair smoothening treatment, deep conditioning, nourishing hair spa, scalp massage, frizz control therapy, hydration repair, steam treatment, and premium hair care services for silky, smooth, shiny, and healthy-looking hair.\r\n\r\nPackage Includes:\r\n• Hair Smoothening\r\n• Deep Conditioning\r\n• Hair Spa Treatment\r\n• Scalp Massage\r\n• Steam Therapy\r\n• Frizz Control Care\r\n• Hydration Repair\r\n• Premium Hair Serum Application','owner_uploads/SSCOMBO.png','14999','9999','Package'),(28,12,'Head Massage','Relaxing head massage service designed to relieve stress, refresh the mind, improve relaxation, and provide a soothing spa experience with gentle scalp massage techniques and nourishing care.','owner_uploads/headmassage.png','1299','899','Service'),(29,12,'Eyelash Extensions','Professional eyelash extension service designed to enhance lash volume, length, and definition for a fuller, elegant, and naturally beautiful eye look with long-lasting results and premium beauty care.','owner_uploads/eyelash.png','1199','799','Service'),(30,15,'Gel Polish','Experience rich color with a flawless glossy finish.\r\nLong-lasting gel polish designed for shine and durability.\r\nGet salon-perfect nails with elegance in every stroke.\r\n','owner_uploads/gelpolish.png','1299','799','Service'),(31,15,'Premium Self-Care Package','Enjoy a luxurious self-care experience designed for complete relaxation.\r\nPamper yourself with premium beauty and wellness treatments.\r\nFeel refreshed, confident, and beautifully renewed. Package Includes:\r\n• Luxury Facial Treatment\r\n• Hair Spa & Smoothening\r\n• Manicure & Pedicure\r\n• Relaxing Head Massage\r\n• Premium Skin Care Rituals','owner_uploads/Premiumselfcare.png','14999','11999','Package'),(32,12,'Party Look Package','Get celebration-ready with a glamorous makeover designed to make you shine.\r\nEnhance your beauty with elegant styling and flawless finishing touches.\r\nStep into every party with confidence, charm, and a stunning look.\r\n\r\nPackage Includes:\r\n• Party Makeup\r\n• Hair Styling\r\n• Nail Art\r\n• Glow Facial\r\n• Eyelash & Eyebrow Styling','owner_uploads/Partylook.png','13999','8999','Package');
/*!40000 ALTER TABLE `packages` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-18 15:50:32
