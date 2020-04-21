package Clases;

import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Secretaria extends Usuario{
    
    private String cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private String telefono;
    private String correoElectrónico;
    
    public Secretaria(String cedula, String nombre, String apellido1, String apellido2, Date fechaNacimiento, String telefono, String correoElectrónico, String usuario, String contrasena) {
        super(usuario, contrasena, "Secretaria");
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correoElectrónico = correoElectrónico;
    }
    
    public Secretaria(String cedula, String usuario, String contrasena) {
        super(usuario, contrasena);
    }
    
     public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectrónico() {
        return correoElectrónico;
    }

    public void setCorreoElectrónico(String correoElectrónico) {
        this.correoElectrónico = correoElectrónico;
    }

    @Override
    public String toString() {
        return "Secretaria{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", correoElectr\u00f3nico=" + correoElectrónico + '}';
    }
}
