# Write your MySQL query statement below
SELECT p.product_id, IFNULL(ROUND(SUM(p.price * us.units) / SUM(us.units),2),0) AS average_price
FROM Prices p
LEFT JOIN UnitsSold us
ON p.product_id = us.product_id
AND p.start_date <= us.purchase_date
AND p.end_date >= us.purchase_date 
GROUP BY p.product_id