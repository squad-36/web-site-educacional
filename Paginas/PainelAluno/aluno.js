let bgAside = document.querySelector('aside');
let bgHeader = document.querySelector('header');
let btnTema = document.getElementById('btnTema');
let capa = document.querySelector('.capa');
let temaStorage = ""

btnTema.addEventListener('click' , () => {
    bgAside.classList.toggle("bg-aluno");
    bgAside.classList.toggle("bg-dark");
    bgAside.classList.toggle("text-light");
    bgHeader.classList.toggle("bg-aluno");
    bgHeader.classList.toggle("bg-dark");
    bgHeader.classList.toggle("text-light");
    capa.classList.toggle("capa-dark");

    bgAside.classList.contains("bg-dark") ? btnTema.innerHTML = "Tema claro" : btnTema.innerHTML = "Tema escuro";

});


function definesName() { 
   
    
    localStorage.setItem('Name', promptName);
    let nameSaved = localStorage.getItem('Name');
  
    
    if(!localStorage.getItem('Name') || !promptName){
        definesName();
    }else{  
        inputWriteName.innerHTML = 'Olá, Bem Vindo ' + nameSaved;
        btnMyName.innerHTML = `Não é ${nameSaved}? Click!`
    }
}

//Quando a pagina carregar Verificar se existe valor salvo no localstorage

window.addEventListener('load', function() {
    let localStorageName = localStorage.getItem('Name');
    if(localStorageName !== null){
        inputWriteName.innerHTML = 'Olá, Bem Vindo ' + localStorageName;
        btnMyName.innerHTML = `Não é ${localStorageName}? Click!`
    }
});

