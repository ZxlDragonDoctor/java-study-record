/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : redis-red

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 14/10/2024 21:39:59
*/
create database  if not exists redis_red;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
use redis_red;
-- ----------------------------
-- Table structure for red_detail
-- ------------a---------------
DROP TABLE IF EXISTS `red_detail`;
CREATE TABLE `red_detail`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `record_id` int NOT NULL COMMENT '红包记录id',
  `amount` decimal(8, 2) NULL DEFAULT NULL COMMENT '金额(单位为分)',
  `is_active` tinyint NULL DEFAULT 1 COMMENT '是否有效',
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '红包明细金额' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for red_record
-- ----------------------------
DROP TABLE IF EXISTS `red_record`;
CREATE TABLE `red_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '用户id',
  `red_packet` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '红包全局唯一标识串',
  `total` int NOT NULL COMMENT '人数',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '总金额(单位为分)',
  `is_active` tinyint NULL DEFAULT 1 COMMENT '是否有效',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '发红包记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for red_rob_record
-- ----------------------------
DROP TABLE IF EXISTS `red_rob_record`;
CREATE TABLE `red_rob_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '用户账号',
  `red_packet` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '红包标识串',
  `amount` decimal(8, 2) NULL DEFAULT NULL COMMENT '红包金额(单位为分)',
  `rob_time` datetime NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '抢红包记录' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
