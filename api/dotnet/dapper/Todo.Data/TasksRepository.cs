using System;
using System.Collections.Generic;
using System.Data;
using System.Threading.Tasks;
using Dapper;
using Microsoft.Extensions.Options;
using MySqlConnector;
using Todo.Core.Data;

namespace Todo.Data
{
    public class TasksRepository : IDisposable
    {
        private readonly IDbConnection _db;

        public TasksRepository(IOptions<ConnectionStrings> connectionStrings)
        {
            _db = new MySqlConnection(connectionStrings.Value.TodoDatabase);
        }

        public void Dispose()
        {
            _db.Close();
        }

        public Task<IEnumerable<Models.Task>> GetAllTasksAsync()
        {
            return _db.QueryAsync<Models.Task>("SELECT * FROM tasks");
        }

        public Task<int> SaveAsync(Models.Task task)
        {
            if (task.Id.HasValue)
            {
                string update = @"UPDATE tasks SET description = @Description, completed = @Completed WHERE id = @Id";
                return _db.ExecuteAsync(update, new { task.Description, task.Completed, task.Id });
            }
            else
            {
                string insert = @"INSERT INTO tasks (description) VALUES (@Description)";
                return _db.ExecuteAsync(insert, new { task.Description });
            }
        }

        public Task<int> DeleteAsync(int taskId)
        {
            string delete = @"DELETE FROM tasks WHERE id = @Id";
            return _db.ExecuteAsync(delete, new { Id = taskId });
        }
    }
}
