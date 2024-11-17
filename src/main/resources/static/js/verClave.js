 // Función para alternar la visibilidad de los campos de contraseña
    function verClave() {
    var clave = document.getElementById("clave");
    var confirmarClave = document.getElementById("confirmarClave");

    // Verificar si los campos de contraseña están en modo "password"
    if (clave.type === "password") {
    clave.type = "text"; // Cambiar a texto
    confirmarClave.type = "text"; // Cambiar a texto
} else {
    clave.type = "password"; // Cambiar a contraseña
    confirmarClave.type = "password"; // Cambiar a contraseña
}
}
