
import Validator from '../utils/validator'

export default {
  validaFormulario: function () {
    const validator = new Validator('#formCriaLista'); 
    console.log("Validator",validator); 
    validator.setRequiredValidatorToFieldGroup('produtos', 'Selecione ao menos um produto');
    
    validator.setRulesForEachInputs({
      rules: {
        required: true
      }
    }); 
  }
}