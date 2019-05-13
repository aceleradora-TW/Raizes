window.$ = window.jQuery = require('jquery');
import '@fortawesome/fontawesome-free/js/all'
import 'animate.css'
import '../scss/styles.scss'
import '@fengyuanchen/validator';

import Validador from '../js/utils/validator';


$(function() {
    const validador = new Validador('form');
    validador.setFieldRule('input', {
        rules: {
            required: true
        }
    });
})

