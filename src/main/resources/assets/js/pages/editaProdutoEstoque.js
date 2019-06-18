import Validator from '../utils/validator'

export default {
  exibeConfirmacaoDeCancelamento: (href) => Modal
    .warning()
    .okAction("Sim", () => { window.location.href = href })
    .cancelAction("Não")
    .show("Realmente deseja cancelar a edição? Os dados não serão salvos."),

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