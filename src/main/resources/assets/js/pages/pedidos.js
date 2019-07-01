export default {
    exibeConfirmacaoDeExclusaoDoPedido: (event) => {
        const form = event.target;
        window.Modal
        .warning()
        .okAction("Sim", () => { form.submit();})
        .cancelAction("Não")
        .show('Você tem certeza que deseja excluir esta compra?');
        return false;
    }
}