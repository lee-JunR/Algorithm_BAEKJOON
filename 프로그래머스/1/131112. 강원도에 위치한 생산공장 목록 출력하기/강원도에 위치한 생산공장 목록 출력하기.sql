-- 코드를 입력하세요
SELECT
    FACTORY_ID,
    FACTORY_NAME,
    ADDRESS
    FROM
        FOOD_FACTORY
    WHERE -- 강원도에 위치한 것들만
        ADDRESS LIKE '강원도%'
    ORDER BY -- 공장 id 기준 오름차순
        FACTORY_ID;