using Microsoft.AspNetCore.Mvc;
using Todo.Core.Services;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Todo.API.Controllers
{
    [Route("api/[controller]")]
    public class TasksController : Controller
    {
        private readonly ITaskService _taskService;

        public TasksController(ITaskService taskService)
        {
            _taskService = taskService;
        }

        // GET: api/tasks
        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var result = await _taskService.FindAllAsync();
            return Ok(result);
        }

        // POST api/tasks
        [HttpPost]
        public async Task<IActionResult> Post([FromBody] Core.Models.Task task)
        {
            var result = await _taskService.InsertAsync(task);
            return Ok(result);
        }

        // PUT api/tasks
        [HttpPut]
        public async Task<IActionResult> Put([FromBody] Core.Models.Task task)
        {
            var result = await _taskService.UpdateAsync(task);
            return Ok(result);
        }

        // DELETE api/tasks?id=5
        [HttpDelete]
        public async Task<IActionResult> Delete([FromQuery] int id)
        {
            var result = await _taskService.DeleteAsync(id);
            return Ok(result);
        }
    }
}
