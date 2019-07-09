import Validator from '../utils/validator'

export default {
  validacaoFormRegistroCliente: () => {
    const validador = new Validator('#registraCliente');

    validador.setRulesForEachInputs({
      rules: {
        required: true
      }
    });
  }
}