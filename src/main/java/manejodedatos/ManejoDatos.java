/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodedatos;

import java.io.File;
import java.io.FileWriter;
import com.mycompany.arduinojavamaven.Estacionamiento;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author Ce
 */
public class ManejoDatos {


     public  void aniadirArchivo(String lista, String Path) {
        FileWriter flwriter = null;
        try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
            flwriter = new FileWriter(Path, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            
                bfwriter.write(lista);
                bfwriter.newLine();
            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
        
    
    
    
    
    public void guardarLecturaPath(String mensaje) throws IOException {
        FileWriter writer = null;
        writer = new FileWriter("C:\\Users\\Ce\\Desktop\\taller\\ejemplo.txt");
        BufferedWriter bwriter = new BufferedWriter(writer);
        bwriter.write(mensaje);
        bwriter.close();

    }
    

    public void archivo(String uso) {
System.out.println("archivo guaradadp");
        try {
//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("registro.txt");

//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);

//Escribimos en el archivo con el metodo write 
            escribir.write(uso);

//Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            
            System.out.println("Error al escribir");
        }
    }
}
