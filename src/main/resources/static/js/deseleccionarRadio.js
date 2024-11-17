function deseleccionarRadiosPorName(name) {
    // Obtenemos todos los radios con el nombre pasado por parámetro
    const radios = document.querySelectorAll(`input[name="${name}"]`);

    // Recorremos los radios y desmarcamos cada uno
    radios.forEach(function(radio) {
        radio.checked = false;
    });
}