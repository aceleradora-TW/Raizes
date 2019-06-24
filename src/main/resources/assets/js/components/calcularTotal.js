const fn = () => {
    var preco = parseFloat($('#preco').text()) ;
    // const box  = $(this).parents('.box');
    // const input  = box.find('input[name=quantidade]');
    var quantidade = parseInt($('input[name=quantidade]').val()) || 0;
    var resultado = preco * quantidade;
    $('#resultado').text(resultado);   
}
export default fn;