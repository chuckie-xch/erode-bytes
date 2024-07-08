-- test-schema.sql
DROP TABLE IF EXISTS test;

CREATE TABLE test
(
    id           BIGINT    NOT NULL AUTO_INCREMENT, -- H2 does not support UNSIGNED
    name         VARCHAR(255),
    test_time    TIMESTAMP,
    is_deleted   TINYINT   NOT NULL DEFAULT 0,
    gmt_create   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    creator_id   VARCHAR(64),
    gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    modifier_id  VARCHAR(64),
    PRIMARY KEY (id)
);

-- 创建索引
CREATE INDEX idx_name ON test (name);
