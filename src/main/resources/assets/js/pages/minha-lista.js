export default {
    exibeConfirmacaoDeExclusaoDaLista: (deleteItemForm) => {
        $(deleteItemForm).submit()
        return window.Modal
        .warning()
        .show('Você tem certeza que deseja excluir esta lista?')
        
    }
}