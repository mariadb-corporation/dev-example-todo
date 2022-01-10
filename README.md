# TODO

**TODO** is a web application that introduces you to the power, performance, and simplicity of [MariaDB](https://mariadb.com/products/).

<p align="center" spacing="10">
    <kbd>
        <img src="media/demo.gif" />
    </kbd>
</p>

This README will walk you through the steps for getting the TODO web application up and running using MariaDB. To ensure success, please follow the instructions in order.

**Note:** The code provided within this repository is completely open source. Please feel free to use it as you see fit.

# Table of Contents
1. [Requirements](#requirements)
2. [Getting started with MariaDB](#introduction)
3. [Getting started with the app](#get-started)
    1. [Get the code](#code)
    2. [Create the schema](#schema)
    3. [Anatomy of the app](#app)
    4. [Build and run the app](#build-run)
4. [Requirements to run the app](#requirements)
5. [Support and contribution](#support-contribution)
6. [License](#license)

## Requirements <a name="requirements"></a>

This sample application, no matter which API project you target, will requires the following to be installed/enabled on your machine:

* [MariaDB Client](https://mariadb.com/products/skysql/docs/clients/), used to connect to MariaDB instances.

## Introduction to MariaDB <a name="introduction"></a>

[MariaDB](https://mariadb.com) is a community-developed, commercially supported relational database management system, and the database you'll be using for this application.

If you don't have a MariaDB database up and running you can find more information on how to download, install and start using a MariaDB database in the [MariaDB Quickstart Guide](https://github.com/mariadb-developers/mariadb-getting-started).

## Get started <a name="get-started"></a>

In order to run the TODO application you will need to have a MariaDB instance to connect to. For more information please check out "[Get Started with MariaDB](https://mariadb.com/get-started-with-mariadb/)".

### Get the code <a name="code"></a>

Download this code directly or use [git](git-scm.org) (through CLI or a client) to retrieve the code using `git clone`:

```
$ git clone https://github.com/mariadb-corporation/dev-example-todo.git
```

### Create the schema <a name="schema"></a>

[Connect to the database](https://mariadb.com/kb/en/connecting-to-mariadb/) and execute the following SQL scripts:

```sql
CREATE DATABASE todo;

CREATE TABLE todo.tasks (
  id INT(11) unsigned NOT NULL AUTO_INCREMENT,
  description VARCHAR(500) NOT NULL,
  completed BOOLEAN NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);
```

### Anatomy of the app <a name="app"></a>

This application is made of two parts:

* Client
    - communicates with the API.
    - is a React.js project located in the [client](client) folder.
* API
    - uses a MariaDB Connector to connect to MariaDB.
    - contains multiple projects, located in the [api](api) folder.
        - [Node.js](api/nodejs)
        - [JDBC](api/jdbc)
        - [Python](api/python)
        - [R2DBC](api/r2dbc)
        - [.NET (C#)](api/dotnet/dapper) (uses a third-party, open-source MySQL connector)

See the README's in [client](client/README.md) and [api](api/README.md) for more information on how to get started!

### Build and run the app <a name="build-run"></a>

1. Navigate to the [client](client) folder and execute the following CLI command to install the package dependencies for the React.js application.

```bash
$ npm install
```

2. Pick an [API](api) project and follow the instructions of the README to build and run the API project.

3. Navigate to the [client](client) folder and execute the following CLI command to start the React.js application.

```bash 
$ npm start
``` 

## Support and Contribution <a name="support-contribution"></a>

Please feel free to submit PR's, issues or requests to this project project or projects within the [official MariaDB Corporation GitHub organization](https://github.com/mariadb-corporation).

If you have any other questions, comments, or looking for more information on MariaDB please check out:

* [MariaDB Developer Hub](https://mariadb.com/developers)
* [MariaDB Community Slack](https://r.mariadb.com/join-community-slack)

Or reach out to us diretly via:

* [developers@mariadb.com](mailto:developers@mariadb.com)
* [MariaDB Twitter](https://twitter.com/mariadb)

## License <a name="license"></a>
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=plastic)](https://opensource.org/licenses/MIT)
