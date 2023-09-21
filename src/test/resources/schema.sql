DROP TABLE IF EXISTS nace;

CREATE TABLE nace (
    id int AUTO_INCREMENT PRIMARY KEY,
    order_num int,
    level bigint,
    code VARCHAR(255),
    parent VARCHAR (255),
    description varchar(255),
    item_includes varchar(4000)
);