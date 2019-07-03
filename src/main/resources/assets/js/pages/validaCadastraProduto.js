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
      // $('#preco').maskMoney();
      $('#preco').inputmask("99.99");
      
        })
      }
    }
  
      // $("#preco").maskMoney({
      //                       prefix:'R$ ', 
      //                       allowNegative: true, 
      //                       thousands:'.', 
      //                       decimal:',', 
      //                       affixesStay: false
      //                     })
      // $('#preco').maskMoney({
      //             allowZero:false, 
      //             allowNegative:true, 
      //             defaultZero:false
      //           });                    
  
      //"#.##0,00"
