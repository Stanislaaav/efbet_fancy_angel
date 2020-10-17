create table public.country_borders (country_border_code varchar(255) not null, country_code varchar(255) not null, country_border_name varchar(255), country_name varchar(255), primary key (country_border_code, country_code)) engine=MyISAM
create table latest_rates (pk_latest_rate bigint not null auto_increment, base varchar(255), date datetime, success bit, timestamp bigint, primary key (pk_latest_rate)) engine=MyISAM
create table latest_rates_rates (latest_rates_pk_latest_rate bigint not null, rates decimal(19,2), rates_key varchar(255) not null, primary key (latest_rates_pk_latest_rate, rates_key)) engine=MyISAM
alter table latest_rates_rates add constraint FK6ncabx024tbkb6opjn4bgb817 foreign key (latest_rates_pk_latest_rate) references latest_rates (pk_latest_rate)
create table public.country_borders (country_border_code varchar(255) not null, country_code varchar(255) not null, country_border_name varchar(255), country_name varchar(255), primary key (country_border_code, country_code)) engine=MyISAM
create table latest_rates (pk_latest_rate bigint not null auto_increment, base varchar(255), date datetime, success bit, timestamp bigint, primary key (pk_latest_rate)) engine=MyISAM
create table latest_rates_rates (latest_rates_pk_latest_rate bigint not null, rates decimal(19,2), rates_key varchar(255) not null, primary key (latest_rates_pk_latest_rate, rates_key)) engine=MyISAM
alter table latest_rates_rates add constraint FK6ncabx024tbkb6opjn4bgb817 foreign key (latest_rates_pk_latest_rate) references latest_rates (pk_latest_rate)
create table public.country_borders (country_border_code varchar(255) not null, country_code varchar(255) not null, country_border_name varchar(255), country_name varchar(255), primary key (country_border_code, country_code)) engine=MyISAM
create table latest_rates (pk_latest_rate bigint not null auto_increment, base varchar(255), date datetime, success bit, timestamp bigint, primary key (pk_latest_rate)) engine=MyISAM
create table latest_rates_rates (latest_rates_pk_latest_rate bigint not null, rates decimal(19,2), rates_key varchar(255) not null, primary key (latest_rates_pk_latest_rate, rates_key)) engine=MyISAM
alter table latest_rates_rates add constraint FK6ncabx024tbkb6opjn4bgb817 foreign key (latest_rates_pk_latest_rate) references latest_rates (pk_latest_rate)
create table public.country_borders (country_border_code varchar(255) not null, country_code varchar(255) not null, country_border_name varchar(255), country_name varchar(255), primary key (country_border_code, country_code)) engine=MyISAM
create table latest_rates (pk_latest_rate bigint not null auto_increment, base varchar(255), date datetime, success bit, timestamp bigint, primary key (pk_latest_rate)) engine=MyISAM
create table latest_rates_rates (latest_rates_pk_latest_rate bigint not null, rates decimal(19,2), rates_key varchar(255) not null, primary key (latest_rates_pk_latest_rate, rates_key)) engine=MyISAM
alter table latest_rates_rates add constraint FK6ncabx024tbkb6opjn4bgb817 foreign key (latest_rates_pk_latest_rate) references latest_rates (pk_latest_rate)
