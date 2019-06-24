const fn = () => {
    var preco = parseFloat($('#preco').text()) ;
    var quantidade = parseInt($('input[name=quantidade]').val()) || 0;
    var resultado = preco * quantidade;
    $('#resultado').text(resultado);   
}
export default fn;

