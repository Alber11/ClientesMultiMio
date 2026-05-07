package com.gmail.albermargar9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase orientada al manejo y lectura del fichero de clientes mediante distintos métodos.
 */
public class LectorFicheros {

    /**
     * Crea un {@link Scanner} para el fichero indicado.
     *
     * @param ruta ruta del fichero a leer.
     * @return scanner para el fichero dado.
     * @throws FileNotFoundException si no existe el fichero.
     */
    public static Scanner lectorFicheroScanner(String ruta) throws FileNotFoundException {
        return new Scanner(new File(ruta));
    }

    /**
     * Crea un {@link FileReader} para el fichero indicado.
     *
     * @param ruta ruta del fichero a leer.
     * @return lector de caracteres para el fichero dado.
     * @throws FileNotFoundException si no existe el fichero.
     */
    public static FileReader lectorFicheroFilereader(String ruta) throws FileNotFoundException {
        return new FileReader(ruta);
    }

    /**
     * Crea un {@link BufferedReader} para el fichero indicado.
     *
     * @param ruta ruta del fichero a leer.
     * @return lector con búfer para el fichero dado.
     * @throws FileNotFoundException si no existe el fichero.
     */
    public static BufferedReader lectorFicheroBufferReader(String ruta) throws FileNotFoundException {
        return new BufferedReader(new FileReader(ruta));
    }

    /**
     * Convierte una línea del fichero en una instancia de {@link Cliente}.
     *
     * @param linea línea del fichero.
     * @return cliente parseado o {@code null} si la línea no es válida.
     */
    private static Cliente parseLinea(String linea) {
        if (linea == null || linea.trim().isEmpty()) {
            return null;
        }
        String[] datos = linea.split(";");
        if (datos.length < 11) {
            return null;
        }
        try {
            String facturacionStr = datos[4].replace(',', '.');
            double facturacion = Double.parseDouble(facturacionStr);
            String ciudad = datos[6];
            String pais = datos[10];
            return new Cliente(datos[0], datos[1], datos[2], ciudad, pais, facturacion);
        } catch (NumberFormatException e) {
            System.err.println("Error parseando facturación en línea: " + linea);
            return null;
        }
    }

    /**
     * Lee el archivo utilizando Scanner y parsea los clientes.
     *
     * @param ruta Ruta del archivo a leer.
     * @return Lista de clientes generada.
     */
    public static List<Cliente> cargarClientesConScanner(String ruta) {
        List<Cliente> clientes = new ArrayList<>();
        try (Scanner scanner = lectorFicheroScanner(ruta)) {
            while (scanner.hasNextLine()) {
                Cliente cliente = parseLinea(scanner.nextLine());
                if (cliente != null) {
                    clientes.add(cliente);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el fichero: " + ruta);
        }
        return clientes;
    }

    /**
     * Lee el archivo utilizando FileReader y parsea los clientes.
     *
     * @param ruta Ruta del archivo a leer.
     * @return Lista de clientes generada.
     */
    public static List<Cliente> cargarClientesConFileReader(String ruta) {
        List<Cliente> clientes = new ArrayList<>();
        File file = new File(ruta);
        if (!file.exists()) {
            System.err.println("No se encontró el fichero: " + ruta);
            return clientes;
        }
        try (FileReader fr = lectorFicheroFilereader(ruta)) {
            char[] buffer = new char[(int) file.length()];
            int charsRead = fr.read(buffer);
            String fileContent = new String(buffer, 0, charsRead);
            String[] lineas = fileContent.split("\\r?\\n");
            for (String linea : lineas) {
                Cliente cliente = parseLinea(linea);
                if (cliente != null) {
                    clientes.add(cliente);
                }
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
        return clientes;
    }

    /**
     * Lee el archivo utilizando BufferedReader y parsea los clientes.
     *
     * @param ruta Ruta del archivo a leer.
     * @return Lista de clientes generada.
     */
    public static List<Cliente> cargarClientesConBufferedReader(String ruta) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = lectorFicheroBufferReader(ruta)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Cliente cliente = parseLinea(linea);
                if (cliente != null) {
                    clientes.add(cliente);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el fichero: " + ruta);
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
        return clientes;
    }
}
