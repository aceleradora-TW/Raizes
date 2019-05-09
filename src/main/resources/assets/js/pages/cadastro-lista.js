 function funcAparece(event){
     const elementoClicado = $(event.target).get(0)
     const elementoQueDeveSerEscondido = $(elementoClicado).siblings('span');
     $(elementoQueDeveSerEscondido.get(0)).toggle();
}

export default {
    aparece : funcAparece
}