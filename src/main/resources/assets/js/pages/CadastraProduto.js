export default{
    atualizaUnidadeMedida: () => {
        const seletorDeProdutos = $('#seletorDeProdutos');

        if(seletorDeProdutos.get().length < 1){
            return;
        }

        const opcaoSelecionada = seletorDeProdutos.find('option:selected');
        const unidadeMedida = $('#unidadeMedida');

        unidadeMedida.text(opcaoSelecionada.data('unidade-medida'));
    }
}