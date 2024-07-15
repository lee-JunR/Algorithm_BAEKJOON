SELECT
    USER_ID, 
    PRODUCT_ID
    from 
        ONLINE_SALE
    group by 
        USER_ID, 
        PRODUCT_ID
    having 
        count(USER_ID) > 1 
        and 
        count(PRODUCT_ID) > 1
    order by
        USER_ID, PRODUCT_ID desc;