--개발자 피씨 디비에만 절대 존재할수 없을거 같은 테이블을 생성하여 조회하는 쿼리르 제일 먼저 실행
--select * from imyourfather;

--select 초기 데이터 삭제
--delete t_user; 

--select 초기 데이터 입력

--insertUser 테스트 케이스 실행후 데이터 초기화
delete t_user where userId in ('TEST_BROWN2');