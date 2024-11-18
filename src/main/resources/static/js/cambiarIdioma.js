function cambiarIdioma() {
    var idiomaSeleccionado = document.getElementById("idiomaSeleccionado").value;

    // Construir la nueva URL con el parámetro lang
    var newUrl = window.location.protocol + "//" + window.location.host + window.location.pathname + "?lang=" + idiomaSeleccionado;

    // Modificar la URL sin recargar la página
    window.history.pushState({ path: newUrl }, '', newUrl);

    // Ahora redirigir a la página 'devuelve-formulario' con el parámetro lang
    window.location.href = 'devuelve-formulario?lang=' + idiomaSeleccionado;
}
