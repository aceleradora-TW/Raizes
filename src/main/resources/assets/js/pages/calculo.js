const fn = () => {
    var num1 = Number(document.getElementById("num1").value);
    var num2 = Number(document.getElementById("num2").value);
    var resultado = document.getElementById("resultado");
    resultado.setAttribute('value',num1 * num2 );
}
export default fn;

