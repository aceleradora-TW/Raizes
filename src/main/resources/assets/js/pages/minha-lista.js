export default {
    exibeConfirmacaoDeExclusaoDaLista: (deleteItemForm) => {
        $(deleteItemForm).submit()
        return window.onload = function() {
            window.Modal
            .success()
            .okAction("Sim", () => {$(deleteItemForm).submit()})
            .cancelAction("Não")
            .show('Você tem certeza que deseja excluir esta lista?')
          };                
    }
}