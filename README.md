# READ EXCEL FILE

## Description
This is a learning project where I process an excel file from a directory. The file is read and data are imported to a relational database. The Excel file need to be placed in the `incoming` folder and it will move to `processing` and then `completed` folders.


## To install

First step, need to clone this repo on your machine.
You need to verify there are tree folders named `incoming`, `processing` and `completed` under teaShop. If not, you need to create it. 

In the project directory run these command: 
- build the project: 
``` mvn clean install```

### Create a PostgreSQL database
You need to create a relational database such as PostgreSQL. Here is the structure of the database. 
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

## Run the project

Verify that the Excel file is present in the incoming folder!

Go to the target folder in project directory
``` cd target ```

Run the jar file which include all the dependencies
``` java -jar teaShop-1.0-SNAPSHOT-jar-with-dependencies.jar```
## Technologies && librairies
Java 17,
Maven,
Mockito,
JUnit5,
Apache POI
