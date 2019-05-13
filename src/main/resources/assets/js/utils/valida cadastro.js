import Validator from "./validator";

$(function){
    const validator = new Validator();

    Validator.setRequiredValidatorToFieldGroup('produtos', 'selecione 1'){
    }

    Validator.setRulesForEachInputs();
}