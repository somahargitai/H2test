CREATE SCHEMA shopdb;

CREATE TABLE shopdb.products (

     productid SERIAL PRIMARY KEY,
     productname text,
     price integer,
     comment text   

);