export default {
    exibeConfirmacaoDeExclusaoDaLista: (deleteItemForm) => {
        const Form = $(deleteItemForm)[0];
        window.Modal
        .success()
        .okAction("Sim", () => { Form.submit();})
        .cancelAction("Não")
        .show('Você tem certeza que deseja excluir esta lista?');
        return false;
    }
}