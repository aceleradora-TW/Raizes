export default {
  exibeConfirmacaoDeCancelamento: () => window.Modal.warning()
    .show("Realmente deseja calcelar a edição? Os dados não serão salvos."),

  onInitEditarPedido: () => {
    const box = $('input:checked').parents('.box');
    const inputQuantidade = box.find('.js-quantidade-pedido');

    inputQuantidade.prop("disabled", false);
  }
}