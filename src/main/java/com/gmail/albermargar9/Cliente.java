package com.gmail.albermargar9;

/**
 * Representa a un cliente con sus datos básicos.
 */
public class Cliente {
    /** Identificador único del cliente. */
    private String id;

    /** Nombre de la empresa del cliente. */
    private String nombreEmpresa;

    /** Nombre del contacto asociado al cliente. */
    private String nombreContacto;

    /** Ciudad de origen del cliente. */
    private String ciudad;

    /** País de origen del cliente. */
    private String pais;

    /** Total de facturación del cliente. */
    private double facturacion;

    /**
     * Constructor de la clase Cliente.
     *
     * @param id Identificador del cliente.
     * @param nombreEmpresa Nombre de la empresa.
     * @param nombreContacto Nombre del contacto.
     * @param ciudad Ciudad de origen.
     * @param pais País de origen.
     * @param facturacion Total de facturación.
     */
    public Cliente(String id, String nombreEmpresa, String nombreContacto, String ciudad, String pais, double facturacion) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreContacto = nombreContacto;
        this.ciudad = ciudad;
        this.pais = pais;
        this.facturacion = facturacion;
    }

    /**
     * Obtiene el nombre del contacto del cliente.
     *
     * @return nombre del contacto.
     */
    public String getNombreContacto() {
        return nombreContacto;
    }

    /**
     * Obtiene el país de origen del cliente.
     *
     * @return país del cliente.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Obtiene la facturación total del cliente.
     *
     * @return facturación en unidades monetarias.
     */
    public double getFacturacion() {
        return facturacion;
    }

    /**
     * Devuelve una representación en texto del cliente.
     *
     * @return cadena con los datos del cliente.
     */
    @Override
    public String toString() {
        return String.format(
                "Cliente [ID=%s, Empresa=%s, Contacto=%s, Ciudad=%s, País=%s, Facturación=%.2f]",
                id, nombreEmpresa, nombreContacto, ciudad, pais, facturacion);
    }
}
