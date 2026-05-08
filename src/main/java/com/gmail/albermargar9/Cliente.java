package com.gmail.albermargar9;

/**
 * Representa a un cliente con sus datos básicos, incluyendo información de contacto y facturación.
 * Esta clase almacena todos los detalles relevantes de un cliente extraídos del fichero de datos.
 */
public class Cliente {

    // --- DATOS DE IDENTIFICACIÓN ---
    /** Identificador único del cliente. */
    private String id;
    /** Nombre de la empresa del cliente. */
    private String nombreEmpresa;

    // --- DATOS DE CONTACTO ---
    /** Nombre del contacto asociado al cliente. */
    private String nombreContacto;
    /** Cargo de la persona de contacto en la empresa. */
    private String cargo;
    /** Número de teléfono del cliente. */
    private String telefono;

    // --- DATOS DE LOCALIZACIÓN ---
    /** Calle de la dirección del cliente. */
    private String calle;
    /** Ciudad de origen del cliente. */
    private String ciudad;
    /** País de origen del cliente. */
    private String pais;

    // --- DATOS FINANCIEROS ---
    /** Antigüedad del cliente en días. */
    private int antiguedad;
    /** Total de facturación del cliente. */
    private double facturacion;

    /**
     * Constructor para inicializar un objeto Cliente con todos sus datos.
     *
     * @param id             El identificador único del cliente.
     * @param nombreEmpresa  El nombre de la empresa del cliente.
     * @param nombreContacto El nombre de la persona de contacto.
     * @param cargo          El cargo de la persona de contacto.
     * @param calle          La calle de la dirección del cliente.
     * @param ciudad         La ciudad donde se encuentra el cliente.
     * @param pais           El país del cliente.
     * @param telefono       El número de teléfono del cliente.
     * @param antiguedad     La antigüedad del cliente.
     * @param facturacion    El total de facturación del cliente.
     */
    public Cliente(String id, String nombreEmpresa, String nombreContacto, String cargo, String calle, String ciudad, String pais, String telefono, int antiguedad, double facturacion) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreContacto = nombreContacto;
        this.cargo = cargo;
        this.calle = calle;
        this.ciudad = ciudad;
        this.pais = pais;
        this.telefono = telefono;
        this.antiguedad = antiguedad;
        this.facturacion = facturacion;
    }

    // --- GETTERS Y SETTERS ---

    /**
     * Obtiene el identificador único del cliente.
     * @return El ID del cliente.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único del cliente.
     * @param id El nuevo ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la empresa del cliente.
     * @return El nombre de la empresa.
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * Establece el nombre de la empresa del cliente.
     * @param nombreEmpresa El nuevo nombre de la empresa.
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * Obtiene el nombre del contacto del cliente.
     * @return El nombre del contacto.
     */
    public String getNombreContacto() {
        return nombreContacto;
    }

    /**
     * Establece el nombre del contacto del cliente.
     * @param nombreContacto El nuevo nombre de contacto.
     */
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    /**
     * Obtiene el cargo de la persona de contacto.
     * @return El cargo del contacto.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo de la persona de contacto.
     * @param cargo El nuevo cargo.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     * @return El número de teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     * @param telefono El nuevo teléfono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la calle de la dirección del cliente.
     * @return La calle del cliente.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección del cliente.
     * @param calle La nueva calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la ciudad de origen del cliente.
     * @return La ciudad del cliente.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de origen del cliente.
     * @param ciudad La nueva ciudad.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el país de origen del cliente.
     * @return El país del cliente.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país de origen del cliente.
     * @param pais El nuevo país.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la antigüedad del cliente.
     * @return La antigüedad del cliente.
     */
    public int getAntiguedad() {
        return antiguedad;
    }

    /**
     * Establece la antigüedad del cliente.
     * @param antiguedad La nueva antigüedad.
     */
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    /**
     * Obtiene la facturación total del cliente.
     * @return La facturación en unidades monetarias.
     */
    public double getFacturacion() {
        return facturacion;
    }

    /**
     * Establece la facturación total del cliente.
     * @param facturacion La nueva facturación.
     */
    public void setFacturacion(double facturacion) {
        this.facturacion = facturacion;
    }
}
