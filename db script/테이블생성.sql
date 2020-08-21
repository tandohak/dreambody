create table black_list (
                            id bigint auto_increment,
                            create_date timestamp,
                            modified_date timestamp,
                            token varchar(255),
                            primary key (id)
)  engine = innodb default  character set = utf8 comment = '블랙리스트';

create table food_info (
                           id bigint auto_increment,
                           create_date timestamp,
                           modified_date timestamp,
                           calorie float not null,
                           carbohydrate float not null,
                           code varchar(255) not null,
                           fat float not null,
                           name varchar(255) not null,
                           protein float not null,
                           registration_date date not null,
                           primary key (id)
) engine = innodb default  character set = utf8 comment = '음식정보';

create table h2connection (
                              id bigint auto_increment,
                              create_date timestamp,
                              modified_date timestamp,
                              name varchar(255),
                              primary key (id)
) engine = innodb default  character set = utf8 comment = 'h2';

create table user_food_mapping (
                                   id bigint auto_increment,
                                   create_date timestamp,
                                   modified_date timestamp,
                                   meal_type varchar(255),
                                   quantity integer not null check (quantity>=1 AND quantity<=999),
                                   registration_date date not null,
                                   food_info_id bigint not null,
                                   user_id bigint not null,
                                   primary key (id)
) engine = innodb default  character set = utf8 comment = '식사타입별로 회원이 저장한 음식,회원 정보';

create table user_infos (
                            id bigint auto_increment,
                            create_date timestamp,
                            modified_date timestamp,
                            activity_type varchar(255),
                            current_weight integer not null check (current_weight>=1 AND current_weight<=999),
                            daily_intake_calorie integer not null check (daily_intake_calorie>=0 AND daily_intake_calorie<=99999),
                            date_of_birth date not null,
                            gender_type varchar(255),
                            goal_type varchar(255),
                            goal_weight integer not null check (goal_weight>=1 AND goal_weight<=999),
                            height integer not null check (height>=1 AND height<=999),
                            registration_date date,
                            user_id bigint,
                            primary key (id)
) engine = innodb default  character set = utf8 comment = '회원정보';

create table users (
                       id bigint auto_increment,
                       create_date timestamp,
                       modified_date timestamp,
                       answered_question boolean default false,
                       email varchar(40) not null,
                       email_verified boolean not null,
                       name varchar(40) not null,
                       password varchar(255),
                       profile_image varchar(255),
                       provider varchar(255) not null,
                       provider_id varchar(255),
                       primary key (id)
) engine = innodb default  character set = utf8 comment = '소셜 로그 정보';

create table water_info (
                            id bigint auto_increment,
                            create_date timestamp,
                            modified_date timestamp,
                            amount_water integer not null,
                            registration_date date not null,
                            user_id bigint not null,
                            primary key (id)
) engine = innodb default  character set = utf8 comment = '물 정보';

alter table food_info
    add constraint UK_code unique (code);

alter table user_infos
    add constraint UK_registration_date unique (registration_date);

alter table users
    add constraint UK_email unique (email);

alter table user_food_mapping
    add constraint FK_user_food_mapping
        foreign key (food_info_id)
            references food_info(id);

alter table user_food_mapping
    add constraint FK_userId_user_food_mapping
        foreign key (user_id)
            references users(id);

alter table user_infos
    add constraint FK_user_info
        foreign key (user_id)
            references users(id);

alter table water_info
   add constraint FKk_water_info
       foreign key (user_id)
           references users(id)