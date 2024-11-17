package org.alejandrocaro.validaciones_final.Model;

import java.lang.reflect.Field;
import java.util.List;

public class DatosFormularioUtils {

    public static String[] obtenerAtributosNoNulos(DatosFormulario datosFormulario) {
        StringBuilder result = new StringBuilder();
        int contador = 0;  // Variable para contar los parámetros no nulos

        // Obtener todos los campos del objeto DatosFormulario
        Field[] fields = DatosFormulario.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);  // Acceder a los campos privados
            try {
                Object value = field.get(datosFormulario);

                // Verificar si el valor es no nulo y no vacío (si es String o Lista)
                if (value != null && !(value instanceof List && ((List<?>) value).isEmpty()) && !(value instanceof String && ((String) value).isEmpty())) {
                    if (contador > 0) {
                        result.append(", ");
                    }
                    result.append(field.getName()) // Nombre del atributo
                            .append("=")
                            .append(value.toString()); // Valor del atributo
                    contador++;  // Incrementar el contador de parámetros no nulos
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        String[]resultado=new String[2];
        resultado[0]=String.valueOf(contador);
        resultado[1]=result.toString();
        return resultado;
    }
}
