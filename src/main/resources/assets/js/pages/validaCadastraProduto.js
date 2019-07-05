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
  validaPreco: () => {
      $('#preco').mask('000.000.000.000.000.00', {reverse: true});
  }
}
