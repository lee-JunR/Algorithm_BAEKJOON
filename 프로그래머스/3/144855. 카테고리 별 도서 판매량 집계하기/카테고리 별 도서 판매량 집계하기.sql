# -- 코드를 입력하세요
SELECT t.CATEGORY,	sum(t.sales) as TOTAL_SALES
FROM 
    (SELECT b.book_id, b.CATEGORY, bs.sales
    FROM BOOK b RIGHT OUTER JOIN BOOK_SALES bs
    ON b.BOOK_ID = bs.BOOK_ID
    WHERE YEAR(sales_date) = 2022 AND MONTH(sales_date) = 1) t
GROUP BY t.CATEGORY
order by CATEGORY