# TODO - Java Spring Boot (with R2DBC) API

- [TODO - Java Spring Boot (with R2DBC) API](#todo---java-spring-boot-with-r2dbc-api)
	- [Requirements <a name="requirements"></a>](#requirements-)
	- [Getting started with the app <a name="getting-started"></a>](#getting-started-with-the-app-)
		- [Configure the code <a name="configure-code"></a>](#configure-the-code-)
		- [Build the code <a name="build-code"></a>](#build-the-code-)
		- [Run the app <a name="run-app"></a>](#run-the-app-)

## Requirements <a name="requirements"></a>

This sample was created using the following techologies and they must be installed before proceeding.

* [Java 8+](https://www.java.com/en/download/)
* [Maven v.3+](https://maven.apache.org/)

## Getting started with the app <a name="getting-started"></a>

### Configure the code <a name="configure-code"></a>

Configure the MariaDB connection by [changing the application.properties file](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html) from the folder [resources folder](src/main/resources).

Example implementation:

```
spring.r2dbc.url=r2dbc:mariadb://example.skysql.net:5001/todo
spring.r2dbc.username=DB00000001
spring.r2dbc.password=****************
spring.r2dbc.properties.sslMode=VERIFY_CA
spring.r2dbc.properties.serverSslCert=classpath:static/skysql_chain.pem
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
$ java -jar target/todo-r2dbc.jar
```

The following steps also exist within the ["Build and run"](../../#build-and-run-the-app-) section of the root README, and are for startin the React.js project once this API project has been started.

2. Navigate to the [../../client](client) folder and execute the following CLI command to start the React.js application.

```bash 
$ npm install
$ npm start
```

3. Open a browser window and navigate to http://localhost:3000.
