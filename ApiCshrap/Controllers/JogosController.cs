using ApiCshrap.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace ApiCshrap.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class JogosController : ControllerBase
    {
        private readonly GenDbContext _context;

        public JogosController(GenDbContext context)
        {
            _context = context;
        }

        //POST: CRIA UM NOVO JOGO
        [HttpPost]
        public IActionResult CriarJogo(Jogos item)
        {
            if (item == null)
            {
                return BadRequest();
            }

            _context.Jogo.Add(item);
            _context.SaveChanges();
            return new ObjectResult(item);

        }

        // GET: api/Jogos - LISTA TODOS OS Jogos 
        [HttpGet]
        public IEnumerable<Jogos> GetJogos()
        {
            return _context.Jogo;
        }

        // GET: api/Jogos/id - LISTA Jogos POR ID
        [HttpGet("{id}")]
        public IActionResult GetJogosPorId(int id)
        {
            Jogos item = _context.Jogo.SingleOrDefault(modelo => modelo.JogosId == id);
            if (item == null)
            {
                return NotFound();
            }
            return new ObjectResult(item);
        }

        //PUT: ATUALIZA UM JOGO EXISTENTE
        [HttpPut("{id}")]
        public IActionResult AtualizaJogos(int id, Jogos item)
        {
            if (id != item.JogosId)
            {
                return BadRequest();
            }
            _context.Entry(item).State = EntityState.Modified;
            _context.SaveChanges();

            return new NoContentResult();
        }

        //DELETE: DELETAR UM JOGO POR ID
        [HttpDelete("{id}")]
        public IActionResult DeletaJogos(int id)
        {
            var item = _context.Jogo.SingleOrDefault(modelo => modelo.JogosId == id);

            if (item == null)
            {
                return BadRequest();
            }

            _context.Jogo.Remove(item);
            _context.SaveChanges();
            return Ok(item);
        }
    }
}
