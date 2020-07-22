-- 系统菜单表
CREATE TABLE system_menu (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	menu_name varchar(32) DEFAULT '' COMMENT '菜单名称',
	perm_code varchar(32) DEFAULT '' COMMENT '权限编码',
	perm_type tinyint DEFAULT 0 COMMENT '菜单类型,0:菜单，1:按钮',
	parent_id int unsigned DEFAULT 0 COMMENT '父ID',
	url varchar(128) DEFAULT '' COMMENT '菜单路径',
	perm_url varchar(512) DEFAULT '' COMMENT '权限路径',
	position int DEFAULT 0 COMMENT '位置排序'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '系统菜单表';
ALTER TABLE system_menu ADD unique(perm_code);

-- 系统管理员
CREATE TABLE system_manager (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	login_name varchar(32) DEFAULT '' COMMENT '登录名',
	login_password varchar(64) DEFAULT '' COMMENT '密码',
	real_name varchar(32) DEFAULT '' COMMENT '真实姓名',
	department_id int unsigned DEFAULT 0 COMMENT '所属部门',
	login_ip varchar(32) DEFAULT '' COMMENT '登录ip地址',
	login_time datetime DEFAULT NULL COMMENT '登录时间',
	login_error_time datetime DEFAULT NULL COMMENT '登录错误时间',
	login_error_count integer DEFAULT 0 COMMENT '登录错误次数',
	mobile varchar(16) DEFAULT '' COMMENT '手机号码',
	note varchar(128) DEFAULT '' COMMENT '备注',
	is_enable tinyint(1) DEFAULT 0 COMMENT '是否启用'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '系统管理员';

-- 管理员角色
CREATE TABLE system_role (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	name varchar(32) DEFAULT '' COMMENT '角色名称',
	note varchar(128) DEFAULT '' COMMENT '备注'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '管理员角色';

-- 管理员-角色关系表
CREATE TABLE manager_role_rel (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	manager_id int unsigned DEFAULT 0 COMMENT '管理员ID',
	role_id int unsigned DEFAULT 0 COMMENT '角色ID'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '管理员-角色关系表';

-- 角色-菜单关系表
CREATE TABLE role_menu_rel (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	role_id int unsigned DEFAULT 0 COMMENT '角色ID',
	menu_id int unsigned DEFAULT 0 COMMENT '菜单ID'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '角色-菜单关系表';

-- 部门表
CREATE TABLE department (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	name varchar(50) DEFAULT '' COMMENT '部门名称',
	note varchar(128) DEFAULT '' COMMENT '备注',
	position int DEFAULT 0 COMMENT '位置排序'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '部门表';

-- 客户端信息
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(256) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 图片分类表
CREATE TABLE image_category (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	name varchar(16) DEFAULT '' COMMENT '分类名称',
	position int DEFAULT 0 COMMENT '位置排序'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '图片分类表';

-- 图片表
CREATE TABLE image (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	name varchar(32) DEFAULT '' COMMENT '名称',
	path varchar(128) DEFAULT '' COMMENT '图片路径',
	category_id int unsigned DEFAULT 0 COMMENT '分类ID',
	support_count int unsigned DEFAULT 0 COMMENT '点赞数量',
	position int DEFAULT 0 COMMENT '位置排序'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '图片表';

-- 广告表
CREATE TABLE ad (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	title varchar(32) DEFAULT '' COMMENT '广告标题',
	path varchar(128) DEFAULT '' COMMENT '图片路径',
	ad_position varchar(32) DEFAULT '' COMMENT '广告位置编码',
	position int DEFAULT 0 COMMENT '位置排序'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '广告表';

-- 会员表
CREATE TABLE member (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	nick_name varchar(32) DEFAULT '' COMMENT '昵称',
	head_image varchar(128) DEFAULT '' COMMENT '头像',
	level_id int unsigned DEFAULT 0 COMMENT '会员等级ID'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '会员表';

-- 会员等级表
CREATE TABLE member_level (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	name varchar(8) DEFAULT '' COMMENT '名称',
	icon varchar(128) DEFAULT '' COMMENT '等级图标',
	points_start int unsigned DEFAULT 0 COMMENT '开始积分',
	points_end int unsigned DEFAULT 0 COMMENT '结束积分',
	position int DEFAULT 0 COMMENT '位置排序'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '会员等级表';

-- 图片评论信息
CREATE TABLE image_comment (
	id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	is_deleted tinyint(1) DEFAULT 0 COMMENT '删除标记',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '修改时间',
	image_id int unsigned DEFAULT 0 COMMENT '图片ID',
	member_id int unsigned DEFAULT 0 COMMENT '会员ID',
	comment varchar(128) DEFAULT '' COMMENT '评论信息',
	support_count int unsigned DEFAULT 0 COMMENT '点赞数量'
) ENGINE = InnoDB CHARSET = utf8 COMMENT '图片评论信息表';