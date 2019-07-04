function duasCasasAposVirgula(num){
    return parseFloat(Math.round(num * Math.pow(10, 2)) /Math.pow(10,2)).toFixed(2);
}
const fn = (event) => {
    
    const inputQuantidade = event.target;
    const totalProduto = $(inputQuantidade).parents('#inputRadio').find('#totalProduto');
    const preco = totalProduto.find('#preco').text();
    const quantidade = event.target.value || 0;
    const resultado = preco * quantidade;
   
    totalProduto.parents('#inputRadio').find('#resultado').text(duasCasasAposVirgula(resultado));
    const resultados = $('.resultado')

    let totalPedido = 0;
    resultados.each( (indice, campoResultado) => {
        let valor = $(campoResultado).text() || 0;
        totalPedido += parseInt(valor);
    });

    $('#valorTotal').text(duasCasasAposVirgula(totalPedido));
}
export default fn;