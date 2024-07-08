delete from test;

INSERT INTO test(name, test_time, is_deleted, gmt_create, creator_id, gmt_modified, modifier_id)
VALUES ('测试项1', '2023-01-01 00:00:00', 0, CURRENT_TIMESTAMP, 'user1', CURRENT_TIMESTAMP, 'user1');

INSERT INTO test(name, test_time, is_deleted, creator_id, modifier_id)
VALUES ('测试项2', '2023-01-02 00:00:00', 0, 'user2', 'user2');

INSERT INTO test(name, test_time, is_deleted, creator_id, modifier_id)
VALUES ('测试项3', '2023-01-03 00:00:00', 0, 'user3', 'user3');