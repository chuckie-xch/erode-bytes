
-- schema.sql
DROP TABLE IF EXISTS test;
CREATE TABLE `test`
(
    `id`           BIGINT  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`         VARCHAR(255)       DEFAULT NULL COMMENT '名称',
    `test_time`    TIMESTAMP          DEFAULT NULL COMMENT '测试时间',
    `is_deleted`   TINYINT(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除标识，0表示正常，1表示已删除',
    `gmt_create`   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `creator_id`   VARCHAR(64)        DEFAULT NULL COMMENT '创建者ID',
    `gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `modifier_id`  VARCHAR(64)        DEFAULT NULL COMMENT '最后修改者ID',
    PRIMARY KEY (`id`)
) COMMENT='测试数据表';

-- 创建索引
CREATE INDEX idx_name ON test(name);
