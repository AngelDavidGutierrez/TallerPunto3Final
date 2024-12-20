package controlador;

import modelo.TiendaCentroComercial;
import java.util.ArrayList;

public class TiendaCentroComercialControlador extends PuntoDeVentaControlador {

    private final ArrayList<TiendaCentroComercial> listTiendaCentroComercial = new ArrayList<>();

    @Override
    public <T> boolean actualizar(String codigo, T obj) {
        boolean result = true;
        try {
            if (obj == null) {
                result = false;
                return result;
            } else {
                TiendaCentroComercial objTiendaCentroComercial = (TiendaCentroComercial) obj;
                for (TiendaCentroComercial objtTiendaCentroComercial : this.listTiendaCentroComercial) {
                    if (objtTiendaCentroComercial.getCodigo().equals(codigo)) {
                        objtTiendaCentroComercial.setAdministrador(objTiendaCentroComercial.getAdministrador());
                        objtTiendaCentroComercial.setNumeroEmpleados(objTiendaCentroComercial.getNumeroEmpleados());
                        objtTiendaCentroComercial.setDiteccion(objTiendaCentroComercial.getDiteccion());
                        objtTiendaCentroComercial.setTelefono(objTiendaCentroComercial.getTelefono());
                        objtTiendaCentroComercial.setArea(objTiendaCentroComercial.getArea());
                        objtTiendaCentroComercial.setLineaRopa(objTiendaCentroComercial.getLineaRopa());
                        break;
                    }
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public String consultar(String codigo) {
        String result = "";

        for (int i = 0; i < this.listTiendaCentroComercial.size(); i++) {
            if (this.listTiendaCentroComercial.get(i).getCodigo().equals(codigo)) {
                result = "Codigo: " + this.listTiendaCentroComercial.get(i).getCodigo() + " - "
                        + "Direccion: " + this.listTiendaCentroComercial.get(i).getDiteccion() + " - "
                        + "Telefono: " + this.listTiendaCentroComercial.get(i).getTelefono() + " - "
                        + "Area: " + this.listTiendaCentroComercial.get(i).getArea() + " - "
                        + "Administrador: " + this.listTiendaCentroComercial.get(i).getAdministrador() + " - "
                        + "Empleados: " + this.listTiendaCentroComercial.get(i).getNumeroEmpleados() + " - "
                        + "Linea de ropa mas vendida: " + this.listTiendaCentroComercial.get(i).getLineaRopa() + " - "
                        + "Presupuesto de venta: " + this.listTiendaCentroComercial.get(i).getPresupuestoVentas()
                        + "\n";

                break;
            }
        }
        return result;
    }

    @Override
    public boolean eliminar(String codigo) {
        boolean result = true;
        try {
            if (codigo == null) {
                result = false;
                return result;
            } else {
                for (TiendaCentroComercial objtTiendaCentroComercial : this.listTiendaCentroComercial) {
                    if (objtTiendaCentroComercial.getCodigo().equals(codigo)) {
                        this.listTiendaCentroComercial.remove(objtTiendaCentroComercial);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public String listar() {
        String lisTiendaCentroComercial = "";

        for (int i = 0; i < this.listTiendaCentroComercial.size(); i++) {

            lisTiendaCentroComercial += "Codigo: " + this.listTiendaCentroComercial.get(i).getCodigo() + " - "
                    + "Administrador: " + this.listTiendaCentroComercial.get(i).getAdministrador() + " - "
                    + "Empleados: " + this.listTiendaCentroComercial.get(i).getNumeroEmpleados() + " - "
                    + "Direccion: " + this.listTiendaCentroComercial.get(i).getDiteccion() + " - "
                    + "Telefono:" + this.listTiendaCentroComercial.get(i).getTelefono() + " - "
                    + "Area: " + this.listTiendaCentroComercial.get(i).getArea() + " - "
                    + "Linea de ropa mas vendida: " + this.listTiendaCentroComercial.get(i).getLineaRopa() + " - "
                    + "Presupuesto de venta: " + this.listTiendaCentroComercial.get(i).getPresupuestoVentas() + "\n";
        }
        return lisTiendaCentroComercial;
    }

    @Override
    public <T> boolean registrar(T obj) {
        try {
            if (obj == "") {
                return false;
            } else {
                TiendaCentroComercial objtTiendaCentroComercial = (TiendaCentroComercial) obj;
                this.listTiendaCentroComercial.add(objtTiendaCentroComercial);

                return true;
            }

        } catch (Exception e) {

            return false;
        }
    }

}
