/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilerjavieroi;

import java.util.Random;

/**
 *
 * @author javier
 */
public class Cliente {
    
    //Atributos
    private String nif;
    private String nombre;
    private String apellidos;

    // Método para generar cliente aleatorio
    public static Cliente generarCliente() {
        Cliente c = new Cliente();
        Random alt = new Random();
        int numAlt;

        String[] apel = {"Gómez", "Ramírez", "López", "Álvarez", "Sánchez"};
        String[] apl2 = new String[2];
        for (int i = 0; i < 2; i++) {
            numAlt = alt.nextInt(5);
            apl2[i] = apel[numAlt];
        }

        c.apellidos = apl2[0] + " " + apl2[1];

        String[] nomb = {"Juan", "Ana", "Antonio", "Carmen", "Javier"};
        numAlt = alt.nextInt(5);
        c.nombre = nomb[numAlt];

        String[] dni = new String[9];

        for (int i = 0; i < dni.length; i++) {
            if (i < 8) {
                numAlt = alt.nextInt(10);
                String num = Integer.toString(numAlt);
                dni[i] = num;
            } else {
                char letra = (char) (alt.nextInt(122 - 97) + 97);
                char mayusc = Character.toUpperCase(letra);
                String l = String.valueOf(mayusc);
                dni[i] = l;
            }

        }

        c.nif = dni[0] + dni[1] + dni[2] + dni[2] + dni[4] + dni[5] + dni[6] + dni[7] + dni[8];

        return c;

    }
    // Constructor por defecto

    public Cliente() {

    }

    //Constructor paramentrizado
    public Cliente(String nif, String nombre, String apellidos) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    //Getters, setters y toString
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
    
}
