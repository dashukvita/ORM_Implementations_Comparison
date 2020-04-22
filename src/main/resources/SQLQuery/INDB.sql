create table person
(
    id SERIAL PRIMARY KEY NOT NULL,
    firstName CHARACTER VARYING(20) NOT NULL,
    middleName CHARACTER VARYING(20),
    lastName CHARACTER VARYING(20) NOT NULL,
    street CHARACTER VARYING(20),
    city CHARACTER VARYING(15),
    zip CHARACTER VARYING(15),
    country CHARACTER VARYING(15),
    phone CHARACTER VARYING(15),
    email CHARACTER VARYING(20) NOT NULL,
    birthDate TIMESTAMP NOT NULL,
    joinDate TIMESTAMP,
    lastLoginDate TIMESTAMP,
    loginCount integer
);

create table personCol
(
    person_id SERIAL PRIMARY KEY NOT NULL,
    firstName CHARACTER VARYING(20) NOT NULL,
    middleName CHARACTER VARYING(20),
    lastName CHARACTER VARYING(20) NOT NULL,
    phone CHARACTER VARYING(50),
    email CHARACTER VARYING(20) NOT NULL,
    birthDate TIMESTAMP NOT NULL,
    joinDate TIMESTAMP,
    lastLoginDate TIMESTAMP,
    loginCount integer
);

create table addressCol
(
    person_id INTEGER NOT NULL,
    street CHARACTER VARYING(20),
    city CHARACTER VARYING(15),
    zip CHARACTER VARYING(15),
    country CHARACTER VARYING(15)
);

create table personOtM
(
    person_id SERIAL PRIMARY KEY NOT NULL,
    firstName CHARACTER VARYING(20) NOT NULL,
    middleName CHARACTER VARYING(20),
    lastName CHARACTER VARYING(20) NOT NULL,
    phone CHARACTER VARYING(50),
    email CHARACTER VARYING(20) NOT NULL,
    birthDate TIMESTAMP NOT NULL,
    joinDate TIMESTAMP,
    lastLoginDate TIMESTAMP,
    loginCount integer
);

create table addressOtM
(
    address_id SERIAL PRIMARY KEY NOT NULL,
    person_id INTEGER REFERENCES personOtM (person_id),
    street CHARACTER VARYING(20),
    city CHARACTER VARYING(15),
    zip CHARACTER VARYING(15),
    country CHARACTER VARYING(15)
);

create table personBase(
    id SERIAL PRIMARY KEY NOT NULL,
    firstName CHARACTER VARYING(20) NOT NULL,
    middleName CHARACTER VARYING(20),
    lastName CHARACTER VARYING(20) NOT NULL,
    dtype CHARACTER VARYING(20)
);

create table personExt(
    id SERIAL PRIMARY KEY NOT NULL,
    street CHARACTER VARYING(20),
    city CHARACTER VARYING(15),
    zip CHARACTER VARYING(15),
    country CHARACTER VARYING(15),
    phone CHARACTER VARYING(15),
    email CHARACTER VARYING(20) NOT NULL
);

create table personExtExt
(
    id SERIAL PRIMARY KEY NOT NULL,
    birthDate TIMESTAMP NOT NULL,
    joinDate TIMESTAMP,
    lastLoginDate TIMESTAMP,
    loginCount integer
);



create table simplePerson
(
    id SERIAL PRIMARY KEY NOT NULL,
    firstName CHARACTER VARYING(20) NOT NULL,
    middleName CHARACTER VARYING(20),
    lastName CHARACTER VARYING(20) NOT NULL,
    street CHARACTER VARYING(20),
    city CHARACTER VARYING(15),
    zip CHARACTER VARYING(15),
    country CHARACTER VARYING(15),
    phone CHARACTER VARYING(15),
    email CHARACTER VARYING(20) NOT NULL,
    birthDate TIMESTAMP NOT NULL,
    joinDate TIMESTAMP,
    lastLoginDate TIMESTAMP,
    loginCount integer
);

create table personIndexed
(
    id SERIAL PRIMARY KEY NOT NULL,
    firstName CHARACTER VARYING(20) NOT NULL,
    middleName CHARACTER VARYING(20),
    lastName CHARACTER VARYING(20) NOT NULL,
    street CHARACTER VARYING(20),
    city CHARACTER VARYING(15),
    zip CHARACTER VARYING(15),
    country CHARACTER VARYING(15),
    phone CHARACTER VARYING(15),
    email CHARACTER VARYING(20) NOT NULL,
    birthDate TIMESTAMP NOT NULL,
    joinDate TIMESTAMP,
    lastLoginDate TIMESTAMP,
    loginCount integer
);


