using Microsoft.AspNetCore.Mvc;
using Todo.Data;
using System.Threading.Tasks;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Todo.API.Controllers
{
    [Route("api/[controller]")]
    public class TasksController : Controller
    {
        private readonly TasksRepository _tasksRepository;

        public TasksController(TasksRepository tasksRepository)
        {
            _tasksRepository = tasksRepository;
        }

        // GET: api/tasks
        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var result = await _tasksRepository.GetAllTasksAsync();
            return Ok(result);
        }

        // POST api/tasks
        [HttpPost]
        public async Task<IActionResult> Post([FromBody] Models.Task task)
        {
            var result = await _tasksRepository.SaveAsync(task);
            return Ok(result);
        }

        // PUT api/tasks
        [HttpPut]
        public async Task<IActionResult> Put([FromBody] Models.Task task)
        {
            var result = await _tasksRepository.SaveAsync(task);
            return Ok(result);
        }

        // DELETE api/tasks/5
        [HttpDelete]
        public async Task<IActionResult> Delete([FromQuery]int id)
        {
            var result = await _tasksRepository.DeleteAsync(id);
            return Ok(result);
        }
    }
}
