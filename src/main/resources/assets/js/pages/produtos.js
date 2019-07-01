export default {
    exibeConfirmacaoDeCancelamento: (href) => Modal
    .warning()
    .okAction("Sim", () => { window.location.href =  href })
    .cancelAction("Não")
    .show("Realmente deseja sair sem salvar o pedido? Os dados não serão salvos."),
    
    atualizaUnidadeMedida: (e) => {
      const seletorDeProdutos = $('#seletorDeProdutos');

      if(seletorDeProdutos.get().length < 1) {
        return;
      }

      const opcaoSelecionada = seletorDeProdutos.find('option:selected');
      const unidadeMedidaElement = $('.unidadeMedida');
      const unidadeMedida = opcaoSelecionada.attr('data-unidade-medida'); 

      unidadeMedidaElement.text(unidadeMedida);

      const textoUnidadeMedida = seletorDeProdutos.find('option:selected');
    
      document
          .querySelectorAll('.unidade-medida')
          .forEach(unidadeMedidaElement => {
              unidadeMedidaElement.text(textoUnidadeMedida)
          })
  }

}