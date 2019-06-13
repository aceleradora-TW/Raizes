export default {
    exibeConfirmacaoDeExclusaoDoPedido: (deleteItemForm) => {
        $(deleteItemForm).submit()
        return window.Modal
        .warning()
        .show('Você tem certeza que deseja excluir este pedido?')
        
    }
}