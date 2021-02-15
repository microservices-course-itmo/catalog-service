update wine_position
set shop_id = 'fa0d78e3-f399-4a86-ae87-c78c29e3d2fb'
from wine_position as wp
inner join shop as s
    on wp.shop_id = s.id
where s.site = 'https://spb.winestyle.ru';


delete from shop
where site = 'https://spb.winestyle.ru' and id <> 'fa0d78e3-f399-4a86-ae87-c78c29e3d2fb';
