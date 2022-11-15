using System.ComponentModel.DataAnnotations;

namespace ApiCshrap.Models
{
    public class Atividades
    {

        [Key]
        public int AtividadesId { get; set; }
        [Required(ErrorMessage = "Informe o id da atividades")]
        [StringLength(50)]

        public string Materia { get; set; }
       
    }
}
