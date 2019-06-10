export default {
    exibeConfirmacaoDeExclusaoDaLista: (event) => {
        event.preventDefault();

        Modal
            .success()
            .okAction("Sim", () => { event.target.submit(); })
            .cancelAction("Não")
            .show('Você tem certeza que deseja excluir esta lista?')
    }
}

