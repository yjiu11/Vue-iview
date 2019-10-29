/*
 Navicat Premium Data Transfer

 Source Server         : MySQL_3306
 Source Server Type    : MySQL
 Source Server Version : 50610
 Source Host           : localhost:3306
 Source Schema         : iview

 Target Server Type    : MySQL
 Target Server Version : 50610
 File Encoding         : 65001

 Date: 29/10/2019 11:22:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目',
  `type` int(11) NULL DEFAULT NULL COMMENT '1:选择题;2:填空题;3:大题;0:多选题',
  `options` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答案',
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, '数据库管理系统产生于哪年', 1, '[{\"item\":\"20世纪50年代\",\"value\":\"A\"},{\"item\":\"20世纪40年代前\",\"value\":\"B\"},{\"item\":\"20世纪90年代后\",\"value\":\"C\"}]', '[{\"item\":\"A\"}]', 'aaa', '2019-10-21 17:39:04', '2019-10-21 17:39:06');
INSERT INTO `question` VALUES (2, '数据库管理系统产生于哪年', 2, NULL, '[{\"item\":\"数据库管理\"},{\"item\":\"哪年\"}]', 'aaa', NULL, NULL);
INSERT INTO `question` VALUES (3, '简述DBMS', 3, '', '[{\"item\":\"DBMS数据库管理系统\"}]', 'aaa', '2019-10-23 09:15:33', '2019-10-23 09:15:35');
INSERT INTO `question` VALUES (8, '数据库管理系统哪年', 2, NULL, '[{\"item\":\"数据库管理\"},{\"item\":\"哪年\"}]', 'aaa', '2019-10-29 10:25:46', '2019-10-29 10:25:46');
INSERT INTO `question` VALUES (9, '选择分配', 1, NULL, '[{\"item\":\"1\"},{\"item\":\"2\"},{\"item\":\"3\"}]', 'aaa', '2019-10-29 10:43:20', '2019-10-29 10:43:20');

-- ----------------------------
-- Table structure for sys_params
-- ----------------------------
DROP TABLE IF EXISTS `sys_params`;
CREATE TABLE `sys_params`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码类型，用以区分',
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明编码类型是干什么的',
  `sort` int(10) NULL DEFAULT NULL COMMENT '键排序',
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '键',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父节点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_params
-- ----------------------------
INSERT INTO `sys_params` VALUES (1, 'category', '分类', 1, '自考', 'zikao', 0);
INSERT INTO `sys_params` VALUES (2, 'category', '分类', 2, '中国近现代史', 'aaa', 1);
INSERT INTO `sys_params` VALUES (3, 'category', '分类', 3, '数据库系统原理', 'db', 1);
INSERT INTO `sys_params` VALUES (4, 'category', '分类', 4, '框架', 'frame', 0);

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `open` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, '首页', 'menu', 0, 'ios-navigate', NULL, '', '1', 1);
INSERT INTO `sys_resource` VALUES (2, '系统信息', 'menu', 1, '', NULL, '', '1', 1);
INSERT INTO `sys_resource` VALUES (3, '用户管理', 'menu', 2, 'icon-search', 'Home', '/home', '1', NULL);
INSERT INTO `sys_resource` VALUES (4, '角色管理', 'menu', 2, 'icon-search', 'About', '/about', '1', NULL);
INSERT INTO `sys_resource` VALUES (5, '资源管理', 'menu', 2, 'icon-search', NULL, '', '1', NULL);
INSERT INTO `sys_resource` VALUES (6, '接口平台', 'menu', 0, 'ios-stats', NULL, '/about', '1', 1);
INSERT INTO `sys_resource` VALUES (7, '中控平台', 'menu', 6, 'ios-navigate', NULL, '', '1', 1);
INSERT INTO `sys_resource` VALUES (8, '马蜂窝', 'menu', 7, 'icon-search', NULL, '', '1', NULL);
INSERT INTO `sys_resource` VALUES (9, '平台助手', 'menu', 1, NULL, NULL, '', '1', 1);
INSERT INTO `sys_resource` VALUES (10, '题目列表', 'menu', 9, NULL, 'Subject', '/subject', '1', 1);
INSERT INTO `sys_resource` VALUES (11, '添加题目', 'menu', 9, NULL, 'AddSubject', '/add_subject', '1', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `resource_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '超级管理员', '1,2,3,4,6,7,8', '1');
INSERT INTO `sys_role` VALUES (5, 'deploy', '发布管理员', '1,4,5,19,6,7,8,9,10,11,17,20,12,13,14,15,16,18,22,23', '1');
INSERT INTO `sys_role` VALUES (6, 'manager', '项目经理', '1,2,6,18,22,23', '1');
INSERT INTO `sys_role` VALUES (7, 'system', '系统管理员', '1,2,3,4,5,19,6,7,8,9,12,13,14,15,16,18', '1');
INSERT INTO `sys_role` VALUES (8, 'apply', '申请管理员', '18', '1');
INSERT INTO `sys_role` VALUES (9, 'Maintain', '维护管理员', '18', '1');
INSERT INTO `sys_role` VALUES (10, 'product', '产品管理员', '18', '1');
INSERT INTO `sys_role` VALUES (11, 'approval', '审批管理员', '18', '1');
INSERT INTO `sys_role` VALUES (15, 'base', '基础角色', '1,2,4,6,7,8,9,10,11,12,14,15,18,23', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `locked` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '管理员', 'e00cf25ad42683b3df678c61f42c6bda', '1,5,6', 'yjsfgn@163.com', '13939393331', '2');
INSERT INTO `sys_user` VALUES (28, 'yjiu', '刘洋', '30d6b3fe65a2b912352e241b4a5aebc9', '1,5', '1364130@163.com', '13641305513', '2');

-- ----------------------------
-- Procedure structure for insert_users
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_users`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_users`(in STAR int(10),in max_num INT(10))
BEGIN
	DECLARE i INT DEFAULT 0;
	DECLARE tmp VARCHAR(50) DEFAULT '';
	SET autocommit =0;
	REPEAT
		SET i = i+1;
		SET tmp = CONCAT(rand_string(4) ,'@163.com');
		INSERT INTO users(id,username,password,email,address,ENABLE,createDate,updateDate) 
			values((STAR+i),rand_string(6),rand_string(12),tmp,rand_address(),1,'20180104','20180104');
		UNTIL i = max_num
	end REPEAT;	
	COMMIT;
END
;;
delimiter ;

-- ----------------------------
-- Function structure for rand_address
-- ----------------------------
DROP FUNCTION IF EXISTS `rand_address`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `rand_address`() RETURNS varchar(255) CHARSET utf8
BEGIN
		DECLARE str INT(10) DEFAULT 0;
		DECLARE return_str varchar(200) DEFAULT '';
		set str = rand_num();
		case str
			when 101 then set return_str = '北京';
			when 102 then set return_str = '天津';
			when 103 then set return_str = '广州';
			when 104 then set return_str = '广东';
			when 105 then set return_str = '河北';
			when 106 then set return_str = '河南';
			when 107 then set return_str = '四川';
			when 108 then set return_str = '厦门';
			when 109 then set return_str = '贵阳';
			when 110 then set return_str = '太原';
			else set return_str = '北上广';
		end case;
	RETURN return_str;
END
;;
delimiter ;

-- ----------------------------
-- Function structure for rand_num
-- ----------------------------
DROP FUNCTION IF EXISTS `rand_num`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `rand_num`() RETURNS int(10)
BEGIN
	DECLARE i INT DEFAULT 0;
	SET i = FLOOR(100+RAND()*10);
	RETURN i;
END
;;
delimiter ;

-- ----------------------------
-- Function structure for rand_string
-- ----------------------------
DROP FUNCTION IF EXISTS `rand_string`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `rand_string`(n INT) RETURNS varchar(255) CHARSET utf8
BEGIN
		declare chars_str varchar(100) default 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ' ;
		DECLARE return_str VARCHAR(255) DEFAULT '';
		DECLARE i INT DEFAULT 0 ;
		WHILE i < n DO
			set return_str = CONCAT(return_str, substring(chars_str, floor(1+ rand()*52),1));
			SET i = i + 1;
		END WHILE;
	RETURN return_str;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
