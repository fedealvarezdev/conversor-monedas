package org.example.conversor;

import java.util.Scanner;

public class App
{

    public static void main( String[] args )
    {
        int opcion;
        double monto;
        Moneda moneda1;
        Moneda moneda2;
        double resultado;
        Scanner teclado = new Scanner(System.in);
        Conversor conversor = new Conversor();

        do{
            menu();
            opcion = teclado.nextInt();
            System.out.println("Ingrese el valor que desea convertir:");
            monto = teclado.nextDouble();

            switch(opcion) {
                case 1:
                    moneda1 = Moneda.USD;
                    moneda2 = Moneda.ARS;
                    break;
                case 2:
                    moneda1 = Moneda.ARS;
                    moneda2 = Moneda.USD;
                    break;
                case 3:
                    moneda1 = Moneda.USD;
                    moneda2 = Moneda.BRL;
                    break;
                case 4:
                    moneda1 = Moneda.BRL;
                    moneda2 = Moneda.USD;
                    break;
                case 5:
                    moneda1 = Moneda.USD;
                    moneda2 = Moneda.COP;
                    break;
                case 6:
                    moneda1 = Moneda.COP;
                    moneda2 = Moneda.USD;
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    System.exit(0);
                default:
                    System.out.println("Opcion invalida");
                    continue;
            }

            resultado = conversor.convertirMondeda(moneda1, moneda2, monto);

            System.out.println(monto + " ["+moneda1+"] son "+resultado +  " ["+moneda2+"]");

        }while(true);
    }

    public static void menu(){
        System.out.println("""
                
                #######################################
                Bienvenido al conversor de Monedas
                
                1) Dólar => Peso Argentino
                2) Peso Argentino => Dólar
                3) Dólar => Real Brasileño
                4) Real Brasileño => Dólar
                5) Dólar => Peso Colombiano
                6) Peso Colombiano => Dólar
                7) Salir
                
                Elija una opcion válida :
                """);
    }
}
