import Validator from '../utils/validator'

export default {
  validaFormulario: () => {
    const validador = new Validator('#formCadastraProduto');

    validador.setFieldRule("#quantidadeEstoque", {
      rules: {
        required: true,
        number: true,
        min: 1
      }
    });

    validador.setFieldRule("#preco", {
      rules: {
        required: true,
        min: 0
      }
    });
  },
  validaPreco: () =>{
    $(document).ready(function() {
      // $('#preco').inputmask("99.99");
//       $("#money").inputmask({
//         'groupSeparator': ',',
//         'autoGroup': true,
//         'digits': 10,
//         'radixPoint': ".",
//         'digitsOptional': false,
//         'allowMinus': false
// });
      
        })
      }
    }
