function cambiarIdioma() {
    var idiomaSeleccionado = document.getElementById("idiomaSeleccionado").value;

    // Construir la nueva URL con el parámetro lang
    var newUrl = window.location.protocol + "//" + window.location.host + window.location.pathname + "?lang=" + idiomaSeleccionado;

    // Modifica la URL sin recargar la página
    window.history.pushState({ path: newUrl }, '', newUrl);
    window.location.replace(newUrl);
}