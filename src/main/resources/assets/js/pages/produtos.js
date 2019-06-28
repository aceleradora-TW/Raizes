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
        };
    
        const textoUnidadeMedida = seletorDeProdutos.find('option:selected');
        .querySelectorAll('.unidade-medida')
        .forEach(unidadeMedidaElement => {
          unidadeMedidaElement.text(textoUnidadeMedida)
      });
    }

}