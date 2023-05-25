drop table if exists _user;

drop table if exists default_routine;

drop table if exists exercise;

drop table if exists exercise_goal;

drop table if exists profile;

drop table if exists routine;

drop table if exists routine_item;

drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;

create table _user (
                      id bigint not null,
                      created_at timestamp with time zone default current_timestamp,
                      updated_at timestamp with time zone default current_timestamp,
                      email varchar(255) not null,
                      social_provider_key varchar(255) not null,
                      user_role varchar(255) not null,
                      username varchar(255) not null,
                      primary key (id)
);

create table default_routine (
                                 id bigint not null,
                                 created_at timestamp with time zone default current_timestamp,
                                 updated_at timestamp with time zone default current_timestamp,
                                 calorie integer,
                                 emotion varchar(255),
                                 exercise_goal_id bigint,
                                 user_id bigint,
                                 primary key (id)
);

create table exercise (
                          id bigint not null,
                          description varchar(255) not null,
                          name varchar(255) not null,
                          primary key (id)
);

create table exercise_goal (
                               id bigint not null,
                               created_at timestamp with time zone default current_timestamp,
                               updated_at timestamp with time zone default current_timestamp,
                               purpose varchar(255) not null,
                               primary key (id)
);

create table profile (
                         id bigint not null,
                         created_at timestamp with time zone default current_timestamp,
                         updated_at timestamp with time zone default current_timestamp,
                         bmi double not null,
                         gender varchar(255) not null,
                         height integer not null,
                         minute_per_workout integer not null,
                         several_times_week integer not null,
                         weight integer not null,
                         user_id bigint,
                         primary key (id)
);

create table routine (
                         id bigint not null,
                         created_at timestamp with time zone default current_timestamp,
                         updated_at timestamp with time zone default current_timestamp,
                         calorie integer,
                         emotion varchar(255),
                         exercise_goal_id bigint,
                         user_id bigint,
                         primary key (id)
);

create table routine_item (
                              id bigint not null,
                              created_at timestamp with time zone default current_timestamp,
                              updated_at timestamp with time zone default current_timestamp,
                              calorie integer,
                              dtype varchar(255),
                              kg integer,
                              number_per_set integer,
                              time integer,
                              times_per_set integer,
                              d_routine_id bigint,
                              exercise bigint,
                              routine_id bigint,
                              primary key (id)
);

alter table default_routine
    add foreign key (exercise_goal_id)
        references exercise_goal;

alter table default_routine
    add foreign key (user_id)
        references _user;

alter table profile
    add foreign key (user_id)
        references _user;

alter table routine
    add foreign key (exercise_goal_id)
        references exercise_goal;

alter table routine
    add foreign key (user_id)
        references _user;

alter table routine_item
    add foreign key (d_routine_id)
        references default_routine;

alter table routine_item
    add foreign key (exercise)
        references exercise;

alter table routine_item
    add foreign key (routine_id)
        references routine;
