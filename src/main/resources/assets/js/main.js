window.$ = window.jQuery = require('jquery')
import '@fortawesome/fontawesome-free/js/all';
import 'animate.css'
import '../scss/styles.scss'
import '@fengyuanchen/validator';
import CriarLista from './pages/criaLista'
import EditaLista from './pages/editaLista'
import MinhasListas from './pages/minha-lista'
import RealizarPedido from './pages/realizarPedido'
import Modal from './components/modal'
import EditaPedido from './pages/editaPedido'
import Pedido from './pages/pedido'

$(function () {
    CriarLista.validaFormulario();   
    EditarLista.validaFormulario();
    
    window.MinhasListas = MinhasListas;
    window.EditaLista = EditaLista;
    window.RealizarPedido = RealizarPedido;
    window.Modal = new Modal();
    window.EditaPedido = EditaPedido;
    window.Pedido = Pedido;
});