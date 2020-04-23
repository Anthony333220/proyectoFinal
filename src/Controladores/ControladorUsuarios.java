package Controladores;

import Archivo.Configuraciones;
import Clases.Usuario;
import Vistas.FrmPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;



public class ControladorUsuarios  {

    Archivo.Configuraciones conexion;
    private Statement sentencias;
    private ResultSet datos;
    
    
    public ControladorUsuarios(){
        conexion=FrmPrincipal.getConexion();
        this.sentencias=conexion.getSentencias();
        this.datos=conexion.getDatos();
        
    }
    public ControladorUsuarios(Configuraciones conexion){
        
         conexion=conexion;
        this.sentencias=conexion.getSentencias();
        this.datos=conexion.getDatos();
        
    }
     public boolean añadir(Usuario usuario){
//        try 
//        {
//            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//            sentencias.execute("insert into usuarios values(null,'"+usuario.getCedula()+"','"+usuario.getNombre()+"','"+f.format(usuario.getFechaNacimiento())+"','"+usuario.getTelefono()+"','"+usuario.getCorreoElectronico()+"','"+usuario.getNombreUsuario()+"','"+usuario.getContrasena()+"','"+usuario.getTipoUsuario()+"')");
//            return true;
//        }catch (SQLException ex) {
//            System.out.println("Error al agregar usuario"+ex.getMessage());
//        }
        return false;
    }
     public Usuario buscar(Usuario usuario){
        try {
          
         
//            this.datos = this.sentencias.executeQuery("select * from usuarios where cedula="+usuario.getCedula());
 
                
                if(datos.next())
                {
             
                    
//                    Usuario usuarioSiguiente = new Usuario();
//                    usuarioSiguiente.setCedula(datos.getInt(2));
//                    usuarioSiguiente.setNombre(datos.getString(3));
//                    usuarioSiguiente.setFechaNacimiento(datos.getDate(4));
//                    usuarioSiguiente.setTelefono(datos.getInt(5));
//                    usuarioSiguiente.setCorreoElectronico(datos.getString(6));
//                    usuarioSiguiente.setNombreUsuario(datos.getString(7));
//                    usuarioSiguiente.setContrasena(datos.getString(8));
//                    usuarioSiguiente.setTipoUsuario(datos.getString(9));
                    
                    return null; //usuarioSiguiente
                } 
                
        }catch (SQLException ex) {
                System.out.println("Error al buscar"+ex);
            }
        return null;

    }
     
    public boolean eliminar(Usuario usuario){
//        try {
//            
//            this.sentencias.executeUpdate("delete from usuarios where cedula="+usuario.getCedula());
//            return true;
//            
//        }catch (SQLException ex) {
//                
//            System.out.println("Error al borrar");
//        }
            
        return false;
    }
     public boolean actualizar(Usuario usuario){
        
//        try {  
//            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//            this.sentencias.executeUpdate("UPDATE usuarios SET nombre='"+usuario.getNombre()+"',fecha_nacimiento='"+f.format(usuario.getFechaNacimiento())+"', telefono='"+usuario.getTelefono()+"', correo='"+usuario.getCorreoElectronico()+"', nombre_usuario='"+usuario.getNombreUsuario()+"', contraseña='"+usuario.getContrasena()+"',tipo_usuario='"+usuario.getTipoUsuario()+"' WHERE cedula ='"+usuario.getCedula()+"';");
//            return true;
//            
//        } catch (Exception ex) {
//            System.out.println("Error al actualizar");
//            System.out.println(ex);
//        }
        return false;
    }
    
       
}