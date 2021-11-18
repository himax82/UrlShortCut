CREATE TABLE site (
                      id SERIAL PRIMARY KEY NOT NULL,
                      name VARCHAR(2000) UNIQUE,
                      login VARCHAR(2000),
                      password VARCHAR(2000)
);

CREATE TABLE url (
                     id SERIAL PRIMARY KEY NOT NULL,
                     url VARCHAR(2000) UNIQUE,
                     code VARCHAR(2000),
                     total INT,
                     site_id INT,
                     FOREIGN KEY (site_id) REFERENCES site (id)
);