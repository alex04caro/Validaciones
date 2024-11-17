function modificarCheckbox(name,valor) {
    // Obtener todos los checkboxes con el atributo name pasado por parámetro
    const checkboxes = document.querySelectorAll(`input[type="checkbox"][name="${name}"]`);

    // Recorremos todos los checkboxes y los desmarcamos
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = valor;
    });
}
