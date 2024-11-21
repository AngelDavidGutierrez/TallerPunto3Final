package modelo;

public class TiendaCentroComercial extends PuntoVenta {
    private String administrador;
    private String numeroEmpleados;
    private String lineaRopa ;
    private String cantidadVendida;

    public String getAdministrador() {
        return administrador;
    }



    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }



    public String getNumeroEmpleados() {
        return numeroEmpleados;
    }



    public void setNumeroEmpleados(String numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }



    public String getLineaRopa() {
        return lineaRopa;
    }



    public void setLineaRopa(String lineaRopa) {
        this.lineaRopa = lineaRopa;
    }



    public String getCantidadVendida() {
        return cantidadVendida;
    }



    public void setCantidadVendida(String cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }



    public TiendaCentroComercial(String codigo, String diteccion, String telefono, String area,
    String presupuestoVentas, String administrador, String numeroEmpleados) {
        super(codigo, diteccion, telefono, area, presupuestoVentas);
        this.administrador = administrador;
        this.numeroEmpleados = numeroEmpleados;
    }

    
}
