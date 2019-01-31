-- https://www.hackerrank.com/challenges/revising-the-select-query/problem
-- Revising the Select Query I

select * from city where countrycode = 'USA' and population > 100000;

select name from city where countrycode = 'USA' and population > 120000;

select * from city;

select * from city where id = 1661;

select * from city where countrycode = 'JPN';

select name from city where countrycode = 'JPN';

select city, state from station;

select distinct city from station where id % 2 = 0;

select count(city) - count(distinct city) from station;

select city from station where regexp_like (city, '^[aeiouAEIOU]');

select distinct city from station where regexp_like(city, '[aeiouAEIOU]$');

select distinct city from station where regexp_like(city, '^[aeiouAEIOU].*[aeiouAEIOU]$');

select distinct city from station where not regexp_like(city, '^[aeiouAEIOU]');

select distinct city from station where not regexp_like(city, '[aeiouAEIOU]$');

select distinct city from station where not regexp_like(city, '^[aeiouAEIOU].*[aeiouAEIOU]$');

select distinct city from station where not regexp_like(city, '^[aeiouAEIOU]') and not regexp_like(city, '[aeiouAEIOU]$');


select sum(city.population) from city inner join country on city.countrycode = country.code where country.continent = 'Asia';



