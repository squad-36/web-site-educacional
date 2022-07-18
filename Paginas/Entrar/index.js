let entrar = document.getElementById("entrar")

let select = document.getElementById('opcao')

select.addEventListener('change', () => {
    let idUsuario = select.value;
    
     if(idUsuario == 1){
         location.href = "../../Paginas/PainelAluno/index.html";
     }else if(idUsuario == 2){
         location.href = "../../Paginas/PainelProfessor/index.html";
     }else if(idUsuario == 3){
         location.href = "../../Paginas/PainelPais/index.html";
     }else{
         alert("escolha um identificador");
     } 
 
 });
