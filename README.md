# Validaciones Formulario - Spring Boot Application

Este proyecto es una aplicación web desarrollada con Spring Boot que permite la validación de formularios con múltiples campos y proporciona retroalimentación en tiempo real sobre los errores de validación.

## Descripción

La aplicación permite a los usuarios completar un formulario con varios campos de entrada como texto, selección, y archivos. La aplicación utiliza validaciones en el servidor para asegurar que los datos enviados sean correctos y se muestra un mensaje de confirmación o error en función de la entrada del usuario. Además, permite cambiar el idioma de la interfaz y proporciona información sobre las cabeceras HTTP.

## Requisitos previos

- Java 17 o superior.
- Maven o Gradle como herramienta de construcción.
- Spring Boot 2.5 o superior.

## Instrucciones para ejecutar

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/alejandrocaro/validaciones_final.git
2.**Ejecucion**:
### La aplicación estará disponible en el siguiente URL:
http://localhost:4444/formulario/devuelve-formulario


### Cambiar puerto (si es necesario)
Si deseas cambiar el puerto del servidor, puedes hacerlo editando el archivo `application.properties` de la siguiente manera:

server.port=4444



## Funcionalidades

- **Validación de formulario**: El formulario incluye campos de texto, fecha, selección, radio, checkbox, archivo y URL, todos con validaciones en el servidor.
- **Feedback visual**: Después de enviar el formulario, se muestra un mensaje de éxito o error dependiendo de si la validación fue correcta.
- **Información sobre las cabeceras HTTP**: La aplicación captura y muestra detalles como la IP del cliente, el navegador, el sistema operativo y el idioma del usuario.
- **Cambio de idioma**: Los usuarios pueden cambiar el idioma de la interfaz de la aplicación utilizando un selector de países que también cambia el idioma de la web.

## Notas

- **Controlador**: El `MainController` maneja las solicitudes GET y POST para mostrar y procesar el formulario, respectivamente.
- **Validaciones**: Utiliza anotaciones de `@Valid` para validar los datos del formulario. Los errores de validación se muestran junto a los campos correspondientes.
- **Internacionalización (i18n)**: Utiliza archivos de mensajes para soportar múltiples idiomas en la interfaz.

## Licencia
Este proyecto está bajo licencia. Consulte el archivo `LICENSE` para más detalles

