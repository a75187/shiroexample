/*
Navicat MySQL Data Transfer

Source Server         : mastesql
Source Server Version : 50725
Source Host           : 172.16.62.139:3307
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-08-15 15:37:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tgroup
-- ----------------------------
DROP TABLE IF EXISTS `tgroup`;
CREATE TABLE `tgroup` (
  `tg_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '组id',
  `group_name` varchar(50) NOT NULL COMMENT '组名称',
  `parent_tg_id` varchar(50) NOT NULL COMMENT '父组',
  `description` varchar(200) DEFAULT NULL COMMENT '组描述',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='组表';

-- ----------------------------
-- Table structure for tgroupRightRelation
-- ----------------------------
DROP TABLE IF EXISTS `tgroupRightRelation`;
CREATE TABLE `tgroupRightRelation` (
  `tgr_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '记录标识id',
  `tg_id` bigint(10) NOT NULL COMMENT '组id',
  `tr_id` bigint(10) NOT NULL COMMENT '权限id',
  `right_type` bigint(10) NOT NULL COMMENT '0：可访问，1：可授权',
  PRIMARY KEY (`tgr_id`),
  KEY `tr_id` (`tr_id`),
  KEY `tg_id` (`tg_id`),
  CONSTRAINT `tgroupRightRelation_ibfk_1` FOREIGN KEY (`tr_id`) REFERENCES `tright` (`tr_id`),
  CONSTRAINT `tgroupRightRelation_ibfk_2` FOREIGN KEY (`tg_id`) REFERENCES `tgroup` (`tg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='组权限表';

-- ----------------------------
-- Table structure for tright
-- ----------------------------
DROP TABLE IF EXISTS `tright`;
CREATE TABLE `tright` (
  `tr_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `pargent_tr_id` bigint(10) NOT NULL COMMENT '父级权限id',
  `right_name` varchar(50) NOT NULL COMMENT '权限名称',
  `description` varchar(200) DEFAULT NULL COMMENT '权限描述',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Table structure for tusergrouprelation
-- ----------------------------
DROP TABLE IF EXISTS `tusergrouprelation`;
CREATE TABLE `tusergrouprelation` (
  `tug_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '用户组id',
  `tu_id` bigint(10) NOT NULL COMMENT '用户id',
  `tg_id` bigint(10) NOT NULL COMMENT '用户组id',
  PRIMARY KEY (`tug_id`),
  KEY `tu_id` (`tu_id`),
  KEY `tg_id` (`tg_id`),
  CONSTRAINT `tUserGroupRelation_ibfk_1` FOREIGN KEY (`tu_id`) REFERENCES `user` (`id`),
  CONSTRAINT `tUserGroupRelation_ibfk_2` FOREIGN KEY (`tg_id`) REFERENCES `tgroup` (`tg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `type` varchar(50) DEFAULT NULL,
  `updatetim` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `regdate` datetime DEFAULT NULL,
  `is_delete` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for userauth
-- ----------------------------
DROP TABLE IF EXISTS `userauth`;
CREATE TABLE `userauth` (
  `id` varchar(50) NOT NULL,
  `authId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
