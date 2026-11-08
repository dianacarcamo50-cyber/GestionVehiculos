/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionvehiculos;

import controlador.VehiculoController;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionVehiculos {

    public static void main(String[] args) {
        VehiculoController controller = new VehiculoController();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE VEHÍCULOS =====");
            System.out.println("1. Registrar nuevo vehículo");
            System.out.println("2. Listar vehículos guardados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Ingrese un número entero.");
                continue;
            }

            switch (opcion) {
                case 1:
                    registrar(controller, scanner);
                    break;
                case 2:
                    listar(controller);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void registrar(VehiculoController controller, Scanner scanner) {
        try {
            System.out.println("\n--- REGISTRAR NUEVO VEHÍCULO ---");
            
            System.out.print("ID del vehículo: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Marca: ");
            String marca = scanner.nextLine();

            System.out.print("Modelo (Año): ");
            int modelo = Integer.parseInt(scanner.nextLine());

            System.out.print("Cilindraje (ej. 2.0L): ");
            String cilindraje = scanner.nextLine();

            System.out.print("Transmisión (ej. Automática / Manual): ");
            String transmision = scanner.nextLine();

            System.out.print("Costo Neto: ");
            double costoNeto = Double.parseDouble(scanner.nextLine());

            System.out.print("Descuento: ");
            double descuento = Double.parseDouble(scanner.nextLine());

            boolean éxito = controller.registrarVehiculo(id, marca, modelo, cilindraje, transmision, costoNeto, descuento);

            if (éxito) {
                System.out.println("¡Vehículo guardado exitosamente en el archivo!");
            } else {
                System.out.println("Ocurrió un error al intentar guardar el vehículo.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error de entrada: Verifique haber ingresado números válidos para ID, Modelo, Costo o Descuento.");
        }
    }

    private static void listar(VehiculoController controller) {
        System.out.println("\n--- LISTA DE VEHÍCULOS REGISTRADOS ---");
        ArrayList<String> lista = controller.listarVehiculos();

        if (lista.isEmpty()) {
            System.out.println("No hay vehículos registrados o el archivo está vacío.");
        } else {
            System.out.println("ID ; MARCA ; MODELO ; CILINDRAJE ; TRANSMISIÓN ; COSTO NETO ; DESCUENTO ; PRECIO FINAL");
            System.out.println("----------------------------------------------------------------------------------");
            for (String linea : lista) {
                System.out.println(linea);
            }
        }
    }
}