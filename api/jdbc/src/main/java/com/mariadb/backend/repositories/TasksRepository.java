package com.mariadb.backend.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.mariadb.backend.MariaDBClient;
import com.mariadb.backend.models.Task;

import org.springframework.stereotype.Repository;

@Repository()
public class TasksRepository {

    public List<Task> findAll() {
        List<Task> tasks;
        try (Connection conn = MariaDBClient.getConnection()) {
            Statement stmt = conn.createStatement();            
            ResultSet rs = stmt.executeQuery("select * from todo.tasks");
            tasks = new ArrayList<Task>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("description");
                Boolean completed = rs.getBoolean("completed");
                tasks.add(new Task(id,description,completed));
            }
            stmt.close();       
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            tasks = null;
        }
        return tasks;
    }

    public void insert(Task task) {
        try (Connection conn = MariaDBClient.getConnection()) {
            PreparedStatement insert = conn.prepareStatement("insert into todo.tasks (description) values (?)");            
            insert.setString(1, task.getDescription());
            insert.executeQuery();
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Task task) {
        try (Connection conn = MariaDBClient.getConnection()) {
            PreparedStatement update = conn.prepareStatement("update todo.tasks set description = ?, completed = ? where id = ?");            
            update.setString(1, task.getDescription());
            update.setBoolean(2, task.getCompleted());
            update.setInt(3, task.getId());
            update.executeQuery();     
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(int id) {
        try (Connection conn = MariaDBClient.getConnection()) {
            PreparedStatement insert = conn.prepareStatement("delete from todo.tasks where id = ?");            
            insert.setInt(1, id);
            insert.executeQuery();     
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}