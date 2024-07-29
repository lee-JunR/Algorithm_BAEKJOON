# # SELECT ID, ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS rank_size
# # FROM ECOLI_DATA
# SELECT ID, 
# CASE
#     WHEN rk <= ((SELECT COUNT(*) FROM ECOLI_DATA) * 0.25) THEN 'LOW'
#     WHEN rk <= ((SELECT COUNT(*) FROM ECOLI_DATA) * 0.50) THEN 'MEDIUM'
#     WHEN rk <= ((SELECT COUNT(*) FROM ECOLI_DATA) * 0.75) THEN 'HIGH'
#     WHEN 'CRITICAL'
# END
# FROM 
# (SELECT ID, ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS rk
#  FROM ECOLI_DATA)
 
 
 
SELECT
    ID,
    CASE
        WHEN rk <= TOTAL_COUNT * 0.25 THEN 'LOW'
        WHEN rk <= TOTAL_COUNT * 0.50 THEN 'MEDIUM'
        WHEN rk <= TOTAL_COUNT * 0.75 THEN 'HIGH'
        ELSE 'CRITICAL'
    END AS COLONY_NAME
FROM
    (SELECT
        ID,
        SIZE_OF_COLONY,
        ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY) AS rk,
        COUNT(*) OVER() AS TOTAL_COUNT
    FROM
        ECOLI_DATA) as e
ORDER BY
    ID ASC;