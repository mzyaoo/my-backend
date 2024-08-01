/*
 Navicat Premium Data Transfer

 Source Server         : Local-Mysql
 Source Server Type    : MySQL
 Source Server Version : 80401 (8.4.1)
 Source Host           : localhost:3306
 Source Schema         : my-database

 Target Server Type    : MySQL
 Target Server Version : 80401 (8.4.1)
 File Encoding         : 65001

 Date: 01/08/2024 16:34:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `path` varchar(255) DEFAULT NULL COMMENT '组件地址',
  `order_num` int DEFAULT NULL COMMENT '排序字段',
  `parent_id` int DEFAULT NULL COMMENT '父菜单ID',
  `query` varchar(255) DEFAULT NULL COMMENT '参数（JSON）',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限标识',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` (`id`, `name`, `component`, `path`, `order_num`, `parent_id`, `query`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `visible`, `status`, `perms`, `menu_type`) VALUES (1, '系统管理', NULL, '/system', 1, 0, NULL, 'IconSettings', 'admin', '2024-08-01 14:30:27', 'admin', '2024-08-01 14:30:27', '0', '0', NULL, 'M');
INSERT INTO `sys_menu` (`id`, `name`, `component`, `path`, `order_num`, `parent_id`, `query`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `visible`, `status`, `perms`, `menu_type`) VALUES (2, '用户管理', 'system/user/index', '/user', 1, 1, NULL, NULL, 'admin', '2024-08-01 14:30:27', 'admin', '2024-08-01 14:30:27', '0', '0', 'system:user:main', 'C');
INSERT INTO `sys_menu` (`id`, `name`, `component`, `path`, `order_num`, `parent_id`, `query`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `visible`, `status`, `perms`, `menu_type`) VALUES (3, '角色管理', 'system/role/index', '/role', 2, 1, NULL, NULL, 'admin', '2024-08-01 14:30:27', 'admin', '2024-08-01 14:30:27', '0', '0', 'system:role:main', 'C');
INSERT INTO `sys_menu` (`id`, `name`, `component`, `path`, `order_num`, `parent_id`, `query`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `visible`, `status`, `perms`, `menu_type`) VALUES (4, '菜单管理', 'system/menu/index', '/menu', 3, 1, NULL, NULL, 'admin', '2024-08-01 14:30:27', 'admin', '2024-08-01 14:30:27', '0', '0', 'system:menu:main', 'C');
INSERT INTO `sys_menu` (`id`, `name`, `component`, `path`, `order_num`, `parent_id`, `query`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `visible`, `status`, `perms`, `menu_type`) VALUES (5, '任务管理', 'system/job/index', '/job', 4, 1, NULL, NULL, 'admin', '2024-08-01 14:30:27', 'admin', '2024-08-01 14:30:27', '0', '0', 'system:job:main', 'C');
INSERT INTO `sys_menu` (`id`, `name`, `component`, `path`, `order_num`, `parent_id`, `query`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `visible`, `status`, `perms`, `menu_type`) VALUES (6, '系统工具', '', '/utils', 2, 0, NULL, 'IconSettings', 'admin', '2024-08-01 14:30:27', 'admin', '2024-08-01 14:30:27', '0', '0', NULL, 'M');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `pass_word` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系方式',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '帐号状态（0正常 1停用）',
  `status` char(1) DEFAULT NULL COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`id`, `user_name`, `pass_word`, `nick_name`, `avatar`, `telephone`, `email`, `sex`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 'admin', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '超级管理员', NULL, '12345678910', '12345678910@163.com', '0', '0', '0', '127.0.0.1', NULL, NULL, '2024-08-01 13:34:42', NULL, '2024-08-01 13:34:45');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
