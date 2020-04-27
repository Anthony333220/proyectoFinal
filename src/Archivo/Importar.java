package Archivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Anthony
 */
public class Importar {

    private String nombre;
    private String ruta;
    private File archivo;
    private BufferedReader lector;
    private BufferedWriter escritor;
    private NodeList listaCaracteristicas;

    public void abrir(String nombre) {
        try {
            archivo = new File("C:/Users/CPU/Desktop", nombre + ".xml");
            if (!archivo.exists()) {
                archivo.createNewFile();
                lector = new BufferedReader(new FileReader(archivo));
                escritor = new BufferedWriter(new FileWriter(archivo, true));
                escritor = new BufferedWriter(new FileWriter(archivo, false));

                escritor.flush();
            }
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder construdocumenento = dbf.newDocumentBuilder();
            Document documento = construdocumenento.parse(archivo);
            documento.getDocumentElement().normalize();
            listaCaracteristicas = documento.getElementsByTagName("Revisiones");
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribir(String string) {
        try {
            escritor.write(string);
            escritor.newLine();
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
