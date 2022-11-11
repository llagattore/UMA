--liquibase formatted sql

--changeset llagator:4

INSERT INTO company(id, name, description)
values ('1', 'Company1', 'Does company1 things'),
       ('2','Company2', 'Does company2 things'),
       ('3', 'Company3', 'Does company3 things'),
       ('4', 'Company4', 'Does company4 things');