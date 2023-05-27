INSERT INTO _user (ID, CREATED_AT, UPDATED_AT, EMAIL, SOCIAL_PROVIDER_KEY, USER_ROLE, USERNAME)
VALUES (1, '2023-05-26 15:41:23.429082+09', '2023-05-26 15:41:23.429082+09',
        'anwjsrlrhwkd@naver.com', '2798804548', 'USER', '김주영'),
        (2, '2023-05-26 15:41:23.429082+09', '2023-05-26 15:41:23.429082+09',
        'tjd123123@nate.com', '2804043032', 'USER', '박성은');
INSERT INTO user_routine (id, created_at, updated_at, calorie, emoji, exercise_goal_id, user_id)
VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 100, 1, 1, 1),
       (2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 150, 2, 2, 1),
       (3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 120, 3, 3, 1),
       (4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 90, 3, 4, 1),
       (5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 110, 2, 5, 1),
        (11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 100, 1, 1, 2),
       (12, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 150, 2, 2, 2),
       (14, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 90, 1, 4, 2);



INSERT INTO routine_item (id, created_at, updated_at, set_count, exercise_id, routine_id)
VALUES (51, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 1, 1),
       (52, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 5, 36, 1),
       (53, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2, 40, 1),
       (54, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2, 41, 1),
       (55, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 4, 2),
       (56, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 28, 2),
       (57, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 11, 2),
       (58, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 13, 2),
       (59, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 24, 2),
       (110, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 9, 3),
       (111, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 10, 3),
       (112, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 11, 3),
       (113, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 12, 3),
       (114, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 13, 3),
       (115, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 5, 28, 4),
       (116, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 29, 4),
       (117, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 30, 4),
       (118, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 31, 4),
       (119, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 32, 4),
       (120, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 1, 5),
       (121, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 2, 5),
       (122, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 3, 5),
       (123, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 4, 5),
       (124, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 5, 5);

drop sequence hibernate_sequence;
create sequence hibernate_sequence start with 200 increment by 1;
