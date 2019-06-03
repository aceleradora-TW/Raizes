window.$ = window.jQuery = require('jquery')
import '@fortawesome/fontawesome-free/js/all'
import 'animate.css'
import '../scss/styles.scss'
import '@fengyuanchen/validator';
import CriarLista from './pages/criaLista'
import EditarLista from './pages/editaLista'
import minhasListas from './pages/minha-lista'
import RealizarPedido from './pages/realizarPedido'
import message from './pages/mensagemSalvar'
import Pedidos from './pages/pedidos'


$(function () {
    CriarLista.validaFormulario();   
    EditarLista.validaFormulario();
    RealizarPedido.exibeConfirmacaDeCancelamento();
    minhasListas.exibeConfirmacaDeExclusaoDaLista();
    Pedidos.exibeConfirmacaDeExclusaoDoPedido();
});

window.minhasListas = minhasListas;
window.RealizarPedido = RealizarPedido;
window.Pedidos = Pedidos;