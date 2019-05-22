window.$ = window.jQuery = require('jquery')
import '@fortawesome/fontawesome-free/js/all'
import 'animate.css'
import '../scss/styles.scss'
import '@fengyuanchen/validator';
import CriarLista from './pages/criaLista'
import minhasListas from './pages/minha-lista'

$(function () {
    CriarLista.validaFormulario();   
         
});

window.minhasListas = minhasListas;

