export default {
    excluirLista: (form) => {
    
        if (confirm(`(nome da lista selecionada) \n Você deseja realmente excluir a lista selecionada?`)) {
            form.submit();
        } else {
            
        }
    },

}