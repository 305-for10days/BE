DROP TABLE IF EXISTS _user;
DROP TABLE IF EXISTS default_routine;
DROP TABLE IF EXISTS exercise;
DROP TABLE IF EXISTS exercise_goal;
DROP TABLE IF EXISTS profile;
DROP TABLE IF EXISTS user_routine;
DROP TABLE IF EXISTS routine_item;

CREATE TABLE _user (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       email VARCHAR(100) NOT NULL,
                       social_provider_key VARCHAR(255) NOT NULL,
                       user_role VARCHAR(50) NOT NULL,
                       username VARCHAR(100) NOT NULL,
                       PRIMARY KEY (id)
);

CREATE TABLE default_routine (
                                 id BIGINT NOT NULL AUTO_INCREMENT,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                 exercise_goal_id BIGINT,
                                 PRIMARY KEY (id)
);

CREATE TABLE exercise (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          description VARCHAR(255),
                          name VARCHAR(100) NOT NULL,
                          category VARCHAR(100) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          calorie INT,
                          dtype VARCHAR(100),
                          weight INT,
                          count INT,
                          time INT,
                          distance INT,
                          PRIMARY KEY (id)
);

CREATE TABLE routine_item (
                              id BIGINT NOT NULL AUTO_INCREMENT,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              goal_calorie INT,
                              set_count INT,
                              exercise_id BIGINT,
                              routine_id BIGINT,
                              d_routine_id BIGINT NULL,
                              PRIMARY KEY (id)
);

CREATE TABLE exercise_goal (
                               id BIGINT NOT NULL AUTO_INCREMENT,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               goal VARCHAR(100) NOT NULL,
                               PRIMARY KEY (id)
);

CREATE TABLE profile (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         bmi DOUBLE NOT NULL,
                         gender VARCHAR(50) NOT NULL,
                         height INT NOT NULL,
                         minute_per_workout INT NOT NULL,
                         several_times_week INT NOT NULL,
                         weight INT NOT NULL,
                         user_id BIGINT,
                         PRIMARY KEY (id)
);

CREATE TABLE user_routine (
                              id BIGINT NOT NULL AUTO_INCREMENT,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              calorie INT,
                              emoji BIGINT,
                              exercise_goal_id BIGINT,
                              user_id BIGINT,
                              PRIMARY KEY (id)
);

ALTER TABLE default_routine
    ADD CONSTRAINT fk_default_routine_exercise_goal_id
        FOREIGN KEY (exercise_goal_id)
            REFERENCES exercise_goal(id);

ALTER TABLE routine_item
    ADD CONSTRAINT fk_routine_item_exercise_id
        FOREIGN KEY (exercise_id)
            REFERENCES exercise(id);

ALTER TABLE routine_item
    ADD CONSTRAINT fk_routine_item_routine_id
        FOREIGN KEY (routine_id)
            REFERENCES user_routine(id);

ALTER TABLE routine_item
    ADD CONSTRAINT fk_routine_item_d_routine_id
        FOREIGN KEY (d_routine_id)
            REFERENCES default_routine(id);

ALTER TABLE profile
    ADD CONSTRAINT fk_profile_user_id
        FOREIGN KEY (user_id)
            REFERENCES _user(id);

ALTER TABLE user_routine
    ADD CONSTRAINT fk_user_routine_exercise_goal_id
        FOREIGN KEY (exercise_goal_id)
            REFERENCES exercise_goal(id);

ALTER TABLE user_routine
    ADD CONSTRAINT fk_user_routine_user_id
        FOREIGN KEY (user_id)
            REFERENCES _user(id);
