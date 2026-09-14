# Write your MySQL query statement below
SELECT *
FROM Cinema c
WHERE (c.id % 2 != 0 && c.description != 'boring')
ORDER BY rating DESC