
package controlador;

import java.util.ArrayList;
import modelo.PuntoFabrica;

abstract class PuntoFabricaController extends PuntoDeVentaControlador {
    
    private final ArrayList <PuntoFabrica> listPuntoFabrica = new ArrayList<>();

    @Override
   public String listar() {
        String lisPuntoFabrica = "";

        for (int i = 0; i < this.listPuntoFabrica.size(); i++) {
            
            lisPuntoFabrica += this.listPuntoFabrica.get(i).getAdministrador()+ " - "
                    + this.listPuntoFabrica.get(i).getNumeroEmpleados() + " - "
                    + this.listPuntoFabrica.get(i).getDiteccion() + " - "
                    + this.listPuntoFabrica.get(i).getTelefono()+ " - "
                    + this.listPuntoFabrica.get(i).getArea()+ " - "
                    + this.listPuntoFabrica.get(i).getPresupuestoVentas() + " \n ";
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
                result = this.listPuntoFabrica.get(i).getDiteccion()+ " - "
                        + this.listPuntoFabrica.get(i).getTelefono() + " - "
                        + this.listPuntoFabrica.get(i).getArea()+ " - "
                        + this.listPuntoFabrica.get(i).getAdministrador()+ " - "
                        + this.listPuntoFabrica.get(i).getNumeroEmpleados() + " - "
                        + this.listPuntoFabrica.get(i).getPresupuestoVentas();

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
