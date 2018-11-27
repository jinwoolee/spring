/* 게시글 */
CREATE TABLE board (
	id NUMBER NOT NULL, /* 게시글번호 */
	title varchar2(500), /* 제목 */
	pid NUMBER /* 부모게시글번호 */
);

COMMENT ON TABLE board IS '게시글';

COMMENT ON COLUMN board.id IS '게시글번호';

COMMENT ON COLUMN board.title IS '제목';

COMMENT ON COLUMN board.pid IS '부모게시글번호';

CREATE UNIQUE INDEX PK_board
	ON board (
		id ASC
	);

ALTER TABLE board
	ADD
		CONSTRAINT PK_board
		PRIMARY KEY (
			id
		);

ALTER TABLE board
	ADD
		CONSTRAINT FK_board_TO_board
		FOREIGN KEY (
			pid
		)
		REFERENCES board (
			id
		);
        

insert into board values (1, '첫번째 글', '');        
insert into board values (2, '두번째 글', '');        
insert into board values (3, '세번째 글-2번글 답글', 2);        
insert into board values (4, '네번째 글-3번글 답글', 3);        
insert into board values (5, '다섯번째 글', '');        
insert into board values (6, '여섯번째 글', '');        
insert into board values (7, '일곱번째 글-5번글  답글', 5);        
insert into board values (8, '여덟번째 글-2번글  답글', 2);

commit;


select * from board;

drop table board;
commit;


select lpad('▶ ',(level-1)*3, ' ')|| title, board.*, level 
    from board
    start with pid is null 
    connect by prior id = pid
    order siblings by id desc;
    
    
    
    
    
    
    
    