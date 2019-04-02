-- 创建了一个存储过程，定时更新closeTime 的值为空
CREATE PROCEDURE test () 
     BEGIN 
          update log SET closetime = null ; 
     END; 

     -- 创建event e_test 
     CREATE EVENT if not exists e_test 
          on schedule every 60 second 
          on completion preserve 
     do call test(); 
     
     
     /*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : dblock

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-04-02 09:19:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `jobNumber` varchar(11) DEFAULT NULL,
  `voltage` varchar(255) DEFAULT NULL COMMENT '变电站',
  `transformersub` varchar(255) DEFAULT NULL COMMENT '电压等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'Admin', 'ISMvKXpXpadDiUoOSoAfww==', '17609346217', '西安博展电力', '1', '20190001', null, null);

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '西安博展电力');
INSERT INTO `company` VALUES ('5', '西安博展1334333');
INSERT INTO `company` VALUES ('10', 'ss888');

-- ----------------------------
-- Table structure for lockinfo
-- ----------------------------
DROP TABLE IF EXISTS `lockinfo`;
CREATE TABLE `lockinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` varchar(255) DEFAULT NULL,
  `mac` varchar(255) DEFAULT NULL,
  `passcode` varchar(255) DEFAULT NULL,
  `lockName` varchar(255) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `transformersubName` varchar(255) DEFAULT NULL,
  `classes` varchar(255) DEFAULT NULL COMMENT '所属班组',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lockinfo
-- ----------------------------
INSERT INTO `lockinfo` VALUES ('2', 'nPQvJQrrHnXkEbKvubPx25', 'VIRTUAL:SITE', '123456', '0002', '西安博展电力', '变电站2', null);
INSERT INTO `lockinfo` VALUES ('27', '4JgLdwp8FJ7RttXQX6ZpEd', '868729039250258', '44111', '0003', null, null, null);
INSERT INTO `lockinfo` VALUES ('28', 'jDGZSjykZwzp8FhyCHhoqt', 'aa', null, null, '西安博展1334333', '变电站1', null);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(30) DEFAULT NULL,
  `voltage` varchar(255) DEFAULT NULL COMMENT '电压等级',
  `transformersub` varchar(255) DEFAULT NULL COMMENT '变电站',
  `classes` varchar(255) DEFAULT NULL COMMENT '运检班组\r\n',
  `lockName` varchar(255) DEFAULT NULL COMMENT '锁名称',
  `mac` varchar(255) DEFAULT NULL,
  `did` varchar(255) DEFAULT NULL,
  `requestTime` varchar(33) DEFAULT NULL COMMENT '开锁时间',
  `openTime` varchar(33) DEFAULT NULL COMMENT '关锁时间',
  `closeTime` varchar(33) DEFAULT NULL,
  `on_off` int(11) DEFAULT NULL COMMENT '开关',
  `actionD` int(255) DEFAULT NULL COMMENT '请求状态',
  `status` int(255) DEFAULT NULL COMMENT '审核状态',
  `realname` varchar(255) DEFAULT NULL COMMENT '请求开锁人真实姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '请求开锁人电话',
  `reason` varchar(255) DEFAULT NULL COMMENT '请求开锁原因',
  `examinePerson` varchar(255) DEFAULT NULL COMMENT '开锁人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `requestTime` (`requestTime`),
  UNIQUE KEY `closeTime` (`closeTime`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('82', '1', null, '1', '1', '1', '1', '1', '2019-03-27', '1', '1', '1', '2', '1', null, null, null, null);

-- ----------------------------
-- Table structure for transformersub
-- ----------------------------
DROP TABLE IF EXISTS `transformersub`;
CREATE TABLE `transformersub` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transformerSubName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transformersub
-- ----------------------------
INSERT INTO `transformersub` VALUES ('1', '变电站1');
INSERT INTO `transformersub` VALUES ('2', '变电站2');
INSERT INTO `transformersub` VALUES ('3', '变电站3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `realname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `post` varchar(255) DEFAULT NULL COMMENT '职务',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `jobnumber` varchar(255) DEFAULT NULL COMMENT '工号',
  `voltage` varchar(255) DEFAULT NULL COMMENT '电压',
  `transformsub` varchar(255) DEFAULT NULL COMMENT '变电站',
  `Administrators` varchar(255) DEFAULT NULL COMMENT '管理员',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `lockname` varchar(255) DEFAULT NULL COMMENT '使用锁',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '张三', '111', '男', '22', '老板', '1778293872', '1', '110kv', '变1', '李四', '无', '无');
INSERT INTO `user` VALUES ('5', '8888', '88', '2iu9I2HkRim3Dk3gBSXrow==', '女', '88', '领导', '15623211456', null, null, '变电站1', '', null, '');
INSERT INTO `user` VALUES ('6', '3', '3', 'rt8RM8T+eWf1RRGM84yJVA==', '男', '33', '---请选择---', '17009346217', null, null, '---请选择---', '33', null, 'e');

-- ----------------------------
-- Table structure for user_lock
-- ----------------------------
DROP TABLE IF EXISTS `user_lock`;
CREATE TABLE `user_lock` (
  `id` int(11) NOT NULL,
  `companyId` int(30) NOT NULL,
  `userId` int(11) NOT NULL,
  `lockId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_lock
-- ----------------------------

-- ----------------------------
-- Table structure for voltage
-- ----------------------------
DROP TABLE IF EXISTS `voltage`;
CREATE TABLE `voltage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `voltageName` varchar(255) DEFAULT NULL COMMENT '电压名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of voltage
-- ----------------------------
