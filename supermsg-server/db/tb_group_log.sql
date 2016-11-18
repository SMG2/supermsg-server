DROP TABLE
IF EXISTS tb_group_log;

CREATE TABLE `tb_group_log` (
	`messageid` INT (11) NOT NULL AUTO_INCREMENT,
	`groupid` VARCHAR (32) NOT NULL,
	`userid` VARCHAR (32) NOT NULL,
	`createTime` VARCHAR (50) NOT NULL,
	`content` VARCHAR (1024) NULL DEFAULT NULL,
	PRIMARY KEY (`messageid`),
	CONSTRAINT `fk_group_user` FOREIGN KEY (`groupid`) REFERENCES `user_detailinfo` (`class`) ON DELETE NO ACTION ON UPDATE CASCADE,
	INDEX `fk_group_user` (`groupid`) USING BTREE
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '群消息存储表' AUTO_INCREMENT = 1 ROW_FORMAT = COMPACT;

