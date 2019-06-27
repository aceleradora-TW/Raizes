export default {
    exibeConfirmacaoDeExclusaoDaLista: (event) => {      
        let form = event.target;

        window.Modal
        .warning()
        .okAction("Sim", () => { form.submit();})
        .cancelAction("Não")
        .show('Você tem certeza que deseja excluir esta lista?');
        return false;
    }
}