package Controladores;

import Archivo.PruebaConexion;
import Clases.Cita;
import Clases.Secretaria;
import Vistas.FrmPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author Emanuel CB
 */
public class ControladorCitas {

    private Statement sentencias;
    private ResultSet datos;

    private ControladorSecretaria ctls = new ControladorSecretaria();
    private Secretaria secretaria;
    private Statement sentencias2;

    private PruebaConexion conn;

    public ControladorCitas(Statement sentencias, ResultSet datos, Secretaria secretaria, Statement sentencias2, PruebaConexion conn) {
        this.sentencias = sentencias;
        this.datos = datos;
        this.secretaria = secretaria;
        this.sentencias2 = sentencias2;
        this.conn = conn;
    }

    public ControladorCitas(PruebaConexion conn) {
        this.conn = conn;
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();

    }

    public ControladorCitas() {

        conn = FrmPrincipal.getConexion();  //probar com conexion o conectar
        try {
            this.sentencias2 = FrmPrincipal.getConexion().getConexion().createStatement();
        } catch (SQLException ex) {

            System.out.println("No se lo gro conectar sentencia  con la conexion");
        }

        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();
    }
    
    public boolean crearCita(Cita cita){
        
        System.out.println("antes de crear la cita el try");
        try {
            
           SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
         
           sentencias.execute("insert into citas values(null,'"+fecha.format(cita.getFecha())+"','"+cita.getHora()+"','"+cita.getVehiculo().getPlaca()+"','"
           +cita.getVehiculo().getMarca()+"','"+cita.getVehiculo().getModelo()+"','"+cita.getVehiculo().getAnio()+"','"+cita.getVehiculo().getFechaInscripcion()+
           "','"+cita.getVehiculo().getCedula()+"','"+cita.getVehiculo().getNombrePropietario()+"')");
            System.out.println("si se logro crear cita");
           
            
            
            return true;  
           
           
        } catch (SQLException ex) {
            
            
            System.out.println("No se logro crear cita devido a"+ex.getMessage());
            System.out.println(ex);
        }
        return false;
    }
    

}
