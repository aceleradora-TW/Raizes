import Validator from '../utils/validator'

export default {
    validacaoEditar: function () {
        const validador = new Validator('#formEditar');
        console.log("Validator",validador);
        validador.setRequiredValidatorToFieldGroup('produtosEditar', 'Selecione ao menos um produto');

        validador.setRulesForEachInputs({
            rules: {
                required: true
            }
        });
    }
}