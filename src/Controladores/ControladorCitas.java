package Controladores;

import Archivo.PruebaConexion;
import Clases.Cita;
import Clases.Secretaria;
import Clases.Vehiculo;
import Vistas.FrmMenuUsuarios;
import Vistas.FrmPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Emanuel CB
 */
public class ControladorCitas {

    private Statement sentencias;
    private ResultSet datos;

    private Statement sentencias2;
    private PruebaConexion conn;

    private ControladorVehiculos ctlv = new ControladorVehiculos();
    private Vehiculo vehiculo;

    public ControladorCitas(PruebaConexion conn) {
        this.conn = conn;
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();
    }

    public ControladorCitas() {

        conn = FrmMenuUsuarios.getConexion();
        try {

            this.sentencias2 = FrmMenuUsuarios.getConexion().getConectar().createStatement();
        } catch (SQLException ex) {

            System.out.println("NO SE CREO SENTENCIA");
        }
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();
    }

    public boolean crearCita(Cita cita) {

        System.out.println("antes de crear la cita el try");
        try {

            SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");

            sentencias.execute("insert into citas values(null,'" + fecha.format(cita.getFecha()) + "','" + cita.getHora() + "','" + cita.getVehiculo().getPlaca() + "','"
                    + cita.getVehiculo().getMarca() + "','" + cita.getVehiculo().getModelo() + "','" + cita.getVehiculo().getAnio() + "','" + cita.getVehiculo().getFechaInscripcion()
                    + "','" + cita.getVehiculo().getCedula() + "','" + cita.getVehiculo().getNombrePropietario() + "','" + cita.getStatus() + "')");
            System.out.println("si se logro crear cita");

            return true;

        } catch (SQLException ex) {

            System.out.println("No se logro crear cita devido a" + ex.getMessage());
            System.out.println(ex);
        }
        return false;
    }

    public boolean deleteCitas(Cita cita) {
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

            this.datos = this.sentencias2.executeQuery("select * from citas where id=" + cita.getId());

            if (datos.next()) {

                vehiculo = new Vehiculo();
                vehiculo.setCedula(datos.getInt(2));
                vehiculo = ctlv.buscarVehiculo(vehiculo);
                Cita cita2 = new Cita(datos.getInt(1), datos.getDate(2), datos.getString(3), vehiculo, datos.getString(4));

                if (cambiarstatusCita(cita2)) {

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

    public boolean cambiarstatusCita(Cita cita) {
        Date fechaActualizada = new Date();

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fechaActualizada = f.parse(f.format(fechaActualizada));

            return true;
        } catch (ParseException ex) {
            System.out.println("no se  actualizo la fecha");

        }
        System.out.println(" no se actualizo la cita");

        return false;

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

}
