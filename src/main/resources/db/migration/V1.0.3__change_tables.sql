ALTER TABLE wine
    DROP COLUMN region_id;
ALTER TABLE wine
    DROP COLUMN grape_id;

CREATE TABLE wineRegion
(
    wine_id   VARCHAR(255),
    region_id VARCHAR(255)
);

CREATE TABLE wineGrape
(
    wine_id  VARCHAR(255),
    grape_id VARCHAR(255)
);

INSERT INTO wineRegion(wine_id, region_id) VALUES ('wine1', 'region1');
INSERT INTO wineRegion(wine_id, region_id) VALUES ('wine1', 'region1');
INSERT INTO wineRegion(wine_id, region_id) VALUES ('wine1', 'region2');
INSERT INTO wineRegion(wine_id, region_id) VALUES ('wine1', 'region3');

INSERT INTO wineGrape(wine_id, grape_id) VALUES ('wine1', 'grape1');
INSERT INTO wineGrape(wine_id, grape_id) VALUES ('wine1', 'grape2');
INSERT INTO wineGrape(wine_id, grape_id) VALUES ('wine1', 'grape3');
INSERT INTO wineGrape(wine_id, grape_id) VALUES ('wine1', 'grape1');

