-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: wechatbuy
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `uiconsrc` varchar(100) DEFAULT NULL,
  `account` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `identity` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (58,NULL,'123123',NULL,'admin','wwwwwww@qq.com','管理员'),(59,NULL,'123123','admin-HWorld_640x1136_20170815_7.jpg','商家测试账号','wwwwwww@qq.com','商家'),(60,NULL,'123123','test1-598a40f607241ac00b00406eca43d287.jpg','test1','123@qq.com','普通用户'),(61,NULL,'123123','test1-HWorld_640x1136_20170815_3.jpg','test2','1@qq.com','商家'),(62,NULL,'123123','test1-598a40f607241ac00b00406eca43d287.jpg','test3','123@qq.com','商家'),(63,NULL,'123123',NULL,'jackqq','qw@w.com','商家'),(64,NULL,'123123',NULL,'admin2','qww@dd.com','管理员'),(65,NULL,'123123',NULL,'12255我','akmh@1222.cm','普通用户'),(66,NULL,'gaojian','admin-416c38c2b12fee7acd1498310e4dede8.jpg','高健大大大','123@qq.com','普通用户'),(67,NULL,'123123',NULL,'123456','123456@123.123','商家'),(68,NULL,'123123','test1-IMG_0044.JPG','123123123','adjgm@ladm.com','商家'),(69,NULL,'123123',NULL,'25812','gk@ln','普通用户'),(70,NULL,'123123','test1-IMG_0044.JPG','125842','twm@k','商家'),(71,NULL,'123123','test1-IMG_0044.JPG','123548','tmdag@jm','商家'),(72,NULL,'123123',NULL,'12312312','55257@jm','普通用户'),(73,NULL,'123123','test1-IMG_0044.JPG','1235485','1244@tj','普通用户'),(74,NULL,'111111','test1-IMG_0044.JPG','admin1','111@111','管理员'),(75,NULL,'111111','admin-IMG_0012.JPG','111111','111111@111','商家'),(76,NULL,'111111','111111-IMG_0044.JPG','管理员11','111@111','管理员'),(77,NULL,'111111','11-IMG_0012.PNG','5862553','111@111','管理员'),(78,NULL,'111111','111111-IMG_0047.JPG','最终测试管理员','1@1122','管理员'),(79,NULL,'111111',NULL,'测试用户1','1@111','商家'),(80,NULL,'123123','test1-IMG_0062.JPG','管理员1号','123@ba','管理员'),(81,NULL,'123123','test1-IMG_0023.JPG','刘二蛋农场','111@bu','商家'),(82,NULL,'123123','1号-IMG_0043.JPG','普通用户01号','123@123','普通用户'),(83,NULL,'11111111','test1-1513086055062.jpg','专业跑腿小哥','123@qq.com','商家'),(84,NULL,'123456789','admin-HWorld_640x1136_20170815_6.jpg','超级配送小哥','123@qq.com','商家'),(85,NULL,'ceshi1',NULL,'测试123','123@qq.com','商家'),(86,NULL,'123456789','undefined-IMG_3677.JPG','测试账号1','123@qq.com','商家'),(87,NULL,'123123','1号-IMG_0149.JPG','普通用户02','123@123','普通用户'),(88,NULL,'123123','01号-IMG_0137.JPG','演示01号','123@123','普通用户'),(89,NULL,'123123','-IMG_0146.JPG','惠先森家政玻璃','123@123','商家'),(90,NULL,'123123','-IMG_0150.JPG','迎宾菜场代购','123@123','商家'),(91,NULL,'123123','-IMG_0159.JPG','1栋王阿姨','123@123','普通用户'),(92,NULL,'123123','1栋王阿姨-IMG_0149.JPG','2栋杨阿姨','133@123','普通用户'),(93,NULL,'123456789',NULL,'21栋唐阿姨','123@qq.com','普通用户'),(94,NULL,'123456',NULL,'21栋马阿姨','123@qq.com','普通用户'),(95,NULL,'123123',NULL,'1栋高阿姨','123@qq.com','普通用户'),(96,NULL,'123123','1栋王阿姨-IMG_0167.JPG','张先生代购','123@123','普通用户'),(97,NULL,'123123','1栋王阿姨-IMG_0167.JPG','光明小区超市','123@123','商家'),(98,NULL,'zlj0906','undefined-101995816.jpg','13775231763','1154816326@qq.com','普通用户'),(99,NULL,'123123','2栋杨阿姨-IMG_0167.JPG','芳婆糕点铺','123@123','商家'),(100,NULL,'123123','01号-IMG_0077.JPG','3栋刘阿姨','123@123','普通用户');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `castpic`
--

DROP TABLE IF EXISTS `castpic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `castpic` (
  `picname` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `castpic`
--

LOCK TABLES `castpic` WRITE;
/*!40000 ALTER TABLE `castpic` DISABLE KEYS */;
INSERT INTO `castpic` VALUES ('c.jpg'),('d.jpg');
/*!40000 ALTER TABLE `castpic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `community`
--

DROP TABLE IF EXISTS `community`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `community` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `cname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `mid` (`mid`),
  CONSTRAINT `community_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `account` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community`
--

LOCK TABLES `community` WRITE;
/*!40000 ALTER TABLE `community` DISABLE KEYS */;
INSERT INTO `community` VALUES (52,80,'测试小区');
/*!40000 ALTER TABLE `community` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favourite`
--

DROP TABLE IF EXISTS `favourite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favourite` (
  `aid` int(11) NOT NULL,
  `orderid` int(11) DEFAULT NULL,
  `postid` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `orderid` (`orderid`),
  KEY `postid` (`postid`),
  CONSTRAINT `favourite_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `account` (`aid`),
  CONSTRAINT `favourite_ibfk_2` FOREIGN KEY (`orderid`) REFERENCES `theorder` (`orderid`),
  CONSTRAINT `favourite_ibfk_3` FOREIGN KEY (`postid`) REFERENCES `postinfo` (`postid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favourite`
--

LOCK TABLES `favourite` WRITE;
/*!40000 ALTER TABLE `favourite` DISABLE KEYS */;
/*!40000 ALTER TABLE `favourite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follower`
--

DROP TABLE IF EXISTS `follower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `follower` (
  `orderid` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `urstatus` varchar(30) DEFAULT NULL,
  `addressid` int(11) DEFAULT NULL,
  KEY `orderid` (`orderid`),
  KEY `aid` (`aid`),
  KEY `addressid` (`addressid`),
  CONSTRAINT `follower_ibfk_1` FOREIGN KEY (`orderid`) REFERENCES `theorder` (`orderid`),
  CONSTRAINT `follower_ibfk_2` FOREIGN KEY (`aid`) REFERENCES `account` (`aid`),
  CONSTRAINT `follower_ibfk_3` FOREIGN KEY (`addressid`) REFERENCES `useraddress` (`addressid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follower`
--

LOCK TABLES `follower` WRITE;
/*!40000 ALTER TABLE `follower` DISABLE KEYS */;
INSERT INTO `follower` VALUES (128,87,'留言','已收货',21),(130,82,'123','未付款',20),(129,88,'123','已收货',22),(135,91,'a户','未付款',23),(139,91,'给孩子买的 尽快发货哦','未付款',23),(140,91,'a版的','未付款',23),(135,92,'a','未付款',24),(140,92,'a','未付款',24),(139,92,'a','未付款',24),(141,100,'豆沙八宝饭','已收货',26);
/*!40000 ALTER TABLE `follower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mypost`
--

DROP TABLE IF EXISTS `mypost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mypost` (
  `aid` int(11) DEFAULT NULL,
  `postid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mypost`
--

LOCK TABLES `mypost` WRITE;
/*!40000 ALTER TABLE `mypost` DISABLE KEYS */;
INSERT INTO `mypost` VALUES (58,25),(58,25),(58,25),(58,25),(62,25),(62,25),(81,25),(81,25),(81,25),(81,25),(81,30),(81,30),(92,39),(92,39);
/*!40000 ALTER TABLE `mypost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notify`
--

DROP TABLE IF EXISTS `notify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notify` (
  `aid` int(11) DEFAULT NULL,
  `orderid` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `descs` varchar(40) DEFAULT NULL,
  `isread` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notify`
--

LOCK TABLES `notify` WRITE;
/*!40000 ALTER TABLE `notify` DISABLE KEYS */;
INSERT INTO `notify` VALUES (61,106,'seller','用户跟单',1),(61,105,'seller','用户跟单',1),(61,104,'seller','用户跟单',1),(62,106,'seller','用户跟单',1),(62,112,'seller','用户跟单',NULL),(60,105,'seller','用户跟单',1),(61,114,'seller','用户跟单',1),(61,115,'seller','用户跟单',1),(61,117,'seller','用户跟单',1),(60,117,'seller','用户跟单',1),(62,107,'seller','用户跟单',1),(60,116,'seller','用户跟单',1),(82,127,'seller','用户跟单',1),(60,123,'seller','用户跟单',NULL),(87,128,'seller','用户跟单',1),(82,130,'seller','用户跟单',1),(88,129,'seller','用户跟单',1),(91,135,'seller','用户跟单',NULL),(91,139,'seller','用户跟单',NULL),(91,140,'seller','用户跟单',NULL),(92,135,'seller','用户跟单',NULL),(92,140,'seller','用户跟单',NULL),(92,139,'seller','用户跟单',NULL),(100,141,'seller','用户跟单',1);
/*!40000 ALTER TABLE `notify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderBarcode`
--

DROP TABLE IF EXISTS `orderBarcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderBarcode` (
  `orderid` int(11) DEFAULT NULL,
  `barcodeurl` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderBarcode`
--

LOCK TABLES `orderBarcode` WRITE;
/*!40000 ALTER TABLE `orderBarcode` DISABLE KEYS */;
INSERT INTO `orderBarcode` VALUES (112,'test2-598a40f607241ac00b00406eca43d287.jpg'),(113,'test1-team_share_7388157-1193959466.png'),(114,'test3-photo_002.jpg'),(115,'test3-d0489cbb4df9e225db2920e769732d94.jpg'),(116,'test3-IMG_0005.PNG'),(117,'test3-IMG_0012.PNG'),(121,'test1-IMG_0010.JPG'),(122,'test1-IMG_0015.JPG'),(124,'111111-IMG_0047.JPG'),(125,'1-IMG_0012.JPG'),(126,'1-IMG_0012.JPG'),(127,'01号-IMG_0068.JPG'),(128,'01号-IMG_0068.JPG'),(129,'01号-IMG_0068.JPG'),(130,'01号-IMG_0068.JPG'),(131,'01号-IMG_0068.JPG'),(132,'01号-IMG_0068.JPG'),(133,'01号-IMG_0068.JPG'),(135,'-IMG_0068.JPG'),(136,'-IMG_0068.JPG'),(137,'1栋王阿姨-IMG_0068.JPG'),(138,'2栋杨阿姨-IMG_0068.JPG'),(139,'-IMG_0068.JPG'),(140,'-IMG_0068.JPG'),(141,'-IMG_0068.JPG');
/*!40000 ALTER TABLE `orderBarcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderpic`
--

DROP TABLE IF EXISTS `orderpic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderpic` (
  `orderid` int(11) DEFAULT NULL,
  `orderpicsrc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderpic`
--

LOCK TABLES `orderpic` WRITE;
/*!40000 ALTER TABLE `orderpic` DISABLE KEYS */;
INSERT INTO `orderpic` VALUES (124,'111111-IMG_0045.JPG'),(124,'111111-IMG_0046.JPG'),(124,'111111-IMG_0047.JPG'),(126,'1-IMG_0046.PNG'),(128,'01号-IMG_0137.JPG'),(128,'01号-IMG_0138.JPG'),(128,'01号-IMG_0140.JPG'),(128,'01号-IMG_0141.JPG'),(129,'01号-IMG_0142.JPG'),(129,'01号-IMG_0145.JPG'),(129,'01号-IMG_0144.JPG'),(130,'01号-IMG_0148.JPG'),(130,'01号-IMG_0146.JPG'),(130,'01号-IMG_0147.JPG'),(132,'01号-IMG_0140.JPG'),(132,'01号-IMG_0141.JPG'),(133,'01号-IMG_0138.JPG'),(133,'01号-IMG_0139.JPG'),(133,'01号-IMG_0143.JPG'),(133,'01号-IMG_0142.JPG'),(135,'-IMG_0158.JPG'),(135,'-IMG_0159.JPG'),(135,'-IMG_0160.JPG'),(136,'-IMG_0162.JPG'),(137,'1栋王阿姨-IMG_0164.JPG'),(138,'2栋杨阿姨-IMG_0165.JPG'),(139,'-IMG_0169.JPG'),(140,'-IMG_0171.JPG'),(140,'-IMG_0172.JPG'),(140,'-IMG_0170.JPG'),(141,'-IMG_0175.JPG'),(141,'-IMG_0174.JPG'),(141,'-IMG_0173.JPG');
/*!40000 ALTER TABLE `orderpic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderstatus`
--

DROP TABLE IF EXISTS `orderstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderstatus` (
  `orderid` int(11) DEFAULT NULL,
  `orderstatus` varchar(30) DEFAULT NULL,
  `peoplelimit` int(11) DEFAULT NULL,
  `currentpeople` int(11) DEFAULT NULL,
  KEY `orderid` (`orderid`),
  CONSTRAINT `orderstatus_ibfk_1` FOREIGN KEY (`orderid`) REFERENCES `theorder` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderstatus`
--

LOCK TABLES `orderstatus` WRITE;
/*!40000 ALTER TABLE `orderstatus` DISABLE KEYS */;
INSERT INTO `orderstatus` VALUES (124,'进行中',NULL,NULL),(125,'进行中',NULL,NULL),(126,'进行中',NULL,NULL),(128,'有人收货',NULL,NULL),(129,'已结束',NULL,NULL),(130,'进行中',NULL,NULL),(132,'进行中',NULL,NULL),(133,'进行中',NULL,NULL),(135,'进行中',NULL,NULL),(136,'进行中',NULL,NULL),(137,'进行中',NULL,NULL),(138,'进行中',NULL,NULL),(139,'进行中',NULL,NULL),(140,'进行中',NULL,NULL),(141,'已结束',NULL,NULL);
/*!40000 ALTER TABLE `orderstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postcontent`
--

DROP TABLE IF EXISTS `postcontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postcontent` (
  `postid` int(11) NOT NULL,
  `speakeraid` int(11) DEFAULT NULL,
  `speaktime` varchar(20) DEFAULT NULL,
  `speakcontent` varchar(300) DEFAULT NULL,
  KEY `speakeraid` (`speakeraid`),
  CONSTRAINT `postcontent_ibfk_2` FOREIGN KEY (`speakeraid`) REFERENCES `account` (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postcontent`
--

LOCK TABLES `postcontent` WRITE;
/*!40000 ALTER TABLE `postcontent` DISABLE KEYS */;
INSERT INTO `postcontent` VALUES (40,89,'2018-04-08 11:23:43','大家好 我们是惠先森家政公司，我们免费为贵小区免费提供上门擦拭玻璃服务'),(40,92,'2018-04-08 11:25:43','真的是免费的吗？'),(39,92,'2018-04-11 23:37:09','1'),(40,100,'2018-04-12 01:36:00','真的'),(40,100,'2018-04-12 01:36:12','我用过他们家的服务'),(40,100,'2018-04-12 01:36:17','非常好'),(40,92,'2018-04-12 01:36:37','这样呀 那我也赶紧试试');
/*!40000 ALTER TABLE `postcontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postinfo`
--

DROP TABLE IF EXISTS `postinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postinfo` (
  `postid` int(11) NOT NULL AUTO_INCREMENT,
  `posttheme` varchar(20) DEFAULT NULL,
  `posttime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`postid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postinfo`
--

LOCK TABLES `postinfo` WRITE;
/*!40000 ALTER TABLE `postinfo` DISABLE KEYS */;
INSERT INTO `postinfo` VALUES (39,'测试','2018-04-08 23:23:43'),(40,'光明小区家政团','2018-04-11 00:24:30');
/*!40000 ALTER TABLE `postinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `ruserorderinfo`
--

DROP TABLE IF EXISTS `ruserorderinfo`;
/*!50001 DROP VIEW IF EXISTS `ruserorderinfo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `ruserorderinfo` AS SELECT 
 1 AS `orderid`,
 1 AS `account`,
 1 AS `ordercontent`,
 1 AS `ordertime`,
 1 AS `promulgatorid`,
 1 AS `com`,
 1 AS `posttime`,
 1 AS `name`,
 1 AS `age`,
 1 AS `sex`,
 1 AS `uiconsrc`,
 1 AS `rorderpicsrc`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `ruserorderinfo2`
--

DROP TABLE IF EXISTS `ruserorderinfo2`;
/*!50001 DROP VIEW IF EXISTS `ruserorderinfo2`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `ruserorderinfo2` AS SELECT 
 1 AS `orderid`,
 1 AS `account`,
 1 AS `ordercontent`,
 1 AS `ordertime`,
 1 AS `promulgatorid`,
 1 AS `com`,
 1 AS `posttime`,
 1 AS `name`,
 1 AS `age`,
 1 AS `sex`,
 1 AS `uiconsrc`,
 1 AS `rorderpicsrc`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `ruserorderinfo3`
--

DROP TABLE IF EXISTS `ruserorderinfo3`;
/*!50001 DROP VIEW IF EXISTS `ruserorderinfo3`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `ruserorderinfo3` AS SELECT 
 1 AS `orderid`,
 1 AS `account`,
 1 AS `ordertheme`,
 1 AS `ordercontent`,
 1 AS `ordertime`,
 1 AS `promulgatorid`,
 1 AS `com`,
 1 AS `posttime`,
 1 AS `name`,
 1 AS `age`,
 1 AS `sex`,
 1 AS `uiconsrc`,
 1 AS `rorderpicsrc`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `content` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (''),(''),(''),('5dsffsaddsa comm2018-02-11 17:14:16'),(''),(''),(''),('5dsffsaddsa comm2018-02-11 17:15:07'),(''),(''),(''),('5asdasdsa comm2018-02-11 17:24:24'),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),('5asdasdsa comm2018-02-11 17:26:41'),(''),(''),(''),('5asdasdsa comm2018-02-11 17:26:54'),(''),(''),(''),('5asdasdsa comm2018-02-11 17:27:24'),(''),(''),(''),('5asdasdsa comm2018-02-11 17:32:04'),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),(''),('429111'),(''),(''),(''),('4291'),(''),(''),(''),('42911'),(''),(''),(''),('429111'),(''),(''),(''),('4291111'),(''),(''),(''),('4291'),(''),(''),(''),('4291'),(''),(''),(''),('4291'),(''),(''),(''),(''),(''),('');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theorder`
--

DROP TABLE IF EXISTS `theorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theorder` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `ordercontent` varchar(300) DEFAULT NULL,
  `ordertime` varchar(40) DEFAULT NULL,
  `promulgatorid` int(11) DEFAULT NULL,
  `com` varchar(20) DEFAULT NULL,
  `posttime` varchar(40) DEFAULT NULL,
  `ordertheme` varchar(100) DEFAULT NULL,
  `isallow` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theorder`
--

LOCK TABLES `theorder` WRITE;
/*!40000 ALTER TABLE `theorder` DISABLE KEYS */;
INSERT INTO `theorder` VALUES (124,'测试','2018-03-31 04:31',75,'111','2018-03-31 01:31:59','测试2',NULL),(125,'a l','2018-04-30 01:36',79,'最终测试','2018-03-31 01:36:43','1235',NULL),(126,'我','2018-03-31 03:37',79,'最终测试','2018-03-31 01:37:58','我',NULL),(128,'高端大气上档次\n穿着衣服的瓜\n一箱178','2018-04-08 23:56',81,'测试小区','2018-04-08 21:57:57','月露',NULL),(129,'46元每只，真空冷藏可以保存5天','2018-04-11 23:00',81,'测试小区','2018-04-08 22:02:55','脱脂猪手',NULL),(130,'产地直达，维生素之王\n31.6每斤','2018-04-10 22:03',81,'测试小区','2018-04-08 22:05:05','千喜橙',NULL),(132,'测试用','2018-04-10 22:34',81,'测试小区','2018-04-08 22:34:43','测试订单',NULL),(133,'演示','2018-04-11 23:44',81,'测试小区','2018-04-08 23:44:55','演示',NULL),(135,'a户型80到90平方 原价 230元 团购价200元，b户型90到100原价250元 团购价220元\n擦玻璃范围: 所有玻璃窗户，客厅阳台推拉门\n不包含纱窗清洗，厨房推拉门','2018-04-14 22:03',89,'测试小区','2018-04-10 22:06:05','惠先森家政玻璃团',NULL),(136,'为了小朋友能按时到校，每天早晨7点30前必须到小区门口集合\n\n联系人 : 周女士 6栋2单元408室业主\n联系方式 : 13423978186\n','选择截至日期',89,'测试小区','2018-04-11 00:30:47','本周芳草园小学学生代送',NULL),(137,'薛阿姨在我家工作5年了，手脚麻利勤快，做事干净有条，善于做家务❤️❤️❤️\n\n时间 周一到周五10点到12点\n联系方式 13625186356','2018-04-24 00:38',91,'测试小区','2018-04-11 00:42:10','钟点工薛阿姨找零工',NULL),(138,'老人，75岁，男，不能行走，坐轮椅2年有余，20号因为家中护工请假，家中只有老人不放心，哪位有空的邻居帮忙照顾一天\n❤️❤️❤️','2018-04-20 00:50',92,'测试小区','2018-04-11 00:52:29','帮忙代照顾老人一天',NULL),(139,'澳洲原瓶原装sada巴氏鲜奶\n只做金鹰.bht等高端商品\n团购价68/瓶','2018-04-17 00:16',96,'测试小区','2018-04-12 00:20:27','澳洲进口sada鲜奶',NULL),(140,'A、混装版：一包12张，中尺寸8张4张（包16开），大尺寸4张（包A4或对半剪开包32开)，附赠16枚姓名贴\n淘宝价：39元\n团购价：30元\nB、滑刀版：一卷，尺寸45cm*10m，底纸可涂鸦，附赠20枚卡通姓名贴\n淘宝价：78元\n团购价：68元\n推荐理由：\n环保CPP材质以及环保胶水，不含任何有毒化学物质。可修正胶反复撕粘不破坏书本表面。通过欧盟高标准环保检测，欧洲同步热销。开张平整，无需尺量，操作便捷。书本使用过程中：防尘、防水、防油、防磨损、防撕裂。杭州魏老爸测评推荐滴环保书皮。','选择截至日期',97,'测试小区','2018-04-12 00:47:34','环保书皮',NULL),(141,'芳婆品种、价格如下：\n主食类，蒸饭加油条6元／个，\n蒸饭加油条加肉松7元／个，\n蒸饭加油条加肉松加卤蛋（全套）10元／个，\n大全套14元/个（里面多加鸡肉肠）蒸饭分咸的或甜的，里面的油条分老的或嫩的，请大家把老咸或嫩咸，老甜或嫩甜写清楚，没注明的通常默认为老油条咸版。\n豆沙粽（甜），枣泥粽（甜），鲜肉粽（咸），香肠粽（咸）都是6元／个，\n板栗肉粽（咸）7元／个，\n八宝饭：豆沙八宝饭7元/份\n              枣泥八宝饭7元/份\n❤️❤️','2018-04-16 01:11',99,'测试小区','2018-04-12 01:12:10','芳婆糕点',NULL);
/*!40000 ALTER TABLE `theorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraddress`
--

DROP TABLE IF EXISTS `useraddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraddress` (
  `aid` int(11) DEFAULT NULL,
  `addressid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`addressid`),
  KEY `aid` (`aid`),
  CONSTRAINT `useraddress_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `account` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraddress`
--

LOCK TABLES `useraddress` WRITE;
/*!40000 ALTER TABLE `useraddress` DISABLE KEYS */;
INSERT INTO `useraddress` VALUES (59,13,'测试小区 111','12','先生','126'),(61,14,'测试小区 qwe','trr','先生','123'),(62,15,'测试小区 1dong 403','tr','先生','123'),(60,18,'测试小区 123123','tr','尊敬的','18952448323'),(82,20,'测试小区 1栋502','唐睿','尊敬的','18952448323'),(87,21,'测试小区 503','测试','尊敬的','123123123123'),(88,22,'测试小区 501','演示','尊敬的','123123123'),(91,23,'测试小区 1栋502','王阿姨','尊敬的','123456789'),(92,24,'测试小区 502','杨阿姨','尊敬的','123123123'),(100,26,'测试小区 501','3栋刘阿姨','尊敬的','123123');
/*!40000 ALTER TABLE `useraddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `aid` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `com` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  CONSTRAINT `userinfo_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `account` (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (58,NULL,NULL,NULL,46),(59,NULL,NULL,NULL,46),(60,NULL,NULL,NULL,46),(61,NULL,NULL,NULL,46),(62,NULL,NULL,NULL,46),(63,NULL,NULL,NULL,46),(64,NULL,NULL,NULL,47),(65,NULL,NULL,NULL,46),(66,NULL,NULL,NULL,46),(67,NULL,NULL,NULL,46),(68,NULL,NULL,NULL,47),(69,NULL,NULL,NULL,46),(70,NULL,NULL,NULL,46),(71,NULL,NULL,NULL,46),(72,NULL,NULL,NULL,46),(73,NULL,NULL,NULL,46),(74,NULL,NULL,NULL,48),(75,NULL,NULL,NULL,48),(76,NULL,NULL,NULL,49),(77,NULL,NULL,NULL,50),(78,NULL,NULL,NULL,51),(79,NULL,NULL,NULL,51),(80,NULL,NULL,NULL,52),(81,NULL,NULL,NULL,52),(82,NULL,NULL,NULL,52),(83,NULL,NULL,NULL,52),(84,NULL,NULL,NULL,52),(85,NULL,NULL,NULL,52),(86,NULL,NULL,NULL,52),(87,NULL,NULL,NULL,52),(88,NULL,NULL,NULL,52),(89,NULL,NULL,NULL,52),(90,NULL,NULL,NULL,52),(91,NULL,NULL,NULL,52),(92,NULL,NULL,NULL,52),(93,NULL,NULL,NULL,52),(94,NULL,NULL,NULL,52),(95,NULL,NULL,NULL,52),(96,NULL,NULL,NULL,52),(97,NULL,NULL,NULL,52),(98,NULL,NULL,NULL,52),(99,NULL,NULL,NULL,52),(100,NULL,NULL,NULL,52);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userorder`
--

DROP TABLE IF EXISTS `userorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userorder` (
  `aid` int(11) NOT NULL,
  `orderid` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `orderid` (`orderid`),
  CONSTRAINT `userorder_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `account` (`aid`),
  CONSTRAINT `userorder_ibfk_2` FOREIGN KEY (`orderid`) REFERENCES `theorder` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userorder`
--

LOCK TABLES `userorder` WRITE;
/*!40000 ALTER TABLE `userorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `userorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `userorderinfo`
--

DROP TABLE IF EXISTS `userorderinfo`;
/*!50001 DROP VIEW IF EXISTS `userorderinfo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `userorderinfo` AS SELECT 
 1 AS `promulgatorid`,
 1 AS `orderid`,
 1 AS `com`,
 1 AS `ordercontent`,
 1 AS `ordertime`,
 1 AS `posttime`,
 1 AS `orderpicsrc`,
 1 AS `account`,
 1 AS `uiconsrc`,
 1 AS `name`,
 1 AS `age`,
 1 AS `sex`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `userorderinfo2`
--

DROP TABLE IF EXISTS `userorderinfo2`;
/*!50001 DROP VIEW IF EXISTS `userorderinfo2`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `userorderinfo2` AS SELECT 
 1 AS `promulgatorid`,
 1 AS `orderid`,
 1 AS `com`,
 1 AS `ordercontent`,
 1 AS `ordertheme`,
 1 AS `ordertime`,
 1 AS `posttime`,
 1 AS `orderpicsrc`,
 1 AS `account`,
 1 AS `uiconsrc`,
 1 AS `name`,
 1 AS `age`,
 1 AS `sex`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `ruserorderinfo`
--

/*!50001 DROP VIEW IF EXISTS `ruserorderinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `ruserorderinfo` AS select `main`.`orderid` AS `orderid`,`main`.`account` AS `account`,`main`.`ordercontent` AS `ordercontent`,`main`.`ordertime` AS `ordertime`,`main`.`promulgatorid` AS `promulgatorid`,`main`.`com` AS `com`,`main`.`posttime` AS `posttime`,`main`.`name` AS `name`,`main`.`age` AS `age`,`main`.`sex` AS `sex`,`main`.`uiconsrc` AS `uiconsrc`,(select `sub`.`orderpicsrc` from `userorderinfo` `sub` where (`sub`.`orderid` = `main`.`orderid`) order by rand() limit 0,1) AS `rorderpicsrc` from `userorderinfo` `main` group by `main`.`orderid` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ruserorderinfo2`
--

/*!50001 DROP VIEW IF EXISTS `ruserorderinfo2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `ruserorderinfo2` AS select `main`.`orderid` AS `orderid`,`main`.`account` AS `account`,`main`.`ordercontent` AS `ordercontent`,`main`.`ordertime` AS `ordertime`,`main`.`promulgatorid` AS `promulgatorid`,`main`.`com` AS `com`,`main`.`posttime` AS `posttime`,`main`.`name` AS `name`,`main`.`age` AS `age`,`main`.`sex` AS `sex`,`main`.`uiconsrc` AS `uiconsrc`,(select `sub`.`orderpicsrc` from `userorderinfo` `sub` where (`sub`.`orderid` = `main`.`orderid`) order by rand() limit 0,1) AS `rorderpicsrc` from `userorderinfo` `main` group by `main`.`orderid` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ruserorderinfo3`
--

/*!50001 DROP VIEW IF EXISTS `ruserorderinfo3`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `ruserorderinfo3` AS select `main`.`orderid` AS `orderid`,`main`.`account` AS `account`,`main`.`ordertheme` AS `ordertheme`,`main`.`ordercontent` AS `ordercontent`,`main`.`ordertime` AS `ordertime`,`main`.`promulgatorid` AS `promulgatorid`,`main`.`com` AS `com`,`main`.`posttime` AS `posttime`,`main`.`name` AS `name`,`main`.`age` AS `age`,`main`.`sex` AS `sex`,`main`.`uiconsrc` AS `uiconsrc`,(select `sub`.`orderpicsrc` from `userorderinfo2` `sub` where (`sub`.`orderid` = `main`.`orderid`) order by rand() limit 0,1) AS `rorderpicsrc` from `userorderinfo2` `main` group by `main`.`orderid` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `userorderinfo`
--

/*!50001 DROP VIEW IF EXISTS `userorderinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `userorderinfo` AS select `theorder`.`promulgatorid` AS `promulgatorid`,`theorder`.`orderid` AS `orderid`,`theorder`.`com` AS `com`,`theorder`.`ordercontent` AS `ordercontent`,`theorder`.`ordertime` AS `ordertime`,`theorder`.`posttime` AS `posttime`,`orderpic`.`orderpicsrc` AS `orderpicsrc`,`account`.`account` AS `account`,`account`.`uiconsrc` AS `uiconsrc`,`userinfo`.`name` AS `name`,`userinfo`.`age` AS `age`,`userinfo`.`sex` AS `sex` from (((`theorder` join `account`) join `userinfo`) join `orderpic`) where ((`theorder`.`orderid` = `orderpic`.`orderid`) and (`theorder`.`promulgatorid` = `account`.`aid`) and (`account`.`aid` = `userinfo`.`aid`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `userorderinfo2`
--

/*!50001 DROP VIEW IF EXISTS `userorderinfo2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `userorderinfo2` AS select `theorder`.`promulgatorid` AS `promulgatorid`,`theorder`.`orderid` AS `orderid`,`theorder`.`com` AS `com`,`theorder`.`ordercontent` AS `ordercontent`,`theorder`.`ordertheme` AS `ordertheme`,`theorder`.`ordertime` AS `ordertime`,`theorder`.`posttime` AS `posttime`,`orderpic`.`orderpicsrc` AS `orderpicsrc`,`account`.`account` AS `account`,`account`.`uiconsrc` AS `uiconsrc`,`userinfo`.`name` AS `name`,`userinfo`.`age` AS `age`,`userinfo`.`sex` AS `sex` from (((`theorder` join `account`) join `userinfo`) join `orderpic`) where ((`theorder`.`orderid` = `orderpic`.`orderid`) and (`theorder`.`promulgatorid` = `account`.`aid`) and (`account`.`aid` = `userinfo`.`aid`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-21 23:04:52
