package Archivo;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Configuraciones {

    private Connection conexion;

    private  Statement sentencias;
    private   ResultSet datos;

    public Connection getConectar() {

        try {
            InputStream isArchi = new FileInputStream("C:\\Users\\user\\Documents\\NetBeansProjects\\sistemaRiteve\\src\\Archivo\\base.properties");
            Properties propiedad = new Properties();
            propiedad.load(isArchi);
            String url = propiedad.getProperty("base.url"), usuario = propiedad.getProperty("base.usuario"), contra = propiedad.getProperty("base.contra");
            isArchi.close();
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando.....");
            // this.sentencias=conexion.createStatement();
            conexion = DriverManager.getConnection(url, usuario, contra);
            System.out.println("Conexion establecida");
            JOptionPane.showMessageDialog(null, "Conexion establecida properties");

        } catch (Exception e) {
            System.out.println("error de connection devido a" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Conexion erronea Configure Archivo.properties");
        }
        return conexion;

    }
    
    

//
//public Connection conectar2(String url, String usuario, String contra) {
//
//        try {
//
//            InputStream isArchi = new FileInputStream("C:\\Users\\user\\Documents\\NetBeansProjects\\SistemaRiteve\\src\\Archivo\\base.properties");
//            Properties propi = new Properties();
//            propi.load(isArchi);
//
//            Class.forName("com.mysql.jdbc.Driver");
//            conexion=DriverManager.getConnection(url, usuario, contra);
//            propi.setProperty("base.url", url);
//            propi.setProperty("base.usuario", usuario);
//            propi.setProperty("base.contra", contra);
//            JOptionPane.showMessageDialog(null, "se establecio  la conexion");
//            try {
//                propi.store(new FileWriter("src\\Archivo\\base.properties"), "Se actualizo los datos");
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e.getMessage());
//            }
//
//        } catch (Exception e) {
//            System.out.println("error al agregar datos" + e.getMessage());
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//        return conexion;
//    }
//
//
//    public Connection getConexion() {
//        return conexion;
//    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSentencias() {
        return sentencias;
    }

    public void setSentencias(Statement sentencias) {
        this.sentencias = sentencias;
    }

    public ResultSet getDatos() {
        return datos;
    }

    public void setDatos(ResultSet datos) {
        this.datos = datos;
    }
}
