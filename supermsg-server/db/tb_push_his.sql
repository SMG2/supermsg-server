CREATE TABLE `tb_push_his` (
	`pushid` VARCHAR (32) NOT NULL,
	`userid` VARCHAR (32) NOT NULL,
	`createtime` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
	`tags` VARCHAR (45) NOT NULL DEFAULT '',
	`isPushToAll` bit NOT NULL COMMENT '如果为推送到全部人员，那么设置为TRUE或者1',
	PRIMARY KEY (`pushid`),
	CONSTRAINT `FK_push_user` FOREIGN KEY (`userid`) REFERENCES `user_baseinfo` (`id`) ON DELETE
SET NULL ON UPDATE CASCADE
);

