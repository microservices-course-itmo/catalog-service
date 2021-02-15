INSERT INTO brand(id, name) VALUES ('brand1', 'AAA');
INSERT INTO brand(id, name) VALUES ('brand2', 'BBB');
INSERT INTO brand(id, name) VALUES ('brand3', 'CCC');

INSERT INTO grape(id, name) VALUES ('grape1', 'Izabel');
INSERT INTO grape(id, name) VALUES ('grape2', 'Merle');
INSERT INTO grape(id, name) VALUES ('grape3', 'Lora');

INSERT INTO producer(id, name) VALUES ('producer1', 'prod 1');
INSERT INTO producer(id, name) VALUES ('producer2', 'prod 2');
INSERT INTO producer(id, name) VALUES ('producer3', 'prod 3');

INSERT INTO region(id, name, country) VALUES ('region1', 'region', 'Russia');
INSERT INTO region(id, name, country) VALUES ('region2', 'region', 'Italy');
INSERT INTO region(id, name, country) VALUES ('region3', 'region', 'Spain');

INSERT INTO shop(id, site) VALUES ('shop1', 'http://shop1.com/');
INSERT INTO shop(id, site) VALUES ('shop2', 'http://shop2.com/');
INSERT INTO shop(id, site) VALUES ('shop3', 'http://shop3.com/');

INSERT INTO wine(id, name, producer_id, brand_id, region_id, grape_id, avg, color, sugar, year)
    VALUES ('wine1', 'Wine 1', 'producer1', 'brand1', 'region1', 'grape1', 15, 'red', 'dry', 2018);
INSERT INTO wine(id, name, producer_id, brand_id, region_id, grape_id, avg, color, sugar, year)
    VALUES ('wine2', 'Wine 2', 'producer2', 'brand3', 'region1', 'grape2', 17, 'white', 'semi_sweet', 2015);
INSERT INTO wine(id, name, producer_id, brand_id, region_id, grape_id, avg, color, sugar, year)
    VALUES ('wine3', 'Wine 3', 'producer1', 'brand2', 'region2', 'grape3', 11, 'rose', 'semi_dry', 2007);
INSERT INTO wine(id, name, producer_id, brand_id, region_id, grape_id, avg, color, sugar, year)
    VALUES ('wine4', 'Wine 4', 'producer3', 'brand1', 'region3', 'grape1', 17, 'red', 'semi_sweet', 2019);

INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position1', 'wine1', 'shop1', 890.00, 790.50, 'http://shop1.com/wine1', 10, '', 'gast', '\000');
INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position2', 'wine1', 'shop2', 890.00, 890.50, 'http://shop2.com/wine1', 10, '', 'gast', '\000');
INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position3', 'wine1', 'shop3', 890.00, 680.50, 'http://shop3.com/wine1', 10, '', 'gast', '\000');
INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position4', 'wine2', 'shop1', 590.00, 590.00, 'http://shop1.com/wine2', 10, '', 'gast', '\000');
INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position5', 'wine2', 'shop2', 690.00, 269.00, 'http://shop2.com/wine2', 10, '', 'gast', '\000');
INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position6', 'wine2', 'shop3', 560.00, 550.00, 'http://shop3.com/wine2', 10, '', 'gast', '\000');
INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position7', 'wine3', 'shop1', 490.00, 490.00, 'http://shop1.com/wine3', 10, '', 'gast', '\000');
INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position8', 'wine3', 'shop2', 590.00, 570.00, 'http://shop2.com/wine3', 10, '', 'gast', '\000');
INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position9', 'wine3', 'shop3', 580.00, 580.00, 'http://shop3.com/wine3', 10, '', 'gast', '\000');
INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position10', 'wine4', 'shop1', 390.00, 380.00, 'http://shop1.com/wine4', 10, '', 'gast', '\000');
INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position11', 'wine4', 'shop2', 500.00, 379.50, 'http://shop2.com/wine4', 10, '', 'gast', '\000');
INSERT INTO wine_position(id, wine_id, shop_id, price, actual_price, link_to_wine, volume, description, gastronomy, image)
    VALUES ('wine_position12', 'wine4', 'shop3', 650.00, 549.50, 'http://shop3.com/wine4', 10, '', 'gast', '\000');