-- 코드를 입력하세요
SELECT
    PT_NAME	,
    PT_NO,
    GEND_CD,
    AGE,
    IFNULL(TLNO, 'NONE') AS TLNO
    FROM
        PATIENT AS P
    WHERE
        AGE <= 12
        and
        GEND_CD = 'W'
    order by    
        age desc, PT_NAME;