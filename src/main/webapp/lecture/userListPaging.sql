insert into jspuser
select 'xxxx' || level, 'xxxx', 'xxxxpass', 
       '대전시 중구 대흥동 76', '2층 대덕인재개발원', '34940',
       sysdate, 'xxxx@gmail.com', '123123123', ''
    from dual
connect by level <= 100;
commit;

--'201810'

select to_char(sysdate - 10 + rownum, 'yyyyMMdd')
 from jspuser -- dual
where rownum <= 31;  -- connect by level

select to_date('201810' || '01', 'yyyyMMdd'),
        LAST_DAY(to_date('201810' || '01', 'yyyyMMdd')),
        LAST_DAY(to_date('201810' || '01', 'yyyyMMdd')) -
        to_date('201810' || '01', 'yyyyMMdd')+1 days
 FROM DUAL;

select to_date('201809' || '01', 'yyyyMMdd'),
        LAST_DAY(to_date('201809' || '01', 'yyyyMMdd')),
        LAST_DAY(to_date('201809' || '01', 'yyyyMMdd')) -
        to_date('201809' || '01', 'yyyyMMdd')+1 days
 FROM DUAL;
 
 select to_char((to_date('201810' || '01', 'yyyyMMdd') + level-1), 'yyyyMMdd') days
  from dual
connect by level <= LAST_DAY(to_date('201810' || '01', 'yyyyMMdd')) -
        to_date('201810' || '01', 'yyyyMMdd')+1;
        
        
--page 당 10건씩 조회되도록 쿼리를 작성
--쿼리 인자 : 페이지 번호(page), 페이지 사이즈(pageSize)
--1페이지 : 1~10번 사용자 
--2페이지 : 11~20번 사용자
--3페이지 : 21~30번 사용자

--정렬기준 : userId

--query id : selectUserPageList
-- --> method 이름
--메소드 인자 kr.or.ddit.util.model.PageVo (page, pageSize)
select *
 from 
(select rownum rnum, a.*
  from
     (select jspuser.*
        from jspuser
       order by userId) a)
where rnum between 2*15-(15-1)
               and 2*15;               
               
where rnum between #{page}*#{pageSize}-(#{pageSize}-1)
               and #{page}*#{pageSize};
               
where rnum between 2*15-(15-1)
               and 2*15;               
--1 --> 1 and 10
--2 --> 11 and 20
--3 --> 21 and 30

select rownum rnum, a.*
  from
(select jspuser.*
 from jspuser
order by userId) a;


select count(*) from jspuser;

'/profile' || userid || '.png'
select userid, profile
 from jspuser;
where userid in ('brown', 'sally', 'cony', 'moon', 'james');

update jspuser set profile = '/profile/' || userid || '.png'
where userid in ('brown', 'sally', 'cony', 'moon', 'james');



