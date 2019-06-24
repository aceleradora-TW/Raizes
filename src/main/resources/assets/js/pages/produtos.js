export default {
    exibeConfirmacaoDeCancelamento: (href) => Modal
    .warning()
    .okAction("Sim", () => { window.location.href =  href })
    .cancelAction("Não")
    .show("Realmente deseja sair sem salvar o pedido? Os dados não serão salvos."),

    exibeConfirmacaoDeSucesso: (href) => Modal
    .warning()
    .okAction("Sim", () => { window.location.href =  href })
    .cancelAction("Não")
    .show("jlkj")




}
