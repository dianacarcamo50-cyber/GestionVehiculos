/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Garme
 */
public class Costo extends Auto {
    
    private Especificaciones especificaciones;
    private double costoNeto;
    private double descuento; 
    public static int contadorAutos = 0;
    
      public Costo(int id, String marca, int modelo, Especificaciones especificaciones,double costoNeto, double descuento) {
        super(id, marca, modelo); 
        this.especificaciones = especificaciones;
        this.costoNeto = costoNeto;
        this.descuento = descuento;
        contadorAutos++; 
    }
   
    public Especificaciones getEspecificaciones() {
        return especificaciones;
    }

    public double getCostoNeto() {
        return costoNeto;
    }

    public double getDescuento() {
        return descuento;
    }

    public static int getContadorAutos() {
        return contadorAutos;
    }
    
  
 
    
    @Override
    public double calcularPrecio() {
        return costoNeto - descuento;
    }
}