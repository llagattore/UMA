--liquibase formatted sql

--changeset llagator:5

INSERT INTO user(username, password, email, date_created, active, company_id)
values  ('JoDe', 'pass1', 'john.doe@foo.com', '2022-11-04 14:57:53', b'1', '1'),
        ('JaDe', 'pass2', 'jane.doe@goo.com', '2022-11-04 14:57:53',b'0', '3'),
        ('DoJe', 'pass3', 'don.joe@bar.com', '2022-11-04 14:57:53',b'1','4'),
        ('DaJe', 'pass4', 'dane.joe@tar.com', '2022-11-04 14:57:53',b'1','3'),
        ('JoBe', 'pass5', 'john.boe@moo.com', '2022-11-04 14:57:53',b'0','4'),
        ('JaBe', 'pass6', 'jane.boe@noo.com', '2022-11-04 14:57:53',b'1','2'),
        ('BoJe', 'pass7', 'bon.joe@zar.com', '2022-11-04 14:57:53',b'1','1'),
        ('Baje', 'pass8', 'bane.joe@jar.com', '2022-11-04 14:57:53',b'0','4');