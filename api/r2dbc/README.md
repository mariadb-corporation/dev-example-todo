# TODO - Java Spring Boot (with R2DBC) API

1. [Requirements](#requirements)
2. [Getting started with the app](#getting-started)
    1. [Configure the code](#configure-code)
    2. [Build the code](#build-code)
    3. [Run the app](#run-app)

## Requirements <a name="requirements"></a>

This sample was created using the following techologies and they must be installed before proceeding.

* [Java 8+](https://www.java.com/en/download/)
* [Maven v.3+](https://maven.apache.org/)

## Getting started with the app <a name="getting-started"></a>

### Configure the code <a name="configure-code"></a>

Configure the MariaDB connection by [changing a application.properties file to the Java project](https://docs.oracle.com/javase/tutorial/essential/environment/properties.html) from the folder [resources folder](src/main/resources).

Example implementation:

```
spring.r2dbc.url=r2dbc:mariadb://sky000XXX.mdb000XXXX.db.skysql.net:5002/todo?sslMode=ENABLE_TRUST
spring.r2dbc.username=DB0000XXXX
spring.r2dbc.password=*************
spring.r2dbc.pool.initial-size=5
spring.r2dbc.pool.max-size=10
spring.r2dbc.pool.max-idle-time=30m
```

### Build the code <a name="build-code"></a>

Once you have retrieved a copy of the code you're ready to build and run the project! 

Build the project by executing the following CLI command:

```
$ mvn package
```

### Run the app <a name="run-app"></a>

Once you've pulled down the code and have verified built the project you're ready to run the application! 

1. Execute the following CLI command 

```bash
$ mvn spring-boot:run
```

The following steps also exist within the ["Build and run"](../../#build-and-run-the-app-) section of the root README, and are for startin the React.js project once this API project has been started.

2. Navigate to the [../../client](client) folder and execute the following CLI command to start the React.js application.

```bash 
$ npm install
$ npm start
```

3. Open a browser window and navigate to http://localhost:3000.
