create database if not exists device;
use device;

CREATE TABLE  if not exists device_info (
                             id BIGINT(20) NOT NULL AUTO_INCREMENT,
                             typeNo VARCHAR(255) NOT NULL,
                             price DECIMAL(10, 2) NOT NULL,
                             date DATE NOT NULL,
                             PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

desc device_info;

select * from device_info;
insert into device_info(typeNo, price, date) value ("123",145.7,"2024-1-4");
