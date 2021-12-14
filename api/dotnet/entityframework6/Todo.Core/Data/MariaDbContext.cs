using Microsoft.EntityFrameworkCore;

namespace Todo.Core.Data
{
    public partial class MariaDbContext : DbContext
    {
        public MariaDbContext(DbContextOptions<MariaDbContext> options)
            : base(options)
        { }

        public virtual DbSet<Models.Task>? Tasks { get; set; }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            builder.Entity<Models.Task>(b =>
            {
                b.ToTable("tasks");
            });
        }
    }
}