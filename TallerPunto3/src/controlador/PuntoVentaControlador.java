package controlador;

abstract class PuntoDeVentaControlador {

    abstract <T> boolean registrar(T obj);

    abstract String consultar(String codigo);

    abstract <T> boolean actualizar(String codigo, T obj);

    abstract boolean eliminar(String codigo);

    abstract String listar();

    public String presupuesto(int area){

        String result;
        if (area>=4) {
            result = "8000000";
        }else{
            result = "5000000";
        }

        return result;
    }

}

