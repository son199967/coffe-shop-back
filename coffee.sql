-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: coffee
-- ------------------------------------------------------
-- Server version	5.7.30-log

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
-- Table structure for table `ca_lam_viec`
--

DROP TABLE IF EXISTS `ca_lam_viec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ca_lam_viec` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gio_bat_dau` varchar(255) DEFAULT NULL,
  `gio_ket_thuc` varchar(255) DEFAULT NULL,
  `ngay` datetime DEFAULT NULL,
  `ten_clv` varchar(255) DEFAULT NULL,
  `hs` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ca_lam_viec`
--

LOCK TABLES `ca_lam_viec` WRITE;
/*!40000 ALTER TABLE `ca_lam_viec` DISABLE KEYS */;
INSERT INTO `ca_lam_viec` VALUES (1,'7h30','12h00','2020-12-07 00:00:00','1',1),(2,'12h00','17h30','2020-12-07 00:00:00','2',1),(3,'17h30','23h00','2020-12-07 00:00:00','3',1),(4,'7h30','12h00','2020-12-08 00:00:00','1',1),(5,'12h00','17h30','2020-12-08 00:00:00','2',1),(6,'17h30','23h00','2020-12-08 00:00:00','3',1),(7,'7h30','12h00','2020-12-09 00:00:00','1',1),(8,'12h00','17h30','2020-12-09 00:00:00','2',1),(9,'17h30','23h00','2020-12-09 00:00:00','3',1),(10,'7h30','12h00','2020-12-10 00:00:00','1',1),(11,'12h00','17h30','2020-12-10 00:00:00','2',1),(12,'17h30','23h00','2020-12-10 00:00:00','3',1),(13,'7h30','12h00','2020-12-11 00:00:00','1',1),(14,'12h00','17h30','2020-12-11 00:00:00','2',1),(15,'17h30','23h00','2020-12-11 00:00:00','3',1),(16,'7h30','12h00','2020-12-12 00:00:00','1',1.5),(17,'12h00','17h30','2020-12-12 00:00:00','2',1.5),(18,'17h30','23h00','2020-12-12 00:00:00','3',1.5),(19,'7h30','12h00','2020-12-13 00:00:00','1',1.5),(20,'12h00','17h30','2020-12-13 00:00:00','2',1.5),(21,'17h30','23h00','2020-12-13 00:00:00','3',1.5);
/*!40000 ALTER TABLE `ca_lam_viec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ca_lam_viec_nhan_vien`
--

DROP TABLE IF EXISTS `ca_lam_viec_nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ca_lam_viec_nhan_vien` (
  `ca_lam_viec_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FKhensu4bkppco87fl60ebyqd86` (`user_id`),
  KEY `FK75jsgo2o0sq454q4pvq6gkqva` (`ca_lam_viec_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ca_lam_viec_nhan_vien`
--

LOCK TABLES `ca_lam_viec_nhan_vien` WRITE;
/*!40000 ALTER TABLE `ca_lam_viec_nhan_vien` DISABLE KEYS */;
/*!40000 ALTER TABLE `ca_lam_viec_nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don`
--

DROP TABLE IF EXISTS `hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoa_don` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `chi_phi_khac` decimal(19,2) DEFAULT NULL,
  `giam_gia` int(11) DEFAULT NULL,
  `khach_hang_id` bigint(20) DEFAULT NULL,
  `so_nguoi` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `tong_tien` decimal(19,2) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK45yefwseblq7nk803cwxkidip` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don`
--

LOCK TABLES `hoa_don` WRITE;
/*!40000 ALTER TABLE `hoa_don` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don_chi_tiet`
--

DROP TABLE IF EXISTS `hoa_don_chi_tiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoa_don_chi_tiet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hoa_don_id` bigint(20) DEFAULT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `san_pham_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqc1kn4qu2dqf4pb1aa2avnv2r` (`san_pham_id`),
  KEY `FK8it5rkm179qgy53rxgafr1d5x` (`hoa_don_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don_chi_tiet`
--

LOCK TABLES `hoa_don_chi_tiet` WRITE;
/*!40000 ALTER TABLE `hoa_don_chi_tiet` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoa_don_chi_tiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khach_hang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `diemtl` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `ten_kh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kho_hang`
--

DROP TABLE IF EXISTS `kho_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kho_hang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mota` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kho_hang`
--

LOCK TABLES `kho_hang` WRITE;
/*!40000 ALTER TABLE `kho_hang` DISABLE KEYS */;
/*!40000 ALTER TABLE `kho_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguyen_lieu`
--

DROP TABLE IF EXISTS `nguyen_lieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguyen_lieu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ten_nguyen_lieu` varchar(255) DEFAULT NULL,
  `don_vi` varchar(255) DEFAULT NULL,
  `gia_nhap` decimal(19,2) DEFAULT NULL,
  `hang` varchar(255) DEFAULT NULL,
  `hinh_anh` varchar(255) DEFAULT NULL,
  `ngay_nhap` datetime DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguyen_lieu`
--

LOCK TABLES `nguyen_lieu` WRITE;
/*!40000 ALTER TABLE `nguyen_lieu` DISABLE KEYS */;
/*!40000 ALTER TABLE `nguyen_lieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `san_pham`
--

DROP TABLE IF EXISTS `san_pham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `san_pham` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gia` decimal(19,2) DEFAULT NULL,
  `hinh_anh` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `hs_discount` double DEFAULT NULL,
  `loai` varchar(255) DEFAULT NULL,
  `mota` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `ten_san_pham` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `san_pham`
--

LOCK TABLES `san_pham` WRITE;
/*!40000 ALTER TABLE `san_pham` DISABLE KEYS */;
INSERT INTO `san_pham` VALUES (35,35000.00,'https://thecoffeevn.com/wp-content/uploads/2019/06/Cookies-Coffee-Mint.png',10,'Kem Float',NULL,'Kem Float Dừa'),(34,35000.00,'https://thecoffeevn.com/wp-content/uploads/2019/06/Cookies-Coffee-Mint.png',10,'Kem Float',NULL,'Kem Float Mint'),(33,35000.00,'https://thecoffeevn.com/wp-content/uploads/2019/06/Cookies-Coffee-Mint.png',10,'Kem Float',NULL,'Kem Float Vani'),(32,35000.00,'https://thecoffeevn.com/wp-content/uploads/2019/06/Cookies-Coffee-Mint.png',10,'Kem Float',NULL,'Kem Float cafe '),(31,37000.00,'https://img.foodbook.vn/cms-admin/20190723/1563851351895-Smoothies-Cam.jpg',10,'Smoothie',NULL,'Smoothie Hỗn Hợp'),(30,37000.00,'https://images.immediate.co.uk/production/volatile/sites/30/2020/08/kiwi-smoothie-3086931.jpg',10,'Smoothie',NULL,'Smoothie Kiwi'),(29,37000.00,'https://tigersugar.com.vn/wp-content/uploads/2018/11/smoothie-chanh-day.jpg',10,'Smoothie',NULL,'Smoothie Chanh Leo'),(28,37000.00,'https://cf.shopee.vn/file/da625991d111a42d323f468063be57c6',10,'Smoothie',NULL,'Smoothie Đào'),(27,37000.00,'https://img.foodbook.vn/cms-admin/20190723/1563851351895-Smoothies-Cam.jpg',10,'Smoothie',NULL,'Smoothie Nha Đam+Cam'),(26,37000.00,'https://hoaxuongrong.org/Resources/media/saved/2018/7/2177/cong-thuc-lam-sua-chua-xoai-dua-4495c4b2.jpg',10,'Smoothie',NULL,'Smoothie Dứa Xoài'),(25,37000.00,'https://media.phunutoday.vn/files/maibaotram/2018/04/03/sinh-to-dau-nho-1827.jpg',10,'Smoothie',NULL,'Smoothie Dâu Rừng'),(24,37000.00,'https://nguyenlieuphache.com.vn/upload/congthuc/smoothie-viet-quat.jpg',10,'Smoothie',NULL,'Smoothie Việt Quất'),(23,45000.00,'https://anh.24h.com.vn/upload/1-2016/images/2016-03-28/1459167714-xoai_mit_2.jpg',10,'Sinh Tố',NULL,'Sinh tố Bơ xoài'),(22,45000.00,'https://bizweb.dktcdn.net/thumb/grande/100/133/179/products/mang-cau-bo.jpg?v=1491965154400',10,'Sinh Tố',NULL,'Sinh tố Bơ mãng cầu'),(21,35000.00,'https://anh.eva.vn//upload/2-2017/images/2017-05-12/extra_large/1494547409-cach-lam-sinh-to-bo-sua.jpg',10,'Sinh Tố',NULL,'Sinh tố Dứa sữa chua'),(20,30000.00,'https://media.phunutoday.vn/files/nguyenai/2017/08/01/5-cong-thuc-lam-sinh-to-canh-day-ngon-mat-cho-mua-he2-1447-phunutoday.jpg',10,'Sinh Tố',NULL,'Sinh tố Chanh leo'),(19,30000.00,'https://media.cooky.vn/recipe/g1/730/s480x480/recipe730-cook-step4-636867081333275902.jpg',10,'Sinh Tố',NULL,'Sinh tố Dưa Hấu'),(18,30000.00,'https://ameovat.com/wp-content/uploads/2017/03/cach-lam-sinh-to-xoai-7.jpg',10,'Sinh Tố',NULL,'Sinh tố Xoài'),(17,40000.00,'https://ameovat.com/wp-content/uploads/2016/07/cach-lam-sinh-to-mang-cau-xiem.jpg',10,'Sinh Tố',NULL,'Sinh tố Mãng Cầu'),(16,35000.00,'https://product.hstatic.net/200000069234/product/s4__s19__5__733ec895ac004967b818ea4c92a734d9_master.jpg',10,'Sinh Tố',NULL,'Sinh tố Bơ'),(15,25000.00,'https://khonguyenlieu.com/wp-content/uploads/2019/11/chanh-tuy%E1%BA%BFt-1.jpg',10,'Nước trái cây',NULL,'Chanh/Mơ muối Shake'),(14,25000.00,'https://cdn.dayphache.edu.vn/wp-content/uploads/2019/05/hinh-anh-tac-xi-muoi-da.jpg',10,'Nước trái cây',NULL,'Xí Muội Shake'),(13,30000.00,'https://cdn.tgdd.vn/Files/2018/11/27/1134029/cong-dung-cua-nuoc-cam-tuoi-va-cach-bao-quan-nuoc-cam-tot-nhat-6.jpg',10,'Nước trái cây',NULL,'Nước Cam'),(12,20000.00,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmb97xgLlH3fO7UHjJ7FRrh5HJwHHjmY0GKQ&usqp=CAU',10,'Nước trái cây',NULL,'Nước Quất'),(11,25000.00,'https://cdn.huongnghiepaau.com/wp-content/uploads/2017/08/nuoc-ep-dua-hau-ngot-mat.jpg',10,'Nước trái cây',NULL,'Dưa Hấu'),(10,20000.00,'https://www.vuacua.vn/upload/product/nuocchanh.jpg',10,'Nước trái cây',NULL,'Chanh tươi'),(9,25000.00,'https://media.cooky.vn/images/blog-2016/bat-mi-cong-dung-lam-dep-toan-dien-cua-chanh-day-6.jpg',10,'Nước trái cây',NULL,'Chanh leo'),(8,25000.00,'https://vuicoffee.com/daily/wp-content/uploads/2019/09/cacaoda.jpg',10,'coffee',NULL,'cafe cacao đá/nóng'),(7,25000.00,'https://bonjourcoffee.vn/blog/wp-content/uploads/2020/11/bac-xiu-3-tang.jpg',10,'coffee',NULL,'cafe bạc xỉu'),(6,30000.00,'https://jarvis.vn/wp-content/uploads/2019/12/khuyay-nhe.jpg',10,'coffee',NULL,'cafe sữa chua shake'),(5,30000.00,'https://cdn.huongnghiepaau.com/wp-content/uploads/2020/05/mon-ca-phe-tran-chau-cot-dua.jpg',10,'coffee',NULL,'cafe cốt dừa'),(4,30000.00,'https://beptruong.edu.vn/wp-content/uploads/2019/01/ca-phe-da-xay.jpg',10,'coffee',NULL,'cafe đá xay'),(3,28000.00,'https://beptruong.edu.vn/wp-content/uploads/2019/01/ca-phe-da-xay.jpg',10,'coffee',NULL,'cafe JQK'),(2,22000.00,'https://vintagecafeq7.com/wp-content/uploads/2018/08/cafe-sua-3.jpg',10,'coffee',NULL,'cafe nâu đá/nóng'),(1,22000.00,'https://sevencafe.net/wp-content/uploads/2018/10/cafedenda.jpg',10,'coffee',NULL,'cafe đen đá/nóng'),(36,35000.00,'https://thecoffeevn.com/wp-content/uploads/2019/06/Cookies-Coffee-Mint.png',10,'Kem Float',NULL,'Kem Float Dâu'),(37,35000.00,'https://thecoffeevn.com/wp-content/uploads/2019/06/Cookies-Coffee-Mint.png',10,'Kem Float',NULL,'Kem Float Chocolate'),(38,28000.00,'https://thecoffeevn.com/wp-content/uploads/2019/06/Cookies-Coffee-Mint.png',10,'Kem Float',NULL,'Kem Float Viên'),(39,18000.00,'https://media.cooky.vn/recipe/g5/47916/s320x320/recipe47916-cook-step6-636975739136566429.jpg',10,'Sữa Chua',NULL,'Sữa Chua Thạch'),(40,18000.00,'https://lamviet.net/wp-content/uploads/2020/04/sua-chua-ca-cao.jpg',10,'Sữa Chua',NULL,'Sữa Chua Cacao '),(41,18000.00,'https://vinbarista.com/uploads/editer/images/cach-lam-sinh-to-sua-chua-ca-phe.jpg',10,'Sữa Chua',NULL,'Sữa Chua cafe ');
/*!40000 ALTER TABLE `san_pham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `email` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `fist_name` varchar(255) DEFAULT NULL,
  `identification` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `index_salarys` decimal(19,2) DEFAULT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `role` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `username` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'phường Bách Khoa, Hai Bà Trưng , Hà Nội','Hai Bà Trưng','a@gmail.com','Trần',NULL,1.00,'Anh','123456','0123456789','Hà Nội','ROLE_USER','admin1'),(2,'phường Bách Khoa, Hai Bà Trưng , Hà Nội','Hai Bà Trưng','b@gmail.com','Nguyễn',NULL,1.00,'Sơn','123456','0123456789','Hà Nội','ROLE_USER','admin2'),(3,'phường Bách Khoa, Hai Bà Trưng , Hà Nội','Hai Bà Trưng','c@gmail.com','Nguyễn',NULL,1.00,'Tựu ','123456','0123456789','Hà Nội','ROLE_ADMIN','admin3'),(4,'phường Bách Khoa, Hai Bà Trưng , Hà Nội','Hai Bà Trưng','d@gmail.com','Nguyễn',NULL,1.00,'Quyết','123456','0123456789','Hà Nội','ROLE_ADMIN','admin4');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'coffee'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-09  1:58:24
