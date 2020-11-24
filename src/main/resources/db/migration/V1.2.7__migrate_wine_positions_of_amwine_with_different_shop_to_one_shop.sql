update wp
set shop_id = 'f8a2114c-2c6c-44d5-9e1b-fb1b5e226e1f'
from wine_position as wp
inner join shop as s
    on wp.shop_id = s.id
where s.site = 'amwine.com';

INSERT INTO shop VALUES ('48db3cfe-b615-44a4-a327-c891dd334267', 'simplewine.ru');
update wp
set shop_id = '48db3cfe-b615-44a4-a327-c891dd334267'
from wine_position as wp
         inner join shop as s
                    on wp.shop_id = s.id
where s.site = '';

delete from shop
where site = 'amwine.com' and id <> 'f8a2114c-2c6c-44d5-9e1b-fb1b5e226e1f';
delete from shop
where site = '' and id <> '48db3cfe-b615-44a4-a327-c891dd334267';