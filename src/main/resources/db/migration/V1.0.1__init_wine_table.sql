CREATE TYPE Color AS ENUM('red', 'white', 'rose');
CREATE TYPE Sugar AS ENUM('dry', 'medium dry', 'medium', 'sweet');

CREATE TABLE grape
(
    id   UUID PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE region
(
    id      UUID PRIMARY KEY,
    name    VARCHAR(255),
    country VARCHAR(255)
);

CREATE TABLE brand
(
    id   UUID PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE producer
(
    id   UUID PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE Wine
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255),
    producer_id UUID,
    brand_id    UUID,
    region_id   UUID,
    grape_id    UUID,
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
    id   UUID PRIMARY KEY,
    site VARCHAR(255)
);

CREATE TABLE wine_position
(
    id           UUID PRIMARY KEY,
    wine_id      UUID,
    shop_id      UUID,
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
    wine_id      UUID,
    user_id      UUID,
    user_name    VARCHAR(255),
    buisness_name VARCHAR(255),
    text         TEXT,
    mark         REAL,
    FOREIGN KEY (wine_id)
        REFERENCES Wine (id)
);
