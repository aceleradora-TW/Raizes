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
    $(function() {
      $('#preco').mask("99,99",{placeholder:"Ex.: 4,50"});  
      //"#.##0,00"
    })      
  }
}