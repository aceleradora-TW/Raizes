import Validator from '../utils/validator'

export default {
  validaFormulario: () => {
    const validador = new Validator('#formEditaLista'); 
    validador.setRequiredValidatorToFieldGroup('produtos', 'Selecione ao menos um produto');
    
    validador.setRulesForEachInputs({
      rules: {
        required: true
      }
    }); 
  }
}