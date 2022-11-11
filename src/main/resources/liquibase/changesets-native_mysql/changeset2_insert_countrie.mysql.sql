--liquibase formatted sql

--changeset llagator:2

insert into country(name, code)
values ('United States of America', 'USA'),
        ('United Kingdom', 'GBR'),
        ('Italy', 'ITA'),
        ('Austria', 'AUT'),
        ('Barbados', 'BRB'),
        ('Bermuda', 'BMU'),
        ('Cambodia', 'KHM'),
        ('Cameron', 'CMR'),
        ('Canada', 'CAN');
