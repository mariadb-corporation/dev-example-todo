# TODO - Python API

1. [Requirements](#requirements)
2. [Getting started with the app](#getting-started)
    1. [Configure the code](#configure-code)
    2. [Set up and activate a virtual environment](#activate)
    3. [Install packages](#install-packages)
    4. [Run the app](#run-app)

## Requirements <a name="requirements"></a>

This sample was created using the following techologies and they must be installed before proceeding.

* [Python (v, 3+)](https://www.python.org/downloads/)
* [MariaDB Connector/C (v. 3.1.5+)](https://mariadb.com/products/skysql/docs/clients/mariadb-connector-c-for-skysql-services/)

## Getting started with the app <a name="getting-started"></a>

### Configure the code <a name="configure-code"></a>

Configure the MariaDB connection by adding an [.env file](https://pypi.org/project/python-dotenv/) to the project within the root folder.

Example implementation:

```
DB_HOST=<host_address>
DB_PORT=<port_number>
DB_USER=<username>
DB_PASS=<password>
DB_NAME=todo
```

**Configuring db.js**

The environmental variables from `.env` are used within the [db.js](src/db.js) for the MariaDB Node.js Connector configuration pool settings:

```python
config = {
    'host': os.getenv("DB_HOST"),
    'port': int(os.getenv("DB_PORT")),
    'user': os.getenv("DB_USER"),
    'password': os.getenv("DB_PASS"),
    'database': os.getenv("DB_NAME")
}
```

**Configuring .env and tasks.py for the MariaDB cloud database service [SkySQL](https://mariadb.com/products/skysql/)**

Note: MariaDB SkySQL requires SSL additions to connection. Details coming soon!

### Set up and activate a virtual environment <a name="activate"></a>

A virtual environment is a directory tree which contains Python executable files and other files which indicate that it is a virtual environment. Basically, it's the backbone for running your Python Flask app.

Creation of [virtual environments](https://docs.python.org/3/library/venv.html?ref=hackernoon.com#venv-def) is done by executing the following command:

```
$ pyvenv venv
```

**Tip**: Tip: pyvenv is only available in Python 3.4 or later. For older versions please use the [virtualenv](https://virtualenv.pypa.io/en/latest/) tool. 

Before you can start installing or using packages in your virtual environment, you’ll need to activate it. Activating a virtual environment will put the virtual environment-specific python and pip executables into your shell’s PATH.

Activate the virtual environment using the following command:

```bash
$ . venv/bin/activate activate
```

### Install packages <a name="install-packages"></a>

[Flask](https://flask.palletsprojects.com/en/1.1.x/?ref=hackernoon.com) is a micro web framework written in Python. It is classified as a [microframework](https://en.wikipedia.org/wiki/Microframework) because it does not require particular tools or libraries. 

**TL;DR** It's what this app uses for the API.

This app also uses the MariaDB Python Connector to connect to and communicate with MariaDB databases. 

Install the necessary packages.

```bash
$ pip3 install flask
$ pip3 install mariadb
```

### Run the app <a name="run-app"></a>

Once you've pulled down the code and have verified that all of the required packages are installed you're ready to run the application! 

1. Execute the following CLI command to start the Python Flask API

```bash
$ python3 api.py
```

The following steps also exist within the ["Build and run"](../../#build-and-run-the-app-) section of the root README, and are for startin the React.js project once this API project has been started.

2. Navigate to the [../../client](client) folder and execute the following CLI command to start the React.js application.

```bash 
$ npm start
```

3. Open a browser window and navigate to http://localhost:3000.
