delete t_user where userId = 'brown';
delete t_user where userId = 'cony';
delete t_user where userId = 'sally';

insert into t_user values ('brown', '브라운', 'br', 'brownpass', 'system', sysdate);    
insert into t_user values ('cony', '코니', 'co', 'conypass', 'system', sysdate);
insert into t_user values ('sally', '샐리', 'sal', 'sallypass', 'system', sysdate);

commit;