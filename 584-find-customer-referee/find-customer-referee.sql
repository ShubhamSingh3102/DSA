-- # Write your MySQL query statement below
-- SELECT name FROM Customer
-- WHERE referee_id is NULL OR referee_id != 2

SELECT name FROM Customer
WHERE IFNULL(referee_id , 0) <> 2;


-- <> is same as !=