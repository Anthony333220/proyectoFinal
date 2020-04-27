package Controladores;

import Archivo.PruebaConexion;
import Clases.Tecnico;
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
public class ControladorTecnicos {

    private PruebaConexion conn;
    private Statement sentencias;
    private ResultSet datos;
    private Tecnico tecnico;

    public ControladorTecnicos() {
        conn = FrmMenuPrincipal.getConexion();
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();
    }

    public ControladorTecnicos(PruebaConexion conn) {
        this.conn = conn;
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();
    }

    public PruebaConexion getConn() {
        return conn;
    }

    public Statement getSentencias() {
        return sentencias;
    }

    public ResultSet getDatos() {
        return datos;
    }

    public boolean agregarTecnico(Tecnico tecnico) {
        System.out.println("antes de la sentencia  de agregar Tecnico");
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

            sentencias.execute("INSERT INTO tecnicos VALUES(null," + tecnico.getCedula() + ",'" + tecnico.getNombre() + "','" + 
                    f.format(tecnico.getFechaNacimiento()) + "'," + tecnico.getTelefono() + ",'" + tecnico.getCorreoElectrónico() + "'," + 
                    tecnico.getSalario() + ")");

            System.out.println(" si se cimplio la sentencia");

            return true;
        } catch (SQLException ex) {
            System.out.println("Error al añadir");
        }
        return false;
    }

    public boolean eliminarTecnico(Tecnico tecnico) {
        System.out.println(" antes de la sentencia");
        try {
            this.sentencias.executeUpdate("delete from tecnicos where cedula=" + tecnico.getCedula());

            System.out.println(" si se elimino tecnico");
            return true;
        } catch (SQLException ex) {
            System.out.println("No se borro el tecnico");
            JOptionPane.showMessageDialog(null, "NO SE BORRO TECNICO" + ex.getMessage());
        }
        return false;
    }

    public Tecnico buscarTecnico(Tecnico tecnico) {
        try {
            this.datos = this.sentencias.executeQuery("select * from tecnicos where cedula=" + tecnico.getCedula());

            if (datos.next()) {
                Tecnico tecnicoSiguiente = new Tecnico();

                tecnicoSiguiente.setCedula(datos.getInt(2));
                tecnicoSiguiente.setNombre(datos.getString(3));
                tecnicoSiguiente.setFechaNacimiento(datos.getDate(4));
                tecnicoSiguiente.setTelefono(datos.getInt(5));
                tecnicoSiguiente.setCorreoElectrónico(datos.getString(6));
                tecnicoSiguiente.setSalario(datos.getDouble(7));

                return tecnicoSiguiente;
            }
        } catch (SQLException ex) {
            System.out.println("No se escuentra el tecnico");
        }
        return null;
    }

    public boolean actualizarTecnicos(Tecnico tecnico) {
        try {
            this.sentencias.executeUpdate("UPDATE tecni_cos SET nombre='" + tecnico.getNombre() + "' WHERE cedula ='" + tecnico.getCedula() + "';");

            JOptionPane.showMessageDialog(null, "iNformacion actualizada de tecnico");

            return true;
        } catch (SQLException ex) {
            System.out.println("No se logro actualizar tecnicos");
        }
        return false;
    }

    //arrayalis que contiene toda la lista de los tecnicos creados
    public ArrayList<Tecnico> listarTecnicos() {
        ArrayList<Tecnico> tecnicosListado = new ArrayList();
        try {

            this.datos = this.sentencias.executeQuery("select * from tecni_cos");

            while (datos.next()) {
                tecnicosListado.add(new Tecnico(datos.getInt(2), datos.getString(3), datos.getDate(4), datos.getInt(5), datos.getString(6), datos.getDouble(7)));
            }
            
            JOptionPane.showMessageDialog(null, "Lista se dio con exito");
            return tecnicosListado;
        } catch (SQLException ex) {
            System.out.println("LISTA DE TERCNICOS NO FUNCIONO");
        }
        return null;
    }

    public Tecnico buscarId(Tecnico tecnico) {
        try {

            this.datos = this.sentencias.executeQuery("select * from tecni_cos where cedula=" + tecnico.getCedula());
            if(datos.next()){
                tecnico.getNombre();
                tecnico.getTelefono();
                tecnico.getCorreoElectrónico();
                tecnico.getSalario();                
            }            
        } catch (Exception e) {
            System.out.println("error no se pudo");
        }
        return tecnico;
    }
    
    public double calcularSalario(){
        return tecnico.calcularSalario();
    }

    public Tecnico getTecnico() {
        return tecnico;
    }
}
