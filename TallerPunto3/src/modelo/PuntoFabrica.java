package modelo;

public class PuntoFabrica extends PuntoVenta {

    private String administrador;
    private String numeroEmpleados;
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
    public PuntoFabrica(String codigo, String diteccion, String telefono, String area, String presupuestoVentas,
            String administrador, String numeroEmpleados) {
        super(codigo, diteccion, telefono, area, presupuestoVentas);
        this.administrador = administrador;
        this.numeroEmpleados = numeroEmpleados;
    }

    
}
