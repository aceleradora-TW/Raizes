export default {
    exibeConfirmacaoDeExclusaoDaLista: (deleteItemForm) => {
        $(deleteItemForm).submit()
        return window.onload = function() {
            window.Modal
            .success()
            .okAction("Ok")
            .show('Você tem certeza que deseja excluir esta lista?')
          };                
    }
}