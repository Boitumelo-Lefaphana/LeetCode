SELECT DISTINCT num AS ConsecutiveNums
FROM Logs l1
WHERE 
    num = (SELECT num FROM Logs l2 WHERE l2.id = l1.id + 1) 
    AND num = (SELECT num FROM Logs l3 WHERE l3.id = l1.id + 2);
