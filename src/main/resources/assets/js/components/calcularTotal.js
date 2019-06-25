function duasCasasAposVirgula(num){
    return parseFloat(Math.round(num * Math.pow(10, 2)) /Math.pow(10,2)).toFixed(2);
}
const fn = (event) => {
    console.log(event);

    const inputQuantidade = event.target;
    const totalProduto = $(inputQuantidade).parents('#totalProduto');

    console.log(totalProduto);

    const preco = totalProduto.find('#preco').text();
    
    const quantidade = event.target.value || 0;
    const resultado = preco * quantidade;
    $('#resultado').text(duasCasasAposVirgula(resultado)); 
    
}
export default fn;


// const fn = (event) => {
//     console.log(event);
    
//     const inputQuantidade = event.target;
//     const quantidade = inputQuantidade.value() || 0;
//     const totalProduto = $(inputQuantidade).parents('.totalProduto');
//     var preco = totalProduto.find('#preco').text();
    
//     var resultado = preco * quantidade;
//     $('.resultado').text(duasCasasAposVirgula(resultado,2)); 
    
// }