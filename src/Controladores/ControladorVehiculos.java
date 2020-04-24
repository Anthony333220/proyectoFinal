/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Archivo.PruebaConexion;
import Clases.Usuario;
import Clases.Vehiculo;
import Vistas.FrmPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Emanuel CB
 */
public class ControladorVehiculos {

    private PruebaConexion conn;
    private Statement sentencias;
    private ResultSet datos;
    private Usuario usuario;
    private Vehiculo vehiculo;

    public ControladorVehiculos() {
        conn = FrmPrincipal.getConexion();
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();
    }

    public ControladorVehiculos(PruebaConexion conn) {
        this.conn = conn;
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();
    }

    public boolean agregarVehiculo(Vehiculo vehiculo) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            //System.out.println("si entra a ejecuchacion");
            this.sentencias.execute("insert into vehiculos values(null,'" + vehiculo.getPlaca() + "','" + 
                    vehiculo.getMarca() + "','" + vehiculo.getModelo() + "','" + vehiculo.getAnio() + "','" +
                    f.format(vehiculo.getFechaInscripcion()) + "','" + vehiculo.getNombrePropietario() + "','" + 
                    vehiculo.getCedula() + "')");
            System.out.println("metodo si agrega  en ctl");
            return true;
        } catch (SQLException ex) {
            System.out.println("El vehiculo nopudoser agregado" + ex.getMessage());
        }
        return false;
    }

    public Vehiculo buscarVehiculo(Vehiculo vehiculo) {
        try {

            this.datos = this.sentencias.executeQuery("select * from vehiculos where placa=" + vehiculo.getPlaca());

            if (datos.next()) {

                Vehiculo automovil = new Vehiculo(vehiculo.getPlaca());
                
                
                automovil.setPlaca(datos.getInt(1));
                automovil.setMarca(datos.getString(2));                
                automovil.setModelo(datos.getString(3));
                automovil.setAnio(datos.getString(4));
                automovil.setFechaInscripcion(datos.getDate(5));
                automovil.setCedula(datos.getInt(6));
                automovil.setNombrePropietario(datos.getString(7));

                return automovil;
            }

        } catch (SQLException ex) {
            System.out.println("no se pudo hayar  un usuario" + ex);
        }
        return null;

    }

    public boolean eliminar(Vehiculo vehiculo) {
        try {

            this.sentencias.executeUpdate("delete from vehiculos where placa=" + vehiculo.getPlaca());
            return true;

        } catch (SQLException ex) {

            System.out.println("Error al borrar");
        }

        return false;
    }

    public boolean actualizar(Vehiculo vehiculo) {

        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            this.sentencias.executeUpdate("UPDATE vehiculos SET placa=" + vehiculo.getPlaca() + ", marca=" +vehiculo.getMarca()+ ", modelo=" +vehiculo.getModelo() + 
                    ", año=" +vehiculo.getAnio() + ", fechaInscripcion=" +vehiculo.getFechaInscripcion() + ", cedula=" +vehiculo.getCedula() + ", nombrePropietario=" + vehiculo.getNombrePropietario()+ "' WHERE placa ='" + vehiculo.getPlaca()+"'");
            return true;

        } catch (SQLException ex) {
            System.out.println("No se pudo actualizar vehiculo");
            System.out.println(ex);
        }
        return false;
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        ArrayList<Vehiculo> listaVehiculos= new ArrayList();
        try {
            this.datos = this.sentencias.executeQuery("select * from usuarios ");

            while (datos.next()) {

             listaVehiculos.add(new Vehiculo(datos.getInt(2), datos.getString(3), datos.getString(4), datos.getString(5), datos.getDate(6), datos.getInt(7), datos.getString(8)));
            }
            return listaVehiculos;
        } catch (SQLException ex) {
            System.out.println("nO se cargo la lista de vehiculos"+ex.getMessage());
        }
        return null;
    }
}
