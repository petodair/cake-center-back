CREATE TABLE if NOT EXISTS tb_user {
    id UUID not null primary key,
    username varchar(50) not null,
    password varchar(50) not null,
    email varchar(100) not null,
    }

CREATE TABLE if NOT EXISTS product (
        id bigint not null primary key,
        name varchar(50) not null,
        description varchar(300),
        price numeric(18,2) not null,
        user_id uuid not null references tb_user(id)
)