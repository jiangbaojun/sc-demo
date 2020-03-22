/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : db1

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 19/02/2020 11:09:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` bigint(20) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `db_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------
BEGIN;
INSERT INTO `dept` VALUES (1, '研发部', 'db1');
INSERT INTO `dept` VALUES (2, '市场部', 'db1');
INSERT INTO `dept` VALUES (3, '财务部', 'db1');
INSERT INTO `dept` VALUES (4, '人事部', 'db1');
INSERT INTO `dept` VALUES (5, 'xiaoming', 'db1');
INSERT INTO `dept` VALUES (6, 'xiaoming', 'db1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
