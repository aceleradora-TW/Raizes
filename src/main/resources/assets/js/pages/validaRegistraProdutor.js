import Validator from '../utils/validator'

export default {
  validacaoFormRegistroProdutor: () => {
    const validador = new Validator('#registraProd');

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
  .show("Realmente deseja sair sem salvar o registro? Os dados não serão salvos.")
}