package vistaUsusario;

import modelo.AlmacenCadena;
import modelo.PuntoFabrica;
import modelo.TiendaCentroComercial;
import controlador.AlmacenCadenaControlador;
import controlador.TiendaCentroComercialControlador;
import controlador.PuntoFabricaControlador;

import dto_generico.Generic;
import java.util.Scanner;

public class vistaTallerPunto3Final {

    private static Scanner scan = new Scanner(System.in);
    private static TiendaCentroComercialControlador objTiendaCentroComercialcControlador = new TiendaCentroComercialControlador();
    private static PuntoFabricaControlador objPuntoFabricaControlador = new PuntoFabricaControlador();
    private static AlmacenCadenaControlador objAlmacenCadenaControlador = new AlmacenCadenaControlador();

    public static void main(String[] args) {
        // aqui se llaman las funciones

        // Tienda centro comercial
        registrarTiendaCentroComercial();
        consultarTiendaCentroComercial();
        actualizarTiendaCentroComercial();
        eliminarTiendaCentroComercial();
        listaTiendaCentroComercial();
        // punto fabrica
        registrarPuntoFabrica();
        consultarPuntoFabrica();
        actualizarPuntoFabrica();
        eliminarPuntoFabrica();
        listaPuntoFabrica();
        // Almacen Cadena
        registrarAlmacenCadena();
        consultarAlmacenCadena();
        actualizarAlmacenCadena();
        eliminarAlmacenCadena();
        listaAlmacenCadena();
    }

    // apartir de aca se crean las funcionalidades
    // funciones tienda centro comercial
    public static void registrarTiendaCentroComercial() {
        char sw;
        do {
            System.out.println("\n Ingresa tienda en centro comercial");
            System.out.println("Ingrese codigo");
            String codigo = scan.nextLine();
            System.out.println("Ingrese la direccion");
            String direccion = scan.nextLine();
            System.out.println("Ingrese el telefono");
            String telefono = scan.nextLine();
            System.out.println("Ingrese el area del establecimiento");
            int area = scan.nextInt(); scan.nextLine();
            String presupuesto = objTiendaCentroComercialcControlador.presupuesto(area);
            System.out.println("Ingrese el nombre del alministrador ");
            String administrador = scan.nextLine();
            System.out.println("Ingrese numero de empleados que trabajan");
            String numeroEmpleados = scan.nextLine();
            System.out.println("Ingrese la linea de ropa con mas ventas ");
            String lienaRopa = scan.nextLine();

            TiendaCentroComercial objTiendaCentroComercial = new TiendaCentroComercial(codigo, direccion, telefono,
                    area, presupuesto, administrador, numeroEmpleados, lienaRopa);

            Generic<TiendaCentroComercial> objGeneric = new Generic<>();
            objGeneric.setContent(objTiendaCentroComercial);

            if (objTiendaCentroComercialcControlador.registrar(objGeneric.getContent())) {
                System.out.println("la tienda en centro comercial se registro correctamente");
            } else {
                System.out.println("error no se pudo registrar, intente nuevamente ");
            }
            System.out.println("desea registrar otra tienda? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');

    }

    public static void consultarTiendaCentroComercial() {
        char sw;
        do {
            System.out.println("\nConsultar tienda de centro comercial");
            System.out.println("Ingrese codigo de la tienda");
            String codigo = scan.nextLine();

            String resultado = objTiendaCentroComercialcControlador.consultar(codigo);
            if (resultado != "") {
                System.out.println("\nDatos del tienda ");
                System.out.println(resultado);
            } else {
                System.out.println("la tienda no se encontro. verifique!!");
            }

            System.out.println("desea consultar otra tienda? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    public static void actualizarTiendaCentroComercial() {
        char sw;

        do {
            System.out.println("Actualizar tienda centro comercial");
            System.out.println("Ingrese el codigo de la tienda que quiere actualizar");
            String codigoActualizar = scan.nextLine();

            if (codigoActualizar != "") {
                String resultado = objTiendaCentroComercialcControlador.consultar(codigoActualizar);

                if (resultado != "") {
                    System.out.println("\nDatos del tienda ");
                    System.out.println(resultado);

                    System.out.println("Desea actualizar la tienda? (s/n)");
                    sw = scan.nextLine().toUpperCase().charAt(0);

                    if (sw == 'S') {
                        System.out.println("Ingrese la dirección");
                        System.out.println("Ingrese codigo");
                        String codigo = scan.nextLine();
                        System.out.println("Ingrese la direccion");
                        String direccion = scan.nextLine();
                        System.out.println("Ingrese el telefono");
                        String telefono = scan.nextLine();
                        System.out.println("Ingrese el area del establecimiento");
                        int area = scan.nextInt(); scan.nextLine();
                        String presupuesto = objTiendaCentroComercialcControlador.presupuesto(area);
                        System.out.println("Ingrese el nombre del administrador ");
                        String administrador = scan.nextLine();
                        System.out.println("Ingrese numero de empleados que trabajan");
                        String numeroEmpleados = scan.nextLine();
                        System.out.println("Ingrese la linea de ropa con mas ventas ");
                        String lienaRopa = scan.nextLine();

                        TiendaCentroComercial objTiendaCentroComercial = new TiendaCentroComercial(codigoActualizar, direccion,
                                telefono, area, presupuesto, administrador, numeroEmpleados, lienaRopa);

                        Generic<TiendaCentroComercial> objGeneric = new Generic<>();
                        objGeneric.setContent(objTiendaCentroComercial);

                        if (objTiendaCentroComercialcControlador.actualizar(codigoActualizar,
                                objGeneric.getContent())) {
                            System.out.println("la tienda en centro comercial se actualizo correctamente");
                        } else {
                            System.out.println("la tienda no se encontro. verifique!!");
                        }
                    } else {
                        System.out.println("la tienda en centro comercial no se actualizo");
                    }
                } else {
                    System.out.println("no se encontro la tienda");
                }

            } else {
                System.out.println("la tienda no se encontro. verifique!!");
            }

            System.out.println("desea actualizar otra tienda? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    public static void eliminarTiendaCentroComercial() {
        char sw;

        do {
            System.out.println("eliminar tienda centro comercial");
            System.out.println("Ingrese el codigo de la tienda que quiere eliminar");
            String codigoEliminar = scan.nextLine();

            if (codigoEliminar != "") {
                String resultado = objTiendaCentroComercialcControlador.consultar(codigoEliminar);
                if (resultado != "") {
                    System.out.println("\nDatos del tienda ");
                    System.out.println(resultado);

                    System.out.println("Desea eliminar la tienda? (s/n)");
                    sw = scan.nextLine().toUpperCase().charAt(0);

                    if (sw == 'S') {

                        if (objTiendaCentroComercialcControlador.eliminar(codigoEliminar)) {
                            System.out.println("la tienda en centro comercial se elimino correctamente");
                        } else {
                            System.out.println("la tienda no se pudo eliminar. verifique!!");
                        }
                    } else {
                        System.out.println("la tienda en centro comercial no se elimino");
                    }
                } else {
                    System.out.println("no se encontro la tienda");
                }

            } else {
                System.out.println("la tienda no se encontro. verifique!!");
            }

            System.out.println("desea eliminar otra tienda? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    public static void listaTiendaCentroComercial() {
        System.out.println("\nLista de tiendas");

        String resultado = objTiendaCentroComercialcControlador.listar();

        if (resultado != "") {
            System.out.println(resultado);
        } else {
            System.out.println("no has registrado ninguna tienda; registra para poder mostrar una lista!!");

        }
    }

    // funciones punto fabrica

    public static void registrarPuntoFabrica() {
        char sw;
        do {
            System.out.println("Registrar punto fabrica");
            System.out.println("\n Ingrese el codigo: ");
            String codigo = scan.nextLine();
            System.out.println("Ingrese la direccion: ");
            String direccion = scan.nextLine();
            System.out.println("Ingrese el numero de telefono: ");
            String telefono = scan.nextLine();
            System.out.println("ingrese el area: ");
            int area = scan.nextInt(); scan.nextLine();
            String presupuesto = objPuntoFabricaControlador.presupuesto(area);
            System.out.println("Ingrese el nombre del administrador: ");
            String administrador = scan.nextLine();
            System.out.println("Ingrese el numero de Empleados: ");
            String empleados = scan.nextLine();

            PuntoFabrica objPuntoFabrica = new PuntoFabrica(codigo, direccion, telefono, area, presupuesto,
                    administrador, empleados);

            Generic<PuntoFabrica> objGeneric = new Generic<>();
            objGeneric.setContent(objPuntoFabrica);

            if (objPuntoFabricaControlador.registrar(objGeneric.getContent())) {
                System.out.println("El Punto de Fabrica se registro correctamente.");
            } else {
                System.out.println("El Punto de Fabrica no se pudo registrar.");
            }
            System.out.println("Desea registrar otro Punto de Fabrica? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');

    }

    public static void consultarPuntoFabrica() {
        char sw;
        do {
            System.out.println("Ingrese el Punto de Fabrica que desea consultar: ");
            System.out.println("Ingrese Codigo del Punto de Fabrica: ");
            String codigo = scan.nextLine();
            String resultado = objPuntoFabricaControlador.consultar(codigo);
            if (resultado != "") {
                System.out.println("Datos del Punto Fabrica");
                System.out.println(resultado);
            } else {
                System.out.println("El Punto de Fabrica no se encontro.");
            }
            System.out.println("Desea consultar otro Punto de Fabrica? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    public static void actualizarPuntoFabrica() {
        char sw;

        do {
            System.out.println("Actualizar Punto Fabrica");
            System.out.println("Ingrese el codigo del Punto Fabrica que desea actualizar:");
            String codigoActualizar = scan.nextLine();

            if (codigoActualizar != "") {
                String resultado = objPuntoFabricaControlador.consultar(codigoActualizar);

                if (resultado != "") {
                    System.out.println("Datos del Punto Fabrica");
                    System.out.println(resultado);

                    System.out.println("Desea actualizar el Punto de Fabrica? (s/n)");

                    sw = scan.nextLine().toUpperCase().charAt(0);

                    if (sw == 'S') {
                        System.out.println("Ingrese la direccion: ");
                        String direccion = scan.nextLine();
                        System.out.println("Ingrese el numero de telefono: ");
                        String telefono = scan.nextLine();
                        System.out.println("ingrese el area: ");
                        int area = scan.nextInt(); scan.nextLine();
                        String presupuesto = objPuntoFabricaControlador.presupuesto(area);
                        System.out.println("Ingrese el nombre del administrador: ");
                        String administrador = scan.nextLine();
                        System.out.println("Ingrese el numero de Empleados: ");
                        String empleados = scan.nextLine();

                        PuntoFabrica objPuntoFabrica = new PuntoFabrica(codigoActualizar, direccion, telefono, area, presupuesto,
                                administrador, empleados);

                        Generic<PuntoFabrica> objGeneric = new Generic<>();
                        objGeneric.setContent(objPuntoFabrica);

                        if (objPuntoFabricaControlador.actualizar(codigoActualizar, objGeneric.getContent())) {
                            System.out.println("El Punto de Fabrica se Actualizo correctamente.");
                        } else {
                            System.out.println("El Punto de Fabrica no se actualizo.");
                        }
                    } else {
                        System.out.println("El Punto de Fabrica no se actualizo.");
                    }
                } else {
                    System.out.println("no se encontro el almacen");
                }

            } else {
                System.out.println("No se encontro el Punto de Fabrica.");
            }
            System.out.println("Desea actualizar otro Punto de Fabrica? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    public static void eliminarPuntoFabrica() {
        char sw;

        do {
            System.out.println("Eliminar Punto Fabrica");
            System.out.println("Ingrese el codigo del Punto Fabrica que desea eliminar:");
            String codigoEliminar = scan.nextLine();

            if (codigoEliminar != "") {
                String resultado = objPuntoFabricaControlador.consultar(codigoEliminar);
                if (resultado != "") {
                    System.out.println("Datos del Punto Fabrica");
                    System.out.println(resultado);

                    System.out.println("Desea Eliminar el Punto de Fabrica? (s/n)");

                    sw = scan.nextLine().toUpperCase().charAt(0);

                    if (sw == 'S') {

                        if (objPuntoFabricaControlador.eliminar(codigoEliminar)) {
                            System.out.println("El Punto de Fabrica se Elimino correctamente.");
                        } else {
                            System.out.println("El Punto de Fabrica no se Elimino.");
                        }
                    } else {
                        System.out.println("El Punto de Fabrica no se Elimino.");
                    }
                } else {
                    System.out.println("no se encontro la fabrica");
                }

            } else {
                System.out.println("No se encontro el Punto de Fabrica.");
            }
            System.out.println("Desea Eliminar otro Punto de Fabrica? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');

    }

    public static void listaPuntoFabrica() {
        System.out.println("Lista de Puntos Fabricas.");

        String resultado = objPuntoFabricaControlador.listar();

        if (resultado != "") {
            System.out.println(resultado);
        } else {
            System.out.println("No has registrado ningun Punto Fabrica.");
        }

    }

    // Funciones Almacen Cadena
    public static void registrarAlmacenCadena() {
        char sw;
        do {
            System.out.println("Ingrese almacen cadena");
            System.out.println("\n Ingrese el codigo: ");
            String codigo = scan.nextLine();
            System.out.println("Ingrese la direccion: ");
            String direccion = scan.nextLine();
            System.out.println("Ingrese el numero de telefono: ");
            String telefono = scan.nextLine();
            System.out.println("ingrese el area: ");
            int area = scan.nextInt();scan.nextLine();
            String presupuesto = objAlmacenCadenaControlador.presupuesto(area);

            AlmacenCadena objAlmacenCadena = new AlmacenCadena(codigo, direccion, telefono, area, presupuesto);

            Generic<AlmacenCadena> objGeneric = new Generic<>();
            objGeneric.setContent(objAlmacenCadena);

            if (objAlmacenCadenaControlador.registrar(objGeneric.getContent())) {
                System.out.println("El Almacen Cadena se registro correctamente.");
            } else {
                System.out.println("El Almacen Cadena no se pudo registrar.");
            }
            System.out.println("Desea registrar otro Almacen de Cadena? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');

        // apartir de aca se crean las funcionalidades
    }

    public static void consultarAlmacenCadena() {
        char sw;
        do {
            System.out.println("Ingrese el Almacen Cadena que desea consultar: ");
            System.out.println("Ingrese Codigo del Almacen Cadena: ");
            String codigo = scan.nextLine();
            String resultado = objAlmacenCadenaControlador.consultar(codigo);
            if (resultado != "") {
                System.out.println("Datos del Almacen Cadena");
                System.out.println(resultado);
            } else {
                System.out.println("El Almacen Cadena no se encontro.");
            }
            System.out.println("Desea consultar otro Almacen Cadena? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    public static void actualizarAlmacenCadena() {
        char sw;

        do {
            System.out.println("Actualizar Almacen Cadena");
            System.out.println("Ingrese el codigo del Almacen Cadena que desea actualizar:");
            String codigoActualizar = scan.nextLine();

            if (codigoActualizar != "") {
                String resultado = objAlmacenCadenaControlador.consultar(codigoActualizar);

                if (resultado != "") {
                    System.out.println("Datos del Almacen Cadena");
                    System.out.println(resultado);

                    System.out.println("Desea actualizar el Almacen Cadena? (s/n)");

                    sw = scan.nextLine().toUpperCase().charAt(0);

                    if (sw == 'S') {
                        System.out.println("Ingrese la direccion: ");
                        String direccion = scan.nextLine();
                        System.out.println("Ingrese el numero de telefono: ");
                        String telefono = scan.nextLine();
                        System.out.println("ingrese el area: ");
                        int area = scan.nextInt();scan.nextLine();
                        String presupuesto = objAlmacenCadenaControlador.presupuesto(area);

                        AlmacenCadena objAlmacenCadena = new AlmacenCadena(codigoActualizar, direccion, telefono, area,
                                presupuesto);

                        Generic<AlmacenCadena> objGeneric = new Generic<>();
                        objGeneric.setContent(objAlmacenCadena);

                        if (objAlmacenCadenaControlador.actualizar(codigoActualizar, objGeneric.getContent())) {
                            System.out.println("El Almacen Cadena se Actualizo correctamente.");
                        } else {
                            System.out.println("El Almacen Cadena no se actualizo.");
                        }
                    } else {
                        System.out.println("El Almacen Cadena no se actualizo.");
                    }
                } else {
                    System.out.println("no se encontro el almacen");
                }

            } else {
                System.out.println("No se encontro el Almacen Cadena.");
            }
            System.out.println("Desea actualizar otro Almacen Cadena? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    public static void eliminarAlmacenCadena() {
        char sw;

        do {
            System.out.println("Eliminar Almacen Cadena");
            System.out.println("Ingrese el codigo del Almacen Cadena que desea eliminar:");
            String codigoEliminar = scan.nextLine();

            if (codigoEliminar != "") {
                String resultado = objAlmacenCadenaControlador.consultar(codigoEliminar);
                if (resultado != "") {
                    System.out.println("Datos del Almacen Cadena");
                    System.out.println(resultado);

                    System.out.println("Desea Eliminar el Almacen Cadena? (s/n)");

                    sw = scan.nextLine().toUpperCase().charAt(0);

                    if (sw == 'S') {

                        if (objAlmacenCadenaControlador.eliminar(codigoEliminar)) {
                            System.out.println("El Almacen Cadena se Elimino correctamente.");
                        } else {
                            System.out.println("El Almacen Cadena no se Elimino.");
                        }
                    } else {
                        System.out.println("El Almacen Cadena no se Elimino.");
                    }
                } else {
                    System.out.println("no se encontro la fabrica");
                }

            } else {
                System.out.println("No se encontro el Almacen Cadena.");
            }
            System.out.println("Desea Eliminar otro Almacen Cadena? (s/n)");
            sw = scan.nextLine().toUpperCase().charAt(0);
        } while (sw == 'S');

    }

    public static void listaAlmacenCadena() {
        System.out.println("Lista de Almacen Cadena.");

        String resultado = objAlmacenCadenaControlador.listar();

        if (resultado != "") {
            System.out.println(resultado);
        } else {
            System.out.println("No has registrado ningun Almacen Cadena.");
        }

    }
}
