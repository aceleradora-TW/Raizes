import Validator from '../utils/validator'

export default {
  validacaoFormRegistroProdutor: () => {
    const validador = new Validator('#registraProd');

    validador.setRulesForEachInputs({
      rules: {
        required: true
      }
    });
  }
}