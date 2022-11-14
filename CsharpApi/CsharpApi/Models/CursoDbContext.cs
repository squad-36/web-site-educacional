using Microsoft.EntityFrameworkCore;
using CsharpApi.Models;

namespace CsharpApi.Models
{
    public class CursoDbContext : DbContext
    {
        public CursoDbContext(DbContextOptions<CursoDbContext> options)
          : base(options)
        { }

        public DbSet<Curso> Cursos { get; set; }


    }
}
