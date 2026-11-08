/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modelo.Costo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author Garme
 */
public class ArchivoVehiculoDAO {
    private static final String RUTA_ARCHIVO = "autos.txt"; 
    
    public void guardarVenta (Costo auto) throws IOException {
        
        try (PrintWriter write = new PrintWriter(new FileWriter(RUTA_ARCHIVO, true))) {
        write.println(
        auto.getId() + ";" + 
        auto.getMarca() + ";" + 
        auto.getModelo() + ";" + 
        auto.getEspecificaciones().getCilindraje() + ";" + 
        auto.getEspecificaciones().getTransmision() + ";" + 
        auto.getCostoNeto() + ";" + 
        auto.getDescuento() + ";" + 
        auto.calcularPrecio()
    );
}
    }
    
     public ArrayList<String> leerAutos() throws IOException {
        ArrayList<String> lista = new ArrayList<>();
        File file = new File(RUTA_ARCHIVO);
        if(!file.exists()) return lista;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            while((linea = reader.readLine()) != null) {
                lista.add(linea);
            }
        }
        return lista;
    }
}
