DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id 			INT NOT NULL AUTO_INCREMENT,
  username 		VARCHAR(255) NOT NULL,
  firstname 	VARCHAR(255),
  lastname 		VARCHAR(255),
  email 		VARCHAR(255) NOT NULL,
  place_id 		INT,
  PRIMARY KEY (id),
  FOREIGN KEY (place_id) REFERENCES place(id),
  UNIQUE (email)
);