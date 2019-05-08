export default {
    excluirLista: (txt) => {
        if (confirm(`${txt} \n Você deseja realmente excluir a lista selecionada?`)) {
            alert("Item excluído com sucesso.");
        } else {

        }
    },
}