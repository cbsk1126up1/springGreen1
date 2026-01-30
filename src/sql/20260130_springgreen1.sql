-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: springgreen1
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
-- Table structure for table `jcat`
--

DROP TABLE IF EXISTS `jcat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jcat` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `kind` varchar(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  `gender` char(2) DEFAULT '여자',
  `fDate` datetime NOT NULL,
  `features` text NOT NULL,
  `photo` varchar(50) DEFAULT 'noname.jpg',
  `missing` char(1) DEFAULT '1',
  `singoja` varchar(10) NOT NULL,
  `singotel` varchar(15) NOT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jcat`
--

LOCK TABLES `jcat` WRITE;
/*!40000 ALTER TABLE `jcat` DISABLE KEYS */;
INSERT INTO `jcat` VALUES (1,'터키시앙고라','꽁이','암컷','2016-11-28 07:00:00','오드아이의 눈이 매력적이며\n털이 새하얗고 무늬가 없습니다.','12.jpg','1','김피리','02-1212-4646'),(2,'샴','까망이','수컷','2024-10-16 16:00:00','눈이 똥그랗고 귀가 오똑해요','01.jpg','1','홍길동','010-1234-5489'),(3,'스핑크스','핑핑이','암컷','2024-09-04 19:00:00','털이없고 귀가뾰족하고 몸집이 작아요','04.jpg','1','김말숙','010-1234-5678'),(4,'아비시니안','고구마','수컷','2025-10-04 13:00:00','코에 항상 콧물이 맺혀있고 순해요.','07.jpg','1','안녕','010-5431-4334'),(5,'러시안블루','흑이','수컷','2026-01-01 10:00:00','되게 활발하며 가만히 있지를 못하는 \n새끼 고양이예요','06.jpg','1','김룰라','010-4567-7897'),(6,'페르시안','뭉치','암컷','2023-04-02 22:00:00','털이 장모이고, 되게 얌전해요 걸을 때 우아해요','08.jpg','1','김찐빵','010-1212-4545'),(7,'코리안숏헤어','탄이','암컷','2020-10-30 19:00:00','얼굴에 무늬가 사진과 같이 되어있고 겁이 많아서\n숨기를 좋아해요','09.jpg','0','김돌돌','010-7979-7878'),(8,'뱅갈','랑랑이','수컷','2024-12-31 08:00:00','아기고양이이고 쉬지않고 놀아요 어딘가에\n올라타기를 좋아해요','10.jpg','0','김순이','010-8787-4545'),(9,'샴','샤브','수컷','2023-05-04 07:00:00','달마시안을 닮고\n쿠앤크색이어서 가끔\n깨물어먹고싶어요.','13.jpg','1','제미나이조','010-1212-4545'),(14,'스코티시폴드','꿍꿍이','암컷','2024-10-16 13:00:00','얼굴 무늬가 매력적인게\n특징이에요 귀가 접혀있어서\n나풀나풀 귀여워요','21.jpg','1','통나무','010-6464-9191'),(17,'스코티시폴드','달이','암컷','2024-12-25 22:00:00','털에 파묻혀 귀가 안보여 얼굴이\n동그랗게 보이는 게 매력이고\n얼굴이 그냥 ㅇㅅㅇ입니다','22.jpg','0','산타','010-1225-1225'),(18,'먼치킨','감자','수컷','2026-01-03 06:00:00','생긴 것과 달리 엄청 씩씩하고\n용감한아이입니다\n아주 활발한 게 특징입니다','23.jpg','0','나나','010-1010-1212'),(19,'스핑크스','름이','수컷','2025-07-07 07:00:00','얼굴과 귀 크기가 동일할 정도로\n귀가 크고 얼굴이 작은 편이며,\n털이 없는 스핑크스로\n굉장히 사랑스러운 아이입니다','24.jpg','0','럭키걸','010-7777-7777'),(20,'코리안숏헤어','복순','암컷','2020-10-24 20:00:00','이목구비가 동글동글\n전혀 날렵해 보이지않고\n강아지상 귀여운 고양이입니다','25.jpg','0','군밤아저씨','010-9999-8888'),(21,'러시안블루','흑자','수컷','2025-12-30 17:00:00','얼굴에 살집이 있는 편이어서\n동글동글하며 굉장히 얌전하고\n잠만 자서 볼 때 마다 자고있는 게\n특징입니다','26.jpg','1','철수','010-1212-1313'),(23,'먼치킨','치키','수컷','2026-01-14 18:00:00','다리가 짧은게 특징이며\n사람을 엄청 좋아해서 누구나에게\n애교가 많습니다','03.jpg','1','김철철','010-1234-4567'),(24,'스코티시폴드','납작이','암컷','2023-09-01 16:00:00','입 주변이 빨간게 특징입니다\n마치 딸기를 훔쳐먹은 듯한\n매력이 사랑스럽습니다','05.jpg','1','김퉁퉁','010-7979-1235'),(27,'노르웨이숲고양이','수피','수컷','2025-11-29 07:00:00','털이 복실복실하여\n이름을 복실이라고 지으려다\n참았습니다 정말 애교도 많고\n귀여운 게 매력입니다','11.jpg','1','흰둥이','010-7894-7894'),(28,'터키시앙고라','솜이','수컷','2020-09-17 16:00:00','안고있으면 따뜻하고 포근한\n든든한 아이입니다\n성숙하여서 항상 사람 옆을 묵묵히\n지켜줍니다','14.jpg','1','김영희','010-5555-5555'),(29,'러시안블루','콩콩','수컷','2024-10-28 17:00:00','쥐꼬리같은 귀여운 꼬리가 특징입니다\n다리가 굉장히 짧은 먼치킨같아서\n사랑스러운 아이입니다','15.jpg','1','신짱아','010-2580-2580'),(30,'먼치킨','잡채','암컷','2023-03-21 15:00:00','사진과 같이 뛰어노는 걸 좋아합니다\n다리가 짧아 틈만 나면 두발로 일어서고\n물을 좋아합니다','16.jpg','1','봉미선','010-0101-0202'),(31,'페르시안','페페','수컷','2020-09-30 10:00:00','얼굴이 눌려있어 눈물이 많이납니다\n그런 생김새가 매력이기도 하여서\n굉장히 지켜주고싶은 아이입니다','17.jpg','1','나미리','010-3333-2222'),(32,'뱅갈','어흥이','암컷','2018-10-02 16:00:00','뱅갈의 매력적인 무늬가 돋보적입니다\n높은곳에 올라타는 것을 유독좋아합니다','18.jpg','0','스폰지밥','010-7878-1515'),(33,'노르웨이숲고양이','옹이','수컷','2024-07-03 16:00:00','다른 고양이에 비해 크기가 크며\n털이 풍성하며 코를 박고있으면\n귀여운 냄새가 풍깁니다','19.jpg','0','뚱이','010-1111-1212'),(34,'스핑크스','둘리','수컷','2024-03-15 02:00:00','걸을 때 토끼처럼 깡충깡충 걸어다녀\n볼 때마다 흐뭇한 미소가 나옵니다\n사랑스러운 아이입니다','20.jpg','1','말숙','010-5555-5555');
/*!40000 ALTER TABLE `jcat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jproduct`
--

DROP TABLE IF EXISTS `jproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jproduct` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `content` text,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jproduct`
--

LOCK TABLES `jproduct` WRITE;
/*!40000 ALTER TABLE `jproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `jproduct` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-30 16:40:39
