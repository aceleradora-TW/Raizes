function duasCasasAposVirgula(num){
    return parseFloat(Math.round(num * Math.pow(10, 2)) /Math.pow(10,2)).toFixed(2);
}
const fn = (event) => {
    
    const inputQuantidade = event.target;
    console.log("inputQuantidade", inputQuantidade);
    const totalProduto = $(inputQuantidade).parents('#inputRadio').find('#totalProduto');
    console.log("totalProduto", totalProduto);
    const preco = totalProduto.find('#preco').text();
    console.log("preco", preco);

    const quantidade = event.target.value || 0;
    console.log("quantidade", quantidade);
    
    const resultado = preco * quantidade;
    console.log("resultado", resultado);
    
    totalProduto.parents('#inputRadio').find('#resultado').text(duasCasasAposVirgula(resultado));
    const resultados = $('.resultado')

    let totalPedido = 0;
    resultados.each( (i, e) => {
        let v = $(e).text() || 0;
        totalPedido += +v;
    });

    $('#valorTotal').text(duasCasasAposVirgula(totalPedido));
}

export default fn;