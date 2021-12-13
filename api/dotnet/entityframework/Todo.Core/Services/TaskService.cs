using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Todo.Core.Data;

namespace Todo.Core.Services
{
    public sealed class TaskService : ITaskService
    {
        private readonly MariaDbContext _dbContext;

        public TaskService(MariaDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public async Task<int> DeleteAsync(int id)
        {
            try
            {
                _dbContext.Tasks.Remove(
                    new Models.Task
                    {
                        Id = id
                    }
                );

                return await _dbContext.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                return 0;
            }
        }

        public async Task<IEnumerable<Models.Task>> FindAllAsync()
        {
            return await _dbContext.Tasks.ToListAsync();
        }

        public async Task<Models.Task> FindOneAsync(int id)
        {
            return await _dbContext.Tasks.FirstOrDefaultAsync(x => x.Id == id);
        }

        public async Task<int> InsertAsync(Models.Task task)
        {
            _dbContext.Add(task);
            return await _dbContext.SaveChangesAsync();
        }

        public async Task<int> UpdateAsync(Models.Task task)
        {
            try
            {
                _dbContext.Update(task);
                return await _dbContext.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                return 0;
            }
        }
    }
}
