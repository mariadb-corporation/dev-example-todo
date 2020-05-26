package com.mariadb.backend.repositories;

import java.sql.SQLException;

import com.mariadb.backend.MariaDBClient;
import com.mariadb.backend.models.Task;

import org.springframework.stereotype.Repository;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.Statement;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TasksRepository {

    public Flux<Task> findAll() {
        Connection conn = null;

        try {
            conn = MariaDBClient.getConnection();
            Statement select = conn.createStatement("select * from todo.tasks");            

            return Flux.from(select.execute())
                .flatMap(
                    res -> res.map(
                        (row, metadata) -> {
                            int id = row.get(0, Integer.class);
                            String description = row.get(1, String.class);
                            Boolean completed = row.get(2, Boolean.class);
                            return new Task(id,description,completed);
                        })
                    );
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void insert(Task task) {
        Connection conn = null;
        try {
            conn = MariaDBClient.getConnection();
            Statement insert = conn.createStatement("insert into todo.tasks (description) values (?)");            
            insert.bind(0, task.getDescription());
            Mono.from(insert.execute()).subscribe();
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            if (conn != null) {
                conn.close();//.subscribe();
            }
        }
    }

    public void update(Task task) {
        Connection conn = null;
        try {
            conn = MariaDBClient.getConnection();
            Statement update = conn.createStatement("update todo.tasks set description = ?, completed = ? where id = ?");            
            update.bind(0, task.getDescription());
            update.bind(1, task.getCompleted());
            update.bind(2, task.getId());
            Mono.from(update.execute()).subscribe();   
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void delete(int id) {
        Connection conn = null;
        try {
            conn = MariaDBClient.getConnection();
            Statement delete = conn.createStatement("delete from todo.tasks where id = ?");            
            delete.bind(0, id);
            Mono.from(delete.execute()).subscribe(); 
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}