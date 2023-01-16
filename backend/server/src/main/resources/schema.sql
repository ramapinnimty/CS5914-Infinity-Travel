create table DISCOUNT_CODES (
    discount_id INT UNSIGNED AUTO_INCREMENT,
    coupon_code VARCHAR(50) NOT NULL,
    percentage INT UNSIGNED NOT NULL,
    creation_date DATE NOT NULL,
    utilized NUMBER(1) NOT NULL,
);