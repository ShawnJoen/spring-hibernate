#DROP database userdb;
CREATE database userdb DEFAULT charset utf8;

#DROP TABLE `users`;
CREATE TABLE `users` (
  `userId` bigint(20) unsigned NOT NULL auto_increment,
  `mobile` char(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `userName` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名称',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `u1` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
#insert into users set `mobile`="18621321111";
#delete from users where `mobile`="18621321112";

#DROP TABLE `user_extends`;
CREATE TABLE `user_extends` (
  `userId` bigint(20) unsigned NOT NULL DEFAULT 0,
  `point` int unsigned NOT NULL DEFAULT 0 COMMENT '积分',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

#触发器 用户表有 INSERT 新用户时触发自动插入用户信息表
#DROP TRIGGER IF EXISTS `user_insert_trigger`;
SET SESSION SQL_MODE='';
DELIMITER //
CREATE TRIGGER `user_insert_trigger` AFTER INSERT ON `users` FOR EACH ROW BEGIN
 insert into `user_extends` value( NEW.userId, 0);
END//
DELIMITER ;

#触发器 在用户表 DELETE 指定用户时触发自动删除用户信息表
#DROP TRIGGER IF EXISTS `user_delete_trigger`;
SET SESSION SQL_MODE='';
DELIMITER //
CREATE TRIGGER `user_delete_trigger` AFTER DELETE ON `users` FOR EACH ROW BEGIN
 delete from user_extends where userId = OLD.userId ;
END//
DELIMITER ;
