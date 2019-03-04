/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilerjavieroi;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author javier
 */
public class EmpresaAlquiler {
    // Atributos propios de la Empresa
    private String cif;
    private String nombre;
    private String paginaWeb;

    // Atributos para determinar el número de clientes de la empresa y array 
    // para almacenarlos
    private int totalClientes;
    private ArrayList<Cliente> clientes;

    // Atributos para determinar el número total de vehículos de la empresa
    // y array para almacenarlos
    private int totalVehiculos;
    private ArrayList<Vehiculo> vehiculos;

    // Atributos para determinar el número total de alquileres de la empresa
    // y array para almacenarlos
    private int totalAlquileres;
    private ArrayList<VehiculoAlquilado> alquileres;

    // Constructor parametrizado. Se le pasará cif,nombre y página web de empresa.
    // Establecerá el número de clientes,vehículos y alquileres en 0.
    // Determinará que el máximo número de clientes y vehículos será 50, mientras que
    // el número de alquileres será 100.    
     public EmpresaAlquiler(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;

        this.totalClientes = 0;
        this.clientes = new ArrayList<>();

        this.totalVehiculos = 0;
        this.vehiculos = new ArrayList<>();

        this.totalAlquileres = 0;
        this.alquileres = new ArrayList<>();

    }

    // Constructor parametrizado pero que se le pasen todos los atributos.
     public EmpresaAlquiler(String cif, String nombre, String paginaWeb, int totalClientes, ArrayList clientes, int totalVehiculos, ArrayList vehiculos, int totalAlquileres, ArrayList alquileres) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.totalClientes = totalClientes;
        this.clientes = clientes;
        this.totalVehiculos = totalVehiculos;
        this.vehiculos = vehiculos;
        this.totalAlquileres = totalAlquileres;
        this.alquileres = alquileres;
    }

    public void ordenarCarteraClientes() {

        int igual;
        Cliente c;
        Cliente c2;

        for (int i = 0; i < this.totalClientes - 1; i++) {
            for (int j = i + 1; j < this.totalClientes; j++) {
                igual = this.clientes.get(i).getNif().compareTo(this.clientes.get(j).getNif());
                if (igual > 0) {

                    c = this.clientes.get(i);
                    c2 = this.clientes.get(j);
                    this.clientes.set(i, c2);
                    this.clientes.set(j, c);

                }
            }
        }
    }

    public void ordenarCatalogoVehiculos() {

        int igual;
        Vehiculo v;
        Vehiculo v2;

        for (int i = 0; i < this.totalVehiculos - 1; i++) {
            for (int j = i + 1; j < this.totalVehiculos; j++) {
                igual = this.vehiculos.get(i).getMatricula().compareTo(this.vehiculos.get(j).getMatricula());

                if (igual > 0) {
                    v = this.vehiculos.get(i);
                    v2 = this.vehiculos.get(j);
                    this.vehiculos.set(i, v2);
                    this.vehiculos.set(j, v);

                }
            }
        }
    }

    public int obtenerCliente(String nif) {
        System.out.println("");
        ordenarCarteraClientes();
        int igual;
        int n = this.clientes.size();
        int centro, inf = 0, sup = n - 1;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            igual = this.clientes.get(centro).getNif().compareTo(nif);
            if (igual == 0) {                
                return centro;
            } else if (igual > 0) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }

        }
        
        return -1;

    }

    public int obtenerVehiculo(String matricula) {
        System.out.println("");
        ordenarCatalogoVehiculos();
        int igual;
        int n = this.vehiculos.size();
        int centro, inf = 0, sup = n - 1;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            igual = this.vehiculos.get(centro).getMatricula().compareTo(matricula);
            if (igual == 0) {                
                return centro;
            } else if (igual > 0) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }

        }
        
        return -1;

    }

    public void rellenarClientes() {

        for (int i = 0; i < 25; i++) {
            registrarCliente(Cliente.generarCliente());
        }
    }

    public void rellenarVehiculos() {

        for (int i = 0; i < 25; i++) {
            registrarVehiculo(Vehiculo.crearVehiculoAlt());
        }
    }

    // Método para añadir clientes a la empresa. Se le pasará un objeto de la 
    // clase Cliente y lo asignará al array de Clientes. Además sumará uno
    // al total de clientes cada vez que se ejecute.
    public void registrarCliente(Cliente nuevo) {

        this.clientes.add(nuevo);

        this.totalClientes++;

    }

    // Método para añadir vehículos a la empresa. Mismo funcionamiento que
    // método registrarCliente().
     public void registrarVehiculo(Vehiculo nuevo) {

        this.vehiculos.add(nuevo);

        this.totalVehiculos++;
    }

    // Método para mostrar los datos de los clientes por pantalla. Mediante un 
    // for se recorrerá el array mostrando el valor de cada cliente mediante
    // el método toString.
    public void imprimirClientes() {

        System.out.println("");

        for (int i = 0; i < this.totalClientes; i++) {
            System.out.println(this.clientes.get(i).toString());
        }
    }

    // Método para mostrar los datos de vehículos. Mismo funcionamiento que 
    // método imprimirClientes().
    public void imprimirVehiculo() {

        System.out.println("");

        for (int i = 0; i < this.totalVehiculos; i++) {
            System.out.println(this.vehiculos.get(i).toString());
        }
    }
    
    public void imprimirAlquileres() {

        System.out.println("");

        for (int i = 0; i < this.totalAlquileres; i++) {
            System.out.println(this.alquileres.get(i).toString());
        }

    }

    // Método privado. Se le pasará un nif y te devolverá el Cliente que
    // corresponda, siempre y cuando éste forme parte del array ( en este caso
    // devuelve null). Lo hará mediante un for que recorrerá el array y un 
    // if else dentro de éste que devolverá el cliente cuando lo encuentre.
    private Cliente getCliente(String nif) {
        for (int i = 0; i < this.totalClientes; i++) {
            if (this.clientes.get(i).getNif().equals(nif)) {
                return this.clientes.get(i);
            }
        }
        return null;
    }

    // Método privado. Mismo funcionamiento que método getCliente(String nif)
    // pero para devolver Vehículos mediante una busqueda en base a matrícula.
    private Vehiculo getVehiculo(String matricula) {

        for (int i = 0; i < this.totalVehiculos; i++) {

            if (this.vehiculos.get(i).getMatricula().equals(matricula)) {
                return this.vehiculos.get(i);
            }
        }

        return null;
    }

    // Métodos para determinar dia,mes y año de hoy. Usaran la clase LocalDate
    // y el método getDayOfMonth(), getMonthValue() y getYear().
    public int diaHoy() {

        LocalDate date = LocalDate.now();

        return date.getDayOfMonth();
    }

    public int mesHoy() {

        LocalDate date = LocalDate.now();

        return date.getMonthValue();

    }

    public int anioHoy() {

        LocalDate date = LocalDate.now();

        return date.getYear();
    }

    // Método para registrar el alquiler de un vehículo. Se le pasarán el 
    // nif del cliente que alquila, la matricula del vehículo que alquila
    // y el número de días que lo alquila. Internamente se crearan dos objetos
    // Vehículo y Cliente para darles los valores de cliente y vehiculos
    // involucrados en la operación. Para hacer esto se utilizarán los métodos
    // getCiente() y getVehiculo(). 
    // Mediante un if se determina si el vehiculo está disponible o no.
    // En caso de estarlo pasará a dejar de estar disponible y se añadirá
    // un objeto de alquiler al array de alquileres. Se sumará uno al valor
    // de alquileres totales.
    public void alquilarVehiculo(String nif, String matricula, int dias) {

        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);

        if (vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            VehiculoAlquilado v = new VehiculoAlquilado(cliente, vehiculo, diaHoy(), mesHoy(), anioHoy(), dias);
            this.alquileres.add(v);

            this.totalAlquileres++;
        }

    }

    // Método para hacer que un vehículo no disponible pase al estado de 
    // disponible. Se le pasará la matrícula del vehículo que se devuelve.
    // Internamente se creará un objeto vehículo con el mismo fin que en el método
    // alquilarVehículo(). Mediante un if se volverá a establecer el estado de
    // disponible.
    public void recibirVehiculo(String matricula) {

        Vehiculo vehiculo = getVehiculo(matricula);

        if (vehiculo != null) {
            vehiculo.setDisponible(true);

        }
    }

    // Getters y setters.
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(int totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }

    public ArrayList<VehiculoAlquilado> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(ArrayList<VehiculoAlquilado> alquileres) {
        this.alquileres = alquileres;
    }
    
}
