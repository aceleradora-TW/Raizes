import Validator from '../utils/validator'

export default {
    validaFormulario: () => {
      const validador = new Validator('#formEditarProduto');
      validador.setRequiredValidatorToFieldGroup('preco', 'Campo não pode ser vazio e não pode ter números negativos');
      validador.setRequiredValidatorToFieldGroup('quantidadeEstoque','Campo não pode ser vazio e não pode ter números negativos');
      
      validador.setRulesForEachInputs({
        rules: {
          required: true
        }
      });
    },
    salvar: (Form) => true
}