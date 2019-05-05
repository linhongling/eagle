/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50723
Source Host           : 192.168.132.128:3306
Source Database       : hichat

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-04-30 17:07:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for h_comment
-- ----------------------------
DROP TABLE IF EXISTS `h_comment`;
CREATE TABLE "h_comment" (
  "id" bigint(10) NOT NULL AUTO_INCREMENT,
  "content" varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  "user_id" bigint(10) DEFAULT NULL,
  "essay_id" bigint(10) DEFAULT NULL,
  "create_time" timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of h_comment
-- ----------------------------

-- ----------------------------
-- Table structure for h_essay
-- ----------------------------
DROP TABLE IF EXISTS `h_essay`;
CREATE TABLE "h_essay" (
  "id" bigint(8) NOT NULL AUTO_INCREMENT,
  "user_id" bigint(8) NOT NULL,
  "content" varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '内容',
  "create_time" timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  "imgs" varchar(500) DEFAULT NULL,
  "small_imgs" varchar(500) DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of h_essay
-- ----------------------------

-- ----------------------------
-- Table structure for h_message
-- ----------------------------
DROP TABLE IF EXISTS `h_message`;
CREATE TABLE "h_message" (
  "id" bigint(16) NOT NULL AUTO_INCREMENT,
  "from_user_id" bigint(16) DEFAULT NULL COMMENT '发送者',
  "to_user_id" bigint(16) DEFAULT NULL COMMENT '接收者',
  "message" varchar(512) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '聊天信息',
  "create_time" timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '聊天信息',
  "read_flag" varchar(16) DEFAULT NULL COMMENT 'no未读 yes已读',
  "msg_type" int(8) DEFAULT NULL,
  "small_img" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h_message
-- ----------------------------

-- ----------------------------
-- Table structure for h_permission
-- ----------------------------
DROP TABLE IF EXISTS `h_permission`;
CREATE TABLE "h_permission" (
  "id" bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  "menu_code" varchar(255) NOT NULL DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  "menu_name" varchar(255) DEFAULT '' COMMENT '菜单的中文释义',
  "permission_code" varchar(255) NOT NULL DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  "permission_name" varchar(255) DEFAULT '' COMMENT '本权限的中文释义',
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='后台权限表';

-- ----------------------------
-- Records of h_permission
-- ----------------------------
INSERT INTO `h_permission` VALUES ('1', 'orderQuery', '订单管理', 'orderQuery:query', '查询');
INSERT INTO `h_permission` VALUES ('2', 'orderQuery', '订单管理', 'orderQuery:send', '发送信息');
INSERT INTO `h_permission` VALUES ('3', 'orderQuery', '订单管理', 'orderQuery:delete', '删除');
INSERT INTO `h_permission` VALUES ('4', 'clientQuery', '客户管理', 'clientQuery:query', '查询');
INSERT INTO `h_permission` VALUES ('5', 'transferCompany', '转运公司管理', 'transferCompany:query', '查询');
INSERT INTO `h_permission` VALUES ('6', 'transferCompany', '转运公司管理', 'transferCompany:delete', '删除');
INSERT INTO `h_permission` VALUES ('7', 'transferCompany', '转运公司管理', 'transferCompany:load', '查看详情');
INSERT INTO `h_permission` VALUES ('8', 'employee', '系统用户管理', 'employee:query', '查询');
INSERT INTO `h_permission` VALUES ('9', 'employee', '系统用户管理', 'employee:edit', '编辑');
INSERT INTO `h_permission` VALUES ('11', 'employee', '系统用户管理', 'employee:delete', '删除');
INSERT INTO `h_permission` VALUES ('12', 'employee', '系统用户管理', 'employee:reset', '重置密码');
INSERT INTO `h_permission` VALUES ('13', 'employee', '系统用户管理', 'employee:assign', '分配角色');
INSERT INTO `h_permission` VALUES ('14', 'role', '系统角色管理', 'role:query', '角色管理查询');
INSERT INTO `h_permission` VALUES ('15', 'role', '系统角色管理', 'role:edit', '编辑');
INSERT INTO `h_permission` VALUES ('17', 'role', '系统角色管理', 'role:delete', '删除');
INSERT INTO `h_permission` VALUES ('18', 'role', '系统角色管理', 'role:assign', '分配权限');
INSERT INTO `h_permission` VALUES ('19', 'goodsQuery', '品类管理', 'goodsQuery:query', '查询');

-- ----------------------------
-- Table structure for h_role
-- ----------------------------
DROP TABLE IF EXISTS `h_role`;
CREATE TABLE "h_role" (
  "id" bigint(11) NOT NULL AUTO_INCREMENT,
  "role_name" varchar(20) DEFAULT NULL COMMENT '角色名',
  "create_time" timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  "update_time" timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8 COMMENT='后台角色表';

-- ----------------------------
-- Records of h_role
-- ----------------------------
INSERT INTO `h_role` VALUES ('1001', '程序员', '2018-07-27 14:45:35', null);
INSERT INTO `h_role` VALUES ('1002', '测试工程师', '2018-07-27 14:45:53', null);
INSERT INTO `h_role` VALUES ('1003', '项目经理', '2018-07-27 14:45:59', null);
INSERT INTO `h_role` VALUES ('1004', '技术总监', '2018-07-27 14:46:07', '2019-04-18 14:15:53');
INSERT INTO `h_role` VALUES ('1005', '管理员', '2018-07-25 16:35:00', '2018-08-03 21:15:15');

-- ----------------------------
-- Table structure for h_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `h_role_permission`;
CREATE TABLE "h_role_permission" (
  "id" bigint(11) NOT NULL AUTO_INCREMENT,
  "role_id" bigint(11) DEFAULT NULL COMMENT '角色id',
  "permission_id" bigint(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

-- ----------------------------
-- Records of h_role_permission
-- ----------------------------
INSERT INTO `h_role_permission` VALUES ('1', '1004', '1');
INSERT INTO `h_role_permission` VALUES ('2', '1004', '2');

-- ----------------------------
-- Table structure for h_user
-- ----------------------------
DROP TABLE IF EXISTS `h_user`;
CREATE TABLE "h_user" (
  "id" bigint(16) NOT NULL AUTO_INCREMENT,
  "account" varchar(255) DEFAULT NULL COMMENT '用户账号',
  "nickname" varchar(512) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户昵称',
  "password" varchar(255) DEFAULT NULL COMMENT '用户密码',
  "avatar" varchar(255) DEFAULT NULL COMMENT '用户头像',
  "sex" int(8) DEFAULT NULL COMMENT '性别 0为女性 1为男性',
  "description" varchar(512) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '个性签名',
  "header" varchar(8) DEFAULT NULL,
  "create_time" timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  "update_time" timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h_user
-- ----------------------------

-- ----------------------------
-- Table structure for h_web_role
-- ----------------------------
DROP TABLE IF EXISTS `h_web_role`;
CREATE TABLE "h_web_role" (
  "id" bigint(11) NOT NULL AUTO_INCREMENT,
  "web_user_id" bigint(11) DEFAULT NULL,
  "role_id" bigint(11) DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h_web_role
-- ----------------------------
INSERT INTO `h_web_role` VALUES ('1005', '1000', '1004');

-- ----------------------------
-- Table structure for h_web_user
-- ----------------------------
DROP TABLE IF EXISTS `h_web_user`;
CREATE TABLE "h_web_user" (
  "id" bigint(16) NOT NULL AUTO_INCREMENT,
  "account" varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  "password" varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  "nickname" varchar(255) DEFAULT NULL,
  "create_time" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "update_time" timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of h_web_user
-- ----------------------------
INSERT INTO `h_web_user` VALUES ('999', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '2018-07-23 09:06:56', '2018-10-25 17:25:53');
INSERT INTO `h_web_user` VALUES ('1000', 'qiu', 'a45958517604f5cd90d6ee51ad9cfdb6', 'qiu', '2019-04-15 16:51:01', '2019-04-17 10:50:04');

-- ----------------------------
-- Table structure for t_client
-- ----------------------------
DROP TABLE IF EXISTS `t_client`;
CREATE TABLE "t_client" (
  "id" bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  "name" varchar(255) NOT NULL,
  "phone" varchar(20) DEFAULT NULL COMMENT '公司联系电话',
  "contact" varchar(50) DEFAULT NULL COMMENT '联系人',
  "cellphone" varchar(20) DEFAULT NULL COMMENT '联系人电话',
  "addr" varchar(255) DEFAULT NULL COMMENT '公司地址',
  "remark" varchar(255) DEFAULT NULL COMMENT '备注',
  "create_date" datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  "modify_date" timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_client
-- ----------------------------
INSERT INTO `t_client` VALUES ('1', '宇达', '13311111111', '王生', '13311111111', '深圳市', null, '2019-04-23 17:10:00', null);
INSERT INTO `t_client` VALUES ('2', '广粤通56', '13355555555', '林', '', '', '', '2019-04-22 17:10:06', '2019-04-23 17:11:28');

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE "t_goods" (
  "id" bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  "name" varchar(255) NOT NULL,
  "remark" varchar(500) DEFAULT NULL,
  "create_date" datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  "modify_date" timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('1', '模具', null, '2019-04-30 15:07:20', '2019-04-30 15:07:24');
INSERT INTO `t_goods` VALUES ('2', '服装', null, '2019-04-30 15:12:20', '2019-04-30 15:12:20');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE "t_order" (
  "id" bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  "no" varchar(50) NOT NULL COMMENT '单号',
  "order_date" date NOT NULL COMMENT '日期',
  "client_id" bigint(20) DEFAULT NULL COMMENT '客户ID',
  "addr" varchar(255) DEFAULT NULL COMMENT '目的地',
  "goods_id" bigint(20) DEFAULT NULL COMMENT '品名',
  "count" int(11) DEFAULT NULL COMMENT '件数',
  "weight" decimal(10,0) DEFAULT NULL COMMENT '重量',
  "volume" decimal(10,0) DEFAULT NULL COMMENT '体积',
  "freight_monthly" decimal(10,0) DEFAULT NULL COMMENT '收入-月结',
  "freight_now" decimal(10,0) DEFAULT NULL COMMENT '收入-现付',
  "freight_arrive" decimal(10,0) DEFAULT NULL COMMENT '收入-到付',
  "cost_freight" decimal(10,0) DEFAULT NULL COMMENT '成本-运费',
  "cost_direct" decimal(10,0) DEFAULT NULL COMMENT '成本-直送',
  "cost_insurance" decimal(10,0) DEFAULT NULL COMMENT '成本-保险',
  "transfer_company_id" bigint(20) DEFAULT NULL COMMENT '转运公司',
  "transfer_no" varchar(50) DEFAULT NULL COMMENT '转运单号',
  "receipt" date DEFAULT NULL COMMENT '回单',
  "remark" varchar(500) DEFAULT NULL COMMENT '备注',
  "create_date" datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  "modify_date" timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '135435', '2019-04-19', '1', '深圳市', '2', '1', '34', '34', '344', null, null, '340', null, '34', '346', '347357', '2019-04-19', '45757', '2019-04-19 17:21:15', '2019-04-19 17:21:19');

-- ----------------------------
-- Table structure for t_transfer_company
-- ----------------------------
DROP TABLE IF EXISTS `t_transfer_company`;
CREATE TABLE "t_transfer_company" (
  "id" bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  "name" varchar(255) NOT NULL,
  "phone" varchar(20) DEFAULT NULL COMMENT '公司联系电话',
  "contact" varchar(50) DEFAULT NULL COMMENT '联系人',
  "cellphone" varchar(20) DEFAULT NULL COMMENT '联系人电话',
  "addr" varchar(255) DEFAULT NULL COMMENT '公司地址',
  "remark" varchar(255) DEFAULT NULL COMMENT '备注',
  "create_date" datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  "modify_date" timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_transfer_company
-- ----------------------------
INSERT INTO `t_transfer_company` VALUES ('1', '聚盟-新侨', '15335555555', null, null, null, null, null, null);

-- ----------------------------
-- View structure for messageusers
-- ----------------------------
DROP VIEW IF EXISTS `messageusers`;
CREATE ALGORITHM=UNDEFINED DEFINER="root"@"localhost" SQL SECURITY DEFINER VIEW `messageusers` AS select "userfrom"."nickname" AS "fromUser","userfrom"."id" AS "fromId","userto"."id" AS "toId","userto"."nickname" AS "toUser","message"."create_time" AS "chatTime","message"."message" AS "message",((("userfrom"."id" + "userto"."id") + ("userfrom"."id" * "userto"."id")) / (("userfrom"."id" * "userto"."id") * 2)) AS "groupId" from (("h_message" "message" left join "h_user" "userfrom" on(("userfrom"."id" = "message"."from_user_id"))) left join "h_user" "userto" on(("userto"."id" = "message"."to_user_id"))) order by "message"."create_time" desc ;

-- ----------------------------
-- View structure for permissionlist
-- ----------------------------
DROP VIEW IF EXISTS `permissionlist`;
CREATE ALGORITHM=UNDEFINED DEFINER="root"@"localhost" SQL SECURITY DEFINER VIEW `permissionlist` AS select "t"."id" AS "pId","t"."menu_name" AS "pLabel","child"."id" AS "cId","child"."permission_name" AS "cLabel" from ("permissionmenu" "t" left join "h_permission" "child" on(("child"."menu_code" = "t"."menu_code"))) order by "child"."id" ;

-- ----------------------------
-- View structure for permissionmenu
-- ----------------------------
DROP VIEW IF EXISTS `permissionmenu`;
CREATE ALGORITHM=UNDEFINED DEFINER="root"@"localhost" SQL SECURITY DEFINER VIEW `permissionmenu` AS select (sum("perm"."id") + 10000) AS "id","perm"."menu_code" AS "menu_code","perm"."menu_name" AS "menu_name" from "h_permission" "perm" group by "perm"."menu_code","perm"."menu_name" ;
