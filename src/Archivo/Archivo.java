package Archivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony
 */
public class Archivo {

    private File archivo;
    private BufferedWriter escritor;

    public Archivo(String nombre) {
        archivo = new File("C:/Users/CPU/Desktop", nombre + ".xml");
    }

    public void crear() {
        try {
            archivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribir(String string) {
        try {
            escritor = new BufferedWriter(new FileWriter(archivo, true));
            escritor.write(string);
            escritor.newLine();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limpiar() {
        try {
            escritor = new BufferedWriter(new FileWriter(archivo, false));
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrar() {
        try {
            escritor.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardar() {
        try {
            escritor.flush();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
