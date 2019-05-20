export default class Validator {
  constructor(form) {
    this.validator = $.fn.validator;
    this.$form = $(form);
    this.$inputs = this.$form.find('input:not(:checkbox)');
    this.$allInputs = this.$form.find('input');
    this.$submit = this.$form.find(':submit');
    this.setup();
  }

  setup() {
    this.setMessages();
    this.handleValidatorFeedbacks()
    this.handleSubmit()
  }
  setMessages() {
    this.validator.setMessages({
      number: 'Somente números são permitidos.',
      email: 'Email inválido.',
      url: 'URL inválida.',
      date: 'Data inválida.',
      required: 'Campo obrigatório.',
      max: 'Tamanho máximo permitido: [0].',
      min: 'Tamanho mínimo permitido: [0].',
      maxlength: 'Tamanho máximo permitido: [0].',
      minlength: 'Tamanho minimo permitido: [0].',
      pattern: '请输入匹配的值。.',
      range: 'Permitido entre [0] e [1] tamanho??',
      rangelength: 'Permitido entre [0] e [1] string tamanho??',
      equalto: 'Deve dser igual'
    });
  }

  handleValidatorFeedbacks(){
    this.validator.setDefaults({
      trigger: 'input change',
      success: function (e) {
        $(this).closest('.field').removeClass('has-error').find('.help-block').empty();
      },
      error: function (e) {
        $(this).closest('.field').addClass('has-error').find('.help-block').text(e.message);
      }
    });
  }

  handleSubmit() {
    this.$submit.click((e) => {
      const validity = [];

      this.$allInputs.each(function () {
        validity.push($(this).validator('isValid'));
      });

      if ($.inArray(false, validity) !== -1) {
        e.preventDefault();
        return false;
      }
    });
  }

   /**
	 * Adiciona regras de validação para todos os campos do formulário,
	 * Espera um objeto de regras no padrão do plugin como por exemplo: 
   * 
   * {
   *   rules: {
   *     required: true
   *   }
   * }
   * 
	 * @param Object rules
	 */
  setRulesForEachInputs(rules) {
    rules = rules || {
      rules: {
        required: true
      }
    };
    this.$inputs.validator(rules);
  }
  
  /**
	 * Adiciona regra de validação customizada,
	 * É obtrigatório que o seletor seja o atributo name dos campos'.
	 * Utilizado para campos do tipo checkbox(grupo de checkboxes de mesmo tipo) ou radio
   * Espera Seletor do campo,  nome do validador, mensagem de erro e a função validadora
   * 
	 * @param String selector Ex: 'input[type="checkbox"]'
	 * @param String name Ex: 'ValidadorCheckbox'
	 * @param String message Ex: 'Selecione ao menos um produto.'
	 * @param Function fn Ex: (s, value) => $(s + ':checked').length >= 1;
	 */
  setCustomValidator(selector, name, message, fn) {
    $(selector).validator('addRule', name, {
      message: message,
      validator: function (value) {
        return fn(selector, value);
      }
    });
  }

  /**
	 * Adiciona regra REQUIRED para um grupo específico de campos,
	 * É obtrigatório que o seletor seja o atributo name dos campos'.
	 * Utilizado para campos do tipo checkbox(grupo de checkboxes de mesmo tipo) ou radio
   * Espera atributo name do campo e a mensagem de erro. 
	 * @param String inputName Ex: 'produtos'
	 * @param String message Ex: 'Selecione ao menos um produto.'
	 */
  setRequiredValidatorToFieldGroup(inputName, message){
    const selector = `input[name="${inputName}"]`;
    this.setCustomValidator(selector, inputName, message, (s) => {
      return $(s + ':checked').length >= 1;
    })
  }
  
  /**
	 * Adiciona regras de validação para um campo específico,
	 * Espera o seletor para o elemento como por exemplo: '.input-nome'.
	 * E um objeto de regras no padrão do plugin como por exemplo: 
   * 
   * {
   *   rules: {
   *     required: true
   *   }
   * }
   * 
	 * @param String selector
	 * @param Object rules
	 */
  setFieldRule(selector, rules) {
    if(!selector  || !rules) return;
    
    const element = this.$form.find(selector);
    element.validator(rules);
  }
}