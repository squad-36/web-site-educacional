using System.ComponentModel.DataAnnotations;

namespace ApiCshrap.Models
{
    public class Notificacoes
    {
        [Key]
        public int NotificacoesId { get; set; }
        [Required(ErrorMessage = "Informe o id da notificação")]
        [StringLength(50)]

        public string Mensagem { get; set; }
       

        public string Nome_notificacoes { get; set; }
    }
}
