SELECT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D
WHERE D.SKILL_CODE & (SELECT SUM(s.CODE) 
                       FROM SKILLCODES s
                       WHERE s.CATEGORY = 'Front End')
ORDER BY D.ID;