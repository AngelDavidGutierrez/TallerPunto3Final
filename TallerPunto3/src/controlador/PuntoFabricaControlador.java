
package controlador;

import java.util.ArrayList;
import modelo.PuntoFabrica;

public class PuntoFabricaControlador extends PuntoDeVentaControlador {
    
    private final ArrayList <PuntoFabrica> listPuntoFabrica = new ArrayList<>();

    @Override
   public String listar() {
        String lisPuntoFabrica = "";

        for (int i = 0; i < this.listPuntoFabrica.size(); i++) {
            
            lisPuntoFabrica += "Codigo: " + this.listPuntoFabrica.get(i).getCodigo()+ " - "
                    + "Administrador: " + this.listPuntoFabrica.get(i).getAdministrador()+ " - "
                    + "Empleados: " + this.listPuntoFabrica.get(i).getNumeroEmpleados()+ " - "
                    + "Direccion: " + this.listPuntoFabrica.get(i).getDiteccion()+ " - "
                    + "Telefono: "+this.listPuntoFabrica.get(i).getTelefono()+ " - "
                    + "Area: " + this.listPuntoFabrica.get(i).getArea()+ " - "
                    + "Presupuesto de venta: " + this.listPuntoFabrica.get(i).getPresupuestoVentas()+ "\n";
        }
        return lisPuntoFabrica;
   }
 
    @Override
    public boolean eliminar(String codigo) {
        boolean result = true;
        try {
            if (codigo == null) {
                result = false;
                return result;
            } else {
                for (PuntoFabrica objtPuntoFabrica : this.listPuntoFabrica) {
                    if (objtPuntoFabrica.getCodigo().equals(codigo)) {
                        this.listPuntoFabrica.remove(objtPuntoFabrica);
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
    public <T> boolean actualizar(String codigo, T obj) {
        boolean result = true;
        try {
            if (obj == null) {
                result = false;
                return result;
            } else {
                for (PuntoFabrica objtPuntoFabrica : this.listPuntoFabrica) {
                    if (objtPuntoFabrica.getCodigo().equals(codigo)){
                        objtPuntoFabrica.setAdministrador(objtPuntoFabrica.getAdministrador());
                        objtPuntoFabrica.setNumeroEmpleados(objtPuntoFabrica.getNumeroEmpleados());
                        objtPuntoFabrica.setDiteccion(objtPuntoFabrica.getDiteccion());
                        objtPuntoFabrica.setTelefono(objtPuntoFabrica.getTelefono());
                        objtPuntoFabrica.setArea(objtPuntoFabrica.getArea());
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

        for (int i = 0; i < this.listPuntoFabrica.size(); i++) {
            if (this.listPuntoFabrica.get(i).getCodigo().equals(codigo)) {
                result = "Codigo: " + this.listPuntoFabrica.get(i).getCodigo()+ " - "
                        + "Direccion: " + this.listPuntoFabrica.get(i).getDiteccion()+ " - "
                        + "Telefono: " + this.listPuntoFabrica.get(i).getTelefono()+ " - "
                        + "Area: "+this.listPuntoFabrica.get(i).getArea()+ " - "
                        + "Administrador: " + this.listPuntoFabrica.get(i).getAdministrador()+ " - "
                        + "Empleados: "+this.listPuntoFabrica.get(i).getNumeroEmpleados()+ " - "
                        + "Presupuesto de venta: " + this.listPuntoFabrica.get(i).getPresupuestoVentas()+ "\n";

                break;
            }
        }
        return result;
    }

    

    @Override
   public <T> boolean registrar(T obj){
    
    try {
            if (obj =="") {
                return false;
            } else {
                PuntoFabrica objtPuntoFabrica = (PuntoFabrica) obj;
                this.listPuntoFabrica.add(objtPuntoFabrica);

                return true;
            }
           
        } catch (Exception e) {

            return false;
        }
  
}
}
