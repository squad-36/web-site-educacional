let entrar = document.getElementById("entrar")

let select = document.getElementById('opcao')

select.addEventListener('change', () => {
    let idUsuario = select.value;
    
     if(idUsuario == 1){
         location.href = "../../Paginas/PainelAluno/aluno.html";
     }else if(idUsuario == 2){
         location.href = "../../Paginas/PainelProfessor/professor.html";
     }else if(idUsuario == 3){
         location.href = "../../Paginas/PainelPais/pais.html";
     }else{
         alert("escolha um identificador");
     } 
 
 });
