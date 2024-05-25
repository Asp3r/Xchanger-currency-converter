package Principal;

import Modelos.CapturadorDeJson;
import Modelos.ConvertidorJsonEnDivisaObjeto;
import Modelos.DivisaObj;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        CapturadorDeJson capturarJson = new CapturadorDeJson();
        ConvertidorJsonEnDivisaObjeto convertidorJson = new ConvertidorJsonEnDivisaObjeto();
        Scanner read = new Scanner(System.in);

        String divisaInicial, nuevaDivisa, cantidadDivisaInicialAux;
        double cantidadDivisaInicial, cantidadNuevaDivisa;
        String opcion = "";

        System.out.println();
        System.out.println("_________________________________________________________");
        System.out.println();
        System.out.println("¡Te damos la bienvenida a Xchanger! Tu conversor de " +
                "divisas de confianza.");
        System.out.println();

        while (true) {
            try {

                System.out.println();
                System.out.println("Actualmente solo aceptamos las siguientes divisas:");
                System.out.println();
                System.out.println("ARS: Peso Argentino.");
                System.out.println("BOB: Bolivar Boliviano.");
                System.out.println("BRL: Real Brasileño.");
                System.out.println("CLP: Peso Chileno.");
                System.out.println("COP: Peso Colombiano.");
                System.out.println("USD: Dolar Estadunidense.");
                System.out.println("SALIR: Finalizar el programa.");
                System.out.println();
                System.out.println();
                System.out.println("Ingresa el codigo de la divisa que deseas cambiar");
                System.out.println("(Ejemplo: USD para Dolar Estadounidense)");

                divisaInicial = read.nextLine();
                divisaInicial = divisaInicial.toUpperCase();

                while (!(divisaInicial.equals("ARS") ||
                        (divisaInicial.equals("BOB")) ||
                        (divisaInicial.equals("BRL")) ||
                        (divisaInicial.equals("CLP")) ||
                        (divisaInicial.equals("COP")) ||
                        (divisaInicial.equals("USD")) ||
                        (divisaInicial.equals("SALIR"))
                        )){

                    System.out.println("Usted no ingreso un codigo de divisa valido.");
                    System.out.println("Ten en cuenta que actualmente solo aceptamos las" +
                            " siguientes divisas:");
                    System.out.println();
                    System.out.println("ARS: Peso Argentino.");
                    System.out.println("BOB: Bolivar Boliviano.");
                    System.out.println("BRL: Real Brasileño.");
                    System.out.println("CLP: Peso Chileno.");
                    System.out.println("COP: Peso Colombiano.");
                    System.out.println("USD: Dolar Estadunidense.");
                    System.out.println();

                    System.out.println("Ingrese el codigo de la divisa que desea convertir:");
                    System.out.println("(Ejemplo: USD para Dolar Estadounidense)");
                    divisaInicial = read.nextLine();
                    divisaInicial = divisaInicial.toUpperCase();

                }

                if (divisaInicial.equalsIgnoreCase("SALIR")){
                    break;
                }

                String jsonDivisa = capturarJson.jsonDivisaComoString(divisaInicial);

                DivisaObj cambiosDeLaDivisa = convertidorJson.cambiosDivisa(jsonDivisa);

                System.out.println();
                System.out.println("_________________________________________________________");
                System.out.println();

                //verificacion de que la cantidad sea una cantidad valida:
                //(ni negativo, ni cero, ni un tipo de dato que no sea double

                while (true){

                    System.out.println("Ingrese la cantidad de " + divisaInicial + " que " +
                            "desea convertir:");

                    cantidadDivisaInicialAux = read.nextLine();

                    try{

                        cantidadDivisaInicial
                                = Double.parseDouble(cantidadDivisaInicialAux);

                        if (cantidadDivisaInicial > 0){
                            break;
                        } else {

                            System.out.println
                                    ("Error: El valor debe ser mayor a cero. Intente de nuevo.");
                            System.out.println();

                        }


                    } catch (NumberFormatException e){
                        System.out.println
                                ("Error: Entrada no válida. Por favor, ingrese un número.");
                        System.out.println();
                    }

                }

                //FIN VERIFICACION

                System.out.println("A que divisa quiere convertir sus " + cantidadDivisaInicial
                + " " + divisaInicial + "?");
                System.out.println();
                System.out.println("Ten en cuenta que actualmente solo aceptamos las" +
                        " siguientes divisas:");
                System.out.println();
                System.out.println("ARS: Peso Argentino.");
                System.out.println("BOB: Bolivar Boliviano.");
                System.out.println("BRL: Real Brasileño.");
                System.out.println("CLP: Peso Chileno.");
                System.out.println("COP: Peso Colombiano.");
                System.out.println("USD: Dolar Estadunidense.");
                System.out.println();

                nuevaDivisa = read.nextLine();
                nuevaDivisa = nuevaDivisa.toUpperCase();

                //verificacion de que sea una divisa valida:
                while (!(nuevaDivisa.equals("ARS") ||
                        (nuevaDivisa.equals("BOB")) ||
                        (nuevaDivisa.equals("BRL")) ||
                        (nuevaDivisa.equals("CLP")) ||
                        (nuevaDivisa.equals("COP")) ||
                        (nuevaDivisa.equals("USD"))
                )){

                    System.out.println("Usted no ingreso un codigo de divisa valido.");
                    System.out.println("Ten en cuenta que actualmente solo aceptamos las" +
                            " siguientes divisas:");
                    System.out.println();
                    System.out.println("ARS: Peso Argentino.");
                    System.out.println("BOB: Bolivar Boliviano.");
                    System.out.println("BRL: Real Brasileño.");
                    System.out.println("CLP: Peso Chileno.");
                    System.out.println("COP: Peso Colombiano.");
                    System.out.println("USD: Dolar Estadunidense.");
                    System.out.println();

                    System.out.println("A que divisa quiere convertir sus " + cantidadDivisaInicial
                            + " " + divisaInicial + "?");;
                    nuevaDivisa = read.nextLine();
                    nuevaDivisa = nuevaDivisa.toUpperCase();

                }

                cantidadNuevaDivisa = cambiosDeLaDivisa.convertirUnaMonedaHaciaOtra
                        (cantidadDivisaInicial, nuevaDivisa);

                System.out.println(divisaInicial + " " + cantidadDivisaInicial +
                        ": " + cantidadNuevaDivisa + " " + nuevaDivisa);

                System.out.println();
                System.out.println();
                System.out.println("_________________________________________________________");
                System.out.println();
                System.out.println("¿Desea realizar otra conversion o salir del programa?");
                System.out.println("PRESIONAR 1: Salir del programa.");
                System.out.println("PRESIONAR 2: Realizar otra conversion.");

                opcion = read.nextLine();

                while ((!(opcion.equalsIgnoreCase("1")))
                        && (!(opcion.equalsIgnoreCase("2")))){

                    System.out.println("Lo sentimos, usted ingreso un numero de opcion invalido.");
                    System.out.println();
                    System.out.println("¿Desea realizar otra conversion o salir del programa?");
                    System.out.println("PRESIONAR 1: Salir del programa.");
                    System.out.println("PRESIONAR 2: Realizar otra conversion.");
                    opcion = read.nextLine();

                }

                if (opcion.equalsIgnoreCase("1")){
                    break;
                }


            } catch (IOException e) {

                System.out.println("Ocurrio un error durante alguna operacion de entrada o salida" +
                        " (I/O) con el servidor.");
                System.out.println(e.getMessage());

            } catch (InterruptedException e) {

                System.out.println("Ocurrio un error debido a que un hilo en ejecucion ha sido" +
                        " interrumpido.");
                System.out.println(e.getMessage());

            }

        }

        System.out.println();
        System.out.println("Gracias por utilizar Xchanger! Esperamos volver a verte.");
        System.out.println();

    }

}
