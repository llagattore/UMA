--liquibase formatted sql

--changeset llagator:3

select @usa := id from country where code = 'USA';
select @gbr := id from country where code = 'GBR';
select @ita := id from country where code = 'ITA';
select @aut := id from country where code = 'AUT';
select @brb := id from country where code = 'BRB';
select @bmu := id from country where code = 'BMU';
select @khm := id from country where code = 'KHM';
select @cmr := id from country where code = 'CMR';
select @can := id from country where code = 'CAN';

insert into city(name, country_id)
values ('Washington', @usa),('New York', @usa),('Chicago', @usa),
        ('London', @gbr),('Manchester', @gbr),
        ('Rome', @ita),('Milan', @ita),('Florence', @ita),('Bologna', @ita),('Como', @ita),
        ('Vienna', @aut),
        ('Bridgetown', @brb),('Speightstown', @brb),('Holetown', @brb),('Oistins', @brb),
        ('Devonshire', @bmu),('Hamilton', @bmu),('Paget', @bmu),('Pembroke', @bmu),
        ('Phnom Penh', @khm),('Siem Reap', @khm),('Battambang', @khm),
        ('Yaounde', @cmr),('Douala', @cmr),
        ('Ottawa', @can),('Québec', @can),('Toronto', @can);