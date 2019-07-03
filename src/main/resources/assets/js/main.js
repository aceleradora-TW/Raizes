window.$ = window.jQuery = require('jquery')
import '../../../../../node_modules/inputmask/dist/inputmask/jquery.inputmask';
// import '../../../../../node_modules/jquery-maskmoney/dist/jquery.maskMoney';
import '@fortawesome/fontawesome-free/js/all';
import 'animate.css'
import '../scss/styles.scss'
import '@fengyuanchen/validator';
import CriarLista from './pages/criaLista'
import EditarLista from './pages/editaLista'
import MinhasListas from './pages/minhaLista'
import RealizarPedido from './pages/realizaPedido'
import Pedidos from './pages/pedidos'
import Pedido from './pages/pedido'
import Modal from './components/modal'
import Burger from './components/menu-burger'
import EditarPedido from './pages/editaPedido'
import Produtos from './pages/produtos'
import EditaProdutoEstoque from './pages/editaProdutoEstoque'
import Calcular from './components/calcularTotal'
import validaCadastraProduto from './pages/validaCadastraProduto'

$(function () {

    window.Modal = new Modal();
    window.Burger = Burger;
    window.Produtos = Produtos;
    window.MinhasListas = MinhasListas;
    window.EditarLista = EditarLista;
    window.RealizarPedido = RealizarPedido;
    window.Pedidos = Pedidos;
    window.Pedido = Pedido;
    window.CriarLista = CriarLista;
    window.EditaPedido = EditarPedido;
    window.Calcular = Calcular;

    CriarLista.validaFormulario();
    EditarLista.validaFormulario();
    Produtos.atualizaUnidadeMedida();
    RealizarPedido.habilitaInputsDeQuantidade();
    EditaProdutoEstoque.validaFormulario();
    validaCadastraProduto.validaFormulario();
    validaCadastraProduto.validaPreco();
    Produtos.atualizaUnidadeMedida();
});
