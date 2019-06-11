window.$ = window.jQuery = require('jquery')
import '@fortawesome/fontawesome-free/js/all';
import 'animate.css'
import '../scss/styles.scss'
import '@fengyuanchen/validator';
import CriarLista from './pages/criaLista'
import EditarLista from './pages/editaLista'
import MinhasListas from './pages/minhaLista'
import RealizarPedido from './pages/realizaPedido'

$(function () {
    CriarLista.validaFormulario();   
    EditarLista.validaFormulario();
});

window.minhasListas = minhasListas;
window.MinhasListas = MinhasListas;
window.EditaLista = EditarLista;
window.RealizarPedido = RealizarPedido;