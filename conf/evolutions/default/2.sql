-- Product schema

-- !Up

Insert into Product(name, price, stock) values (
    "Play station 5",
    700,
    10
)

-- !Downs
DELETE FROM Product WHERE id = '1'