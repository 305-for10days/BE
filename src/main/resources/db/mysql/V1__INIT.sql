drop table if exists _user;
drop table if exists exercise;
drop table if exists exercise_goal;
drop table if exists profile;
drop table if exists user_routine;
drop table if exists routine_item;

create table _user (
                       id bigint not null auto_increment,
                       created_at datetime(6),
                       updated_at datetime(6),
                       email varchar(100) not null,
                       social_provider_key varchar(255) not null,
                       user_role varchar(50) not null,
                       username varchar(100) not null,
                       is_profile_exist boolean default false,
                       primary key (id)
) engine=innoDB;

create table exercise (
                          id bigint not null auto_increment,
                          description varchar(255),
                          name varchar(100) not null,
                          category varchar(100) not null,
                          created_at datetime(6),
                          updated_at datetime(6),
                          calorie integer,
                          dtype varchar(100),
                          weight integer,
                          count integer,
                          time integer,
                          distance integer,
                          primary key (id)
) engine=innoDB;

create table routine_item (
                              id bigint not null auto_increment,
                              created_at datetime(6),
                              updated_at datetime(6),
                              goal_calorie integer,
                              set_count integer,
                              exercise_id bigint,
                              routine_id bigint,
                              primary key (id)
) engine=innoDB;

create table exercise_goal (
                               id bigint not null auto_increment,
                               created_at datetime(6),
                               updated_at datetime(6),
                               goal varchar(100) not null,
                               primary key (id)
) engine=innoDB;

create table profile (
                         id bigint not null auto_increment,
                         created_at datetime(6),
                         updated_at datetime(6),
                         bmi double not null,
                         gender varchar(50) not null,
                         height integer not null,
                         minute_per_workout integer not null,
                         several_times_week integer not null,
                         weight integer not null,
                         user_id bigint,
                         primary key (id)
) engine=innoDB;

create table user_routine (
                              id bigint not null auto_increment,
                              created_at datetime(6),
                              updated_at datetime(6),
                              calorie integer,
                              is_default boolean default false,
                              exercise_goal_id bigint,
                              user_id bigint,
                              primary key (id)
) engine=innoDB;

create table user_routine_record (
                                     id bigint not null auto_increment,
                                     created_at datetime(6),
                                     updated_at datetime(6),
                                     total_calorie integer,
                                     emoji bigint,
                                     routine_id bigint,
                                     user_id bigint,
                                     primary key (id)
) engine=innoDB;

alter table routine_item
    add constraint fk_routine_item_exercise_id
        foreign key (exercise_id)
            references exercise(id);

alter table routine_item
    add constraint fk_routine_item_user_routine_id
        foreign key(routine_id)
            references user_routine(id);

alter table profile
    add constraint fk_profile_user_id
        foreign key (user_id)
            references _user(id);

alter table user_routine
    add constraint fk_user_routine_exercise_goal_id
        foreign key (exercise_goal_id)
            references exercise_goal(id);

alter table user_routine
    add constraint fk_user_routine_user_id
        foreign key (user_id)
            references _user(id);

alter table user_routine_record
    add constraint fk_user_routine_record_user_id
        foreign key (user_id)
            references _user(id);

alter table user_routine_record
    add constraint fk_user_routine_record_user_routine
        foreign key (routine_id)
            references user_routine(id);
