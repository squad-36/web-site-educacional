using ApiCshrap.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace ApiCshrap.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class NotificacoesController : ControllerBase
    {
        private readonly GenDbContext _context;

        public NotificacoesController(GenDbContext context)
        {
            _context = context;
        }

        //POST: CRIA UMA NOVO USUARIO
        [HttpPost]
        public IActionResult CriarNotificacao(Notificacoes item)
        {
            if (item == null)
            {
                return BadRequest();
            }

            _context.Notificacao.Add(item);
            _context.SaveChanges();
            return new ObjectResult(item);

        }

        // GET: api/Notificacoes - LISTA TODOS OS NOTIFICAÇÔES 
        [HttpGet]
        public IEnumerable<Notificacoes> GetNotificacoes()
        {
            return _context.Notificacao;
        }

        // GET: api/Notificacao/id - LISTA NOTIFICACAO POR ID
        [HttpGet("{id}")]
        public IActionResult GetNotificacaoPorId(int id)
        {
            Notificacoes item = _context.Notificacao.SingleOrDefault(modelo => modelo.NotificacoesId == id);
            if (item == null)
            {
                return NotFound();
            }
            return new ObjectResult(item);
        }

        //PUT: ATUALIZA UMA NOTICACAO EXISTENTE
        [HttpPut("{id}")]
        public IActionResult AtualizaNotificacao(int id, Notificacoes item)

        {
            if (id != item.NotificacoesId)
            {
                return BadRequest();
            }
            _context.Entry(item).State = EntityState.Modified;
            _context.SaveChanges();

            return new NoContentResult();
        }

        //DELETE: DELETAR UMA NOTIFICACAO POR ID
        [HttpDelete("{id}")]
        public IActionResult DeletaNotificacao(int id)
        {
            var item = _context.Notificacao.SingleOrDefault(modelo => modelo.NotificacoesId == id);

            if (item == null)
            {
                return BadRequest();
            }

            _context.Notificacao.Remove(item);
            _context.SaveChanges();
            return Ok(item);
        }
    }
}
