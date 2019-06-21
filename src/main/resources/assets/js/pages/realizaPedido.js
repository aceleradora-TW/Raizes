export default {
  exibeConfirmacaoDeCancelamento: (href) => Modal
    .warning()
    .okAction("Sim", () => { window.location.href = href })
    .cancelAction("Não")
    .show("Realmente deseja cancelar? Os dados não serão salvos."),

  habilitaInputsDeQuantidade: ($) => {
    $('input[type=radio]').on('change', function () {
      const box = $(this).parents('.box');
      const input = box.find('input[type=number]');
      input.prop('disabled', false);
      console.log(input);
    });

    $('input[type=radio]:first').attr('checked', 'checked').change();
  }
}