create table book_tbl_06
(
    book_no number primary key,
    book_name varchar2(50) not null,
    book_coverimg varchar2(20),
    book_date date,
    book_price number,
    book_publisher varchar2(50),
    book_info varchar2(2000)
);
SELECT book_no
        ,book_name
        ,book_name
        ,book_coverimg
        ,book_date
        ,book_price
        ,book_publisher
        ,book_info
FROM book_tbl_06
ORDER BY book_no desc;


insert into book_tbl_06 (book_no
                        ,book_name
                        ,book_coverimg
                        ,book_date
                        ,book_price
                        ,book_publisher
                        ,book_info)
values  (100
        ,'리눅스'
        ,'100.jpg'
        ,'15/09/02'
        ,24000
        ,'나룩스'
        ,'운영체제, DB기초, 네트워크기초,개발환경구축');
        
insert into book_tbl_06 (book_no
                        ,book_name
                        ,book_coverimg
                        ,book_date
                        ,book_price
                        ,book_publisher
                        ,book_info)
values  (101
        ,'자바'
        ,'101.jpg'
        ,'16/01/10'
        ,20000
        ,'이자바'
        ,'프로그래밍 언어');
        
insert into book_tbl_06 (book_no
                        ,book_name
                        ,book_coverimg
                        ,book_date
                        ,book_price
                        ,book_publisher
                        ,book_info)
values  (102
        ,'자바웹프로그래밍'
        ,'102.jpg'
        ,'16/10/30'
        ,25000
        ,'김프로'
        ,'개발환경/서버프로그램/배치프로그램');
        
insert into book_tbl_06 (book_no
                        ,book_name
                        ,book_coverimg
                        ,book_date
                        ,book_price
                        ,book_publisher
                        ,book_info)
values  (103
        ,'오픈소스활용하기'
        ,'103.jpg'
        ,'17/09/01'
        ,30000
        ,'박오픈'
        ,'형상관리,빌드,배포');
        
insert into book_tbl_06 (book_no
                        ,book_name
                        ,book_coverimg
                        ,book_date
                        ,book_price
                        ,book_publisher
                        ,book_info)
values  (104
        ,'HTML'
        ,'104.jpg'
        ,'18/04/04'
        ,10000
        ,'홍길동'
        ,'HTML/CSS/JAVASCRIPT/JQUERY');
        
select * from book_tbl_06;
        
create table rent_tbl_06( rent_no number primary key
                            ,book_no number not null
                            ,rent_price number not null
                            ,rent_date date not null
                            ,rent_status char(1) default 0 not null
                            );

insert into rent_tbl_06 (rent_no
                        ,book_no
                        ,rent_price
                        ,rent_date
                        ,rent_status
                            )
values(10001
        ,100
        ,2400
        ,'18/07/02'
        ,1
        );
        
insert into rent_tbl_06 (rent_no
                        ,book_no
                        ,rent_price
                        ,rent_date
                        ,rent_status
                            )
values(10002
        ,101
        ,2000
        ,'18/07/04'
        ,1
        );
        
insert into rent_tbl_06 (rent_no
                        ,book_no
                        ,rent_price
                        ,rent_date
                        ,rent_status
                            )
values(10003
        ,100
        ,2400
        ,'18/0802'
        ,1
        );
        
insert into rent_tbl_06 (rent_no
                        ,book_no
                        ,rent_price
                        ,rent_date
                        ,rent_status
                            )
values(10004
        ,100
        ,2400
        ,'18/08/12'
        ,1
        );
        
insert into rent_tbl_06 (rent_no
                        ,book_no
                        ,rent_price
                        ,rent_date
                        ,rent_status
                            )
values(10005
        ,102
        ,2500
        ,'18/08/13'
        ,1
        );
        
insert into rent_tbl_06 (rent_no
                        ,book_no
                        ,rent_price
                        ,rent_date
                        ,rent_status
                            )
values(10006
        ,103
        ,3000
        ,'18/08/13'
        ,1
        );
        
insert into rent_tbl_06 (rent_no
                        ,book_no
                        ,rent_price
                        ,rent_date
                        ,rent_status
                            )
values(10007
        ,103
        ,3000
        ,'18/08/20'
        ,0
        );
        
insert into rent_tbl_06 (rent_no
                        ,book_no
                        ,rent_price
                        ,rent_date
                        ,rent_status
                            )
values(10008
        ,100
        ,2400
        ,'18/09/03'
        ,1
        );
        
insert into rent_tbl_06 (rent_no
                        ,book_no
                        ,rent_price
                        ,rent_date
                        ,rent_status
                            )
values(10009
        ,100
        ,2400
        ,'18/09/08'
        ,1
        );
        
insert into rent_tbl_06 (rent_no
                        ,book_no
                        ,rent_price
                        ,rent_date
                        ,rent_status
                            )
values(10010
        ,100
        ,2400
        ,'18/09/14'
        ,0
        );
        
insert into rent_tbl_06 (rent_no
                        ,book_no
                        ,rent_price
                        ,rent_date
                        ,rent_status
                            )
values(10011
        ,102
        ,2500
        ,'18/09/14'
        ,0
        );
        
select * from rent_tbl_06;

//book_no,book_name, 대여총개, 대여횟수
select book_no, count(book_no)
from rent_tbl_06
group by book_no;

select b.book_no, b.book_name, count(b.book_no) as cnt
from rent_tbl_06 a
left outer join book_tbl_06 b
on a.book_no = b.book_no
group by b.book_no, b.book_name;

select b.book_no, b.book_name, count(a.book_no) as cnt
from rent_tbl_06 a
left outer join book_tbl_06 b
on a.book_no = b.book_no
group by b.book_no, b.book_name;

--망한거
select a.book_no, b.book_name, count(a.book_no) as cnt
from rent_tbl_06 as a
left outer join book_tbl_06 as b
on a.book_no = b.book_no
group by a.book_no;

SELECT b.book_no, b.book_name, COALESCE(SUM(r.rent_price), 0) AS rent_sum, COUNT(r.book_no) AS rent_cnt
FROM book_tbl_06 b
inner JOIN rent_tbl_06 r ON b.book_no = r.book_no
GROUP BY b.book_no, b.book_name
ORDER BY b.book_no;


SELECT sq.book_no, b.book_name, sq.rent_sum, sq.rent_cnt
FROM book_tbl_06 b
RIGHT JOIN (
            SELECT book_no, sum(rent_price) AS rent_sum, count(book_no) AS rent_cnt
            FROM rent_tbl_06
            GROUP BY book_no
            ) sq
ON b.book_no = sq.book_no
ORDER BY book_no







