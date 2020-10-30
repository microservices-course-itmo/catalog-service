CREATE TYPE Color AS ENUM('red', 'white', 'rose');
CREATE TYPE Sugar AS ENUM('dry', 'semi_dry', 'semi_sweet', 'sweet');

CREATE TABLE grape
(
    id   VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE region
(
    id      VARCHAR(255) PRIMARY KEY,
    name    VARCHAR(255),
    country VARCHAR(255)
);

CREATE TABLE brand
(
    id   VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE producer
(
    id   VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE Wine
(
    id          VARCHAR(255) PRIMARY KEY,
    name        VARCHAR(255),
    producer_id VARCHAR(255),
    brand_id    VARCHAR(255),
    region_id   VARCHAR(255),
    grape_id    VARCHAR(255),
    avg         REAL,
    color       Color,
    sugar       Sugar,
    year        INT,
    FOREIGN KEY (producer_id)
        REFERENCES producer (id),
    FOREIGN KEY (brand_id)
        REFERENCES brand (id),
    FOREIGN KEY (region_id)
        REFERENCES region (id),
    FOREIGN KEY (grape_id)
        REFERENCES grape (id)
);

CREATE TABLE shop
(
    id   VARCHAR(255) PRIMARY KEY,
    site VARCHAR(255)
);

CREATE TABLE wine_position
(
    id           VARCHAR(255) PRIMARY KEY,
    wine_id      VARCHAR(255),
    shop_id      VARCHAR(255),
    price        REAL,
    actual_price REAL,
    link_to_wine VARCHAR(255),
    volume       REAL,
    description  TEXT,
    gastronomy   TEXT,
    image        BYTEA,
    FOREIGN KEY (wine_id)
        REFERENCES Wine (id),
    FOREIGN KEY (shop_id)
        REFERENCES shop (id)
);

CREATE TABLE review
(
    wine_id      VARCHAR(255),
    user_id      VARCHAR(255),
    user_name    VARCHAR(255),
    buisness_name VARCHAR(255),
    text         TEXT,
    mark         REAL,
    FOREIGN KEY (wine_id)
        REFERENCES Wine (id)
);
