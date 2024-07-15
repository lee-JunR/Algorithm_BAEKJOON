# # -- 리뷰의 평균 점수를 조회
SELECT
    I.REST_ID, -- REST_INFO, REST_REVIEW
    I.REST_NAME, -- REST_INFO
    I.FOOD_TYPE, --  REST_INFO
    I.FAVORITES, --   REST_INFO
    I.ADDRESS, -- REST_INFO
    ROUND(R.SCORE, 2) AS SCORE-- REST_REVIEW (리뷰의 평균 점수)
    FROM
        REST_INFO AS I
        JOIN 
            (SELECT
            REST_ID,
            AVG(REVIEW_SCORE) AS SCORE
            FROM
            REST_REVIEW
            GROUP BY REST_ID) AS R
    ON 
        I.REST_ID = R.REST_ID
    WHERE 
        I.ADDRESS LIKE '서울%' 
    ORDER BY 
        SCORE DESC, 
        FAVORITES DESC;
        
        
# OUTER JOIN 사용하지 않아도 됨.
# SELECT
#     I.REST_ID, -- REST_INFO, REST_REVIEW
#     I.REST_NAME, -- REST_INFO
#     I.FOOD_TYPE, --  REST_INFO
#     I.FAVORITES, --   REST_INFO
#     I.ADDRESS, -- REST_INFO
#     ROUND(R.SCORE, 2) AS SCORE-- REST_REVIEW (리뷰의 평균 점수)
#     FROM
#         REST_INFO AS I
#         LEFT OUTER JOIN 
#             (SELECT
#             REST_ID,
#             AVG(REVIEW_SCORE) AS SCORE
#             FROM
#             REST_REVIEW
#             GROUP BY REST_ID) AS R
#     ON 
#         I.REST_ID = R.REST_ID
#     WHERE 
#         I.ADDRESS LIKE '서울%' 
#         AND 
#         I.REST_ID = R.REST_ID
#     ORDER BY 
#         SCORE DESC, 
#         FAVORITES DESC;