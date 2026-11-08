/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Costo;
import modelo.Especificaciones;
import persistencia.ArchivoVehiculoDAO;
import java.io.IOException;
import java.util.ArrayList;

public class VehiculoController {

    private ArchivoVehiculoDAO dao;

    public VehiculoController() {
        this.dao = new ArchivoVehiculoDAO();
    }
    
    public boolean registrarVehiculo(int id, String marca, int modelo, 
                                     String cilindraje, String transmision, 
                                     double costoNeto, double descuento) {
        try {
            Especificaciones espec = new Especificaciones(cilindraje, transmision);
            Costo Auto = new Costo(id, marca, modelo, espec, costoNeto, descuento);
            dao.guardarVenta(Auto);

            return true; 
        } catch (IOException e) {
            System.err.println("Error de E/S al guardar el vehículo: " + e.getMessage());
            return false; 
        }
    }

 
    public ArrayList<String> listarVehiculos() {
        try {
            return dao.leerAutos();
        } catch (IOException e) {
            System.err.println("Error de E/S al leer los vehículos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
