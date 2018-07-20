DROP TABLE IF EXISTS `admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hexid` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'HEXID',
  `account` varchar(32) NOT NULL COMMENT '账户名',
  `channel_key` varchar(16) DEFAULT NULL COMMENT '渠道Key，用于签名验证',
  `ps` varchar(255) DEFAULT NULL COMMENT '备注',
  `avatar` varchar(128) DEFAULT NULL COMMENT '头像',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `password_hash` varchar(32) DEFAULT NULL COMMENT '密码HASH值用户重置时使用',
  `role` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '账户类型:0-管理员,1-平台账户,2-渠道账户',
  `ip` varchar(16) DEFAULT NULL COMMENT 'ip地址',
  `divide_per` float(4,2) unsigned DEFAULT '1.00' COMMENT '分成比例',
  `open` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '是否启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `account` (`account`),
  KEY `type` (`role`),
  KEY `hexid` (`hexid`),
  KEY `open` (`open`),
  KEY `channelkey` (`channel_key`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='平台用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_user`
--

LOCK TABLES `admin_user` WRITE;
/*!40000 ALTER TABLE `admin_user` DISABLE KEYS */;
INSERT INTO `admin_user` VALUES (1,103750313,'admin','admin','官方','7.jpg','123456','4f7f31584924d41a0fbe145532800b9e',0,NULL,1.00,1,'2017-12-09 23:52:51','2018-03-14 00:28:52');
/*!40000 ALTER TABLE `admin_user` ENABLE KEYS */;
UNLOCK TABLES;