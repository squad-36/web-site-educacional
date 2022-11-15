using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using ApiCshrap.Models;

namespace ApiCshrap.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsuariosController : ControllerBase
    {
        private readonly GenDbContext _context;

        public UsuariosController(GenDbContext context)
        {
            _context = context;
        }

        //POST: CRIA UMA NOVO USUARIO
        [HttpPost]
        public IActionResult CriarUsuario(Usuarios item)
        {
            if (item == null)
            {
                return BadRequest();
            }

            _context.Usuario.Add(item);
            _context.SaveChanges();
            return new ObjectResult(item);

        }

        // GET: api/Usuarios - LISTA TODOS OS USUARIOS 
        [HttpGet]
        public IEnumerable<Usuarios> GetUsuarios()
        {
            return _context.Usuario;
        }

        // GET: api/Usuario/id - LISTA Usuario POR ID
        [HttpGet("{id}")]
        public IActionResult GetUsuariosPorId(int id)
        {
            Usuarios item = _context.Usuario.SingleOrDefault(modelo => modelo.UsuarioId == id);
            if (item == null)
            {
                return NotFound();
            }
            return new ObjectResult(item);
        }

        //PUT: ATUALIZA UM USUARIO EXISTENTE
        [HttpPut("{id}")]
        public IActionResult AtualizaUsuario(int id, Usuarios item)
        {
            if (id != item.UsuarioId)
            {
                return BadRequest();
            }
            _context.Entry(item).State = EntityState.Modified;
            _context.SaveChanges();

            return new NoContentResult();
        }

        //DELETE: DELETAR UMA Usuario POR ID
        [HttpDelete("{id}")]
        public IActionResult DeletaUsuario(int id)
        {
            var item = _context.Usuario.SingleOrDefault(modelo => modelo.UsuarioId == id);

            if (item == null)
            {
                return BadRequest();
            }

            _context.Usuario.Remove(item);
            _context.SaveChanges();
            return Ok(item);
        }

    }
}
