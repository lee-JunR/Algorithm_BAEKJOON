SELECT t.FISH_COUNT,	n.FISH_NAME
FROM (SELECT FISH_TYPE, COUNT(FISH_TYPE) as FISH_COUNT
    FROM FISH_INFO
    GROUP BY FISH_TYPE) t 
    LEFT OUTER JOIN FISH_NAME_INFO n
    ON t.FISH_TYPE = n.FISH_TYPE
ORDER BY FISH_COUNT DESC;
