/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilerjavieroi;

import java.util.Scanner;

/**
 *
 * @author javier
 */
public class Main {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        // Creacion objeto de EmpresaAlquiler
        EmpresaAlquiler easydrive = new EmpresaAlquiler("A-28-187189", "easy drive", "www.easydrive.com");

        // Rellenar Clientes y Vehiculos
        easydrive.rellenarClientes();
        easydrive.rellenarVehiculos();

        // Imprimir listas
        easydrive.imprimirClientes();
        easydrive.imprimirVehiculo();

        // Solicitar vehiculo que alquilar
        System.out.println("");
        System.out.println("ALQUILER DE VEHICULO");
        System.out.println("Introduzca su nif");
        String nif = tec.nextLine();
        System.out.println("Introduzca la matrícula del vehículo que desea alquilar");
        String matricula = tec.nextLine();
        System.out.println("Introduzca el número de días que desea alquilarlo");
        int diasAlq = tec.nextInt();

        //Alquilar vehículo
        easydrive.alquilarVehiculo(nif, matricula, diasAlq);

        // Mostrar alquiler
        if (easydrive.getTotalAlquileres() != 0 && easydrive.obtenerCliente(nif)!=-1) {
            System.out.println(easydrive.getAlquileres());
        } else {
            System.out.println("No existe ningún alquiler en el sistema");
        }

        // Ordenar clientes
        easydrive.ordenarCarteraClientes();
        easydrive.ordenarCatalogoVehiculos();
        easydrive.imprimirClientes();
        easydrive.imprimirVehiculo();

        // Buscar cliente        
        System.out.println("");
        System.out.println("Introduzca el nif del cliente que desea buscar");
        tec.nextLine();
        String nif3 = tec.nextLine();
        if (easydrive.obtenerCliente(nif3) == -1) {
            System.out.println("El cliente no está en el sistema");
        } else {
            System.out.println(nif3 + " está en el array y está en la posición " + easydrive.obtenerCliente(nif3));
        }

        // Buscar vehiculo
        System.out.println("");
        System.out.println("Introduzca la matricula del vehiculo que desea buscar");
        String matricula2 = tec.nextLine();
        if (easydrive.obtenerVehiculo(matricula2) == -1) {
            System.out.println("El vehiculo no está en el sistema");
        } else {
            System.out.println(matricula2 + " está en el array y está en la posición " + easydrive.obtenerVehiculo(matricula2));
        }

    }

}
