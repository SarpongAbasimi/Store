-- Product Schema

-- !UPs
create TABLE Product(
    id serial NOT NULL
    name varchar(255) NOT NULL
    price money NOT NULL
    discount int NULL
    stock int NOT NULL
    PRIMARY KEY(id)
)

-- !Downs

DROP TABLE Product