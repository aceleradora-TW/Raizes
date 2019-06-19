export default {
  atualizaUnidadeMedida: (e) => {
    console.log(e);
    const seletorDeProdutos = $('#seletorDeProdutos');
    
    if(seletorDeProdutos.get().length < 1) {
      return;
    }

    const opcaoSelecionada = seletorDeProdutos.find('option:selected');
    const unidadeMedidaElement = $('#unidadeMedida');
    const unidadeMedida = opcaoSelecionada.attr('data-unidade-medida'); 

    unidadeMedidaElement.text(unidadeMedida);
  }
}
