DROP TABLE IF EXISTS place;

CREATE TABLE place (
  id 			INT NOT NULL AUTO_INCREMENT,
  name			VARCHAR(255) NOT NULL,
  type_id		INT NOT NULL,
  coordinate	POINT,
  PRIMARY KEY (id),
  FOREIGN KEY (type_id) REFERENCES place_type(id)
);