export default {
  exibeConfirmacaoDeCancelamento: (href) => Modal
  .warning()
  .okAction("Sim", () => { window.location.href =  href })
  .cancelAction("Não")
  .show("Realmente deseja cancelar? Os dados não serão salvos.")
}