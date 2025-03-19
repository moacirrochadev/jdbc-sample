CREATE TABLE employees(
    id BIGINT not null auto_increment,
    name VARCHAR(150),
    old_name VARCHAR(150),
    salary DECIMAL(10,2),
    old_salary DECIMAL(10,2),
    birthday TIMESTAMP,
    old_birthday TIMESTAMP,
    PRIMARY KEY (id)
)engine=InnoDB default charset=utf8mb4;