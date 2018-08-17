-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `cname` varchar(20) NOT NULL COMMENT '中文名',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `divide_per` float unsigned DEFAULT '1.00' COMMENT '分成比例',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近访问时间',
  `account_name` varchar (10) DEFAULT NULL COMMENT '银行账户名',
  `bank_account` varchar(20) DEFAULT NULL COMMENT '银行收款账号',
  `opening_bank` varchar (50) DEFAULT NULL COMMENT '开户银行地址',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `status` char(1) NOT NULL COMMENT '状态 0锁定 1有效',
  PRIMARY KEY (`user_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8;

INSERT INTO `admin_user` VALUES ('1','管理员', 'admin', '1fedc5a36d03c185065dd2b323886aa5', '18566209357',2.3, '2018-08-06 11:47:19', '2018-08-06 14:05:12','2018-08-06 17:29:32','宁夏', '6259384513455533222','浙江宁波招商银行', 'default.jpg',  '我是老板',  1);


-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '管理员', '2017-12-27 16:23:11', '2018-02-24 16:01:45');
INSERT INTO `role` VALUES ('2', '运营人员', '运营人员', '2017-12-27 16:25:09', '2018-01-23 09:11:11');
INSERT INTO `role` VALUES ('3', '渠道账号', '渠道账号，只可账号下的数据', '2017-12-29 16:00:15', '2018-02-24 17:33:45');
INSERT INTO `role` VALUES ('4', '维护人员', '维护人员，维护书籍等', '2018-01-09 15:32:41', null);
INSERT INTO `role` VALUES ('5', '客服专员', '客服专员，查看订单数据', '2018-01-09 15:32:41', null);


-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user_role` VALUES ('1', '1');


-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID',
  `parent_id` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单/按钮名称',
  `url` varchar(100) DEFAULT NULL COMMENT '菜单URL',
  `perms` text COMMENT '权限标识',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `type` char(2) NOT NULL COMMENT '类型 0菜单 1按钮',
  `order_num` bigint(20) DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '0', '系统管理', null, null, 'zmdi zmdi-settings', '0', '1', '2017-12-27 16:39:07', null);
INSERT INTO `menu` VALUES ('2', '1', '用户管理', 'user', 'user:list', '', '0', '1', '2017-12-27 16:47:13', '2018-04-25 09:00:01');
INSERT INTO `menu` VALUES ('3', '2', '新增用户', null, 'user:add', null, '1', null, '2017-12-27 17:02:58', null);
INSERT INTO `menu` VALUES ('4', '2', '修改用户', null, 'user:update', null, '1', null, '2017-12-27 17:04:07', null);
INSERT INTO `menu` VALUES ('5', '2', '删除用户', null, 'user:delete', null, '1', null, '2017-12-27 17:04:58', null);

INSERT INTO `menu` VALUES ('6', '1', '角色管理', 'role', 'role:list', '', '0', '2', '2017-12-27 16:48:09', '2018-04-25 09:01:12');
INSERT INTO `menu` VALUES ('7', '6', '新增角色', null, 'role:add', null, '1', null, '2017-12-27 17:06:38', null);
INSERT INTO `menu` VALUES ('8', '6', '修改角色', null, 'role:update', null, '1', null, '2017-12-27 17:06:38', null);
INSERT INTO `menu` VALUES ('9', '6', '删除角色', null, 'role:delete', null, '1', null, '2017-12-27 17:06:38', null);

INSERT INTO `menu` VALUES ('10', '1', '菜单管理', 'menu', 'menu:list', '', '0', '3', '2017-12-27 16:48:57', '2018-04-25 09:01:30');
INSERT INTO `menu` VALUES ('11', '10', '新增菜单', null, 'menu:add', null, '1', null, '2017-12-27 17:08:02', null);
INSERT INTO `menu` VALUES ('12', '10', '修改菜单', null, 'menu:update', null, '1', null, '2017-12-27 17:08:02', null);
INSERT INTO `menu` VALUES ('13', '10', '删除菜单', null, 'menu:delete', null, '1', null, '2017-12-27 17:08:02', null);

INSERT INTO `menu` VALUES ('14', '1', '字典管理', 'dict', 'dict:list', '', '0', null, '2018-01-18 10:38:25', '2018-04-25 09:01:50');
INSERT INTO `menu` VALUES ('15', '14', '新增字典', null, 'dict:add', null, '1', null, '2018-01-18 19:10:08', null);
INSERT INTO `menu` VALUES ('16', '14', '修改字典', null, 'dict:update', null, '1', null, '2018-01-18 19:10:27', null);
INSERT INTO `menu` VALUES ('17', '14', '删除字典', null, 'dict:delete', null, '1', null, '2018-01-18 19:10:47', null);

INSERT INTO `menu` VALUES ('18', '0', '系统监控', null, null, 'zmdi zmdi-shield-security', '0', '2', '2017-12-27 16:45:51', '2018-01-17 17:08:28');
INSERT INTO `menu` VALUES ('19', '18', '在线用户', 'session', 'session:list', '', '0', '1', '2017-12-27 16:59:33', '2018-04-25 09:02:04');
INSERT INTO `menu` VALUES ('20', '19', '踢出用户', null, 'user:kickout', null, '1', null, '2017-12-27 17:11:13', null);
INSERT INTO `menu` VALUES ('21', '18', '系统日志', 'log', 'log:list', '', '0', '3', '2017-12-27 17:00:50', '2018-04-25 09:02:18');
INSERT INTO `menu` VALUES ('22', '21', '删除日志', null, 'log:delete', null, '1', null, '2017-12-27 17:11:45', null);
INSERT INTO `menu` VALUES ('23', '18', 'Redis监控', 'redis/info', 'redis:list', '', '0', null, '2018-06-28 14:29:42', null);
INSERT INTO `menu` VALUES ('24', '18', 'Redis终端', 'redis/terminal', 'redis:terminal', '', '0', null, '2018-06-28 15:35:21', null);

INSERT INTO `menu` VALUES ('25', '0', '网络资源', null, null, 'zmdi zmdi-globe-alt', '0', null, '2018-01-12 15:28:48', '2018-01-22 19:49:26');
INSERT INTO `menu` VALUES ('26', '25', '天气查询', 'weather', 'weather:list', '', '0', null, '2018-01-12 15:40:02', '2018-04-25 09:02:57');
INSERT INTO `menu` VALUES ('27', '25', '影视资讯', null, null, null, '0', null, '2018-01-22 14:12:59', null);
INSERT INTO `menu` VALUES ('28', '27', '正在热映', 'movie/hot', 'movie:hot', '', '0', null, '2018-01-22 14:13:47', '2018-04-25 09:03:48');
INSERT INTO `menu` VALUES ('29', '27', '即将上映', 'movie/coming', 'movie:coming', '', '0', null, '2018-01-22 14:14:36', '2018-04-25 09:04:05');

INSERT INTO `menu` VALUES ('30', '0', '任务调度', null, null, 'zmdi zmdi-alarm', '0', null, '2018-02-24 15:52:57', null);
INSERT INTO `menu` VALUES ('31', '30', '定时任务', 'job', 'job:list', '', '0', null, '2018-02-24 15:53:53', '2018-04-25 09:05:12');
INSERT INTO `menu` VALUES ('32', '31', '新增任务', null, 'job:add', null, '1', null, '2018-02-24 15:55:10', null);
INSERT INTO `menu` VALUES ('33', '31', '修改任务', null, 'job:update', null, '1', null, '2018-02-24 15:55:53', null);
INSERT INTO `menu` VALUES ('34', '31', '删除任务', null, 'job:delete', null, '1', null, '2018-02-24 15:56:18', null);
INSERT INTO `menu` VALUES ('35', '31', '暂停任务', null, 'job:pause', null, '1', null, '2018-02-24 15:57:08', null);
INSERT INTO `menu` VALUES ('36', '31', '恢复任务', null, 'job:resume', null, '1', null, '2018-02-24 15:58:21', null);
INSERT INTO `menu` VALUES ('37', '31', '立即执行任务', null, 'job:run', null, '1', null, '2018-02-24 15:59:45', null);
INSERT INTO `menu` VALUES ('38', '30', '调度日志', 'jobLog', 'jobLog:list', '', '0', null, '2018-02-24 16:00:45', '2018-04-25 09:05:25');
INSERT INTO `menu` VALUES ('39', '38', '删除日志', null, 'jobLog:delete', null, '1', null, '2018-02-24 16:01:21', null);



-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单/按钮ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1');
INSERT INTO `role_menu` VALUES ('1', '2');
INSERT INTO `role_menu` VALUES ('1', '3');
INSERT INTO `role_menu` VALUES ('1', '4');
INSERT INTO `role_menu` VALUES ('1', '5');
INSERT INTO `role_menu` VALUES ('1', '6');
INSERT INTO `role_menu` VALUES ('1', '7');
INSERT INTO `role_menu` VALUES ('1', '8');
INSERT INTO `role_menu` VALUES ('1', '9');
INSERT INTO `role_menu` VALUES ('1', '10');
INSERT INTO `role_menu` VALUES ('1', '11');
INSERT INTO `role_menu` VALUES ('1', '12');
INSERT INTO `role_menu` VALUES ('1', '13');
INSERT INTO `role_menu` VALUES ('1', '14');
INSERT INTO `role_menu` VALUES ('1', '15');
INSERT INTO `role_menu` VALUES ('1', '16');
INSERT INTO `role_menu` VALUES ('1', '17');
INSERT INTO `role_menu` VALUES ('1', '18');
INSERT INTO `role_menu` VALUES ('1', '19');
INSERT INTO `role_menu` VALUES ('1', '20');
INSERT INTO `role_menu` VALUES ('1', '21');
INSERT INTO `role_menu` VALUES ('1', '22');
INSERT INTO `role_menu` VALUES ('1', '23');
INSERT INTO `role_menu` VALUES ('1', '24');
INSERT INTO `role_menu` VALUES ('1', '25');
INSERT INTO `role_menu` VALUES ('1', '26');
INSERT INTO `role_menu` VALUES ('1', '27');
INSERT INTO `role_menu` VALUES ('1', '28');
INSERT INTO `role_menu` VALUES ('1', '29');
INSERT INTO `role_menu` VALUES ('1', '30');
INSERT INTO `role_menu` VALUES ('1', '31');
INSERT INTO `role_menu` VALUES ('1', '32');
INSERT INTO `role_menu` VALUES ('1', '33');
INSERT INTO `role_menu` VALUES ('1', '34');
INSERT INTO `role_menu` VALUES ('1', '35');
INSERT INTO `role_menu` VALUES ('1', '36');
INSERT INTO `role_menu` VALUES ('1', '37');
INSERT INTO `role_menu` VALUES ('1', '38');
INSERT INTO `role_menu` VALUES ('1', '39');


DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `keyy` bigint(20) NOT NULL COMMENT '键',
  `valuee` varchar(100) NOT NULL COMMENT '值',
  `field_name` varchar(100) NOT NULL COMMENT '字段名称',
  `table_name` varchar(100) NOT NULL COMMENT '表名',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `dict` VALUES ('4', '1', '有效', 'status', 'user');
INSERT INTO `dict` VALUES ('5', '0', '锁定', 'status', 'user');
INSERT INTO `dict` VALUES ('6', '0', '菜单', 'type', 'menu');
INSERT INTO `dict` VALUES ('7', '1', '按钮', 'type', 'menu');
INSERT INTO `dict` VALUES ('30', '0', '正常', 'status', 't_job');
INSERT INTO `dict` VALUES ('31', '1', '暂停', 'status', 't_job');
INSERT INTO `dict` VALUES ('32', '0', '成功', 'status', 't_job_log');
INSERT INTO `dict` VALUES ('33', '1', '失败', 'status', 't_job_log');


/*
 支付管理，支付通道
*/
DROP TABLE IF EXISTS `passageway`;
CREATE TABLE `passageway` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `pay_id` varchar (32) NOT NULL COMMENT '支付商户号ID',
  `pay_key` varchar(50) NOT NULL COMMENT '支付秘钥，根据加密类型区分',
  `public_key` varchar(50) NOT NULL COMMENT '支付秘钥，根据加密类型区分,RSA类型需要此秘钥解密',
  `sign_type` varchar(32) NOT NULL COMMENT '签名类型',
  `app_id` varchar(32) NOT NULL COMMENT '产品ID',
  `pay_type` varchar(32) NOT NULL COMMENT '支付类型',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status`tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '启用状态:0-关闭,1-开启',
  `passageway_id` varchar (11) NOT NULL COMMENT '通道标识ID',
  `passageway_name` varchar(100) NOT NULL COMMENT '通道名称',
  PRIMARY KEY (`id`),
  KEY `passagewayId` (`passageway_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*
 支付管理，支付订单
*/
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `mch_id` bigint(20) NOT NULL COMMENT '商户ID',
  `passageway_id` bigint(20) NOT NULL COMMENT '支付通道ID',
  `user_id` bigint(20) NOT NULL COMMENT '渠道用户ID',
  `order_no` varchar(50) NOT NULL COMMENT '商户订单号',
  `trade_no` varchar(50) NOT NULL COMMENT '平台订单号',
  `pay_type` varchar(32) NOT NULL COMMENT '支付类型',
  `amount` int (11) NOT NULL COMMENT '金额，单位为分',
  `status`tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '订单状态:0-已取消,1-未支付,2-已支付',
  `product_id` varchar(32) DEFAULT NULL COMMENT '产品ID',
  `callback_status` tinyint(3) unsigned zerofill DEFAULT '0' COMMENT '是否已同步渠道,0-3未同步或未成功,9-成功',
  `user_ip` varchar(32) DEFAULT NULL COMMENT '用户IP',
  `body` varchar(32) NOT NULL COMMENT '商品名称',
  `nonce_str` varchar(32) NOT NULL COMMENT '随机字符串',
  `attach` varchar(32) DEFAULT NULL COMMENT '拓展字段，异步通知数据原样返回',
  `notifyUrl` varchar(32) NOT NULL COMMENT '异步通知地址',
  `callbackUrl` varchar(32) DEFAULT NULL COMMENT '前端回调地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `limitPay` varchar(100) DEFAULT NULL COMMENT '是否限制使用信用卡',
  `sceneInfo` varchar (256) DEFAULT NULL COMMENT '场景信息',
  PRIMARY KEY (`id`),
  KEY `userId`(`user_id`),
  KEY `mchId`(`mch_id`),
  KEY `passagewayId` (`passageway_id`),
  KEY `px_status` (`status`),
  KEY `orderNo`(`order_no`),
  KEY `tradeNo`(`trade_no`),
  KEY `payType`(`pay_type`),
  KEY `callbackStatus`(`callback_status`),
  KEY `createTime`(`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;


/*
支付管理，分配给渠道的商户号
 */
DROP TABLE IF EXISTS `mch_info`;
CREATE TABLE `mch_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `mch_id` varchar(20) NOT NULL COMMENT '商户号ID',
  `mch_key` varchar(50) NOT NULL COMMENT '商户秘钥',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status`tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '启用状态:0-关闭,1-开启',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

insert into mch_info values (1,'5646546','asdf65465465',now(),null,true);
insert into mch_info values (2,'10023654895','asdf65465465',now(),null,true);
insert into mch_info values (3,'10023548415','asdf65465465',now(),null,true);

/**
关联商户号，支付通道，渠道ID中间表
 */
DROP TABLE IF EXISTS `user_mch_pay`;
CREATE TABLE `user_mch_pay` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `mch_id` varchar (20) NOT NULL COMMENT '商户号ID',
  `user_id` bigint(50) NOT NULL COMMENT '商户秘钥',
  `passageway_id` varchar(50) NOT NULL COMMENT '创建时间',
  `settlement_rate` float NOT NULL default 1 COMMENT '费率',
  `status`tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '启用状态:0-关闭,1-开启',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

insert into user_mch_pay values (1,'5646546',1,'15338987',1,true);
insert into user_mch_pay values (2,'5646546',1,'15338988',1,true);
insert into user_mch_pay values (3,'10023654895',171,'15338987',1,true);
insert into user_mch_pay values (4,'10023654895',171,'15338988',1,true);







-- ----------------------------
-- Table structure for t_job
-- ----------------------------
DROP TABLE IF EXISTS `t_job`;
CREATE TABLE `t_job` (
  `JOB_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `BEAN_NAME` varchar(100) NOT NULL COMMENT 'spring bean名称',
  `METHOD_NAME` varchar(100) NOT NULL COMMENT '方法名',
  `PARAMS` varchar(200) DEFAULT NULL COMMENT '参数',
  `CRON_EXPRESSION` varchar(100) NOT NULL COMMENT 'cron表达式',
  `STATUS` char(2) NOT NULL COMMENT '任务状态  0：正常  1：暂停',
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_job
-- ----------------------------
INSERT INTO `t_job` VALUES ('1', 'testTask', 'test', 'mrbird', '0/1 * * * * ?', '1', '有参任务调度测试', '2018-02-24 16:26:14');
INSERT INTO `t_job` VALUES ('2', 'testTask', 'test1', null, '0/10 * * * * ?', '1', '无参任务调度测试', '2018-02-24 17:06:23');
INSERT INTO `t_job` VALUES ('3', 'testTask', 'test', 'hello world', '0/1 * * * * ?', '1', '有参任务调度测试,每隔一秒触发', '2018-02-26 09:28:26');
INSERT INTO `t_job` VALUES ('11', 'testTask', 'test2', null, '0/5 * * * * ?', '1', '测试异常', '2018-02-26 11:15:30');

-- ----------------------------
-- Table structure for t_job_log
-- ----------------------------
DROP TABLE IF EXISTS `t_job_log`;
CREATE TABLE `t_job_log` (
  `LOG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `JOB_ID` bigint(20) NOT NULL COMMENT '任务id',
  `BEAN_NAME` varchar(100) NOT NULL COMMENT 'spring bean名称',
  `METHOD_NAME` varchar(100) NOT NULL COMMENT '方法名',
  `PARAMS` varchar(200) DEFAULT NULL COMMENT '参数',
  `STATUS` char(2) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `ERROR` text COMMENT '失败信息',
  `TIMES` decimal(11,0) DEFAULT NULL COMMENT '耗时(单位：毫秒)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2476 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_job_log
-- ----------------------------
INSERT INTO `t_job_log` VALUES ('2448', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:31:50');
INSERT INTO `t_job_log` VALUES ('2449', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:51');
INSERT INTO `t_job_log` VALUES ('2450', '3', 'testTask', 'test', 'hello world', '0', null, '2', '2018-03-20 15:31:52');
INSERT INTO `t_job_log` VALUES ('2451', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:31:53');
INSERT INTO `t_job_log` VALUES ('2452', '3', 'testTask', 'test', 'hello world', '0', null, '2', '2018-03-20 15:31:54');
INSERT INTO `t_job_log` VALUES ('2453', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:55');
INSERT INTO `t_job_log` VALUES ('2454', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:31:56');


-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '操作用户',
  `OPERATION` text COMMENT '操作内容',
  `TIME` decimal(11,0) DEFAULT NULL COMMENT '耗时',
  `METHOD` text COMMENT '操作方法',
  `PARAMS` text COMMENT '方法参数',
  `IP` varchar(64) DEFAULT NULL COMMENT '操作者IP',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `location` varchar(50) DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=860 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log
-- ----------------------------
INSERT INTO `t_log` VALUES ('730', 'MrBird', '恢复任务', '55', 'cn.xry.job.controller.JobController.resumeJob()', 'jobIds: 3', '127.0.0.1', '2018-03-19 10:07:32', null);
INSERT INTO `t_log` VALUES ('731', 'MrBird', '执行任务', '40', 'cn.xry.job.controller.JobController.runJob()', 'jobIds: 3', '127.0.0.1', '2018-03-19 10:07:36', null);
INSERT INTO `t_log` VALUES ('733', 'MrBird', '暂停任务', '10', 'cn.xry.job.controller.JobController.pauseJob()', 'jobIds: 3', '127.0.0.1', '2018-03-19 10:07:53', null);
INSERT INTO `t_log` VALUES ('734', 'MrBird', '恢复任务', '17', 'cn.xry.job.controller.JobController.resumeJob()', 'jobIds: 1', '127.0.0.1', '2018-03-19 10:08:02', null);
INSERT INTO `t_log` VALUES ('735', 'MrBird', '执行任务', '13', 'cn.xry.job.controller.JobController.runJob()', 'jobIds: 1', '127.0.0.1', '2018-03-19 10:08:05', null);
INSERT INTO `t_log` VALUES ('737', 'MrBird', '暂停任务', '11', 'cn.xry.job.controller.JobController.pauseJob()', 'jobIds: 1', '127.0.0.1', '2018-03-19 10:08:27', null);
INSERT INTO `t_log` VALUES ('738', 'MrBird', '执行任务', '14', 'cn.xry.job.controller.JobController.runJob()', 'jobIds: 11', '127.0.0.1', '2018-03-19 10:08:34', null);
INSERT INTO `t_log` VALUES ('840', 'MrBird', '删除用户', '255', 'cn.xry.system.controller.UserController.deleteUsers()', 'ids: 165,166', '127.0.0.1', '2018-03-20 18:34:26', null);
INSERT INTO `t_log` VALUES ('841', 'MrBird', '修改用户', '348', 'cn.xry.system.controller.UserController.updateUser()', 'user: cn.xry.system.domain.User@5adf3b3b  roles: [Ljava.lang.Long;@75a9cd18', '127.0.0.1', '2018-03-21 09:05:12', null);
INSERT INTO `t_log` VALUES ('842', 'MrBird', '删除调度日志', '79', 'cn.xry.job.controller.JobLogController.deleteJobLog()', 'ids: 2447', '127.0.0.1', '2018-03-22 18:52:10', 'XX内网IP');
INSERT INTO `t_log` VALUES ('843', 'MrBird', '修改用户', '18805', 'cn.xry.system.controller.UserController.updateUser()', 'user: cn.xry.system.domain.User@1a6c90df  rolesSelect: [Ljava.lang.Long;@4d9b2e06', '127.0.0.1', '2018-03-27 09:20:05', 'XX内网IP');

commit;