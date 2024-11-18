function confirmaReseteo(nombreFormulario) {
    var mensaje = "Pulsa Aceptar para establecer el valor por defecto de los campos del formulario. Pulsa Cancelar para abortar esta operación.";
    if (confirm(mensaje)) {  // si se pulsa Aceptar
// se resetea el formulario
        document.getElementById(nombreFormulario).reset();
    }
}