export default {
  exibeConfirmacaoDeCancelamento: (href) => Modal
    .warning()
    .okAction("Sim", () => { window.location.href = href })
    .cancelAction("Não")
    .show("Realmente deseja cancelar? Os dados não serão salvos."),

  habilitaInputsDeQuantidade: () => {
    $('input[type=radio]').on('change', function () {

      const bigbox = $(this).parents('.bigbox');
      const inputs = bigbox.find('input[type=number]');
      const resultados = bigbox.find('.resultado');
      
      const box = $(this).parents('.box');
      
      const input = box.find('input[type=number]');

      inputs.val(0);
      resultados.text("");
      
      inputs.trigger('click');
      inputs.attr('disabled', true);
      input.attr('disabled', false);
    });

  }
}