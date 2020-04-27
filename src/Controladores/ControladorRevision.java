package Controladores;

import Archivo.Archivo;
import Archivo.Configuracion;
import Archivo.PruebaConexion;
import Clases.Cita;
import Clases.Revision;
import Clases.Tecnico;
import Clases.Vehiculo;
import Vistas.FrmMenuPrincipal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony
 */
public class ControladorRevision {

    private ResultSet datos;
    private Revision revision;
    private Vehiculo vehiculo;
    private Tecnico tecnico;
    private ControladorVehiculos ctrVehiculo;
    private ControladorTecnicos ctrTecnico;
    private Statement sentencias;
    private PruebaConexion conn;
    private int contador = 0;

    public ControladorRevision(ResultSet datos, Revision revision, Statement sentencias, PruebaConexion conn) {
        this.datos = datos;
        this.revision = revision;
        this.sentencias = sentencias;
        this.conn = conn;
    }

    public ControladorRevision(PruebaConexion conn) {
        this.conn = conn;
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();

    }

    public ControladorRevision() {
        conn = FrmMenuPrincipal.getConexion();  //probar com conexion o conectar
        try {
            this.sentencias = FrmMenuPrincipal.getConexion().getConexion().createStatement();
        } catch (SQLException ex) {

            System.out.println("No se logro conectar sentencia con la conexion");        
        }
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();
    }

    public boolean crearRevision(Revision revision, Vehiculo vehiculo, Tecnico tecnico) {
        try {     
            
            this.vehiculo = ctrVehiculo.buscarVehiculo(vehiculo);
            
            if (!this.vehiculo.equals(null)) {
                SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
                sentencias.execute("insert into revision values(null,'" + revision.getVehiculo().getPlaca() + "','" + 
                        fecha.format(revision.getFecha()) + "','" + revision.getHora() + "','" + revision.getVehiculo().getCedula() + "','"
                        + revision.getTipoRevision() + "','" + revision.getObservacione() + "','" + revision.isEstado() + "')");
                System.out.println("Se agrego la revision exitosamente");
            }          
            return true;
        } catch (SQLException ex) {
            System.out.println("No se logro crear cita devido a" + ex.getMessage());
            System.out.println(ex);
        }
        return false;
    }
    
    public Revision buscarRevision(Date fechaRevision){
        try {
            SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
            this.datos = this.sentencias.executeQuery("select * from revision where fechaRevision=" + fecha.format(fechaRevision));

            if (datos.next()) {

                Revision revision = new Revision(fechaRevision);                
                
                revision.setVehiculo(new Vehiculo(datos.getInt(1)));
                revision.setFecha(datos.getDate(2));                
                revision.setHora(datos.getTime(3));
                revision.setTecnico(new Tecnico(datos.getInt(4)));
                revision.setTipoRevision(datos.getString(5));
                revision.setObservacione(datos.getString(6));
//                revision.setEstado(datos.geString(7));

                return revision;
            }

        } catch (SQLException ex) {
            System.out.println("no se pudo hayar  un usuario" + ex);
        }
        return null;
    }
    
    public ArrayList<String> listarRevisiones(String Placa){
        ArrayList <String> revisiones = new ArrayList();
        try {
            this.datos = this.sentencias.executeQuery("select * from revision where placa=" + Placa);
            
            revision.setVehiculo(new Vehiculo(datos.getInt(1)));
            vehiculo = ctrVehiculo.buscarVehiculo(revision.getVehiculo());            
            revisiones.add(vehiculo.toString());
            
            while(this.datos.next()){
                revision.setFecha(datos.getDate(2));                
                revision.setHora(datos.getTime(3));
                revision.setTecnico(new Tecnico(datos.getInt(4)));
                revision.setTipoRevision(datos.getString(5));
                revision.setObservacione(datos.getString(6));
                
                tecnico = ctrTecnico.buscarTecnico(revision.getTecnico());
                
                revisiones.add(revision.toString());
                revisiones.add(tecnico.toString());
                
                contador++;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorRevision.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return revisiones;        
    }
    
    public void exportarXML(String Placa){
        ArrayList<String> revisiones = listarRevisiones(Placa);
        Archivo archivoXML = new Archivo("");
        archivoXML.limpiar();
        archivoXML.escribir("<xml>");
        archivoXML.escribir(revisiones.toString());
        archivoXML.escribir("</xml>");
        archivoXML.guardar();
        archivoXML.cerrar();
        revisiones.clear();
    }

}
