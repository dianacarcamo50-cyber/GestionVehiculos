/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Garme
 */
public abstract class Auto {

    private int id;
    private String marca;
    private int modelo;

    public Auto(int id, String marca, int modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }
   
    
    public abstract double calcularPrecio(); 
}
