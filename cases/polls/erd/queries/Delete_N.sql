-- SELECT MAX(unique_Name) 
-- FROM information;

select *
from information
;

SELECT MAX(unique_Name=0) 
FROM information;


DELETE FROM information
where unique_Name = 'N1';

DELETE FROM information
where unique_Name = 'N2';

DELETE FROM information
where unique_Name = 'N3';