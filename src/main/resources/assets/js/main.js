window.$ = window.jQuery = require('jquery')
import '@fortawesome/fontawesome-free/js/all';
import 'animate.css'
import '../scss/styles.scss'
import '@fengyuanchen/validator';
import CriarLista from './pages/criaLista'
import EditarLista from './pages/editaLista'
import minhasListas from './pages/minha-lista'
import mensagemCancelar  from './pages/mensagem'
import validaEditar from './pages/validaAdicionarProdutos'
import RealizarPedido from './pages/realizarPedido'

$(function () {
    CriarLista.validaFormulario();
    validaEditar.validacaoEditar();
    EditarLista.validaFormulario();
});
window.EditarLista = EditarLista;
window.exibirMensagem = mensagemCancelar;
window.minhasListas = minhasListas;
window.RealizarPedido = RealizarPedido;