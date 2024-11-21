package modelo;

abstract class PuntoVenta {
    protected String codigo;
    protected String diteccion;
    protected String telefono;
    protected int area;
    protected String presupuestoVentas;
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDiteccion() {
        return diteccion;
    }
    public void setDiteccion(String diteccion) {
        this.diteccion = diteccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public int getArea() {
        return area;
    }
    public void setArea(int area) {
        this.area = area;
    }
    public String getPresupuestoVentas() {
        return presupuestoVentas;
    }
    public void setPresupuestoVentas(String presupuestoVentas) {
        this.presupuestoVentas = presupuestoVentas;
    }
    protected PuntoVenta(String codigo, String diteccion, String telefono, int area, String presupuestoVentas) {
        this.codigo = codigo;
        this.diteccion = diteccion;
        this.telefono = telefono;
        this.area = area;
        this.presupuestoVentas = presupuestoVentas;
    }

   

}
