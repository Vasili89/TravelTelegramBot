CREATE SCHEMA IF NOT EXISTS travelbot;

DROP TABLE IF EXISTS travelbot.city;

CREATE TABLE travelbot.city (
        id INT8 GENERATED BY DEFAULT AS IDENTITY,
        name VARCHAR(255) NOT NULL,
        message VARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
    );

INSERT INTO travelbot.city (name, message)
    VALUES('Москва', 'Не забудьте посетить Красную Площадь. Ну а в ЦУМ можно и не заходить)))'),
    ('Минск', 'Не забудьте посетить Ботанический сад.'),
    ('Вильнюс', 'Вильнюс красивый город. Стоит задержаться в нём подольше.'),
    ('Варшава', 'Варшава красивый город. Стоит задержаться в нём подольше.');