-- psql login
-- psql -h localhost -d postgres

-- table作成
CREATE TABLE i_user
(
    id        int          NOT NULL,
    email     varchar(255) NOT NULL,
    password  varchar(255) NOT NULL,
    role_type varchar(32)  NOT NULL,
    PRIMARY KEY (id)
);

-- data注入
INSERT INTO i_user (id, email, password, role_type)
VALUES (1, 'admin', '$2a$10$u/rC0jwmFjf19aP7ElnB..mvV.DNkyDbyQiDfvCkLg0fejdZII7i6', 'ADMIN'),
       (2, 'techbot', '{bcrypt}techbot', 'USER');

-- data確認
select *
from i_user;

-- table削除
truncate i_user;