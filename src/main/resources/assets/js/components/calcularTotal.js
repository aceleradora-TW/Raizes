function duasCasasAposVirgula(num){
    return parseFloat(Math.round(num * Math.pow(10, 2)) /Math.pow(10,2)).toFixed(2);
}
const fn = (event) => {
    console.log(event);
    var preco = parseFloat($('#preco').text());
    
    var quantidade = parseInt($('input[name=quantidade]').val()) || 0;
    var resultado = preco * quantidade;
    $('#resultado').text(duasCasasAposVirgula(resultado)); 
    
}
export default fn;


// const fn = (event) => {
//     console.log(event);
    
//     const inputQuantidade = event.target;
//     const quantidade = inputQuantidade.value() || 0;
//     const adao = $(inputQuantidade).parents('.adao');
//     var preco = adao.find('#preco').text();
    
//     var resultado = preco * quantidade;
//     $('.resultado').text(duasCasasAposVirgula(resultado,2)); 
    
// }