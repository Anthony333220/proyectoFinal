/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Emanuel CB
 */
public class PruebaConexion {
    
    
    private Statement sentencias;
    private ResultSet datos;
    private Connection conexion;
    private String driver = "com.mysql.jdbc.Driver";
    private String user ="root" ;
    private String password ="";
    private String url = "jdbc:mysql://localhost:3306/riteve?useServerPrepStmts=true";
     
    public Connection getConectar() {
       conexion = null; 
       
        try {
            
  //           Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
            this.sentencias=this.conexion.createStatement();
            System.out.println("si se connecto bien");
            if(conexion!=null)
            {
                System.out.println("se conecto la bien");
            }       
            
             
        } catch (SQLException e) {
            
            System.out.println("no se conecto la bien");
            
        }
        return conexion;
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

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
//   public static void main(String[]arg){
//       
//       PruebaConexion p=new PruebaConexion();
//       p.getConectar();
//   }
//        
    
}
