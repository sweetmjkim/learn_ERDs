insert into answer(unique_A, ANSWER)
values(1, "1.그렇다")
;
insert into answer(unique_A, ANSWER)
values(2, "2.그저그렇다")
;
insert into answer(unique_A, ANSWER)
values(3, "3.그렇지않다")
;
insert into answer(unique_A, ANSWER)
values(4, "4.잘모르겠다")
;


DELETE FROM ANSWER
where unique_A = 1;
DELETE FROM ANSWER
where unique_A = 2;
DELETE FROM ANSWER
where unique_A = 3;
DELETE FROM ANSWER
where unique_A = 4;

SELECT * 
FROM answer
;