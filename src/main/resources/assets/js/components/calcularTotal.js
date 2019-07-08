function duasCasasAposVirgula(num) {
  return parseFloat(Math.round(num * Math.pow(10, 2)) / Math.pow(10, 2)).toFixed(2);
}

export default {
  totalRealizar: (event) => {

    const inputQuantidade = event.target;
    const totalProduto = $(inputQuantidade).parents('#inputRadio').find('#totalProduto');
    const preco = totalProduto.find('#preco').text();
    const quantidade = event.target.value || 0;
    const resultado = preco * quantidade;

    totalProduto.parents('#inputRadio').find('#resultado').text(duasCasasAposVirgula(resultado));
    const resultados = $('.resultado')

    let totalPedido = 0;
    resultados.each((indice, campoResultado) => {
      let valor = $(campoResultado).text() || 0;
      totalPedido += parseFloat(valor);
    });

    $('#valorTotal').text(duasCasasAposVirgula(totalPedido))
  },

  totalVisualizar: () => {
    

    const preco = $('#visualizar').find('#valor').val();
    console.log("Preco",preco);
    const quantidadePedido = $('#visualizar').find('.quantidadePedido').text();
    console.log("Quantidade",quantidadePedido);

    const precoCadaProduto = preco * quantidadePedido;
    console.log("precoCadaProduto",precoCadaProduto);
    $('#visualizar').find('.precoCadaProduto').text(parseFloat(precoCadaProduto));
    // const totalProdutor = preco * quantidadePedido;


    // console.log(totalProdutor);

    // calculo.parents('#visualizar').find('#totalProdutor').text(duasCasasAposVirgula(totalProdutor));

    const total = $('#valorTotalPedido').text("100");
    console.log("Total",total);

  }
}