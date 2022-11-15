using Microsoft.EntityFrameworkCore;

namespace ApiCshrap.Models
{
    public class GenDbContext : DbContext

    {
        public GenDbContext(DbContextOptions<GenDbContext>options)
            : base(options) { }     

        public DbSet<Atividades> Atividade { get; set; }

        public DbSet<Notificacoes> Notificacao { get; set; }

        public DbSet<Jogos> Jogo { get; set; }

        public DbSet<Usuarios> Usuario { get; set; }

    }
}
