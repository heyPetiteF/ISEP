# BONUS
```
SELECT
    country,
    COUNT(*) FILTER(WHERE position = 1) AS gold,
    COUNT(*) FILTER(WHERE position = 2) AS silver,
    COUNT(*) FILTER(WHERE position = 3) AS bronze
FROM A JOIN P
    WHERE year = 2024
GROUP BY country
ORDER BY gold, silver, bronze

```

# 5.
```
SELECT FROM A JOIN P JOIN E 
WHERE position = 1
GROUP BY country
HABING COUNT(DISTINCT(category)) = (SELECT COUNT(DISTINCT(category))) 
```

```
SELECT country
FROM Athelete JOIN Partipation JOIN Event
WHERE 
GROUP BY country
HABING COUNT(DISTINCT(category)) = (SELECT COUNT(EVENT))
```