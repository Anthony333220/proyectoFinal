package Controladores;


import Archivo.PruebaConexion;
import Clases.Usuario;

import Vistas.FrmMenuPrincipal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ControladorUsuarios {

    private PruebaConexion conn;
    private Statement sentencias;
    private ResultSet datos;
     private Usuario usuario;
   
   
   
   
   
    public ControladorUsuarios() {
       conn  = FrmMenuPrincipal.getConexion();
        
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();

    }

    public ControladorUsuarios(PruebaConexion conn) {

        this.conn = conn;
        this.sentencias = conn.getSentencias();
        this.datos = conn.getDatos();

    }
  
    
    
    

    public boolean agregarUsuario(Usuario usuario) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            //System.out.println("si entra a ejecuchacion");
            this.sentencias.execute("insert into usuarios values(null,'"+usuario.getCedula()+"','"+usuario.getNombre()+"','" +usuario.getTelefono()+ "','"+usuario.getCorreoElectronico()+"','"+f.format(usuario.getFechaNacimiento())+"','"+usuario.getNombreUsuario()+"','"+usuario.getContrasena()+"','"+usuario.getTipoUsuario()+"')");
            System.out.println("metodo si agrega  en ctl");
            return true;
        } catch (SQLException ex) {
            System.out.println("no se agredo usuario devido a" + ex.getMessage());
        }
        return false;
    }

    public Usuario buscarUsuario(Usuario usuario) {
        try {

            this.datos = this.sentencias.executeQuery("select * from usuarios where cedula=" +usuario.getCedula());

            if (datos.next()) {

                Usuario usuarioSiguiente = new Usuario();
                usuarioSiguiente.setCedula(datos.getInt(2));
                usuarioSiguiente.setNombre(datos.getString(3));
                usuarioSiguiente.setFechaNacimiento(datos.getDate(4));
                usuarioSiguiente.setTelefono(datos.getInt(5));
                usuarioSiguiente.setCorreoElectronico(datos.getString(6));
                usuarioSiguiente.setNombreUsuario(datos.getString(7));
                usuarioSiguiente.setContrasena(datos.getString(8));
                usuarioSiguiente.setTipoUsuario(datos.getString(9));

                return usuarioSiguiente;
            }

        } catch (SQLException ex) {
            System.out.println("no se pudo hayar  un usuario" + ex);
        }
        return null;

    }

    public boolean eliminar(Usuario usuario) {
        try {

            this.sentencias.executeUpdate("delete from usuarios where cedula=" + usuario.getCedula());
            return true;

        } catch (SQLException ex) {

            System.out.println("Error al borrar");
        }

        return false;
    }

    public boolean actualizar(Usuario usuario) {

        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            this.sentencias.executeUpdate("UPDATE usuarios SET nombre='" + usuario.getNombre() + "',fechaNacimiento='" + f.format(usuario.getFechaNacimiento()) + "', telefono='" + usuario.getTelefono() + "', correoElectronico='" + usuario.getCorreoElectronico() + "', NombreUsuario='" + usuario.getNombreUsuario() + "', Contraseña='" + usuario.getContrasena() + "',tipoUsuario='" + usuario.getTipoUsuario() + "' WHERE cedula ='" + usuario.getCedula() + "';");
            return true;

        } catch (SQLException ex) {
            System.out.println("Error al actualizar");
            System.out.println(ex);
        }
        return false;
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            this.datos = this.sentencias.executeQuery("select * from usuarios ");

            while (datos.next()) {

                //usuarios.add(new Usuario(datos.getString(2), datos.getDate(3), datos.getInt(4), datos.getString(5), datos.getString(6), datos.getString(7), datos.getInt(8)));
                usuarios.add(new Usuario(datos.getInt(2), datos.getString(3), datos.getDate(4), datos.getInt(5), datos.getString(6), datos.getString(7), datos.getString(8), datos.getString(9)));
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error al listar");
        }
        return null;
    }
}
