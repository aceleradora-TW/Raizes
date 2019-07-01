function duasCasasAposVirgula(num){
    return parseFloat(Math.round(num * Math.pow(10, 2)) /Math.pow(10,2)).toFixed(2);
}
const fn = (event) => {

    const inputQuantidade = event.target;
    const totalProduto = $(inputQuantidade).parents('#totalProduto');

    const preco = totalProduto.find('#preco').text();
    
    const quantidade = event.target.value || 0;

    const resultado = preco * quantidade;
    
    totalProduto.find('#resultado').text(duasCasasAposVirgula(resultado));
    const resultados = $('.resultado')

    let totalPedido = 0;
    resultados.each( (i, e) => {
        let v = $(e).text() || 0;
        totalPedido += +v;
    });

    $('#valorTotal').text(duasCasasAposVirgula(totalPedido));
}
export default fn;