# TODO - .NET 6 (C#) Web API project using Entity Framework 6 & MySQLConnector

This .NET solution uses [MySqlConnector](https://github.com/mysql-net/MySqlConnector) in combination with the [Pomelo.EntityFramework.Core v.6.0.0.0](https://github.com/PomeloFoundation/Pomelo.EntityFrameworkCore.MySql) and [Entity Framework 6](https://docs.microsoft.com/en-us/ef/) Object Mapping library to connect to and communicate to a MariaDB database instance.

1. [Requirements](#requirements)
2. [Getting started with the app](#getting-started)
    1. [Configure the code](#configure-code)
    3. [Build and run the app](#run-app)

## Requirements <a name="requirements"></a>

This sample was created using the following techologies and they must be installed before proceeding.

* [Visual Studio](https://visualstudio.microsoft.com/vs/)
 
## Getting started with the app <a name="getting-started"></a>

First, open [Todo.sln](Todo.sln) in Visual Studio.

### Configure the code <a name="configure-code"></a>

Configure the MariaDB connection with **your** connection details in [appsettings.json](Todo.API/appsettings.json) file.

Example implementation:

```json
{
  "Logging": {
    "LogLevel": {
      "Default": "Information",
      "Microsoft": "Warning",
      "Microsoft.Hosting.Lifetime": "Information"
    }
  },
  "ConnectionStrings": {
    "TodoDatabase": "host=localhost;port=3306;user id=root;password=Password123!;database=todo;"
  },
  "AllowedHosts": "*"
}
```

### Run the app <a name="run-app"></a>

Once you've pulled down the code and have verified built the project you're ready to run the application! 

1. Build and run the application using Visual Studio. The solution will be built and the Web API project will begin listening on http://localhost:8080.

2. Within the terminal, navigate to the [client](../../../client) folder and execute the following CLI command to start the React.js application.

```bash 
$ npm install
$ npm start
```

3. Open a browser window and navigate to http://localhost:3000 (which will load the TODO application web UI).
