CREATE TYPE Color AS ENUM ('red', 'white', 'rose');
CREATE TYPE Sugar AS ENUM ('dry', 'medium dry', 'medium', 'sweet');

CREATE TABLE Brands
(
    brandID   serial PRIMARY KEY,
    brandName TEXT
);

CREATE TABLE Countries
(
    countryID   serial PRIMARY KEY,
    countryName TEXT
);

CREATE TABLE Wine
(
    wineID      VARCHAR(255) PRIMARY KEY,
    picture     BYTEA        NOT NULL,
    brandID     INT,
    countryID   INT          NOT NULL,
    volume      real         NOT NULL,
    abv         real         NOT NULL,
    color       Color        NOT NULL,
    sugar       Sugar        NOT NULL,
    name        varchar(255) NOT NULL,
    year        varchar(10)  NOT NULL,
    grapes_info varchar(255),

    FOREIGN KEY (brandID)
        REFERENCES Brands (brandID),
    FOREIGN KEY (countryID)
        REFERENCES Countries (countryID)
);

CREATE TABLE PositionPrice
(
    priceID serial PRIMARY KEY,
    wineID  varchar(255),
    shopID  int,
    value   real
);

CREATE TABLE Discount
(
    wineID varchar(255),
    shopID int,
    value  real
);

CREATE TABLE Grapes
(
    grapeID   VARCHAR(255) PRIMARY KEY,
    grapeName VARCHAR(255),
    grapeCode VARCHAR(255)
);

CREATE TABLE WineGrapesInfo
(
    id      serial PRIMARY KEY,
    wineID  VARCHAR(255),
    grapeID VARCHAR(255),
    FOREIGN KEY (wineID)
        REFERENCES Wine (wineID),
    FOREIGN KEY (grapeID)
        REFERENCES Grapes (grapeID)
);

CREATE TABLE Shops
(
    shopID   serial PRIMARY KEY,
    shopName TEXT
);

CREATE TABLE Catalog
(
    winePositionID serial PRIMARY KEY,
    wineID         VARCHAR(255),
    shopID         INT,
    price          INT,
    FOREIGN KEY (wineID)
        REFERENCES Wine (wineID),
    FOREIGN KEY (shopID)
        REFERENCES Shops (shopID)
);
