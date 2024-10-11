-- Database: lab4db

-- DROP DATABASE IF EXISTS lab4db;

-- CREATE DATABASE lab4db
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'English_United Kingdom.1252'
--     LC_CTYPE = 'English_United Kingdom.1252'
--     LOCALE_PROVIDER = 'libc'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1
--     IS_TEMPLATE = False;

-- CREATE TABLE users (
--     id SERIAL PRIMARY KEY,  -- Auto-incrementing primary key
--     name VARCHAR(100) NOT NULL,  -- User's name, cannot be null
--     age INT CHECK (age >= 0)  -- User's age, must be a positive number
-- );

SELECT * FROM users;
