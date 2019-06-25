function duasCasasAposVirgula(num){
    return parseFloat(Math.round(num * Math.pow(10, 2)) /Math.pow(10,2)).toFixed(2);
}
const fn = () => {
    var preco = parseFloat($('#preco').text());
    
    var quantidade = parseInt($('input[name=quantidade]').val()) || 0;
    var resultado = preco * quantidade;
    $('#resultado').text(duasCasasAposVirgula(resultado)); 
    
}
export default fn;