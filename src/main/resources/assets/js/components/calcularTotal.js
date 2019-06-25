function duasCasasAposVirgula(num,n){
    return parseFloat(Math.round(num * Math.pow(10, n)) /Math.pow(10,n)).toFixed(n);
}
const fn = () => {
    var preco = parseFloat($('#preco').text());
    
    var quantidade = parseInt($('input[name=quantidade]').val()) || 0;
    var resultado = preco * quantidade;
    $('#resultado').text(duasCasasAposVirgula(resultado)); 
    
}
export default fn;