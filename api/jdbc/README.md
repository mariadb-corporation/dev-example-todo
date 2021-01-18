# TODO - Java Spring Boot (with JDBC) API

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

Configure the MariaDB connection with your connection details in [application.properties](src/main/resources).

Example implementation:

```
spring.datasource.url=jdbc:mariadb://localhost:3306/todo
spring.datasource.username=app_user
spring.datasource.password=Password123!
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
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
