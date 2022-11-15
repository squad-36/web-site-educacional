using System.ComponentModel.DataAnnotations;

namespace ApiCshrap.Models
{
    public class Jogos
    {
        [Key]
        public int JogosId { get; set; }
        [Required(ErrorMessage = "Informe o id do Jogo")]
        [StringLength(50)]

        public string Nome { get; set; }
        [Required(ErrorMessage = "Informe o nome do Jogo")]

        public int Pontos { get; set; }

    }
}
