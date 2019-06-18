import Validator from '../utils/validator'

export default {
    validaFormulario: () => {
      const validador = new Validator('#formEditarProduto');
     
      validador.setRulesForEachInputs({
        rules: {
          required: true
        }
      });
    },
    salvar: (Form) => true
}