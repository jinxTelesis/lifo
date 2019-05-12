
DROP TABLE IF EXISTS reviews;
CREATE TABLE reviews (
    reviews_id int NOT NULL auto_increment,
    products_id int NOT NULL,
    customers_id int,
    customers_name varchar(255) NOT NULL,
    reviews_rating int,
    date_added DATETIME,
    last_modified DATETIME,
    reviews_status tinyint NOT NULL default '0',
    reviews_read int NOT NULL default '0',
    PRIMARY KEY (reviews_id)
)ENGINE=MyISAM;


DROP TABLE IF EXISTS tax_rates;
CREATE TABLE tax_rates (
    tax_rates_id int NOT NULL auto_increment,
    tax_rate decimal(7,4) NOT NULL,
    tax_description varchar(255) NOT NULL,
    last_modified DATETIME NULL,
    date_added DATETIME NOT NULL,
    PRIMARY KEY (tax_rates_id)
)ENGINE=MyISAM;

DROP TABLE IF EXISTS specials;
CREATE TABLE specials (
    specials_id int auto_increment,
    products_id int NULL,
    specials_new_products_price decimal(15,4) NOT NULL,
    specials_date_added DATETIME,
    specials_last_modified DATETIME,
    expires_date DATETIME,
    date_status_change DATETIME,
    status int NOT NULL DEFAULT '1',
    PRIMARY KEY (specials_id)
)ENGINE=MyISAM;

DROP TABLE IF EXISTS whos_online;
CREATE TABLE whos_online (
    customer_id int,
    full_name varchar(255) NOT NULL,
    session_id varchar(128) NOT NULL,
    ip_address varchar(15) NOT NULL,
    time_entry varchar(14) NOT NULL,
    time_last_click varchar(14) NOT NULL,
    last_page_url text NOT NULL,
    host_address text NOT NULL,
    user_agent varchar(255) NOT NULL default ''
)ENGINE=MyISAM ;

DROP TABLE IF EXISTS sessions;
CREATE TABLE sessions (
    sesskey varchar(128) NOT NULL,
    expiry int(11) unsigned NOT NULL,
    value text NOT NULL,
    PRIMARY KEY (sesskey)
);

DROP TABLE IF EXISTS featured;
CREATE TABLE featured (
    featured_id int(11) NOT NULL auto_increment,
    products_id bigint(20) NOT NULL default '0',
    featured_date_added DATETIME default NULL,
    featured_last_modified DATETIME default NULL,
    expires_date date NOT NULL default '0001-01-01',
    date_status_change DATETIME default NULL,
    status tinyint NOT NULL default '1',
    featured_date_available date NOT NULL default '0001-01-01',
    PRIMARY KEY  (featured_id)
)ENGINE=MyISAM;

DROP TABLE IF EXISTS coupons;
CREATE TABLE coupons (
    coupon_id int(11) NOT NULL auto_increment,
    coupon_type char(1) NOT NULL default 'F',
    coupon_code varchar(32) NOT NULL default '',
    coupon_amount decimal(15,4) NOT NULL default '0.0000',
    coupon_minimum_order decimal(15,4) NOT NULL default '0.0000',
    coupon_start_date DATETIME NOT NULL default '0001-01-01 00:00:00',
    coupon_expire_date DATETIME NOT NULL default '0001-01-01 00:00:00',
    uses_per_coupon int(5) NOT NULL default 1,
    uses_per_user int(5) NOT NULL default 0,
    restrict_to_products varchar(255) default NULL,
    restrict_to_categories varchar(255) default NULL,
    coupon_active char(1) NOT NULL default 'Y',
    date_created DATETIME NOT NULL default '0001-01-01 00:00:00',
    date_modified DATETIME NOT NULL default '0001-01-01 00:00:00',
    coupon_order_limit int(4) NOT NULL default 0,
    PRIMARY KEY (coupon_id)
)ENGINE=MyISAM;

DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
    categories_id int NOT NULL auto_increment,
    categories_name varchar(64) NOT NULL,
    categories_image varchar(64) NULL,
    parent_id int DEFAULT '0' NOT NULL,
    sort_order int(3),
    date_added DATETIME,
    last_modified DATETIME,
    categories_status tinyint NOT NULL default '1',
    PRIMARY KEY (categories_id)
)ENGINE=MyISAM;

DROP TABLE IF EXISTS coupon_redeem_track;
CREATE TABLE coupon_redeem_track (
    unique_id int(11) NOT NULL auto_increment,
    coupon_id int(11) NOT NULL default '0',
    customer_id bigint(20) NOT NULL default '0',
    redeem_date DATETIME NULL,
    redeem_ip varchar(40) NULL,
    order_id int NULL,
    PRIMARY KEY  (unique_id)
)ENGINE=MyISAM;


DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
    orders_id int NOT NULL auto_increment,
    customers_id int NOT NULL,
    customers_name varchar(255) NOT NULL,
    customers_company varchar(255),
    delivery_name varchar(255) NOT NULL,
    delivery_company varchar(255),
    delivery_street_address varchar(255) NOT NULL,
    delivery_suburb varchar(255),
    delivery_city varchar(255) NOT NULL,
    delivery_postcode varchar(255) NOT NULL,
    delivery_state varchar(255),
    delivery_country varchar(255) NOT NULL,
    delivery_date DATETIME NULL,
    billing_name varchar(255) NOT NULL,
    billing_company varchar(255),
    billing_street_address varchar(255) NOT NULL,
    billing_suburb varchar(255),
    billing_city varchar(255) NOT NULL,
    billing_postcode varchar(255) NOT NULL,
    billing_state varchar(255),
    billing_country varchar(255) NOT NULL,
    payment_method varchar(255) NOT NULL,
    shipping_method varchar(255) default NULL,
    coupon_code varchar(32) NOT NULL default '',
    date_purchased DATETIME,
    orders_status int(5) NOT NULL,
    orders_date_finished DATETIME,
    order_total decimal(15,4) default NULL,
    order_tax decimal(15,4) default NULL,
    ip_address varchar(96) NOT NULL default '',
    order_weight float default NULL,
    last_modified DATETIME,
    PRIMARY KEY (orders_id)
)ENGINE=MyISAM;