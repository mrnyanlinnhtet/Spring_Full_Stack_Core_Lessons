
CREATE TABLE IF NOT EXISTS categories(
  id INT GENERATED BY DEFAULT AS IDENTITY (START WITH 1)  PRIMARY KEY NOT NULL,
  name VARCHAR(20) UNIQUE NOT NULL
);


CREATE TABLE IF NOT EXISTS products(

  id INT GENERATED BY DEFAULT AS IDENTITY (START WITH 1)  PRIMARY KEY NOT NULL,
  category_id INT NOT NULL,
  name VARCHAR(40) NOT NULL,
  price INT,
  FOREIGN KEY (category_id) REFERENCES categories(id)
);