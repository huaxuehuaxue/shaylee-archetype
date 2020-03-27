/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.80
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 192.168.0.80:3306
 Source Schema         : shaylee

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 27/03/2020 13:43:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_route_conf
-- ----------------------------
DROP TABLE IF EXISTS `sys_route_conf`;
CREATE TABLE `sys_route_conf`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `route_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路由名称',
  `route_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路由ID',
  `predicates` json NULL COMMENT '断言',
  `filters` json NULL COMMENT '过滤器',
  `uri` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '资源名称',
  `sort` int(2) NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(3) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(3) NULL DEFAULT NULL COMMENT '修改时间',
  `del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志(0正常 1删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '路由配置表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
