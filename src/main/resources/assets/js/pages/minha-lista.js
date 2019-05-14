export default {
    excluirLista: (form) => {
        const message = `(nome da lista selecionada) \n Você deseja realmente excluir a lista selecionada?`
        const r = confirm(message);
        console.log(r);
        
        if (r) {
            console.log(form);// verificar se o form existe aqui
            form.submit();
        } else {
            return false;
        }
    },

}