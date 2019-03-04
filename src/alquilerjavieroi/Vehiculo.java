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
public class Vehiculo {
    
    // Creacion de atributos
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;

    public static Vehiculo crearVehiculoAlt() {
        Vehiculo v = new Vehiculo();
        int numAlt;
        Random alt = new Random();

        String[] colores = {"Rojo", "Azul", "Blanco"};
        numAlt = alt.nextInt(3);
        v.color = colores[numAlt];

        String[] marcas = {"Renault", "Seat", "Peugeot"};
        numAlt = alt.nextInt(3);
        v.marca = marcas[numAlt];

        switch (numAlt) {
            case 0:
                numAlt = alt.nextInt(3);
                String[] modeloRen = {"Clio", "Megane", "Captur"};
                v.modelo = modeloRen[numAlt];
                break;
            case 1:
                numAlt = alt.nextInt(3);
                String[] modeloSea = {"Ibiza", "Leon", "Toledo"};
                v.modelo = modeloSea[numAlt];
                break;
            case 2:
                numAlt = alt.nextInt(3);
                String[] modeloPeu = {"208", "308", "508"};
                v.modelo = modeloPeu[numAlt];
                break;

        }

        double[] tarf = {120, 90, 170};
        numAlt = alt.nextInt(3);
        v.tarifa = tarf[numAlt];

        v.disponible = alt.nextBoolean();

        String[] numMatr = new String[7];

        for (int i = 0; i < numMatr.length; i++) {
            if (i < 4) {
                numAlt = alt.nextInt(10);
                String num = Integer.toString(numAlt);
                numMatr[i] = num;
            } else {
                char letra = (char) (alt.nextInt(122 - 97) + 97);
                char mayusc = Character.toUpperCase(letra);
                String l = String.valueOf(mayusc);
                numMatr[i] = l;
            }

        }

        v.matricula = numMatr[0] + numMatr[1] + numMatr[2] + numMatr[3] + " " + numMatr[4] + numMatr[5] + numMatr[6];
        return v;
    }

    //Constructor por defecto
    public Vehiculo() {

    }

    // Constructor parametrizado
    public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }

    // Getters, setters y toString
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", tarifa=" + tarifa + ", disponible=" + disponible + '}';
    }

    
}
