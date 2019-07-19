export default {
  onInitEditarPedido: () => {
    const box = $('input:checked').parents('.box');
    const inputQuantidade = box.find('.js-quantidade-pedido');

    inputQuantidade.prop("disabled", false);
  },
  exibeConfirmacaoDeCancelamento: (href) => Modal
  .warning()
  .okAction("Sim", () => { window.location.href =  href })
  .cancelAction("Não")
  .show("Realmente deseja sair sem salvar a edição? Os dados não serão salvos.")
}