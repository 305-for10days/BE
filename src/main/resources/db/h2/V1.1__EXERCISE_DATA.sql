INSERT INTO exercise_goal (id, goal)
VALUES (1, '체지방 감소'),
       (2, '골격근량 증가'),
       (3, '부위강화-상체'),
       (4, '부위강화-하체'),
       (5, '부위강화');

INSERT INTO exercise (id, name, description, category, dtype, weight, count, time, distance,
                      calorie)
VALUES (1, '플랭크', '몸을 지탱하며 가만히 누워있는 운동', '코어', 'TIME_AND_COUNT_BASED', NULL, NULL, 30, NULL, 15),
       (2, '버드 독', '바닥에 손과 무릎을 대고 반대쪽 팔과 다리를 드는 운동', '코어', 'COUNT_BASED', NULL, 15, NULL, NULL, 25),
       (3, '롤-아웃', '휠을 이용해 상체를 앞으로 내밀면서 코어를 강화하는 운동', '코어', 'COUNT_BASED', NULL, 15, NULL, NULL,
        30),
       (4, '크런치', '바닥에 누워 상체를 들어올리는 코어 운동', '코어', 'COUNT_BASED', NULL, 20, NULL, NULL, 25),
       (5, '마운틴 클라이머', '손과 발로 바닥을 지탱하며 빠르게 다리를 번갈아 드는 운동', '코어', 'COUNT_BASED', NULL, 15, NULL,
        NULL, 35),
       (6, '슈퍼맨', '바닥에 누워 팔과 다리를 동시에 드는 운동', '코어', 'TIME_AND_COUNT_BASED', NULL, 3, 30, NULL, 10),
       (7, '레그레이즈', '바닥에 누워 다리를 들어올리는 운동', '코어', 'COUNT_BASED', NULL, 15, NULL, NULL, 25),
       (8, '브릿지', '바닥에 누워 엉덩이를 들어올리는 운동', '코어', 'TIME_AND_COUNT_BASED', NULL, 3, 30, NULL, 15),
       (9, '오버헤드프레스', '무거운 물체를 머리 위로 드는 상체 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL,
        35),
       (10, '펙덱플라이', '가슴 운동 장비를 이용하는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL, 25),
       (11, '체스트프레스', '가슴 운동을 위해 무거운 물체를 밀어내는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL,
        NULL, 40),
       (12, '어시스트 풀업', '풀업 운동을 보조 장비로 돕는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15,
        NULL, NULL, 35),
       (13, '랫풀다운', '랫풀다운 기계를 이용해 상체를 강화하는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL,
        35),
       (14, '바벨 플랫 벤치 프레스', '벤치에 누워 바벨을 드는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL,
        40),
       (15, '덤벨 플랫 벤치 프레스', '벤치에 누워 덤벨을 드는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL,
        35),
       (16, '덤벨 인클라인 벤치 프레스', '기울어진 벤치에 누워 덤벨을 드는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL,
        NULL, 40),
       (17, '덤벨 플라이', '벤치에 누워 덤벨을 양 옆으로 벌리는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL,
        30),
       (18, '푸쉬업', '몸을 지탱하며 바닥과 상체를 움직이는 운동', '상체', 'COUNT_BASED', NULL, 15, NULL, NULL, 35),
       (19, '밴드 프론트 레이즈', '밴드를 이용해 팔을 앞으로 드는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL,
        25),
       (20, '머신 숄더 프레스', '머신을 이용해 어깨를 강화하는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL,
        30),
       (21, '케이블 레터럴 레이즈', '케이블을 이용해 팔을 옆으로 드는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL,
        NULL, 25),
       (22, '덤벨 로우', '덤벨을 이용해 상체를 당기는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL, 40),
       (23, '머신 시티드 로우', '머신을 이용해 앉아서 상체를 당기는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL,
        NULL, 35),
       (24, '바벨 로우', '바벨을 이용해 상체를 당기는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL, 45),
       (25, '스미스 벤트 오버 로우', '스미스 머신을 이용해 상체를 당기는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL,
        NULL, 40),
       (26, '케이블 시티드 로우', '케이블을 이용해 앉아서 상체를 당기는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL,
        NULL, 35),
       (27, '데드리프트', '바닥에 놓인 무거운 바벨을 드는 운동', '상체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL, 75),
       (28, '스쿼트', '하체를 강화하고 균형 감각을 향상시키는 기본적인 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL,
        NULL, 45),
       (29, '레그프레스', '머신을 이용해 다리를 뻗는 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL, 40),
       (30, '힙쓰러스트', '엉덩이와 허벅지를 강화하는 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL, 35),
       (31, '레그익스텐션', '머신을 이용해 다리를 뻗는 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL, 30),
       (32, '레그컬', '머신을 이용해 다리를 구부리는 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL, 30),
       (33, '바벨스쿼트', '바벨을 어깨에 얹고 스쿼트하는 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL, 45),
       (34, '스플릿스쿼트', '한쪽 다리를 앞에 두고 스쿼트하는 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL,
        40),
       (35, '백익스텐션', '허리를 강화하는 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL, 35),
       (36, '케틀벨 스윙', '케틀벨을 앞뒤로 휘두르는 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 20, NULL, NULL, 50),
       (37, '랙풀', '무거운 바벨을 들어올리는 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL, 60),
       (38, '스티프 데드리프트', '다리를 일직선으로 유지하며 바벨을 드는 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL,
        NULL, 75),
       (39, '덤벨 런지', '덤벨을 들고 한 발을 앞으로 내디디는 운동', '하체', 'COUNT_AND_WEIGHT_BASED', 5, 15, NULL, NULL,
        40),
       (40, '걷기', '가장 기본적인 유산소 운동', '유산소', 'DISTANCE_BASED', NULL, NULL, NULL, 1, 30),
       (41, '인터벌 러닝', '달리기와 걷기를 반복하는 운동', '유산소', 'DISTANCE_BASED', NULL, NULL, NULL, 1, 60),
       (42, '버피', '점프와 푸시업을 결합한 복합 운동', '유산소', 'COUNT_BASED', NULL, 15, NULL, NULL, 75),
       (43, '실내 사이클', '실내 자전거를 이용한 운동', '유산소', 'TIME_AND_COUNT_BASED', NULL, 3, 30, NULL, 60),
       (44, '스텝밀 또는 계단 오르기', '계단을 오르는 운동 혹은 기계를 이용한 운동', '유산소', 'DISTANCE_BASED', NULL, NULL, NULL,
        1, 30);


-- 체지방 감소
INSERT INTO default_routine (id, exercise_goal_id)
VALUES (1, 1);

-- 골격근량 증가
INSERT INTO default_routine (id, exercise_goal_id)
VALUES (2, 2);

-- 부위 강화-상체
INSERT INTO default_routine (id, exercise_goal_id)
VALUES (3, 3);

-- 부위 강화-하체
INSERT INTO default_routine (id, exercise_goal_id)
VALUES (4, 4);

-- 부위 강화 - 코어
INSERT INTO default_routine (id, exercise_goal_id)
VALUES (5, 5);


-- 체지방 감소
INSERT INTO routine_item (id, set_count, exercise_id, d_routine_id)
VALUES (1, 3, 1, 1),  -- 플랭크
       (2, 5, 36, 1), -- 케틀벨
       (3, 2, 40, 1), -- 걷기
       (4, 2, 41, 1);
-- 인터벌

-- 골격근량 증가
INSERT INTO routine_item (id, set_count, exercise_id, d_routine_id)
VALUES (5, 3, 4, 2),  -- 크런치
       (6, 3, 28, 2), -- 스쿼트
       (7, 3, 11, 2), -- 체스트 프레스
       (8, 3, 13, 2), -- 랫풀다운
       (9, 3, 24, 2);
-- 바벨 로우

-- 부위 강화-상체
INSERT INTO routine_item (id, set_count, exercise_id, d_routine_id)
VALUES (10, 3, 9, 3),  -- 오버헤드프레스
       (11, 3, 10, 3), -- 펙덱플라이
       (12, 3, 11, 3), -- 체스트 프레스
       (13, 3, 12, 3), -- 어시스트 풀업
       (14, 3, 13, 3);
-- 랫풀다운

-- 부위 강화-하체
INSERT INTO routine_item (id, set_count, exercise_id, d_routine_id)
VALUES (15, 5, 28, 4), -- 스쿼트
       (16, 3, 29, 4), -- 레그프레스
       (17, 3, 30, 4), -- 힙쓰러스트
       (18, 3, 31, 4), -- 레그익스텐션
       (19, 3, 32, 4);
-- 레그컬

-- 부위 강화 - 코어
INSERT INTO routine_item (id, set_count, exercise_id, d_routine_id)
VALUES (20, 3, 1, 5), -- 플랭크
       (21, 3, 2, 5), -- 버드 독
       (22, 3, 3, 5), -- 롤-아웃
       (23, 3, 4, 5), -- 크런치
       (24, 3, 5, 5);
-- 마운틴 클라이머

