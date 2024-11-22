package controlador;

import modelo.AlmacenCadena;
import java.util.ArrayList;

public class AlmacenCadenaControlador extends PuntoDeVentaControlador {

    private final ArrayList<AlmacenCadena> listAlmacenCadena = new ArrayList<>();

    @Override
    public <T> boolean registrar(T obj) {
        try {
           if (obj == null) {
                return false;
            } else {
                AlmacenCadena objAlmacenCadena = (AlmacenCadena) obj;
                this.listAlmacenCadena.add(objAlmacenCadena);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String consultar(String codigo) {
        String result = "";

        for (int i = 0; i < this.listAlmacenCadena.size(); i++) {
            if (this.listAlmacenCadena.get(i).getCodigo().equals(codigo)) {
                result = "Codigo: " + this.listAlmacenCadena.get(i).getCodigo()+ " - "
                        + "Telefono: " + this.listAlmacenCadena.get(i).getTelefono()+ " - "
                        + "Area: " + this.listAlmacenCadena.get(i).getArea()+ " - "
                        + "Direccion:" + this.listAlmacenCadena.get(i).getDiteccion()+ " - "
                        + "Presupuesto de venta: " + this.listAlmacenCadena.get(i).getPresupuestoVentas()+ "\n";

                break;
            }
        }
        return result;
    }

    @Override
    public <T> boolean actualizar(String codigo, T obj) {
        boolean result = true;
        try {
            if (obj == null) {
                result = false;
                return result;
            } else {
                AlmacenCadena objAlmacenCadena = (AlmacenCadena) obj;
                for (AlmacenCadena objtAlmacenCadena : this.listAlmacenCadena) {
                    if (objtAlmacenCadena.getCodigo().equals(codigo)){
                        objtAlmacenCadena.setDiteccion(objAlmacenCadena.getDiteccion());
                        objtAlmacenCadena.setTelefono(objAlmacenCadena.getTelefono());
                        objtAlmacenCadena.setArea(objAlmacenCadena.getArea());
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
    public boolean eliminar(String codigo) {
        boolean result = true;
        try {
            if (codigo == null) {
                result = false;
                return result;
            } else {
                for (AlmacenCadena objtAlmacenCadena : this.listAlmacenCadena) {
                    if (objtAlmacenCadena.getCodigo().equals(codigo)) {
                        this.listAlmacenCadena.remove(objtAlmacenCadena);
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
        String lisAlmacenCadena = "";

        for (int i = 0; i < this.listAlmacenCadena.size(); i++) {
            
            lisAlmacenCadena += "Codigo: " + this.listAlmacenCadena.get(i).getCodigo()+ " - "
                    + "Telefono: " + this.listAlmacenCadena.get(i).getTelefono()+ " - "
                    + "Area: " + this.listAlmacenCadena.get(i).getArea()+ " - "
                    + "Direccion: " + this.listAlmacenCadena.get(i).getDiteccion()+ " - " 
                    + "Presupuesto de venta: " + this.listAlmacenCadena.get(i).getPresupuestoVentas()+ "\n";
        }
        return lisAlmacenCadena;
    }
}
