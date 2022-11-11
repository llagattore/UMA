--liquibase formatted sql

--changeset llagator:5

select @usr1 := id from user where username = 'JoDe';
select @usr2 := id from user where username = 'DaJe';
select @usr3 := id from user where username = 'JaBe';
select @usr4 := id from user where username = 'BoJe';

INSERT INTO user_details(user_id, first_name, last_name, date_of_birth, sex)
values (@usr1, 'John', 'Doe', '1995-11-07', 'm'),
        (@usr2, 'Dane', 'Joe', '1999-07-24', 'f'),
        (@usr3, 'Jane', 'Boe', '1986-03-05', 'f'),
        (@usr4, 'Bon', 'Joe', '1993-12-13', 'm');