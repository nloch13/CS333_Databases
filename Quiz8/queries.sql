SELECT s.Season_Name, COUNT(d.Drink_NUM) AS TotalDrinks
From Season_ s 
JOIN Drinks d ON s.Season_NUM = d.Season_NUM
GROUP BY s.Season_NUM
ORDER BY TotalDrinks DESC
LIMIT 1;

SELECT s.Season_Name, COUNT(f.Dish_NUM) AS TotalFoods
From Season_ s 
JOIN Food f ON s.Season_NUM = f.Season_NUM
GROUP BY s.Season_NUM
ORDER BY TotalFoods DESC
LIMIT 1;

SELECT d.Drink_Name, f.Dish_Name
FROM Food f 
JOIN Drinks d ON f.Season_NUM = d.Season_NUM
WHERE d.Season_NUM = 4;
