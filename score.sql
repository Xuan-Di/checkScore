/*
 Navicat Premium Data Transfer

 Source Server         : My server
 Source Server Type    : MySQL
 Source Server Version : 50540

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 17/06/2020 15:35:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course_grade
-- ----------------------------
DROP TABLE IF EXISTS `course_grade`;
CREATE TABLE `course_grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `term` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `course_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `LEVEL` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `score_coursegrade_stcls`(`student_num`, `term`, `course_name`, `LEVEL`, `score`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4894 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `major_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `grade` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `course_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `STATUS` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `student_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `class_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `term` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `course_num` int(11) NOT NULL,
  `flunk_num` int(11) NOT NULL,
  `avg_score` float(11, 2) NOT NULL,
  `all_score` float(11, 2) NOT NULL,
  `all_credit_score` float(11, 2) NOT NULL,
  `avg_credit` float(11, 2) NOT NULL,
  `avg_credit_point` float(11, 2) NOT NULL,
  `major_rank` int(11) NOT NULL,
  `STATUS` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`, `class_name`) USING BTREE,
  INDEX `score_student_cts`(`class_name`, `term`, `student_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 532 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `work_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_type` int(11) NULL DEFAULT NULL,
  `class_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `STATUS` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
