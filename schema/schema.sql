create table season22 (
    player_id varchar(25) not null primary key,
    pos varchar(10),
    player varchar(50),
    team varchar(10),
    pass_cmp integer,
    pass_att integer,
    pass_yds integer,
    pass_td integer,
    pass_int integer,
    rush_att integer,
    rush_yds integer,
    rush_td integer,
    targets integer,
    rec integer,
    rec_yds integer,
    rec_td integer,
    fumbles_lost integer,
	two_point_conv integer,
    total_ret_td integer,
	offensive_fumble_recovery_td integer,
    pass_rating decimal(5, 2)
);

drop table season22;

--for some reason these column values were swapped when import csv data
update season22
set two_point_conv = total_ret_td,
total_ret_td = two_point_conv;