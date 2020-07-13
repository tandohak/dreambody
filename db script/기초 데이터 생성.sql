INSERT INTO activities(CREATE_DATE, MODIFIED_DATE, ACTIVITY, VOLUME) VALUES(sysdate(), sysdate(), '주로 좌식 생활을 하는 사람', 1.2);
INSERT INTO activities(CREATE_DATE, MODIFIED_DATE, ACTIVITY, VOLUME) VALUES(sysdate(), sysdate(), '약간 활동적인 사람 (주당 1일~3일 운동)', 1.3);
INSERT INTO activities(CREATE_DATE, MODIFIED_DATE, ACTIVITY, VOLUME) VALUES(sysdate(), sysdate(), '보통 (주당 3일~5일 이상 운동)', 1.5);
INSERT INTO activities(CREATE_DATE, MODIFIED_DATE, ACTIVITY, VOLUME) VALUES(sysdate(), sysdate(), '상당히 활동적인 사람 (매일 운동)', 1.7);
INSERT INTO activities(CREATE_DATE, MODIFIED_DATE, ACTIVITY, VOLUME) VALUES(sysdate(), sysdate(), '매우 활동적(운동선수와 비슷한 강도로 매일 운동)', 1.9);

INSERT INTO genders (CREATE_DATE, MODIFIED_DATE, GENDER) VALUES(sysdate(), sysdate(), '남');
INSERT INTO genders (CREATE_DATE, MODIFIED_DATE, GENDER) VALUES(sysdate(), sysdate(), '여');

INSERT INTO goals (CREATE_DATE, MODIFIED_DATE, GOAL) VALUES(sysdate(), sysdate(), '체중감소');
INSERT INTO goals (CREATE_DATE, MODIFIED_DATE, GOAL) VALUES(sysdate(), sysdate(), '체중유지');
INSERT INTO goals (CREATE_DATE, MODIFIED_DATE, GOAL) VALUES(sysdate(), sysdate(), '체중증가');

INSERT INTO meal_type (CREATE_DATE, MODIFIED_DATE, TYPE) VALUES(sysdate(), sysdate(), '아침');
INSERT INTO meal_type (CREATE_DATE, MODIFIED_DATE, TYPE) VALUES(sysdate(), sysdate(), '점심');
INSERT INTO meal_type (CREATE_DATE, MODIFIED_DATE, TYPE) VALUES(sysdate(), sysdate(), '저녁');
INSERT INTO meal_type (CREATE_DATE, MODIFIED_DATE, TYPE) VALUES(sysdate(), sysdate(), '간식');

select * from users;

select * from user_infos;

select * from genders;

select * from activities;

select * from goals;