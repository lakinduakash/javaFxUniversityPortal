# javaFxUniversityPortal
[![Build Status](https://travis-ci.org/lakinduakash/javaFxUniversityPortal.svg?branch=master)](https://travis-ci.org/lakinduakash/javaFxUniversityPortal)
[![DeepScan grade](https://deepscan.io/api/projects/3073/branches/24593/badge/grade.svg)](https://deepscan.io/dashboard#view=project&pid=3073&bid=24593)
## Student,Course and Staff management system example for university with javaFx and MongoDb

To run this project you need `gradle 4.4` or higher and mongodb.

### Setup database

To change database connection to your configurations edit these line in `com.ultimatex.nsbm.util.MorphiaHelper.java`
```java
datastore = morphia.createDatastore(new MongoClient(), "morphia_test"); //change database name if you want

//To have different mongoClient other than default use 
// new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
//and replace with new MongoClient()
```
### Run project

`gradle run` or `gradlew run` on linux or `gradle.bat run` in Windows

### Run tests

`gradle test` or `gradlew test` on linux or `gradle.bat test` in Windows

a
