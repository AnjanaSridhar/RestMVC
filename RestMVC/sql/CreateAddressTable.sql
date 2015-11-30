create table Address(id int AUTO_INCREMENT, house_number int(4) not null  , person_id int(4) REFERENCES Person(person_id), 
streetname varchar(30), city varchar(30), primary key(id));