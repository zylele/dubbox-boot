CREATE TABLE `dubbo_user` (
    `userid` VARCHAR (50) NOT NULL COMMENT '用户ID',
    `nickname` VARCHAR(30) NOT NULL COMMENT '昵称',
    `systime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统时间',
    PRIMARY KEY (`userid`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'dubbo测试用户';

INSERT INTO `xy_test`.`dubbo_user` (`userid`, `nickname`) VALUES ('1', 'tom');
INSERT INTO `xy_test`.`dubbo_user` (`userid`, `nickname`) VALUES ('2', 'hanmeimei');
INSERT INTO `xy_test`.`dubbo_user` (`userid`, `nickname`) VALUES ('3', 'lilei');


CREATE TABLE `dubbo_dynamic` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `content` VARCHAR(10000) NOT NULL COMMENT '内容',
    `systime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统时间',
    PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'dubbo测试动态';


INSERT INTO `xy_test`.`dubbo_dynamic` (`id`, `content`) VALUES ('1', '啦啦啦啦');
INSERT INTO `xy_test`.`dubbo_dynamic` (`id`, `content`) VALUES ('2', '哈哈哈哈');
INSERT INTO `xy_test`.`dubbo_dynamic` (`id`, `content`) VALUES ('3', '嘻嘻嘻嘻');

