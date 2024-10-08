package Colas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menuCola();
    }


    public static void menuCola() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño maximo de archivos en espera: ");
        int capacidad = scanner.nextInt();
        String paginasImprimir = scanner.nextLine();
        boolean imprimir = false;
        Cola cola = new Cola(capacidad);

        while (true) {
            System.out.println("\n1. Seleccione el archivo");
            System.out.println("2. Realizar Impresion");
            System.out.println("3. Mostrar Lista de Archivos Pendiente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del Archivo que desea Imprimir: ");
                    String nombre = scanner.next();
                    System.out.print("¿Desea imprimir todas las paginas? ");
                    imprimir = scanner.nextBoolean();
                    if (!imprimir) {
                        System.out.print("Seleccione el numero de paginas que desea imprimir: ");
                        paginasImprimir = scanner.next();
                    }
                    try {
                        cola.encolar(nombre);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        cola.desencolar();
                        if (!imprimir){
                            System.out.println("Paginas impresas: " + paginasImprimir);
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    cola.mostrarCola();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}