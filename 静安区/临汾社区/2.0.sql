/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50629
Source Host           : 127.0.0.1:3306
Source Database       : 2.0

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2019-10-12 17:21:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for a
-- ----------------------------
DROP TABLE IF EXISTS `a`;
CREATE TABLE `a` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a
-- ----------------------------
INSERT INTO `a` VALUES ('1', 'as');
INSERT INTO `a` VALUES ('2', 'ssd');

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flyway_schema_history
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(200) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `cron_expression` varchar(200) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(200) DEFAULT NULL,
  `job_group` varchar(200) DEFAULT NULL,
  `is_nonconcurrent` varchar(1) DEFAULT NULL,
  `requests_recovery` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `job_class_name` varchar(250) NOT NULL,
  `is_durable` varchar(1) NOT NULL,
  `is_nonconcurrent` varchar(1) NOT NULL,
  `is_update_data` varchar(1) NOT NULL,
  `requests_recovery` varchar(1) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('hesicareScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', null, 'com.hesicare.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xC2ACED9CB005737200156F72672E71756172747A2E4A6F62446174614D6170C29FC2B0C283E8BFA9C2B0CB820000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D6170C28208E883BBC59D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E6AEAD28760ACE8200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DA81C39660D183000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F5045525449455373720021636F6D2E68657369636172652E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200094C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E00097872002A636F6D2E68657369636172652E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686AC281014B59741903000078707708000001622CDEA9E0B8B07400007070707400013174000E302F3130202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673BC28BE4908CC28F23DF8200014A000576616C7565787200106A6176612E6C616E672E4E756D626572C286C2ACC2951D0BC294CB8200007870000000000000000174000672795461736B74000A72794E6F506172616D7374000074000133740001307800);
INSERT INTO `qrtz_job_details` VALUES ('hesicareScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', null, 'com.hesicare.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xC2ACED9CB005737200156F72672E71756172747A2E4A6F62446174614D6170C29FC2B0C283E8BFA9C2B0CB820000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D6170C28208E883BBC59D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E6AEAD28760ACE8200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DA81C39660D183000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F5045525449455373720021636F6D2E68657369636172652E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200094C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E00097872002A636F6D2E68657369636172652E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686AC281014B59741903000078707708000001622CDEA9E0B8B07400007070707400013174000E302F3230202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673BC28BE4908CC28F23DF8200014A000576616C7565787200106A6176612E6C616E672E4E756D626572C286C2ACC2951D0BC294CB8200007870000000000000000274000672795461736B7400087279506172616D73740002727974000133740001317800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('hesicareScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('hesicareScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('hesicareScheduler', 'DESKTOP-8BDEFD31570863450190', '1570863610867', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `str_prop_1` varchar(512) DEFAULT NULL,
  `str_prop_2` varchar(512) DEFAULT NULL,
  `str_prop_3` varchar(512) DEFAULT NULL,
  `int_prop_1` int(11) DEFAULT NULL,
  `int_prop_2` int(11) DEFAULT NULL,
  `long_prop_1` bigint(20) DEFAULT NULL,
  `long_prop_2` bigint(20) DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) DEFAULT NULL,
  `bool_prop_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `next_fire_time` bigint(13) DEFAULT NULL,
  `prev_fire_time` bigint(13) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) DEFAULT NULL,
  `calendar_name` varchar(200) DEFAULT NULL,
  `misfire_instr` smallint(2) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('hesicareScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', 'TASK_CLASS_NAME1', 'DEFAULT', null, '1565666900000', '1565666890000', '5', 'ACQUIRED', 'CRON', '1565593776000', '0', null, '2', '');
INSERT INTO `qrtz_triggers` VALUES ('hesicareScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', 'TASK_CLASS_NAME2', 'DEFAULT', null, '1565593780000', '-1', '5', 'PAUSED', 'CRON', '1565593778000', '0', null, '2', '');

-- ----------------------------
-- Table structure for sys_advice_template
-- ----------------------------
DROP TABLE IF EXISTS `sys_advice_template`;
CREATE TABLE `sys_advice_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门id',
  `template_type` varchar(20) DEFAULT NULL COMMENT '模版类型 (LongStandards-长期标准时段医嘱 LongNotStandards-长期非标准时段医嘱)',
  `template_name` varchar(200) DEFAULT '0' COMMENT '模板名称',
  `template_content` varchar(2000) DEFAULT NULL,
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='血糖医嘱模板表';

-- ----------------------------
-- Records of sys_advice_template
-- ----------------------------

-- ----------------------------
-- Table structure for sys_blood_glucose
-- ----------------------------
DROP TABLE IF EXISTS `sys_blood_glucose`;
CREATE TABLE `sys_blood_glucose` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `measure_period` varchar(64) DEFAULT NULL COMMENT '测量时段(KF-空腹 ZCH-早餐后 WUCQ-午餐前 WUCH-午餐后 WACQ-晚餐前 WACH-晚餐后 SQ-睡前LC-凌晨 LC3-凌晨3点  SJ-随机)',
  `measure_time` datetime DEFAULT NULL COMMENT '测量时间',
  `meature_value` double DEFAULT NULL COMMENT '测量值',
  `equipment_sn` varchar(50) DEFAULT NULL COMMENT '测量设备编号',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `data_source` varchar(2) DEFAULT NULL COMMENT '数据来源(0移动端录入1管理后台录入 2设备上传)',
  `measure_status` varchar(20) DEFAULT NULL COMMENT '测量状态 1-偏低 2-正常 3-偏高',
  `abnormal_result` varchar(20) DEFAULT NULL COMMENT '异常结果()',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `other_remark` varchar(200) DEFAULT NULL COMMENT '其他原因',
  `color` varchar(20) DEFAULT NULL COMMENT '测量颜色',
  `data_status` varchar(5) DEFAULT '0' COMMENT '数据状态码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='患者血糖记录表';

-- ----------------------------
-- Records of sys_blood_glucose
-- ----------------------------
INSERT INTO `sys_blood_glucose` VALUES ('1', '3', 'WACQ', '2019-09-23 14:41:21', '30.7', '47900202246', '0', '2', '3', '', '', '00001', '2019-09-23 14:41:21', '00001', '2019-09-23 14:41:21', '2', '', 'orange', '1');

-- ----------------------------
-- Table structure for sys_blood_glucose_qa
-- ----------------------------
DROP TABLE IF EXISTS `sys_blood_glucose_qa`;
CREATE TABLE `sys_blood_glucose_qa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门id',
  `equipment_sn` varchar(50) DEFAULT NULL COMMENT '质控设备编号',
  `liquid_type` varchar(10) DEFAULT '1' COMMENT '质控液类型(1-高 2-中 3-低)',
  `liquid_num` varchar(100) DEFAULT '' COMMENT '质控液批次号',
  `manufactor` varchar(100) DEFAULT '' COMMENT '生产厂家',
  `max_value` double DEFAULT NULL COMMENT '最大测量值',
  `min_value` double DEFAULT NULL COMMENT '最小测量值',
  `liquid_date` datetime DEFAULT NULL COMMENT '质控液有效期',
  `qa_time` datetime DEFAULT NULL COMMENT '质控时间',
  `qa_value` double DEFAULT NULL COMMENT '质控值',
  `test_paper_num` varchar(100) DEFAULT '' COMMENT '试纸批次号',
  `test_paper_date` datetime DEFAULT NULL COMMENT '试纸有效期',
  `qa_result` char(1) DEFAULT '0' COMMENT '质控结果（0合格 1不合格 2 未质控）',
  `create_by` varchar(64) DEFAULT '' COMMENT '执行人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='血糖仪质控结果';

-- ----------------------------
-- Records of sys_blood_glucose_qa
-- ----------------------------

-- ----------------------------
-- Table structure for sys_blood_pressure
-- ----------------------------
DROP TABLE IF EXISTS `sys_blood_pressure`;
CREATE TABLE `sys_blood_pressure` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `measure_period` varchar(64) DEFAULT NULL COMMENT '测量时段(SW-上午 ZW-中午 XW-下午)',
  `measure_time` datetime DEFAULT NULL COMMENT '测量时间',
  `systolic` double DEFAULT NULL COMMENT '收缩压',
  `diastolic` double DEFAULT NULL COMMENT '舒张压',
  `pluse` double DEFAULT NULL COMMENT '心率',
  `equipment_sn` varchar(50) DEFAULT NULL COMMENT '测量设备编号',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `data_source` varchar(2) DEFAULT NULL COMMENT '数据来源(0移动端录入1管理后台录入 2设备上传)',
  `measure_status` varchar(20) DEFAULT NULL COMMENT '测量状态（High1-一级高血压 High2-二级高血压 High3-三级高血压）',
  `display_color` varchar(20) DEFAULT '' COMMENT '测量状态颜色',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `color` varchar(20) DEFAULT NULL COMMENT '测量颜色',
  `data_type` varchar(10) DEFAULT NULL COMMENT '数据类型[平均:average, 测量值:real]',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '测量值对应平均值id',
  `hand` varchar(20) DEFAULT NULL COMMENT '左 left右 right',
  `data_status` varchar(5) DEFAULT '0' COMMENT '数据状态码 0未推送，1已推送',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='患者血压记录表';

-- ----------------------------
-- Records of sys_blood_pressure
-- ----------------------------
INSERT INTO `sys_blood_pressure` VALUES ('1', '3', 'SW', '2019-08-23 23:23:33', '98', '129', '76', '1111', '0', '2', 'High3', '', null, 'admin', '2019-09-16 20:47:00', 'admin', '2019-09-16 20:47:00', '345', null, 'average', '3', 'right', '0');
INSERT INTO `sys_blood_pressure` VALUES ('2', '3', 'SW', '2019-08-23 23:14:53', '98', '129', '76', '1111', '0', '2', null, '', null, 'admin', '2019-09-16 20:47:00', 'admin', '2019-09-16 20:47:00', '345', null, 'real', '3', 'right', '0');
INSERT INTO `sys_blood_pressure` VALUES ('3', '3', 'SW', '2019-08-23 23:16:33', '98', '127', '76', '1111', '0', '2', null, '', null, 'admin', '2019-09-16 20:47:00', 'admin', '2019-09-16 20:47:00', '345', null, 'real', '3', 'right', '0');

-- ----------------------------
-- Table structure for sys_blood_pressure_qa
-- ----------------------------
DROP TABLE IF EXISTS `sys_blood_pressure_qa`;
CREATE TABLE `sys_blood_pressure_qa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门id',
  `equipment_sn` varchar(50) DEFAULT NULL COMMENT '质控设备编号',
  `qa_time` datetime DEFAULT NULL COMMENT '质控时间',
  `qa_result` char(1) DEFAULT '0' COMMENT '质控结果（0合格 1不合格 2 未质控）',
  `create_by` varchar(64) DEFAULT '' COMMENT '执行人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='血压计质控结果';

-- ----------------------------
-- Records of sys_blood_pressure_qa
-- ----------------------------

-- ----------------------------
-- Table structure for sys_common_advice
-- ----------------------------
DROP TABLE IF EXISTS `sys_common_advice`;
CREATE TABLE `sys_common_advice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `common_advice_type` varchar(64) DEFAULT NULL COMMENT '医嘱类型(medicate-用药医嘱)',
  `advice_name` varchar(100) DEFAULT NULL COMMENT '医嘱名称',
  `advice_content` varchar(500) DEFAULT NULL COMMENT '医嘱内容(json)',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '医嘱医生',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='普通医嘱信息表';

-- ----------------------------
-- Records of sys_common_advice
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(100) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_consultation
-- ----------------------------
DROP TABLE IF EXISTS `sys_consultation`;
CREATE TABLE `sys_consultation` (
  `consultation_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id,关联患者表',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '归属部门',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别(0男 1女 2未知)',
  `hospitalized_num` varchar(64) DEFAULT NULL COMMENT '住院号',
  `bed_num` varchar(64) DEFAULT NULL COMMENT '床号',
  `consultation_dept_id` bigint(20) DEFAULT NULL COMMENT '会诊部门',
  `consultation_doctor` bigint(20) DEFAULT NULL COMMENT '会诊医生',
  `consultation_time` datetime DEFAULT NULL COMMENT '会诊时间',
  `create_dept_id` bigint(20) DEFAULT NULL COMMENT '申请会诊人部门',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `status` char(1) DEFAULT NULL COMMENT '状态(0-会诊中 1-已完成)',
  PRIMARY KEY (`consultation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='患者会诊信息表';

-- ----------------------------
-- Records of sys_consultation
-- ----------------------------

-- ----------------------------
-- Table structure for sys_consultation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_consultation_log`;
CREATE TABLE `sys_consultation_log` (
  `consultation_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `consultation_id` bigint(20) NOT NULL COMMENT '会诊id,关联会诊信息表',
  `status` char(1) DEFAULT NULL COMMENT '状态(0-会诊中 1-已完成)',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`consultation_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='患者会诊记录表';

-- ----------------------------
-- Records of sys_consultation_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `com_code` varchar(50) DEFAULT NULL COMMENT '部门编码',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `parent_name` varchar(30) DEFAULT '' COMMENT '父部门名称',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(10) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `wristband_type` varchar(10) DEFAULT NULL COMMENT '腕带类型',
  `report_type` varchar(10) DEFAULT NULL COMMENT '报表类型',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=349 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('100', '0', '0', '无', '0', '根节点机构', '0', 'hesiCloud', '15888888888', 'ry@qq.com', '0', '0', null, null, 'admin', '2018-03-16 11:33:00', 'admin', '2019-09-10 10:35:25');
INSERT INTO `sys_dept` VALUES ('345', '1001', '100', '', '0,100', '人民医院', '0', null, null, null, '0', '0', '1', '1', 'admin', '2019-09-12 16:43:07', '', null);
INSERT INTO `sys_dept` VALUES ('346', '1001001', '345', '', '0,100,345', '高血压科', '0', null, null, null, '0', '0', '1', '1', 'admin', '2019-09-12 16:43:33', '', null);
INSERT INTO `sys_dept` VALUES ('347', '1001002', '345', '', '0,100,345', '糖尿病科', '0', null, null, null, '0', '0', '1', '1', 'admin', '2019-09-12 16:43:43', '', null);
INSERT INTO `sys_dept` VALUES ('348', '1001003', '345', '', '0,100,345', '信息科', '0', null, null, null, '0', '0', '1', '1', 'admin', '2019-09-12 16:46:20', '', null);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES ('1', '1', '男', '0', null, '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '性别男');
INSERT INTO `sys_dict_data` VALUES ('2', '2', '女', '1', null, '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '性别女');
INSERT INTO `sys_dict_data` VALUES ('3', '3', '未知', '2', null, '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '性别未知');
INSERT INTO `sys_dict_data` VALUES ('4', '1', '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '显示菜单');
INSERT INTO `sys_dict_data` VALUES ('5', '2', '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES ('6', '1', '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('7', '2', '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('8', '1', '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('9', '2', '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('10', '1', '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '系统默认是');
INSERT INTO `sys_dict_data` VALUES ('11', '2', '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '系统默认否');
INSERT INTO `sys_dict_data` VALUES ('12', '1', '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '通知');
INSERT INTO `sys_dict_data` VALUES ('13', '2', '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '公告');
INSERT INTO `sys_dict_data` VALUES ('14', '1', '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('15', '2', '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '关闭状态');
INSERT INTO `sys_dict_data` VALUES ('16', '1', '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('17', '2', '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '修改操作');
INSERT INTO `sys_dict_data` VALUES ('18', '3', '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '删除操作');
INSERT INTO `sys_dict_data` VALUES ('19', '4', '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '授权操作');
INSERT INTO `sys_dict_data` VALUES ('20', '5', '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '导出操作');
INSERT INTO `sys_dict_data` VALUES ('21', '6', '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '导入操作');
INSERT INTO `sys_dict_data` VALUES ('22', '7', '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '强退操作');
INSERT INTO `sys_dict_data` VALUES ('23', '8', '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '生成操作');
INSERT INTO `sys_dict_data` VALUES ('24', '9', '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '清空操作');
INSERT INTO `sys_dict_data` VALUES ('25', '1', '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('26', '2', '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-08-26 09:48:57', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('68', '1', '质控液低值', 'low', 'cj_okme', null, null, 'Y', '0', 'admin', '2019-08-03 12:09:45', 'admin', '2019-08-26 09:48:57', null);
INSERT INTO `sys_dict_data` VALUES ('69', '2', '质控液高值', 'high', 'cj_okme', null, null, 'Y', '0', 'admin', '2019-08-03 12:10:07', 'admin', '2019-08-26 09:48:57', null);
INSERT INTO `sys_dict_data` VALUES ('74', '1', '低', 'low', 'cj_baier', null, null, 'Y', '0', 'admin', '2019-08-27 16:47:44', 'admin', '2019-08-27 16:48:46', '拜耳质控液');
INSERT INTO `sys_dict_data` VALUES ('75', '2', '中', 'middle', 'cj_baier', null, null, 'Y', '0', 'admin', '2019-08-27 16:48:15', 'admin', '2019-08-27 16:48:44', '拜耳质控液');
INSERT INTO `sys_dict_data` VALUES ('76', '3', '高', 'high', 'cj_baier', null, null, 'Y', '0', 'admin', '2019-08-27 16:48:41', 'admin', '2019-08-27 16:48:41', '拜耳质控液');
INSERT INTO `sys_dict_data` VALUES ('77', '1', '控制液0（倍安）', 'low', 'cj_aikang', null, null, 'Y', '0', 'admin', '2019-08-27 16:50:21', 'admin', '2019-08-27 16:51:18', 'aikang质控液');
INSERT INTO `sys_dict_data` VALUES ('78', '2', '控制液1', 'middle', 'cj_aikang', null, null, 'Y', '0', 'admin', '2019-08-27 16:50:40', 'admin', '2019-08-27 16:51:14', 'aikang质控液');
INSERT INTO `sys_dict_data` VALUES ('79', '3', '控制液2', 'high', 'cj_aikang', null, null, 'Y', '0', 'admin', '2019-08-27 16:51:11', 'admin', '2019-08-27 16:51:11', 'aikang质控液');
INSERT INTO `sys_dict_data` VALUES ('80', '1', '控制液1', 'low', 'cj_lekang', null, null, 'Y', '0', 'admin', '2019-08-27 16:52:20', 'admin', '2019-08-27 16:53:08', 'lekang质控液');
INSERT INTO `sys_dict_data` VALUES ('81', '2', '控制液2', 'high', 'cj_lekang', null, null, 'Y', '0', 'admin', '2019-08-27 16:53:05', 'admin', '2019-08-27 16:53:05', 'lekang质控液');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1', '用户性别', 'sys_user_sex', '1', 'admin', '2019-08-26 09:48:57', 'admin', '2019-08-26 09:48:57', '用户性别列表');
INSERT INTO `sys_dict_type` VALUES ('2', '菜单状态', 'sys_show_hide', '0', 'admin', '2019-08-26 09:48:57', 'admin', '2019-08-26 09:48:57', '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES ('3', '系统开关', 'sys_normal_disable', '0', 'admin', '2019-08-26 09:48:57', 'admin', '2019-08-26 09:48:57', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES ('4', '任务状态', 'sys_job_status', '0', 'admin', '2019-08-26 09:48:57', 'admin', '2019-08-26 09:48:57', '任务状态列表');
INSERT INTO `sys_dict_type` VALUES ('5', '系统是否', 'sys_yes_no', '0', 'admin', '2019-08-26 09:48:57', 'admin', '2019-08-26 09:48:57', '系统是否列表');
INSERT INTO `sys_dict_type` VALUES ('6', '通知类型', 'sys_notice_type', '0', 'admin', '2019-08-26 09:48:57', 'admin', '2019-08-26 09:48:57', '通知类型列表');
INSERT INTO `sys_dict_type` VALUES ('7', '通知状态', 'sys_notice_status', '0', 'admin', '2019-08-26 09:48:57', 'admin', '2019-08-26 09:48:57', '通知状态列表');
INSERT INTO `sys_dict_type` VALUES ('8', '操作类型', 'sys_oper_type', '0', 'admin', '2019-08-26 09:48:57', 'admin', '2019-08-26 09:48:57', '操作类型列表');
INSERT INTO `sys_dict_type` VALUES ('9', '系统状态', 'sys_common_status', '0', 'admin', '2019-08-26 09:48:57', 'admin', '2019-08-26 09:48:57', '登录状态列表');
INSERT INTO `sys_dict_type` VALUES ('35', 'cj_okme', 'cj_okme', '0', 'admin', '2019-08-26 09:48:57', 'admin', '2019-08-26 09:48:57', 'okme厂家');
INSERT INTO `sys_dict_type` VALUES ('38', 'cj_lekang', 'cj_lekang', '0', 'admin', '2019-08-27 16:46:09', 'admin', '2019-08-27 16:46:09', '艾康厂家');
INSERT INTO `sys_dict_type` VALUES ('39', 'cj_aikang', 'cj_aikang', '0', 'admin', '2019-08-27 16:46:29', 'admin', '2019-08-27 16:46:29', '艾康厂家');
INSERT INTO `sys_dict_type` VALUES ('40', 'cj_baier', 'cj_baier', '0', 'admin', '2019-08-27 16:46:59', 'admin', '2019-08-27 16:46:59', '拜耳厂家');

-- ----------------------------
-- Table structure for sys_equipment
-- ----------------------------
DROP TABLE IF EXISTS `sys_equipment`;
CREATE TABLE `sys_equipment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门id',
  `equipment_type` varchar(10) DEFAULT '0' COMMENT '设备类型(pressure-血压仪 glucose-血糖仪)',
  `equipment_sn` varchar(100) DEFAULT '' COMMENT '设备编号',
  `manufactor` varchar(100) DEFAULT '' COMMENT '生产厂家',
  `product_model` varchar(100) DEFAULT '' COMMENT '产品型号',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备信息表';

-- ----------------------------
-- Records of sys_equipment
-- ----------------------------

-- ----------------------------
-- Table structure for sys_glucose_advice
-- ----------------------------
DROP TABLE IF EXISTS `sys_glucose_advice`;
CREATE TABLE `sys_glucose_advice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `advice_type` varchar(64) DEFAULT NULL COMMENT '医嘱类型(LongStandards-长期标准时段医嘱 LongNotStandards-长期非标准时段医嘱 Temporary-临时医嘱)',
  `template_name` varchar(200) DEFAULT '0' COMMENT '模板名称',
  `advice_name` varchar(100) DEFAULT NULL COMMENT '医嘱名称',
  `advice_content` varchar(2000) DEFAULT NULL COMMENT '医嘱内容(json)',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '医嘱医生',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '患者部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='血糖测量医嘱表';

-- ----------------------------
-- Records of sys_glucose_advice
-- ----------------------------

-- ----------------------------
-- Table structure for sys_glucose_advice_task
-- ----------------------------
DROP TABLE IF EXISTS `sys_glucose_advice_task`;
CREATE TABLE `sys_glucose_advice_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `advice_id` bigint(20) NOT NULL COMMENT '所属医嘱',
  `advice_type` varchar(64) DEFAULT NULL COMMENT '医嘱类型(LongStandards-长期标准时段医嘱 LongNotStandards-长期非标准时段医嘱 Temporary-临时医嘱)',
  `advice_name` varchar(100) DEFAULT NULL COMMENT '医嘱名称',
  `advice_content` varchar(2000) DEFAULT NULL COMMENT '医嘱内容(json存储拆分后的结果)',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '医嘱医生',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `isDone` char(1) DEFAULT '0' COMMENT '是否已测(0 未测 1已测)',
  `blood_glucose_id` bigint(20) DEFAULT NULL COMMENT '血糖记录主键ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '患者部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='血糖医嘱任务拆分表';

-- ----------------------------
-- Records of sys_glucose_advice_task
-- ----------------------------

-- ----------------------------
-- Table structure for sys_glucose_crisis
-- ----------------------------
DROP TABLE IF EXISTS `sys_glucose_crisis`;
CREATE TABLE `sys_glucose_crisis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门id',
  `high_value` double DEFAULT NULL COMMENT '危机高值',
  `high_color` varchar(20) DEFAULT '' COMMENT '危机高值颜色',
  `low_value` double DEFAULT NULL COMMENT '危机低值',
  `low_color` varchar(20) DEFAULT '' COMMENT '危机低值颜色',
  `normal_color` varchar(20) DEFAULT '' COMMENT '正常值颜色',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='血糖危急值表';

-- ----------------------------
-- Records of sys_glucose_crisis
-- ----------------------------
INSERT INTO `sys_glucose_crisis` VALUES ('1', '345', '27.8', 'orange', '2.8', 'red', '', '0', 'admin', '2019-09-12 16:43:07', '', null);
INSERT INTO `sys_glucose_crisis` VALUES ('2', '346', '27.8', 'orange', '2.8', 'red', '', '0', 'admin', '2019-09-12 16:43:34', '', null);
INSERT INTO `sys_glucose_crisis` VALUES ('3', '347', '27.8', 'orange', '2.8', 'red', '', '0', 'admin', '2019-09-12 16:43:44', '', null);
INSERT INTO `sys_glucose_crisis` VALUES ('4', '348', '27.8', 'orange', '2.8', 'red', '', '0', 'admin', '2019-09-12 16:46:21', '', null);

-- ----------------------------
-- Table structure for sys_glucose_crisis_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_glucose_crisis_record`;
CREATE TABLE `sys_glucose_crisis_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `measure_period` varchar(64) DEFAULT NULL COMMENT '测量时段(KF-空腹 ZCH-早餐后 WUCQ-午餐前 WUCH-午餐后 WACQ-晚餐前 WACH-晚餐后 SQ-睡前LC-凌晨 LC3-凌晨3点  SJ-随机)',
  `measure_time` datetime DEFAULT NULL COMMENT '测量时间',
  `meature_value` double DEFAULT NULL COMMENT '测量值',
  `equipment_sn` varchar(50) DEFAULT NULL COMMENT '测量设备编号',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `data_source` varchar(2) DEFAULT NULL COMMENT '数据来源(0移动端录入1管理后台录入 2设备上传)',
  `measure_status` char(1) DEFAULT '0' COMMENT '测量状态（1偏低 2正常 3 偏高 ）',
  `abnormal_result` varchar(20) DEFAULT NULL COMMENT '异常结果(normal-normal Lo-Lo Hi-Hi 1001-拒测 1002-外出 1003-食晚 1004-其他)',
  `display_color` varchar(20) DEFAULT '' COMMENT '测量状态颜色',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `blood_glucose_id` bigint(20) DEFAULT NULL COMMENT '血糖id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='血糖危机记录表';

-- ----------------------------
-- Records of sys_glucose_crisis_record
-- ----------------------------

-- ----------------------------
-- Table structure for sys_glucose_period
-- ----------------------------
DROP TABLE IF EXISTS `sys_glucose_period`;
CREATE TABLE `sys_glucose_period` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门id',
  `measure_period` varchar(64) DEFAULT NULL COMMENT '测量时段(KF-空腹 ZCH-早餐后 WUCQ-午餐前 WUCH-午餐后 WACQ-晚餐前 WACH-晚餐后 SQ-睡前LC-凌晨 LC3-凌晨3点  SJ-随机)',
  `display_name` varchar(64) DEFAULT '' COMMENT '显示名称',
  `start_time` varchar(32) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(32) DEFAULT NULL COMMENT '结束时间',
  `max_value` double DEFAULT NULL COMMENT '最大测量值',
  `min_value` double DEFAULT NULL COMMENT '最小测量值',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `high_Color` varchar(20) DEFAULT NULL COMMENT '偏高值颜色',
  `low_Color` varchar(20) DEFAULT NULL COMMENT '偏低值颜色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='血糖测量时间段配置表';

-- ----------------------------
-- Records of sys_glucose_period
-- ----------------------------
INSERT INTO `sys_glucose_period` VALUES ('1', '345', 'LC', '凌晨', '00:00', '02:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:07', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('2', '345', 'LC3', '凌晨', '02:00', '04:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:07', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('3', '345', 'KF', '空腹', '04:00', '07:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:07', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('4', '345', 'ZCH', '早餐后', '07:00', '10:00', '10', '4.4', '0', 'admin', '2019-09-12 16:43:07', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('5', '345', 'WUCQ', '午餐前', '10:00', '12:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:07', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('6', '345', 'WUCH', '午餐后', '12:00', '14:00', '10', '4.4', '0', 'admin', '2019-09-12 16:43:07', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('7', '345', 'WACQ', '晚餐前', '14:00', '17:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:07', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('8', '345', 'WACH', '晚餐后', '17:00', '20:00', '10', '4.4', '0', 'admin', '2019-09-12 16:43:07', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('9', '345', 'SQ', '睡前', '20:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:43:07', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('10', '345', 'SJ', '随机', '00:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:43:07', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('11', '345', 'WU', '无', '00:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:43:07', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('12', '346', 'LC', '凌晨', '00:00', '02:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:34', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('13', '346', 'LC3', '凌晨', '02:00', '04:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:34', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('14', '346', 'KF', '空腹', '04:00', '07:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:34', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('15', '346', 'ZCH', '早餐后', '07:00', '10:00', '10', '4.4', '0', 'admin', '2019-09-12 16:43:34', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('16', '346', 'WUCQ', '午餐前', '10:00', '12:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:34', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('17', '346', 'WUCH', '午餐后', '12:00', '14:00', '10', '4.4', '0', 'admin', '2019-09-12 16:43:34', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('18', '346', 'WACQ', '晚餐前', '14:00', '17:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:34', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('19', '346', 'WACH', '晚餐后', '17:00', '20:00', '10', '4.4', '0', 'admin', '2019-09-12 16:43:34', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('20', '346', 'SQ', '睡前', '20:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:43:34', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('21', '346', 'SJ', '随机', '00:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:43:34', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('22', '346', 'WU', '无', '00:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:43:34', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('23', '347', 'LC', '凌晨', '00:00', '02:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:43', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('24', '347', 'LC3', '凌晨', '02:00', '04:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:43', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('25', '347', 'KF', '空腹', '04:00', '07:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:43', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('26', '347', 'ZCH', '早餐后', '07:00', '10:00', '10', '4.4', '0', 'admin', '2019-09-12 16:43:43', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('27', '347', 'WUCQ', '午餐前', '10:00', '12:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:43', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('28', '347', 'WUCH', '午餐后', '12:00', '14:00', '10', '4.4', '0', 'admin', '2019-09-12 16:43:43', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('29', '347', 'WACQ', '晚餐前', '14:00', '17:00', '7', '4.4', '0', 'admin', '2019-09-12 16:43:43', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('30', '347', 'WACH', '晚餐后', '17:00', '20:00', '10', '4.4', '0', 'admin', '2019-09-12 16:43:43', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('31', '347', 'SQ', '睡前', '20:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:43:43', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('32', '347', 'SJ', '随机', '00:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:43:43', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('33', '347', 'WU', '无', '00:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:43:43', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('34', '348', 'LC', '凌晨', '00:00', '02:00', '7', '4.4', '0', 'admin', '2019-09-12 16:46:21', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('35', '348', 'LC3', '凌晨', '02:00', '04:00', '7', '4.4', '0', 'admin', '2019-09-12 16:46:21', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('36', '348', 'KF', '空腹', '04:00', '07:00', '7', '4.4', '0', 'admin', '2019-09-12 16:46:21', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('37', '348', 'ZCH', '早餐后', '07:00', '10:00', '10', '4.4', '0', 'admin', '2019-09-12 16:46:21', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('38', '348', 'WUCQ', '午餐前', '10:00', '12:00', '7', '4.4', '0', 'admin', '2019-09-12 16:46:21', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('39', '348', 'WUCH', '午餐后', '12:00', '14:00', '10', '4.4', '0', 'admin', '2019-09-12 16:46:21', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('40', '348', 'WACQ', '晚餐前', '14:00', '17:00', '7', '4.4', '0', 'admin', '2019-09-12 16:46:21', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('41', '348', 'WACH', '晚餐后', '17:00', '20:00', '10', '4.4', '0', 'admin', '2019-09-12 16:46:21', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('42', '348', 'SQ', '睡前', '20:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:46:21', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('43', '348', 'SJ', '随机', '00:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:46:21', null, null, 'orange', 'red');
INSERT INTO `sys_glucose_period` VALUES ('44', '348', 'WU', '无', '00:00', '23:59', '7', '4.4', '0', 'admin', '2019-09-12 16:46:21', null, null, 'orange', 'red');

-- ----------------------------
-- Table structure for sys_health_archives
-- ----------------------------
DROP TABLE IF EXISTS `sys_health_archives`;
CREATE TABLE `sys_health_archives` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `archives_name` varchar(64) DEFAULT NULL COMMENT '档案名称',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `dept_id` varchar(20) DEFAULT NULL COMMENT '归属部门',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像地址',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别(0男 1女 2未知)',
  `hospitalized_num` varchar(64) DEFAULT NULL COMMENT '住院号',
  `hospitalized_date` date DEFAULT NULL COMMENT '入院日期',
  `wristband_code` varchar(64) DEFAULT NULL COMMENT '腕带码',
  `bed_num` varchar(64) DEFAULT NULL COMMENT '床号',
  `doctor_id` bigint(20) DEFAULT NULL COMMENT '住院医生编号',
  `address` varchar(200) DEFAULT NULL COMMENT '住址',
  `card_type` varchar(10) DEFAULT NULL COMMENT '卡类型(1-身份证 2-医保卡 3-就诊卡)',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `card_num` varchar(20) DEFAULT NULL COMMENT '医保卡/就诊卡号',
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_health_archives
-- ----------------------------

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT '' COMMENT '任务组名',
  `method_name` varchar(500) DEFAULT '' COMMENT '任务方法',
  `method_params` varchar(50) DEFAULT NULL COMMENT '方法参数',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log` (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `method_name` varchar(500) DEFAULT NULL COMMENT '任务方法',
  `method_params` varchar(50) DEFAULT NULL COMMENT '方法参数',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1190 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1157', '用户管理', '0', '1', '#', '', 'M', '0', null, 'anticon-user', '合思超级管理员', '2019-07-07 13:49:04', 'admin', '2019-09-07 12:41:31', '');
INSERT INTO `sys_menu` VALUES ('1161', '所有用户', '1157', '0', '/user/list', '', 'C', '0', null, '#', '合思超级管理员', '2019-07-07 13:50:11', 'admin', '2019-08-30 13:57:44', '');
INSERT INTO `sys_menu` VALUES ('1173', '机构管理', '0', '5', '#', '', 'M', '0', null, 'anticon-profile', '合思超级管理员', '2019-07-07 14:05:34', 'admin', '2019-09-10 21:20:19', '');
INSERT INTO `sys_menu` VALUES ('1174', '机构及部门', '1173', '0', '/hospital/hospital-set', '', 'C', '0', null, '#', '合思超级管理员', '2019-07-07 14:06:06', 'admin', '2019-09-10 21:20:31', '');
INSERT INTO `sys_menu` VALUES ('1175', '员工管理', '1173', '1', '/hospital/staff-set', '', 'C', '0', null, '#', '合思超级管理员', '2019-07-07 14:06:47', 'admin', '2019-08-30 14:00:11', '');
INSERT INTO `sys_menu` VALUES ('1176', '系统配置', '0', '6', '#', '', 'M', '0', null, 'anticon-setting', '合思超级管理员', '2019-07-07 14:07:18', 'admin', '2019-09-07 12:41:54', '');
INSERT INTO `sys_menu` VALUES ('1177', '参数配置', '1176', '0', '/hospital/blood-set', '', 'C', '0', null, '#', '合思超级管理员', '2019-07-07 14:07:50', '合思超级管理员', '2019-07-07 15:13:19', '');
INSERT INTO `sys_menu` VALUES ('1179', '菜单管理', '1176', '10', '/menu/menu-set', '', 'C', '0', null, '#', '合思超级管理员', '2019-07-07 14:09:03', 'admin', '2019-07-23 20:10:07', '');
INSERT INTO `sys_menu` VALUES ('1180', '角色管理', '1176', '6', '/role/role-set', '', 'C', '0', null, '#', '合思超级管理员', '2019-07-07 14:10:37', 'admin', '2019-08-15 11:15:29', '');
INSERT INTO `sys_menu` VALUES ('1183', '字典类型', '1176', '3', '/dic/dic-type', '', 'C', '0', null, '#', '合思超级管理员', '2019-07-08 16:17:16', 'admin', '2019-08-15 11:14:55', '');
INSERT INTO `sys_menu` VALUES ('1184', '字典', '1176', '4', '/dic/dic-item', '', 'C', '0', null, '#', '合思超级管理员', '2019-07-08 16:17:42', 'admin', '2019-08-15 11:15:02', '');
INSERT INTO `sys_menu` VALUES ('1186', '操作日志', '1176', '7', '/operlog/list', '', 'C', '0', null, '#', 'admin', '2019-07-22 15:58:48', 'admin', '2019-08-15 11:15:39', '');
INSERT INTO `sys_menu` VALUES ('1188', '高血压CDSS', '1157', '1', '/blood-pressure-cdss/list', '', 'C', '0', null, '#', 'admin', '2019-09-03 17:07:58', '', null, '');
INSERT INTO `sys_menu` VALUES ('1189', '糖尿病CDSS', '1157', '2', '/blood-cdss/list', '', 'C', '0', null, '#', 'admin', '2019-09-03 17:08:54', '', null, '');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_out_blood_glucose
-- ----------------------------
DROP TABLE IF EXISTS `sys_out_blood_glucose`;
CREATE TABLE `sys_out_blood_glucose` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `measure_period` varchar(64) DEFAULT NULL COMMENT '测量时段(KF-空腹 ZCH-早餐后 WUCQ-午餐前 WUCH-午餐后 WACQ-晚餐前 WACH-晚餐后 SQ-睡前LC-凌晨 LC3-凌晨3点  SJ-随机)',
  `measure_time` datetime DEFAULT NULL COMMENT '测量时间',
  `meature_value` double DEFAULT NULL COMMENT '测量值',
  `equipment_sn` varchar(50) DEFAULT NULL COMMENT '测量设备编号',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `data_source` varchar(2) DEFAULT NULL COMMENT '数据来源(0移动端录入1管理后台录入 2设备上传 3数据来源 )',
  `measure_status` char(1) DEFAULT '0' COMMENT '测量状态（1偏低 2正常 3 偏高 ）',
  `display_color` varchar(20) DEFAULT '' COMMENT '测量状态颜色',
  `abnormal_result` varchar(20) DEFAULT NULL COMMENT '异常结果(normal-normal Lo-Lo Hi-Hi 1001-拒测 1002-外出 1003-食晚 1004-其他)',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门诊患者血糖记录表';

-- ----------------------------
-- Records of sys_out_blood_glucose
-- ----------------------------

-- ----------------------------
-- Table structure for sys_out_patient
-- ----------------------------
DROP TABLE IF EXISTS `sys_out_patient`;
CREATE TABLE `sys_out_patient` (
  `patient_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '归属部门',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像地址',
  `login_name` varchar(30) DEFAULT NULL COMMENT '登录账号',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别(0男 1女 2未知)',
  `hospitalized_num` varchar(64) DEFAULT NULL COMMENT '住院号',
  `hospitalized_date` date DEFAULT NULL COMMENT '入院日期',
  `leave_date` date DEFAULT NULL COMMENT '入院日期',
  `hospitalized_type` date DEFAULT NULL COMMENT '住院状态(1 住院 2 出院)',
  `wristband_code` varchar(64) DEFAULT NULL COMMENT '腕带码',
  `bed_num` varchar(64) DEFAULT NULL COMMENT '床号',
  `doctor_id` bigint(20) DEFAULT NULL COMMENT '住院医生编号',
  `address` varchar(200) DEFAULT NULL COMMENT '住址',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `card_type` varchar(10) DEFAULT NULL COMMENT '卡类型(1-医保卡 2-就诊卡)',
  `card_num` varchar(20) DEFAULT NULL COMMENT '医保卡/就诊卡号',
  `status` char(1) DEFAULT NULL COMMENT '状态(0-正常 1-禁用)',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门诊患者信息表';

-- ----------------------------
-- Records of sys_out_patient
-- ----------------------------

-- ----------------------------
-- Table structure for sys_patient
-- ----------------------------
DROP TABLE IF EXISTS `sys_patient`;
CREATE TABLE `sys_patient` (
  `patient_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '归属部门',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像地址',
  `login_name` varchar(30) DEFAULT NULL COMMENT '登录账号',
  `patient_name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别(0男 1女 2未知)',
  `hospitalized_num` varchar(64) DEFAULT NULL COMMENT '住院号',
  `hospitalized_date` datetime DEFAULT NULL COMMENT '入院日期',
  `leave_date` datetime DEFAULT NULL COMMENT '出院日期',
  `hospitalized_type` char(1) DEFAULT '1' COMMENT '住院状态(1 住院 2 出院)',
  `wristband_code` varchar(64) DEFAULT NULL COMMENT '腕带码',
  `bed_num` varchar(64) DEFAULT NULL COMMENT '床号',
  `doctor_id` bigint(20) DEFAULT NULL COMMENT '住院医生编号',
  `address` varchar(200) DEFAULT NULL COMMENT '住址',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `magnetic_card` varchar(20) DEFAULT NULL COMMENT 'magneticCard',
  `chip_card` varchar(20) DEFAULT NULL COMMENT '芯片医保卡号',
  `status` char(1) DEFAULT NULL COMMENT '状态(0-正常 1-禁用)',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `user_type` varchar(20) DEFAULT NULL COMMENT '用户类型 bloodPressure高血压 bloodGlucos糖尿病 heart心血管疾病 other其他',
  `high` varchar(20) DEFAULT NULL COMMENT '身高(m)',
  `weight` varchar(20) DEFAULT NULL COMMENT '体重(kg)',
  `waist` varchar(20) DEFAULT NULL COMMENT '腰围(cm)',
  `hip` varchar(20) DEFAULT NULL COMMENT '臀围(cm)',
  `contacts_name` varchar(20) DEFAULT NULL COMMENT '紧急联系人',
  `contacts_phone` varchar(20) DEFAULT NULL COMMENT '联系人手机',
  `user_level` varchar(20) DEFAULT NULL COMMENT '用户等级 normal 普通 vip vvip',
  `pressure_level` varchar(20) DEFAULT NULL COMMENT '血压级别 Normal-正常血压 NormalHigh-正常高值  High1-1级高血压 High2-2级高血压 High3-3级高血压',
  `pressure_danger_level` varchar(20) DEFAULT NULL COMMENT '血压危险等级 Init-待评估 Low-低危 Middle-中危 High-高危 Higher-很高危',
  `glucose_danger_level` varchar(20) DEFAULT NULL COMMENT '血糖危险等级 Low-低危 Middle-中危 High-高危',
  `code_id` varchar(50) DEFAULT NULL COMMENT '扫描枪扫出来条形码或二维码的ID',
  `employee_card` varchar(50) DEFAULT NULL COMMENT '员工卡号',
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='患者信息表';

-- ----------------------------
-- Records of sys_patient
-- ----------------------------
INSERT INTO `sys_patient` VALUES ('1', '2', '1', '1', '1', '15617163667', '1', '2019-10-23', '1', '1', '2019-10-16 17:17:30', '2019-10-23 17:17:36', '1', '1', '1', '1', '1', '1', '1', '1', null, '', null, '', null, '', null, '', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_patient` VALUES ('2', '346', null, null, '用户2', null, null, '1998-07-20', '0', null, null, null, '1', null, null, null, null, '412702199807205016', null, null, '0', '', null, 'admin', '2019-10-09 14:23:20', 'admin', '2019-10-09 14:23:20', '', 'other', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_patient` VALUES ('3', '346', null, null, '唐恩泽', null, null, '2010-08-02', '0', null, null, null, '1', null, null, null, null, '320925201008025117', null, null, '0', '', null, '合思身高体重仪', '2019-10-09 14:31:58', '合思身高体重仪', '2019-10-09 19:23:27', '', 'other', '182', '77.3', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_patient_bmi
-- ----------------------------
DROP TABLE IF EXISTS `sys_patient_bmi`;
CREATE TABLE `sys_patient_bmi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `high` varchar(20) DEFAULT NULL COMMENT '身高(m)',
  `weight` varchar(20) DEFAULT NULL COMMENT '体重(kg)',
  `bmi` varchar(20) DEFAULT NULL COMMENT 'bmi',
  `bmi_result` varchar(20) DEFAULT NULL COMMENT '身体状况 偏瘦 正常 过重 肥胖',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间/测量时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `status` varchar(5) DEFAULT '0' COMMENT '状态码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='体重BMI数据表';

-- ----------------------------
-- Records of sys_patient_bmi
-- ----------------------------
INSERT INTO `sys_patient_bmi` VALUES ('1', '1', '156', '111', '21', '1', '1111', '2019-10-15 15:41:17', '', '2019-10-15 15:41:21', '', '0');
INSERT INTO `sys_patient_bmi` VALUES ('2', '3', '181', '74.7', '22.8', '正常', '合思身高体重仪', '2019-10-09 14:53:33', '', null, '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('3', '3', '182', '77.6', '23.4', '正常', '合思身高体重仪', '2019-10-09 16:21:20', '', null, '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('4', '3', '182', '77.1', '23.3', '正常', '合思身高体重仪', '2019-10-09 16:35:01', '', '2019-10-09 16:35:00', '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('5', '3', '162', '65.7', '25', '过重', '合思身高体重仪', '2019-10-09 16:54:36', '', '2019-10-09 16:54:35', '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('6', '3', '163', '52.1', '19.6', '正常', '合思身高体重仪', '2019-10-09 16:54:57', '', '2019-10-09 16:54:56', '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('7', '3', '162', '63.5', '24.2', '过重', '合思身高体重仪', '2019-10-09 16:55:07', '', '2019-10-09 16:55:07', '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('8', '3', '161', '64.2', '24.8', '过重', '合思身高体重仪', '2019-10-09 16:55:15', '', '2019-10-09 16:55:15', '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('9', '3', '162', '65.3', '24.9', '过重', '合思身高体重仪', '2019-10-09 16:55:24', '', '2019-10-09 16:55:24', '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('10', '3', '162', '65.2', '24.8', '过重', '合思身高体重仪', '2019-10-09 16:55:31', '', '2019-10-09 16:55:30', '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('11', '3', '162', '65.2', '24.8', '过重', '合思身高体重仪', '2019-10-09 16:55:35', '', '2019-10-09 16:55:34', '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('12', '3', '162', '65.2', '24.8', '过重', '合思身高体重仪', '2019-10-09 16:55:44', '', '2019-10-09 16:55:44', '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('13', '3', '162', '65.3', '24.9', '过重', '合思身高体重仪', '2019-10-09 16:55:49', '', '2019-10-09 16:55:48', '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('14', '3', '162', '65.4', '24.9', '过重', '合思身高体重仪', '2019-10-09 16:56:01', '', '2019-10-09 16:56:01', '', '1');
INSERT INTO `sys_patient_bmi` VALUES ('15', '3', '182', '77.3', '23.3', '正常', '合思身高体重仪', '2019-10-09 19:23:27', '', '2019-10-09 19:23:27', '', '1');

-- ----------------------------
-- Table structure for sys_patient_other_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_patient_other_info`;
CREATE TABLE `sys_patient_other_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `Past_History` varchar(2000) DEFAULT NULL COMMENT '既往史',
  `family_history` varchar(2000) DEFAULT NULL COMMENT '家族史',
  `drug_taboos` varchar(2000) DEFAULT NULL COMMENT '药物禁忌',
  `smoking` varchar(2000) DEFAULT NULL COMMENT ' 吸烟 0无 1偶尔(每周1根以上) 2 经常(每周10根以上) 3 过量(每周20根以上)',
  `drink` varchar(2000) DEFAULT NULL COMMENT '饮酒 0 无 1偶尔(每周1次以上) 2经常(每周4次以上) 3过量(每周20瓶以上)',
  `sport` varchar(2000) DEFAULT NULL COMMENT '运动0无1 偶尔(每周1次以上)2经常(每周2次以上)3过量(每周4次以上)',
  `sport_remark` varchar(2000) DEFAULT '' COMMENT '主要运动方式',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='患者疾病信息及生活方式表';

-- ----------------------------
-- Records of sys_patient_other_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_patient_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_patient_record`;
CREATE TABLE `sys_patient_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `dept_id` varchar(20) DEFAULT NULL COMMENT '归属部门',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像地址',
  `login_name` varchar(30) DEFAULT NULL COMMENT '登录账号',
  `patient_name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别(0男 1女 2未知)',
  `hospitalized_num` varchar(64) DEFAULT NULL COMMENT '住院号',
  `hospitalized_date` date DEFAULT NULL COMMENT '入院日期',
  `leave_date` date DEFAULT NULL COMMENT '出院日期',
  `hospitalized_type` char(1) DEFAULT '1' COMMENT '住院状态(1 住院 2 出院)',
  `wristband_code` varchar(64) DEFAULT NULL COMMENT '腕带码',
  `bed_num` varchar(64) DEFAULT NULL COMMENT '床号',
  `doctor_id` bigint(20) DEFAULT NULL COMMENT '住院医生编号',
  `address` varchar(200) DEFAULT NULL COMMENT '住址',
  `card_type` varchar(10) DEFAULT NULL COMMENT '卡类型(1-身份证 2-医保卡 3-就诊卡)',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `card_num` varchar(20) DEFAULT NULL COMMENT '医保卡/就诊卡号',
  `status` char(1) DEFAULT NULL COMMENT '状态(0-正常 1-禁用)',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='患者信息记录表';

-- ----------------------------
-- Records of sys_patient_record
-- ----------------------------

-- ----------------------------
-- Table structure for sys_pressure_advice
-- ----------------------------
DROP TABLE IF EXISTS `sys_pressure_advice`;
CREATE TABLE `sys_pressure_advice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `advice_name` varchar(100) DEFAULT NULL COMMENT '医嘱名称',
  `advice_content` varchar(500) DEFAULT NULL COMMENT '医嘱内容(json)',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '医嘱医生',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='血压测量医嘱表';

-- ----------------------------
-- Records of sys_pressure_advice
-- ----------------------------

-- ----------------------------
-- Table structure for sys_pressure_crisis_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_pressure_crisis_record`;
CREATE TABLE `sys_pressure_crisis_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `measure_period` varchar(64) DEFAULT NULL COMMENT '测量时段(SW-上午 ZW-中午 XW-下午)',
  `measure_time` datetime DEFAULT NULL COMMENT '测量时间',
  `systolic` double DEFAULT NULL COMMENT '收缩压',
  `diastolic` double DEFAULT NULL COMMENT '舒张压',
  `pluse` double DEFAULT NULL COMMENT '心率',
  `equipment_sn` varchar(50) DEFAULT NULL COMMENT '测量设备编号',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `data_source` varchar(2) DEFAULT NULL COMMENT '数据来源(0移动端录入1管理后台录入 2设备上传)',
  `measure_status` varchar(20) DEFAULT NULL COMMENT '测量状态（High1-一级高血压 High2-二级高血压 High3-三级高血压）',
  `display_color` varchar(20) DEFAULT '' COMMENT '测量状态颜色',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `pressure_id` bigint(20) DEFAULT NULL COMMENT '血压id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='患者血压危机数据';

-- ----------------------------
-- Records of sys_pressure_crisis_record
-- ----------------------------

-- ----------------------------
-- Table structure for sys_pressure_period
-- ----------------------------
DROP TABLE IF EXISTS `sys_pressure_period`;
CREATE TABLE `sys_pressure_period` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门id',
  `measure_period` varchar(64) DEFAULT NULL COMMENT '测量时段(SW-上午 ZW-中午 XW-下午)',
  `display_name` varchar(64) DEFAULT '' COMMENT '显示名称',
  `start_time` varchar(32) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(32) DEFAULT NULL COMMENT '结束时间',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='血压测量时间段配置表';

-- ----------------------------
-- Records of sys_pressure_period
-- ----------------------------
INSERT INTO `sys_pressure_period` VALUES ('1', '345', 'SW', '上午', '00:00', '10:00', '0', 'admin', '2019-09-12 16:43:07', null, null);
INSERT INTO `sys_pressure_period` VALUES ('2', '345', 'ZW', '中午', '10:00', '15:00', '0', 'admin', '2019-09-12 16:43:07', null, null);
INSERT INTO `sys_pressure_period` VALUES ('3', '345', 'XW', '下午', '15:00', '23:59', '0', 'admin', '2019-09-12 16:43:07', null, null);
INSERT INTO `sys_pressure_period` VALUES ('4', '346', 'SW', '上午', '00:00', '10:00', '0', 'admin', '2019-09-12 16:43:34', null, null);
INSERT INTO `sys_pressure_period` VALUES ('5', '346', 'ZW', '中午', '10:00', '15:00', '0', 'admin', '2019-09-12 16:43:34', null, null);
INSERT INTO `sys_pressure_period` VALUES ('6', '346', 'XW', '下午', '15:00', '23:59', '0', 'admin', '2019-09-12 16:43:34', null, null);
INSERT INTO `sys_pressure_period` VALUES ('7', '347', 'SW', '上午', '00:00', '10:00', '0', 'admin', '2019-09-12 16:43:43', null, null);
INSERT INTO `sys_pressure_period` VALUES ('8', '347', 'ZW', '中午', '10:00', '15:00', '0', 'admin', '2019-09-12 16:43:43', null, null);
INSERT INTO `sys_pressure_period` VALUES ('9', '347', 'XW', '下午', '15:00', '23:59', '0', 'admin', '2019-09-12 16:43:43', null, null);
INSERT INTO `sys_pressure_period` VALUES ('10', '348', 'SW', '上午', '00:00', '10:00', '0', 'admin', '2019-09-12 16:46:21', null, null);
INSERT INTO `sys_pressure_period` VALUES ('11', '348', 'ZW', '中午', '10:00', '15:00', '0', 'admin', '2019-09-12 16:46:21', null, null);
INSERT INTO `sys_pressure_period` VALUES ('12', '348', 'XW', '下午', '15:00', '23:59', '0', 'admin', '2019-09-12 16:46:21', null, null);

-- ----------------------------
-- Table structure for sys_pressure_report
-- ----------------------------
DROP TABLE IF EXISTS `sys_pressure_report`;
CREATE TABLE `sys_pressure_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_id` bigint(20) NOT NULL COMMENT '患者id',
  `report_name` varchar(100) DEFAULT NULL COMMENT '报告名称',
  `report_content` varchar(500) DEFAULT NULL COMMENT '血压评估报告内容',
  `report_time` datetime DEFAULT NULL COMMENT '评估时间',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '医生',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='血压评估报告表';

-- ----------------------------
-- Records of sys_pressure_report
-- ----------------------------

-- ----------------------------
-- Table structure for sys_pressure_standard
-- ----------------------------
DROP TABLE IF EXISTS `sys_pressure_standard`;
CREATE TABLE `sys_pressure_standard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门id',
  `standard_content` varchar(200) DEFAULT '' COMMENT '血压判断标准json',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='血压测量标准判定表';

-- ----------------------------
-- Records of sys_pressure_standard
-- ----------------------------

-- ----------------------------
-- Table structure for sys_qa_liquid
-- ----------------------------
DROP TABLE IF EXISTS `sys_qa_liquid`;
CREATE TABLE `sys_qa_liquid` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门id',
  `liquid_type` varchar(10) DEFAULT '0' COMMENT '质控液类型(1-高 2-中 3-低)',
  `liquid_num` varchar(100) DEFAULT '' COMMENT '质控液批次号',
  `manufactor` varchar(100) DEFAULT '' COMMENT '生产厂家',
  `max_value` double DEFAULT NULL COMMENT '最大测量值',
  `min_value` double DEFAULT NULL COMMENT '最小测量值',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `expiredTime` datetime DEFAULT NULL COMMENT '失效时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='质控液信息表';

-- ----------------------------
-- Records of sys_qa_liquid
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) DEFAULT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '院外超级管理员', 'admin', '1', '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_role` VALUES ('156', '管理员', null, '1', '5', '0', '0', 'admin', '2019-09-12 16:44:26', 'admin', '2019-09-12 16:45:19', null);
INSERT INTO `sys_role` VALUES ('157', '医生', null, '0', '4', '0', '0', 'admin', '2019-09-12 16:44:48', 'admin', '2019-09-12 16:45:22', null);

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '0');
INSERT INTO `sys_role_menu` VALUES ('1', '1157');
INSERT INTO `sys_role_menu` VALUES ('1', '1161');
INSERT INTO `sys_role_menu` VALUES ('1', '1162');
INSERT INTO `sys_role_menu` VALUES ('1', '1163');
INSERT INTO `sys_role_menu` VALUES ('1', '1168');
INSERT INTO `sys_role_menu` VALUES ('1', '1169');
INSERT INTO `sys_role_menu` VALUES ('1', '1170');
INSERT INTO `sys_role_menu` VALUES ('1', '1171');
INSERT INTO `sys_role_menu` VALUES ('1', '1172');
INSERT INTO `sys_role_menu` VALUES ('1', '1173');
INSERT INTO `sys_role_menu` VALUES ('1', '1174');
INSERT INTO `sys_role_menu` VALUES ('1', '1175');
INSERT INTO `sys_role_menu` VALUES ('1', '1176');
INSERT INTO `sys_role_menu` VALUES ('1', '1177');
INSERT INTO `sys_role_menu` VALUES ('1', '1178');
INSERT INTO `sys_role_menu` VALUES ('1', '1179');
INSERT INTO `sys_role_menu` VALUES ('1', '1180');
INSERT INTO `sys_role_menu` VALUES ('1', '1182');
INSERT INTO `sys_role_menu` VALUES ('1', '1183');
INSERT INTO `sys_role_menu` VALUES ('1', '1184');
INSERT INTO `sys_role_menu` VALUES ('1', '1186');
INSERT INTO `sys_role_menu` VALUES ('1', '1187');
INSERT INTO `sys_role_menu` VALUES ('156', '1157');
INSERT INTO `sys_role_menu` VALUES ('156', '1161');
INSERT INTO `sys_role_menu` VALUES ('156', '1173');
INSERT INTO `sys_role_menu` VALUES ('156', '1174');
INSERT INTO `sys_role_menu` VALUES ('156', '1175');
INSERT INTO `sys_role_menu` VALUES ('156', '1188');
INSERT INTO `sys_role_menu` VALUES ('156', '1189');
INSERT INTO `sys_role_menu` VALUES ('157', '1157');
INSERT INTO `sys_role_menu` VALUES ('157', '1161');
INSERT INTO `sys_role_menu` VALUES ('157', '1188');
INSERT INTO `sys_role_menu` VALUES ('157', '1189');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '100', 'admin', '超级管理员', '00', '', '', '0', '2019/08/02/81e3221b10c60f6e9573b38d8b48626a.png', 'd7ec133b3e882b9d58ccd66dc8438d81', '2f3c7d', '0', '0', '127.0.0.1', '2019-08-19 21:22:25', 'admin', '2018-03-16 11:33:00', 'hs', '2019-09-12 16:55:15', '管理员');
INSERT INTO `sys_user` VALUES ('158', '348', '00000000', '管理员', '00', '', '', '2', '', '8d738642172c08489f7501ae82b679a8', 'aac18d', '0', '0', '', null, 'admin', '2019-09-12 16:47:34', '', null, '');
INSERT INTO `sys_user` VALUES ('159', '346', '00001', '王医生', '00', '', '', '2', '', 'cc5458c5dd8a12b63ea1f2bd21c326fe', '6dec8e', '0', '0', '', null, 'admin', '2019-09-12 16:47:58', '', null, '');
INSERT INTO `sys_user` VALUES ('160', '347', '00002', '徐医生', '00', '', '', '2', '', '9250c7c0925e0bd98c02016a614a6519', 'b6fda9', '0', '0', '', null, 'admin', '2019-09-12 16:48:21', '', null, '');

-- ----------------------------
-- Table structure for sys_user_online
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_online`;
CREATE TABLE `sys_user_online` (
  `sessionId` varchar(50) NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(5) DEFAULT '0' COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线用户记录';

-- ----------------------------
-- Records of sys_user_online
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('158', '156');
INSERT INTO `sys_user_role` VALUES ('158', '157');
INSERT INTO `sys_user_role` VALUES ('159', '157');
INSERT INTO `sys_user_role` VALUES ('160', '157');

-- ----------------------------
-- View structure for patient_blood_glucose_view
-- ----------------------------
DROP VIEW IF EXISTS `patient_blood_glucose_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `patient_blood_glucose_view` AS select `sbg`.`id` AS `id`,`sbg`.`measure_time` AS `measure_time`,`sp`.`id_card` AS `identify_card`,`sbg`.`meature_value` AS `meature_value`,`sbg`.`measure_status` AS `evaluation`,`sbg`.`equipment_sn` AS `devicesn`,`sbg`.`data_status` AS `data_status`,`sbg`.`measure_period` AS `status` from ((`sys_blood_glucose` `sbg` left join `sys_patient` `sp` on((`sbg`.`patient_id` = `sp`.`patient_id`))) left join `sys_dept` `sd` on((`sbg`.`dept_id` = `sd`.`dept_id`))) where ((`sp`.`id_card` <> '') and (`sbg`.`data_status` <> '1')) ;

-- ----------------------------
-- View structure for patient_blood_pressure_view
-- ----------------------------
DROP VIEW IF EXISTS `patient_blood_pressure_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `patient_blood_pressure_view` AS select `sbp`.`id` AS `id`,`sp`.`patient_id` AS `userid`,`sp`.`patient_name` AS `name`,`sp`.`birth` AS `birth`,`sp`.`sex` AS `sex`,`sbp`.`measure_time` AS `measure_time`,`sp`.`id_card` AS `identify_card`,ifnull(`sp`.`chip_card`,`sp`.`magnetic_card`) AS `card_number`,`sbp`.`systolic` AS `systolicPressure`,`sbp`.`diastolic` AS `diastolicPressure`,`sbp`.`pluse` AS `pluse`,if((`sbp`.`data_type` = 'average'),'1','0') AS `is_average`,`sbp`.`measure_status` AS `evaluation`,`sbp`.`hand` AS `hand`,`sbp`.`equipment_sn` AS `devicesn`,`sbp`.`parent_id` AS `parent_id`,`sbp`.`data_status` AS `status` from ((`sys_blood_pressure` `sbp` left join `sys_patient` `sp` on((`sbp`.`patient_id` = `sp`.`patient_id`))) left join `sys_dept` `sd` on((`sbp`.`dept_id` = `sd`.`dept_id`))) where ((`sp`.`id_card` <> '') and (`sbp`.`data_status` <> '1') and (`sp`.`status` = '0')) ;

-- ----------------------------
-- View structure for patient_bmi_view
-- ----------------------------
DROP VIEW IF EXISTS `patient_bmi_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `patient_bmi_view` AS select `spb`.`id` AS `id`,`sp`.`id_card` AS `idcard`,`spb`.`high` AS `hight`,`spb`.`weight` AS `weight`,`spb`.`create_time` AS `mearsure_time`,`spb`.`status` AS `status` from (`sys_patient_bmi` `spb` left join `sys_patient` `sp` on((`spb`.`patient_id` = `sp`.`patient_id`))) where ((`sp`.`id_card` <> '') and (`sp`.`status` = '0') and (`spb`.`status` <> '1')) ;
