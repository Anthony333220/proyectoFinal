package Controladores;

import Archivo.PruebaConexion;
import Clases.Cita;
import Clases.Vehiculo;
import Vistas.FrmMenuPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Emanuel CB
 */
public class ControladorCitas {

    private ResultSet datos;
    private Statement sentencias;
    private PruebaConexion conn;
    private ControladorVehiculos ctlv = new ControladorVehiculos();
    private Vehiculo vehiculo;

    public ControladorCitas(PruebaConexion conn) {
        this.conn = conn;
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();
    }

    public ControladorCitas() {
        conn = FrmMenuPrincipal.getConexion();
        try {

            this.sentencias = FrmMenuPrincipal.getConexion().getConectar().createStatement();
            
        } catch (SQLException ex) {

            System.out.println("NO SE CREO SENTENCIA");
        }
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();
    }

    public boolean crearCita(Cita cita) {
        try {
            
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

            sentencias.execute("insert into citas values(null,'" + f.format(cita.getFecha()) + "','" + cita.getHora() + "','" + cita.getVehiculo().getPlaca() + "','" + cita.getStatus() + "')");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al añadir");
            System.out.println(ex);
        }
        return false;
    }

    public boolean eliminarCita(Cita cita) {
        try {

            this.sentencias.executeUpdate("delete from citas where id=" + cita.getId());
            
            return true;
        } catch (SQLException ex) {

            System.out.println("No se logro borrar la cita");
        }
        return false;
    }

    public Cita buscarCita(Cita cita) {
        try {

            this.datos = this.sentencias.executeQuery("select * from citas where id=" + cita.getId());

            if (datos.next()) {

                vehiculo = new Vehiculo();
                vehiculo.setCedula(datos.getInt(2));
                vehiculo = ctlv.buscarVehiculo(vehiculo);
                Cita cita2 = new Cita(datos.getInt(1), datos.getDate(2), datos.getString(3), vehiculo, datos.getString(4));

                if (cambiarEstadoCita(cita2)) {
                    actualizarCita(cita2);
                }
                return cita2;
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar");
            System.out.println(ex);
        }
        return null;
    }

    public ArrayList<Cita> listarPorFecha(Cita cita) {

        ArrayList<Cita> citas = new ArrayList();
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

            this.datos = this.sentencias.executeQuery("select * from citas where fecha ='" + f.format(cita.getFecha()) + "' AND estado = 'activado' ;");

            //si se encontro resultados en la consulta se guardan en el arrayList
            while (datos.next()) {
                vehiculo = new Vehiculo();
                vehiculo.setCedula(datos.getInt(4));
                Cita cita2 = new Cita(datos.getDate(2), String.valueOf(datos.getTime(3)), ctlv.buscarVehiculo(vehiculo));
                if (cambiarEstadoCita(cita2)) {
                    //si la fecha se vencio desactivamos la cita 
                    actualizarCita(cita2);
                }
                citas.add(cita2);
            }
            //si se encontro una cita o más, las retornamos
            if (citas.size() > 0) {
                return citas;
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar");
            System.out.println(ex);
        }
        return null;
    }

    public boolean actualizarCita(Cita cita) {
        try {
            this.sentencias.executeUpdate("UPDATE citas SET fecha='" + cita.getFecha() + "', hora='" + cita.getHora() + "', status='" + cita.getStatus() + "'  WHERE id ='" + cita.getId() + "';");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar");
        }
        return false;
    }

    public boolean validarPK(Cita cita) {
        try {
            this.datos = this.sentencias.executeQuery("select * from citas where placa = '" + cita.getVehiculo().getPlaca() + "'  AND status = 'activado'  ;");
            if (datos.next()) {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al validarPK");
        }
        return true;
    }

    public boolean validarCantCitas(Cita cita) {
        //si está vacio ó hay menos de 4 citas
        return listarPorFecha(cita) == null || listarPorFecha(cita).size() < 4;
    }

    //valida que exista un cliente para poder agregar una cita
    public boolean validarFK(Cita cita) {

        try {
            this.datos = this.sentencias.executeQuery("select * from clientes where placa=" + cita.getVehiculo().getPlaca());
            if (datos.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al validarFK");
        }
        return false;
    }

    /**
     * utiliza la fecha del parametro cita y la compara con la fecha actual
     *
     * @param cita
     * @return verdadero si la fecha es menor
     */
    private boolean cambiarEstadoCita(Cita cita) {
        Date fechaActual = new Date();

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        //se utiliza para que el compareto funcione correctamente
        try {
            fechaActual = f.parse(f.format(fechaActual));
        } catch (ParseException ex) {

        }

        System.out.println("fecha actual :" + fechaActual + "--fecha de la cita:" + cita.getFecha());
        if (cita.getFecha().compareTo(fechaActual) < 0) {
            cita.setStatus("desactivado");
            System.out.println("La Fecha es menor :" + cita.getFecha().compareTo(fechaActual));
            return true;
        } else {
            if (cita.getFecha().compareTo(fechaActual) > 0) {
                System.out.println("La Fecha es mayor :" + cita.getFecha().compareTo(fechaActual));
                return false;
            } else {
                System.out.println("La Fecha es Igual :" + cita.getFecha().compareTo(fechaActual));
                return false;
            }
        }
    }
}
