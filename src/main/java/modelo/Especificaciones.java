/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.io.Serializable;

/**
 *
 * @author Garme
 */
public class Especificaciones implements Serializable {

    private String Cilindraje;
    private String transmision;

    public Especificaciones(String Cilindraje, String transmision) {
        this.Cilindraje = Cilindraje;
        this.transmision = transmision;
    }
    
    public String getCilindraje() {
        return Cilindraje;
    }

    public String getTransmision() {
        return transmision;
    }

    @Override
    public String toString() {
        return Cilindraje + ", " + transmision; 
    }
}
