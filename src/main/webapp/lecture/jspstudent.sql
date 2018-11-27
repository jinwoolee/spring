
/* 학생 */
CREATE TABLE jsptstudent (
	no NUMBER, /* 학생번호 */
	name VARCHAR2(50) /* 학생이름 */
);

COMMENT ON TABLE jsptstudent IS '학생';

COMMENT ON COLUMN jsptstudent.no IS '학생번호';

COMMENT ON COLUMN jsptstudent.name IS '학생이름';



insert into jspstudent values(1, '강석균');
insert into jspstudent values(2, '구인수');
insert into jspstudent values(3, '김정현');
insert into jspstudent values(4, '김종훈');
insert into jspstudent values(5, '김지선');
insert into jspstudent values(6, '김지태');
insert into jspstudent values(7, '나진실');
insert into jspstudent values(8, '박동주');
insert into jspstudent values(9, '박  진');
insert into jspstudent values(10, '박찬배');
insert into jspstudent values(11, '방민성');
insert into jspstudent values(12, '변찬우');
insert into jspstudent values(13, '서준영');
insert into jspstudent values(14, '송연진');
insert into jspstudent values(15, '유다영');
insert into jspstudent values(16, '유민지');
insert into jspstudent values(17, '이소형');
insert into jspstudent values(18, '임규승');
insert into jspstudent values(19, '최재현');
commit;

