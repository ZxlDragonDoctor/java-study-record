
use studb;
drop table if exists `scheduled`;
create table `scheduled` (
                             `cron_id` varchar(30) NOT NULL primary key,
                             `cron_name` varchar(30) NULL,
                             `cron` varchar(30) NOT NULL
);
insert into `scheduled` values ('1','定时器任务一','0/6 * * * * ?');