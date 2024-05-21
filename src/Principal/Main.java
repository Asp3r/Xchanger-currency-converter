package Principal;

import Modelos.CapturadorDeJson;
import Modelos.ConvertidorJsonEnDivisaObjeto;
import Modelos.DivisaObj;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        CapturadorDeJson capturarJson = new CapturadorDeJson();
        ConvertidorJsonEnDivisaObjeto convertidorJson = new ConvertidorJsonEnDivisaObjeto();
        Scanner read = new Scanner(System.in);

        String divisaInicial;

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

                    System.out.println("Ingrese el codigo de la divisa que desea convertir.");
                    System.out.println("(Ejemplo: USD para Dolar Estadounidense)");
                    divisaInicial = read.nextLine();
                    divisaInicial = divisaInicial.toUpperCase();

                }

                if (divisaInicial.equalsIgnoreCase("SALIR")){
                    break;
                }

                String jsonDivisa = capturarJson.jsonDivisaComoString(divisaInicial);

                DivisaObj cambiosDeLaDivisa = convertidorJson.cambiosDivisa(jsonDivisa);



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
