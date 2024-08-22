SELECT eg.EMP_NO,	EMP_NAME,	eg.GRADE,	
        CASE
            WHEN eg.GRADE = 'S'
            THEN 0.2 * hr.SAL
            WHEN eg.GRADE = 'A'
            THEN 0.15 * hr.SAL
            WHEN eg.GRADE = 'B'
            THEN 0.1 * hr.SAL
            ELSE 0 
        END BONUS
FROM 
    (SELECT EMP_NO,
        CASE
            WHEN SCORE >= 96
            THEN 'S'
            WHEN SCORE >= 90
            THEN 'A'
            WHEN SCORE >= 80
            THEN 'B'
            ELSE 'C'
        END GRADE
    FROM 
        (SELECT EMP_NO,	AVG(SCORE) SCORE
        FROM HR_GRADE
        GROUP BY EMP_NO, YEAR) Avg_score) eg
    LEFT OUTER JOIN HR_EMPLOYEES hr
    ON hr.EMP_NO = eg.EMP_NO


# SELECT EMP_NO,
#         CASE
#             WHEN SCORE >= 96
#             THEN 'S'
#             WHEN SCORE >= 90
#             THEN 'A'
#             WHEN SCORE >= 80
#             THEN 'B'
#             ELSE 'C'
#         END GRADE
#     FROM 
#         (SELECT EMP_NO,	AVG(SCORE) SCORE
#         FROM HR_GRADE
#         GROUP BY EMP_NO, YEAR) Avg_score
    