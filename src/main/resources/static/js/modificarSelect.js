function modificarSelect(name,valor) {
    // Obtener el select con el nombre pasado por parámetro
    const selectElement = document.querySelector(`select[name="${name}"]`);

    if (selectElement) {
        // Recorremos todas las opciones dentro del select
        for (let i = 0; i < selectElement.options.length; i++) {
            selectElement.options[i].selected = valor;
        }
    }
}