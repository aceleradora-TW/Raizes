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
      
      const box = $(this).parents('.box');
      
      const input = box.find('input[type=number]');
      
      inputs.val(0);
      inputs.trigger('click');
      inputs.attr('disabled', true);
      input.attr('disabled', false);
    });

  }
}