package Clases;

import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Usuario {

    private String nombre;
    private Date fechaNacimiento;
    private int telefono;
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasena;
    private String tipoUsuario;
    private int cedula;

    public Usuario(int cedula, String nombre, Date fechaNacimiento, int telefono, String correo, String sobrenombre,String contraseña, String tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correoElectronico = correo;
        this.nombreUsuario = sobrenombre;
        this.contrasena = contraseña;
        this.tipoUsuario = tipo;
    }
    

    public Usuario() {
        this.cedula = 0;
        this.contrasena = null;
        this.correoElectronico = null;
        this.telefono = 0;
        this.tipoUsuario = null;
        this.nombre = null;
        this.fechaNacimiento = null;
        this.nombreUsuario = null;

    }
        
    public boolean comprobar() {
        
        return  this.telefono >0 && this.tipoUsuario!=null &&
                this.cedula >0 && this.nombre!=null && 
                this.contrasena!=null && this.correoElectronico!=null && 
                this.fechaNacimiento!=null && this.nombreUsuario!=null ;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

}
