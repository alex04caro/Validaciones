// Función que se llama cuando se cambia la opción en el select
function cambiarIdioma() {
    var idioma = document.getElementById("idiomaSelect").value;  // Obtener el valor seleccionado
    // Redirigir al servidor con el idioma seleccionado como parámetro en la URL
    window.location.href = '/cambiar-idioma?lang=' + idioma;
}
