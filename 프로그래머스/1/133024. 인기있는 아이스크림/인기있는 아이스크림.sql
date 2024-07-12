-- 코드를 입력하세요
SELECT
    FLAVOR
    FROM
        FIRST_HALF
    ORDER BY -- TOTAL_ORDER 기준 내림차 2. SHIPMENT_ID 기준 오름차
        TOTAL_ORDER DESC,
        SHIPMENT_ID;