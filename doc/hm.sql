/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : hm

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 12/05/2019 15:08:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dk
-- ----------------------------
DROP TABLE IF EXISTS `dk`;
CREATE TABLE `dk`  (
  `userId` int(5) NULL DEFAULT NULL COMMENT '用户id',
  `dkTime` datetime(0) NULL DEFAULT NULL COMMENT '打卡时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qjsq
-- ----------------------------
DROP TABLE IF EXISTS `qjsq`;
CREATE TABLE `qjsq`  (
  `qjId` int(6) NOT NULL AUTO_INCREMENT,
  `qjyy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请假原因',
  `qjms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请假描述',
  `ksTime` datetime(0) NULL DEFAULT NULL COMMENT '请假开始时间',
  `jsTime` datetime(0) NULL DEFAULT NULL COMMENT '请假结束时间',
  `qjzt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请假状态',
  `userId` int(5) NULL DEFAULT NULL COMMENT '请假人',
  PRIMARY KEY (`qjId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qjsq
-- ----------------------------
INSERT INTO `qjsq` VALUES (9, '事假', '回家', '2019-05-11 00:00:00', '2019-05-11 00:00:00', '审批中', 1);
INSERT INTO `qjsq` VALUES (10, '病假', '', '2019-05-12 00:00:00', '2019-05-13 00:00:00', '审批中', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(5) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permission` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `ks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `xb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '郑佳伟', '1', 'true', '儿科', '1', '男');

SET FOREIGN_KEY_CHECKS = 1;
