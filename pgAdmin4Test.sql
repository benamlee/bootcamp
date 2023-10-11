drop table finnhub_stocks;
create table finnhub_stocks (
	id BIGSERIAL PRIMARY KEY,
	country varchar(2) not null,
	company_name varchar(100) not null,
	ipo_date date not null,
	logo varchar(200),
	currency varchar(3) not null,
	market_cap numeric(15,2) not null
)

drop table finnhub_stock_prices;
create table finnhub_stock_prices (
	id BIGSERIAL PRIMARY KEY,
	stock_id integer REFERENCES finnhub_stocks(id),
	datetime TIMESTAMP not null,
	current_price numeric(15,2) not null,
	day_high numeric(15,2) not null,
	day_low numeric(15,2) not null,
	day_open numeric(15,2) not null,
	prev_day_close numeric(15,2) not null
)

SELECT * FROM FINNHUB_STOCKS;
SELECT * FROM FINNHUB_STOCK_PRICES;


select * from finnhub_company_profile;

select * from finnhub_stock_prices;

select * from finnhub_stock_symbols;

drop table finnhub_stock_prices;

drop table finnhub_company_profile;

drop table finnhub_stock_symbols;
