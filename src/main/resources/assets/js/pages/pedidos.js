export default {
    exibeConfirmacaoDeExclusaoDoPedido: () => {
        var seExcluiu = false;
        seExcluiu = confirm("Deseja excluir a compra selecionada?");
        if(seExcluiu == true){        
        }else {
            return false;
        }
    }
}

