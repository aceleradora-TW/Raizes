import Http from '../utils/Http'
const criarNovoProduto = (produto) => {
    return  $(`
    <div>
        <label class="checkbox">
            <input type="checkbox" name="produtos" value="${produto.id}">
            <span>${produto.nome}</span>
        </label>
    </div>
    `);
}

const inserirProduto = (produto, listaProdutos) => {
    const novoProduto = criarNovoProduto(produto)
    listaProdutos.append(novoProduto);


}

const  funcAparece = (event, idCategoria) => {
    const elementoClicado = $(event.target).get(0) 
    const listaProdutos = $(elementoClicado).siblings('.lista-produtos');
    const elementoQueDeveSerEscondido = $(elementoClicado).siblings('span');


    Http.get('/produtos').then(data => {
        data.forEach(produto => inserirProduto(produto, listaProdutos))
        $(elementoQueDeveSerEscondido.get(0)).fadeToggle( "slow", "linear" );
    });
}  

export default {
    aparece : funcAparece
}


