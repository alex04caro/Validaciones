// Función para vaciar todos los campos del formulario
function vaciarFormulario() {
    const formulario = document.getElementById('formulario');
    const elementos = formulario.elements;

    for (let i = 0; i < elementos.length; i++) {
        const campo = elementos[i];

        // Si el campo es un input de tipo texto, email o similar
        if (campo.type === "text" || campo.type === "email" || campo.type === "password") {
            campo.value = "";  // Vaciamos el valor del input
        }
        // Si el campo es un input de tipo radio o checkbox
        else if (campo.type === "radio" || campo.type === "checkbox") {
            campo.checked = false;  // Desmarcamos el radio/checkbox
        }
        // Si el campo es un select (multiple o no)
        else if (campo.tagName === "SELECT") {
            campo.selectedIndex = -1;  // No seleccionamos ninguna opción
        }
        // Si el campo es un textarea
        else if (campo.tagName === "TEXTAREA") {
            campo.value = "";  // Vaciamos el contenido del textarea
        }
    }
}
