# TODO - C++ Console Application

The [task.cpp](task.cpp) file can be used (via C++ compiler) to build an executable that can perform create-read-update-delete (CRUD) operations on a target MariaDB database using MariaDB's C++ connector.

## Requirements <a name="requirements"></a>

This sample was created using the following techologies and they must be installed before proceeding.

* [MariaDB Connector/C++](https://mariadb.com/docs/appdev/connector-cpp/)

## Configure the code <a name="configure-code"></a>

Within the [tasks.cpp](tasks.cpp) file, navigate to the `main` method and add your database connection values.

Example implementation:

```cpp
sql::SQLString url("jdbc:mariadb://localhost:3306/todo");
sql::Properties properties({{"user", "app_user"}, {"password", "Password123!"}});
```

## Run the app <a name="run-app"></a>

Once you've pulled down and configured the code, you're ready to build and run the application! 

1. Build [tasks.cpp](tasks.cpp) to produce an executable called `tasks`.

```bash
$ g++ -o tasks tasks.cpp -std=c++11 -lmariadbcpp
```

2. Perform CRUD operations using the `tasks` executable.

    a. **Insert** a new task record.

    ```
    $ ./tasks addTask 'New Task Description'
    ```

    b. **Update** a task's completion status.

    ```
    $ ./tasks updateTaskStatus 1 1
    ```

    c. **Select** and print all tasks.

    ```
    $ ./tasks showTasks
    ```

    d. **Delete** a task record.

    ```
    $ ./tasks deleteTask 1
    ```
