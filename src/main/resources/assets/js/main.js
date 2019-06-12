window.$ = window.jQuery = require('jquery')
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


$(function () {
    CriarLista.validaFormulario();   
    EditarLista.validaFormulario();



    window.MinhasListas = MinhasListas;
    window.EditaLista = EditarLista;
    window.RealizarPedido = RealizarPedido;
    window.Pedidos = Pedidos;
    window.Pedido = Pedido;
    window.CriarLista = CriarLista;
    window.Modal = new Modal();
    window.EditaPedido = EditarPedido;
    window.burger = burger;

});
