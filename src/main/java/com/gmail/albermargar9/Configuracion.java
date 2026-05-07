package com.gmail.albermargar9;

import java.io.*;

/**
 * Gestiona la configuración de la aplicación mediante un archivo binario.
 */
public class Configuracion {
    /** Ruta del archivo de configuración binaria del usuario. */
    private final String RUTA_ARCHIVO;

    /** Ruta por defecto del fichero de clientes. */
    private String defaultLocation;

    /** Carácter usado en el formato del menú. */
    private String menuCharacter;

    /** Indicador de si el informe debe guardarse en un fichero. */
    private String saveReport;

    /** Nombre del fichero de salida para los informes. */
    private String fileReport;

    public Configuracion() {
        RUTA_ARCHIVO = System.getProperty("user.home") + File.separator + "configuration.bin";
        cargarConfiguracionPredeterminada();
        cargarDesdeFichero();
    }

    /**
     * Carga los valores por defecto en caso de no existir el archivo.
     */
    private void cargarConfiguracionPredeterminada() {
        defaultLocation = "Clientes_LF.txt";
        menuCharacter = "*";
        saveReport = "false";
        fileReport = "informe.txt";
    }

    /**
     * Lee la configuración del archivo binario.
     */
    private void cargarDesdeFichero() {
        File file = new File(RUTA_ARCHIVO);
        if (!file.exists()) {
            return;
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while (dis.available() > 0) {
                String linea = dis.readUTF();
                String[] partes = linea.split(";", 2);
                if (partes.length == 2) {
                    setValor(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer la configuración: " + e.getMessage());
        }
    }

    /**
     * Guarda la configuración actual en el archivo binario.
     */
    public void guardarEnFichero() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            dos.writeUTF("default_location;" + defaultLocation);
            dos.writeUTF("menu_character;" + menuCharacter);
            dos.writeUTF("save_report;" + saveReport);
            dos.writeUTF("file_report;" + fileReport);
            System.out.println("Configuración guardada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la configuración: " + e.getMessage());
        }
    }

    /**
     * Recupera el valor de una opción de configuración.
     *
     * @param clave clave de configuración.
     * @return valor de configuración o {@code null} si la clave no existe.
     */
    public String getValor(String clave) {
        switch (clave) {
            case "default_location":
                return defaultLocation;
            case "menu_character":
                return menuCharacter;
            case "save_report":
                return saveReport;
            case "file_report":
                return fileReport;
            default:
                return null;
        }
    }

    /**
     * Actualiza el valor de una opción de configuración.
     *
     * @param clave clave de configuración.
     * @param valor nuevo valor.
     */
    public void setValor(String clave, String valor) {
        switch (clave) {
            case "default_location":
                defaultLocation = valor;
                break;
            case "menu_character":
                menuCharacter = valor;
                break;
            case "save_report":
                saveReport = valor;
                break;
            case "file_report":
                fileReport = valor;
                break;
        }
    }
}
