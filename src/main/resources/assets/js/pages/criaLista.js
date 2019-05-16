
import Validator from '../utils/validator'

export default {
  validaFormulario: function () {
    const validador = new Validator('#formCriaLista'); 
    console.log("Validator",validador); 
    validador.setRequiredValidatorToFieldGroup('produtos', 'Selecione ao menos um produto');
    
    validador.setRulesForEachInputs({
      rules: {
        required: true
      }
    }); 
  }
}