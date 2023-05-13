/*
 Navicat Premium Data Transfer

 Source Server         : localhost：3306
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : dormitory

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 12/05/2023 15:48:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for absent
-- ----------------------------
DROP TABLE IF EXISTS `absent`;
CREATE TABLE `absent`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `building_id` int NULL DEFAULT NULL,
  `dormitory_id` int NULL DEFAULT NULL,
  `student_id` int NULL DEFAULT NULL,
  `dormitory_admin_id` int NULL DEFAULT NULL,
  `create_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of absent
-- ----------------------------
INSERT INTO `absent` VALUES (13, 1, 2, 5, 16, '2022-04-16', '请假');
INSERT INTO `absent` VALUES (14, 1, 1, 1, 1, '2022-04-26', '请假');
INSERT INTO `absent` VALUES (15, 2, 5, 63, 1, '2022-04-26', '请假');

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduction` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES (1, '1号楼', '计算机学院宿舍楼', 1);
INSERT INTO `building` VALUES (2, '2号楼', '计算机学院宿舍楼', 2);
INSERT INTO `building` VALUES (3, '3号楼', '电信学院宿舍楼', 3);
INSERT INTO `building` VALUES (4, '4号楼', '机械学院宿舍楼', 4);

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `building_id` int NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int NULL DEFAULT NULL,
  `available` int NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES (1, 1, '1101', 4, 0, '88131101');
INSERT INTO `dormitory` VALUES (2, 1, '1102', 4, 0, '88131102');
INSERT INTO `dormitory` VALUES (3, 1, '1211', 4, 0, '88132111');
INSERT INTO `dormitory` VALUES (4, 2, '2212', 6, 1, '88232212');
INSERT INTO `dormitory` VALUES (5, 2, '2321', 8, 7, '88232321');
INSERT INTO `dormitory` VALUES (6, 2, '2322', 10, 10, '88232322');
INSERT INTO `dormitory` VALUES (7, 1, '1366', 6, 6, '88131366');
INSERT INTO `dormitory` VALUES (8, 3, '3215', 6, 5, '88333215');
INSERT INTO `dormitory` VALUES (9, 4, '4331', 6, 6, '88434331');

-- ----------------------------
-- Table structure for dormitory_admin
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_admin`;
CREATE TABLE `dormitory_admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory_admin
-- ----------------------------
INSERT INTO `dormitory_admin` VALUES (1, 'll', '123123', '宋玉', '女', '13312345679');
INSERT INTO `dormitory_admin` VALUES (2, 'ww', '123123', '王力', '男', '13612345678');
INSERT INTO `dormitory_admin` VALUES (3, 'zz', '123123', '张三', '女', '13312345678');
INSERT INTO `dormitory_admin` VALUES (4, 'xm', '123123', '小明', '男', '12312345678');

-- ----------------------------
-- Table structure for moveout
-- ----------------------------
DROP TABLE IF EXISTS `moveout`;
CREATE TABLE `moveout`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitory_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of moveout
-- ----------------------------
INSERT INTO `moveout` VALUES (1, '20', '6', '毕业', '2022-04-17');
INSERT INTO `moveout` VALUES (2, '18', '4', '毕业', '2022-04-27');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormitory_id` int NULL DEFAULT NULL,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '001', '王伟', '男', 1, '入住', '2023-04-14');
INSERT INTO `student` VALUES (2, '002', '曹海', '男', 1, '入住', '2023-04-14');
INSERT INTO `student` VALUES (3, '003', '李力', '男', 1, '入住', '2023-04-14');
INSERT INTO `student` VALUES (4, '004', '赵昭', '男', 1, '入住', '2023-04-14');
INSERT INTO `student` VALUES (5, '005', '王维利', '男', 2, '入住', '2023-04-14');
INSERT INTO `student` VALUES (6, '006', '李双', '女', 2, '入住', '2023-04-14');
INSERT INTO `student` VALUES (7, '007', '李小峰', '男', 2, '入住', '2023-04-14');
INSERT INTO `student` VALUES (8, '008', '孙奇', '男', 2, '入住', '2023-04-14');
INSERT INTO `student` VALUES (9, '009', '李立', '女', 3, '入住', '2023-04-14');
INSERT INTO `student` VALUES (10, '010', '周华发', '男', 3, '入住', '2023-04-14');
INSERT INTO `student` VALUES (11, '011', '赵正义', '男', 3, '入住', '2023-04-14');
INSERT INTO `student` VALUES (12, '012', '李明', '男', 3, '入住', '2023-04-14');
INSERT INTO `student` VALUES (13, '013', '许鹏飞', '男', 4, '入住', '2023-04-14');
INSERT INTO `student` VALUES (14, '014', '朱海', '男', 4, '入住', '2023-04-14');
INSERT INTO `student` VALUES (15, '015', '苏苏苏', '男', 4, '入住', '2023-04-14');
INSERT INTO `student` VALUES (16, '016', '李雪', '女', 4, '入住', '2023-04-14');
INSERT INTO `student` VALUES (17, '017', '李爽', '女', 4, '入住', '2023-04-14');
INSERT INTO `student` VALUES (18, '018', '王纯', '女', 4, '迁出', '2023-04-14');
INSERT INTO `student` VALUES (19, '019', '小王', '男', 5, '入住', '2023-04-17');
INSERT INTO `student` VALUES (20, '032', '小明2', '男', 6, '迁出', '2023-05-10');
INSERT INTO `student` VALUES (21, '035', '小红', '女', 8, '入住', '2023-05-11');

-- ----------------------------
-- Table structure for system_admin
-- ----------------------------
DROP TABLE IF EXISTS `system_admin`;
CREATE TABLE `system_admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_admin
-- ----------------------------
INSERT INTO `system_admin` VALUES (1, 'admin1', '123123', '管理员1', '88130001');
INSERT INTO `system_admin` VALUES (2, 'admin2', '123123', '管理员2', '88130002');
INSERT INTO `system_admin` VALUES (3, 'admin3', '123123', '管理员3', '88130003');

SET FOREIGN_KEY_CHECKS = 1;
