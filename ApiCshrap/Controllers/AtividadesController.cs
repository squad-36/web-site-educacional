using ApiCshrap.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace ApiCshrap.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AtividadesController : ControllerBase
    {
        private readonly GenDbContext _context;

        public AtividadesController(GenDbContext context)
        {
            _context = context;
        }

        //POST: CRIA UMA NOVA Atividades
        [HttpPost]
        public IActionResult CriarAtividades(Atividades item)
        {
            if (item == null)
            {
                return BadRequest();
            }

            _context.Atividade.Add(item);
            _context.SaveChanges();
            return new ObjectResult(item);

        }

        // GET: api/Atividades - LISTA TODAS AS ATIVIDADES 
        [HttpGet]
        public IEnumerable<Atividades> GetAtividades()
        {
            return _context.Atividade;
        }

        // GET: api/Atividades/id - LISTA Atividades POR ID
        [HttpGet("{id}")]
        public IActionResult GetAtividadesPorId(int id)
        {
            Atividades item = _context.Atividade.SingleOrDefault(modelo => modelo.AtividadesId == id);
            if (item == null)
            {
                return NotFound();
            }
            return new ObjectResult(item);
        }

        //PUT: ATUALIZA UMA ATIVIDADES EXISTENTE
        [HttpPut("{id}")]
        public IActionResult AtualizaAtividades(int id, Atividades item)
        {
            if (id != item.AtividadesId)
            {
                return BadRequest();
            }
            _context.Entry(item).State = EntityState.Modified;
            _context.SaveChanges();

            return new NoContentResult();
        }

        //DELETE: DELETAR UMA Atividades POR ID
        [HttpDelete("{id}")]
        public IActionResult DeletaAtividades(int id)
        {
            var item = _context.Atividade.SingleOrDefault(modelo => modelo.AtividadesId == id);

            if (item == null)
            {
                return BadRequest();
            }

            _context.Atividade.Remove(item);
            _context.SaveChanges();
            return Ok(item);
        }
    }
}
