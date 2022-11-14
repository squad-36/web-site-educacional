using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace CsharpApi.Models
{
    [Table("Curso")]
    public class Curso
    {
        [Key]
        public int CursoId { get; set; }
        [Required(ErrorMessage = "Informe a descrição do curso")]
        [StringLength(50)]
        public string Descricao { get; set; }
        [Required(ErrorMessage = "Informe a carga horária")]
        public int CargaHoraria { get; set; }
    }
}
