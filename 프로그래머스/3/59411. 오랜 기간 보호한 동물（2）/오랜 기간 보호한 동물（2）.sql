SELECT DISTINCT i.ANIMAL_ID,	i.NAME, DATEDIFF(i.DATETIME, o.DATETIME)
FROM ANIMAL_INS i, ANIMAL_OUTS o
ORDER BY DATEDIFF(i.DATETIME, o.DATETIME) DESC
LIMIT 10