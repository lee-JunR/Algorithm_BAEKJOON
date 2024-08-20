SELECT DISTINCT *
FROM 
    (SELECT 
        CASE
            WHEN (d.SKILL_CODE & fe.CODE) > 0 AND (d.SKILL_CODE & py.CODE) > 0 THEN 'A'
            WHEN (d.SKILL_CODE & cs.CODE) > 0  THEN 'B'
            WHEN (d.SKILL_CODE & fe.CODE) > 0 THEN 'C'
        END AS GRADE,
        d.ID,
        d.EMAIL
    FROM
        DEVELOPERS d
        JOIN SKILLCODES fe ON fe.CATEGORY = 'Front End'
        JOIN SKILLCODES py ON py.NAME = 'Python'
        JOIN SKILLCODES cs ON cs.NAME = 'C#'
    ) t
WHERE GRADE IS NOT NULL 
ORDER BY
    GRADE,
    ID

