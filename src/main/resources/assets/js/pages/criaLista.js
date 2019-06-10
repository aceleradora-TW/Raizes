import Validator from '../utils/validator'

export default {
  validaFormulario: () => {
    const validador = new Validator('#formCriaLista'); 
    validador.setRequiredValidatorToFieldGroup('produtos', 'Selecione ao menos um produto');
    
    validador.setRulesForEachInputs({
      rules: {
        required: true
      }
    }); 
  },
  exibeConfirmacaoDeCancelamento: (href) => Modal
  .warning()
  .okAction("Sim", () => { window.location.href =  href })
  .cancelAction("Não")
  .show("Realmente deseja sair sem salvar a lista? Os dados não serão salvos.")
  
}