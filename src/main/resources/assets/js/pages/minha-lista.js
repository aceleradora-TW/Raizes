export default {
    excluirLista: () => {
        const message = `Realmente deseja excluir a lista selecionada?`
        
        return confirm(message);
    },

}