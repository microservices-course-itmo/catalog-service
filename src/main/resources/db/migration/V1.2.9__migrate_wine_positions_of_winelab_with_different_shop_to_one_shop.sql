update wine_position
set shop_id = '80e909b0-d1dd-4708-9a71-fcfc114c88ac'
from wine_position as wp
inner join shop as s
    on wp.shop_id = s.id
where s.site = 'winelab.ru';


delete from shop
where site = 'winelab.ru' and id <> '80e909b0-d1dd-4708-9a71-fcfc114c88ac';
