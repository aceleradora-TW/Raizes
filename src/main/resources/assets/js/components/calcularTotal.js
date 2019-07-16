function duasCasasAposVirgula(num) {
  return parseFloat(Math.round(num * Math.pow(10, 2)) / Math.pow(10, 2)).toFixed(2);
}

export default {
  calculaInicio: () => {
   $('.js-quantidade-pedido:enabled').each(function(index, element) {
        const event = document.createEvent("HTMLEvents");
        event.initEvent("change", false, true);

       element.dispatchEvent(event);
   });
  },

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
  totalEditar: (event) => {

    const inputQuantidade = event.target;
    const totalProduto = $(inputQuantidade).parents('#inputRadio').find('#totalProduto');
    const preco = totalProduto.find('#preco').text();
    const quantidade = event.target.value || 0;
    const resultado = preco * quantidade;

    totalProduto.parents('#inputRadio').find('#resultado').text(duasCasasAposVirgula(resultado));
    const resultados = $('.resultado')
    console.log("resultados",resultados);

    let totalPedido = 0;
    resultados.each((indice, campoResultado) => {
      let valor = $(campoResultado).text() || 0;
      console.log("valor",valor);
      totalPedido += parseFloat(valor);
    });


    $('#valorTotal').text(duasCasasAposVirgula(totalPedido))
  },

  totalEditar: (event) => {

    const inputQuantidade = event.target;
    const totalProduto = $(inputQuantidade).parents('#inputRadio').find('#totalProduto');
    const preco = totalProduto.find('#preco').text();
    const quantidade = event.target.value || 0;
    const resultado = preco * quantidade;

    totalProduto.parents('#inputRadio').find('#resultado').text(duasCasasAposVirgula(resultado));
    const resultados = $('.resultado')
    console.log("resultados",resultados);


    let totalPedido = 0;
    resultados.each((indice, campoResultado) => {
      let valor = ($(campoResultado).text() || "").trim()|| 0;
      console.log("valor", valor);
      console.log("valoooooor", '"' + valor + '"');
    //   console.log("campoResultado",campoResultado);
      totalPedido += parseFloat(valor);
      console.log("totalPedido1",totalPedido);
    });

    $('#valorTotal').text(duasCasasAposVirgula(totalPedido))
    console.log("totalPedido",totalPedido);
  }

}