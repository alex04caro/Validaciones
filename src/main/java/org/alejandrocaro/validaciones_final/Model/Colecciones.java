package org.alejandrocaro.validaciones_final.Model;

import java.util.HashMap;
import java.util.Map;


public class Colecciones {
    private static final Map<String,String> listaGeneros=new HashMap<>();
    static {
        listaGeneros.put("F","Femenino");
        listaGeneros.put("M","Masculino");
        listaGeneros.put("O","Otro");
    }
    private static final Map<String,String> listaAficiones =new HashMap<>();
    static {
        listaAficiones.put("D","Deporte");
        listaAficiones.put("L","Lectura");
        listaAficiones.put("P","Pintura");
        listaAficiones.put("V","Viajes");
    }
    private static final Map<String,Pais> listaPaises =new HashMap<>();
    static {

    listaPaises.put("es", new Pais("España", "Castellano", "34", true, "espania.png"));
    listaPaises.put("fr", new Pais("Francia", "Francés", "33", false, "francia.png"));
    listaPaises.put("it", new Pais("Italia", "Italiano", "39", false, "italia.png"));
    listaPaises.put("pt", new Pais("Portugal", "Portugués", "351", false, "portugal.png"));
    listaPaises.put("en", new Pais("Reino unido", "Inglés", "44", true, "reino_unido.png"));

    }
    private static final Map<String,String> listaMusicas =new HashMap<>();
    static {
        listaMusicas.put("E","Electronica");
        listaMusicas.put("F","Funky");
        listaMusicas.put("N","New age");
        listaMusicas.put("P","Pop");
        listaMusicas.put("R","Rock");
    }

    public static Map<String, String> getListaGeneros() {
        return listaGeneros;
    }
    public static Map<String, String> getListaAficiones() {
        return listaAficiones;
    }
    public static Map<String, Pais> getListaPaises() {
        return listaPaises;
    }
    public static Map<String, String> getListaMusicas() {
        return listaMusicas;
    }
}