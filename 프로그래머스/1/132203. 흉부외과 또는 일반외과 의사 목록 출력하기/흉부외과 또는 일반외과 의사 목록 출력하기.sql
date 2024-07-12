SELECT 
    DR_NAME,
    DR_ID,
    MCDP_CD, 
    DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
    FROM
        DOCTOR
    WHERE
        MCDP_CD IN ('CS', 'GS') -- 진료과코드가 CS or GS
    ORDER BY -- 고용일자 기준으로 내림차순 정리 1순 이름 기준 오름차순 정리 2순
        HIRE_YMD DESC,
        DR_NAME;
         
        
        
