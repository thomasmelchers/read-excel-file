# READ EXCEL FILE

## Description
This is a learning project where I process an excel file from a directory. The file is read and data are imported to a relational database. The Excel file need to be placed in the `incoming` folder and it will move to `processing` and then `completed` folders.


## To install

### Create a PostgreSQL database
```
   CREATE TABLE sales (
    id SERIAL PRIMARY KEY,
    tea_name VARCHAR(100),
    tea_origin VARCHAR(100),
    customer VARCHAR(100),
    quantity NUMERIC,
    price NUMERIC,
    total NUMERIC
);

```

### application.properties file
Need to create an `application.properties` file in `src/main/resources` folder
In this file, you need to add these properties and fill the blank. 

  directory.incoming=
  directory.processing=
  directory.completed=
  postgres.database=
  postgres.username=
  postgres.password=

## Technologies
Java 17
Maven
Mockito
JUnit5
