/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : qg

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-05-01 21:48:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `group` varchar(50) DEFAULT NULL,
  `grade` varchar(50) DEFAULT NULL,
  `clas` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dormitory` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('100', '陈凌丰', '数据挖掘', '大一', '软件工程一班', '15521178532', 'm15521178532@163.com', '西一430', '广东工业大学');
INSERT INTO `info` VALUES ('1000', '2121', '1212', '1012012', '010', '1201201', '2012012', '012010', '1012010');
INSERT INTO `info` VALUES ('101', '林大润', '数据挖掘', '大一', '软件工程', '12345678911', '12222255', '西一430', '广东工业大学');
INSERT INTO `info` VALUES ('102', '陈伟镔', '前端', '大一', '软件工程一班', '9876543211', '11158855', '西一430', '广东工业大学');
INSERT INTO `info` VALUES ('104', '李昌校', '后台', '大一', '软件工程一班', '987654321', '12222', '555555', '广东工业大学');

-- ----------------------------
-- Table structure for logininfo
-- ----------------------------
DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE `logininfo` (
  `name` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of logininfo
-- ----------------------------
INSERT INTO `logininfo` VALUES ('李昌校', '123456');
INSERT INTO `logininfo` VALUES ('林大润', '123456');
INSERT INTO `logininfo` VALUES ('陈伟镔', '123456');
INSERT INTO `logininfo` VALUES ('陈凌丰', '123456');
