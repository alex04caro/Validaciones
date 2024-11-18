
    function confirmarEnvio(nombreFormulario) {
    var mensaje = "Pulsa Aceptar para enviar el formulario. Pulsa Cancelar para abortar esta operación.";
    if (confirm(mensaje)) {  // si se pulsa Aceptar
// se resetea el formulario
    document.getElementById(nombreFormulario).submit();
}
}

