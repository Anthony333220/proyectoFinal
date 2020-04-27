package Controladores;

import Archivo.PruebaConexion;
import Clases.Secretaria;
import Vistas.FrmMenuPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel CB
 */
public class ControladorSecretaria {

    private PruebaConexion conn;
    private Statement sentencias;
    private ResultSet datos;
    private Secretaria secretaria;

    public ControladorSecretaria(PruebaConexion conn) {
        this.conn = conn;
        this.sentencias = sentencias;
        this.datos = datos;
    }

    public ControladorSecretaria() {
        conn = FrmMenuPrincipal.getConexion();

        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();
    }

    

    public boolean crearSecretaria(Secretaria secretaria) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            sentencias.execute("insert into secretaria values(null,'" + secretaria.getCedula()
                    + "','" + secretaria.getNombre() + "','" + f.format(secretaria.getFechaNacimiento())
                    + "','" + secretaria.getTelefono() + "','" + secretaria.getCorreoElectrónico() +"')");

            System.out.println("si se creo secretaria");
            return true;

        } catch (SQLException ex) {
            System.out.println("no se creo secretaria");
        }
        return false;
    }

    public Secretaria buscarSecretaria(Secretaria secretaria) {
        try {

            this.datos = this.sentencias.executeQuery("select * from secretaria where cedula="
                    + secretaria.getCedula());

            if (datos.next()) {

                Secretaria cliente2 = new Secretaria();
                cliente2.setCedula(datos.getInt(2));
                cliente2.setNombre(datos.getString(3));
                cliente2.setFechaNacimiento(datos.getDate(4));
                cliente2.setTelefono(datos.getInt(5));
                cliente2.setCorreoElectrónico(datos.getString(6));

                return cliente2;
            }
        } catch (SQLException ex) {

            System.out.println("No se logro hayar Secretaria");
        }
        return null;
    }

    public boolean deleteSecretaria(Secretaria secretaria) {
        try {
            this.sentencias.executeUpdate("delete from secretaria where cedula="
                    + secretaria.getCedula());

            System.out.println("si se logro eliminar");
            
            JOptionPane.showMessageDialog(null, "Se logro borrar el registro");
            return true;

        } catch (SQLException ex) {

            System.out.println("no se pudo borrar");
        }
        return false;
    }
    public boolean actualizarSecretaria(Secretaria secretaria) {
        try {
            SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");            
            
            this.sentencias.executeUpdate("UPDATE secretaria SET nombre='" + secretaria.getNombre() 
             + "',fechaNacimiento='" + fecha.format(secretaria.getFechaNacimiento()) + "',telefono='" + secretaria.getTelefono() 
             + "',correoElectronico='" + secretaria.getCorreoElectrónico() + "'  WHERE cedula ='" +secretaria.getCedula() + "';");
            return true;
        } catch (SQLException ex) {       
            System.out.println("No se lofro actualizar la secretaria");
        }
        return false;
    }

    public ArrayList<Secretaria> listaSecretarias() {
        ArrayList<Secretaria> listadoSecretarias = new ArrayList();
        try {
            this.datos = this.sentencias.executeQuery("select * from clientes");

            while (datos.next()) {
                listadoSecretarias.add(new Secretaria(datos.getInt(2), datos.getString(3), datos.getDate(4), datos.getInt(5), datos.getString(6)));
            }
            return listadoSecretarias;

        } catch (SQLException ex) {
            System.out.println("no se agrego secretaria");
        }
        return null;
    }
}
