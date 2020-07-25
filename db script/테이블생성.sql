create table activities (
                            id bigint auto_increment,
                            create_date timestamp,
                            modified_date timestamp,
                            activity varchar(40) not null,
                            volume float not null,
                            primary key (id)
) engine = innodb default  character set = utf8 comment = '활동성';

create table food_info (
                           id bigint auto_increment,
                           create_date timestamp,
                           modified_date timestamp,
                           calorie float not null,
                           carbohydrate float not null,
                           code varchar(10) not null,
                           fat float not null,
                           name varchar(255) not null,
                           protein float not null,
                           primary key (id)
) engine = innodb default  character set = utf8 comment = '음식정보';

create table genders (
                         id bigint auto_increment,
                         create_date timestamp,
                         modified_date timestamp,
                         gender varchar(1) not null,
                         primary key (id)
) engine = innodb default  character set = utf8 comment = '성별';

create table goals (
                       id bigint auto_increment,
                       create_date timestamp,
                       modified_date timestamp,
                       goal varchar(10) not null,
                       primary key (id)
) engine = innodb default  character set = utf8 comment = '목표';

create table h2connection (
                              id bigint auto_increment,
                              create_date timestamp,
                              modified_date timestamp,
                              name varchar(255),
                              primary key (id)
) engine = innodb default  character set = utf8 comment = 'h2';

create table meal_type (
                           id bigint auto_increment,
                           create_date timestamp,
                           modified_date timestamp,
                           type varchar(2) not null,
                           primary key (id)
) engine = innodb default  character set = utf8 comment = '식사타입';

create table user_food_mapping (
                                   id bigint auto_increment,
                                   create_date timestamp,
                                   modified_date timestamp,
                                   quantity integer not null check (quantity<=999 AND quantity>=1),
                                   registration_date date not null,
                                   food_info_id bigint not null,
                                   meal_type_id bigint not null,
                                   user_id bigint not null,
                                   primary key (id)
) engine = innodb default  character set = utf8 comment = '식사타입별로 회원이 저장한 음식,회원 정보';

create table user_infos (
                            id bigint auto_increment,
                            create_date timestamp,
                            modified_date timestamp,
                            current_weight integer not null check (current_weight<=999 AND current_weight>=1),
                            daily_intake_calorie integer not null check (daily_intake_calorie<=99999 AND daily_intake_calorie>=1),
                            date_of_birth date not null,
                            goal_weight integer not null check (goal_weight<=999 AND goal_weight>=1),
                            height integer not null check (height<=999 AND height>=1),
                            registration_date date,
                            activity_id bigint,
                            gender_id bigint,
                            goal_id bigint,
                            user_id bigint,
                            primary key (id)
) engine = innodb default  character set = utf8 comment = '회원정보';

create table users (
                       id bigint auto_increment,
                       create_date timestamp,
                       modified_date timestamp,
                       email varchar(40) not null,
                       email_verified boolean not null,
                       name varchar(40) not null,
                       provider varchar(255) not null,
                       provider_id varchar(255),
                       primary key (id)
) engine = innodb default  character set = utf8 comment = '소셜 로그 정보';

alter table activities
    add constraint activityID unique (activity);

alter table food_info
    add constraint foodInfoId unique (code);

alter table genders
    add constraint genderId unique (gender);

alter table goals
    add constraint goalId unique (goal);

alter table user_infos
    add constraint userInfoId unique (registration_date);

alter table users
    add constraint userId unique (email);

alter table user_food_mapping
    add constraint foodInfoId
        foreign key (food_info_id)
            references food_info(id);

alter table user_food_mapping
    add constraint mealTypeId
        foreign key (meal_type_id)
            references meal_type(id);

alter table user_food_mapping
    add constraint userIdUserFoodMapping
        foreign key (user_id)
            references users(id);

alter table user_infos
    add constraint activityID
        foreign key (activity_id)
            references activities(id);

alter table user_infos
    add constraint genderId
        foreign key (gender_id)
            references genders(id);

alter table user_infos
    add constraint goalId
        foreign key (goal_id)
            references goals(id);

alter table user_infos
    add constraint userIdUserInfos
        foreign key (user_id)
            references users(id);