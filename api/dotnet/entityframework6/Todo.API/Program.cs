using Microsoft.EntityFrameworkCore;
using Todo.Core.Data;
using Todo.Core.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddDbContextPool<MariaDbContext>(options => options
                .UseMySql(builder.Configuration.GetConnectionString("TodoDatabase"), new MariaDbServerVersion(new Version(10, 6, 5)))
            );
builder.Services.AddScoped<ITaskService, TaskService>();
builder.Services.AddControllers();

var app = builder.Build();

// Configure the HTTP request pipeline.

app.UseAuthorization();

app.MapControllers();

app.Run();
