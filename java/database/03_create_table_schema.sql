BEGIN TRANSACTION;

-- drop tables
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS itinerary;
DROP TABLE IF EXISTS users;

-- drop sequences
DROP SEQUENCE IF EXISTS seq_user_id;
DROP SEQUENCE IF EXISTS seq_itinerary_id;

--create sequences manually - so that you can set the value after inserting seed data
CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_itinerary_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

-- create tables
CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id') NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE itinerary (
	itinerary_id int DEFAULT nextval('seq_itinerary_id') NOT NULL,
	user_id int NOT NULL,
	name varchar(50) NOT NULL,
	itinerary_date date NOT NULL,
	PRIMARY KEY (itinerary_id),
	CONSTRAINT fk_itinerary
		FOREIGN KEY(user_id)
		REFERENCES users(user_id)
);

CREATE TABLE locations (
        location_id varchar(50) NOT NULL,
        name varchar(50) NOT NULL,
        latitude decimal NOT NULL,
        longitude decimal NOT NULL,
        itinerary_id int NOT NULL,
        address varchar(100),
        location_order int,
        PRIMARY KEY (location_id, itinerary_id),
        CONSTRAINT fk_itinerary_location
		FOREIGN KEY(itinerary_id)
		REFERENCES itinerary(itinerary_id)
		
);



-- create foreign key constraints


COMMIT TRANSACTION;
