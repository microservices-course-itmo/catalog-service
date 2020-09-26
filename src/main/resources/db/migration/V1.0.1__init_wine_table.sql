CREATE TYPE Color AS ENUM('red', 'white', 'rose');
CREATE TYPE Sugae AS ENUM('dry', 'medium dry', 'medium', 'sweet');

CREATE TABLE Brands
(
    brandID   serial PRIMARY KEY,
    brandName TEXT
);

CREATE TABLE Countries
(
    countryID serial PRIMARY KEY,
    countryName TEXT
);

CREATE TABLE Wine
(
    wineID    serial PRIMARY KEY,
    picture   BYTEA NOT NULL,
    brandID   INT,
    countryID INT   NOT NULL,
    volume    real  NOT NULL,
    abv       real  NOT NULL,
    color     Color NOT NULL,
    sugar     Sugar NOT NULL,
    FOREIGN KEY (brandID)
        REFERENCES Brands (brandID),
    FOREIGN KEY (countryID)
        REFERENCES Countries (countryID)
);

CREATE TABLE Grapes
(
    grapeID   serial PRIMARY KEY,
    grapeName TEXT
);

CREATE TABLE WineGrapesInfo
(
    wineID  INT,
    grapeID INT,
    FOREIGN KEY (wineID)
        REFERENCES Wine (wineID),
    FOREIGN KEY (grapeID)
        REFERENCES Grapes (grapeID)
);

CREATE TABLE Shops
(
    shopID   sertial PRIMARY KEY,
    shopName TEXT
);

CREATE TABLE Catalog
(
    winePositionID serial PRIMARY KEY,
    wineID         INT,
    shopID         INT,
    price          INT,
    FOREIGN KEY (wineID)
        REFERENCES Wine (wineID),
    FOREIGN KEY (shopID)
        REFERENCES Shops (shopID)
);
