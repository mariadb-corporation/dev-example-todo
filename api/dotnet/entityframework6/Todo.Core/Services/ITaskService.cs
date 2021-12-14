using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Todo.Core.Services
{
    public interface ITaskService
    {
        Task<int> DeleteAsync(int id);
        Task<IEnumerable<Models.Task>> FindAllAsync();
        Task<Models.Task> FindOneAsync(int id);
        Task<int> InsertAsync(Models.Task task);
        Task<int> UpdateAsync(Models.Task task);
    }
}
