import Validator from '../utils/validator'

export default {
    validaFormulario: () => {
      const validador = new Validator('#formEditarProduto');

      validador.setFieldRule("#quantidadeEstoque",{
        rules: {
          required: true,
          number: true,
          min: 1
        }
      });

      validador.setFieldRule("#preco",{
        rules: {
          required: true,
          min: 0
        }
      });
    },
}