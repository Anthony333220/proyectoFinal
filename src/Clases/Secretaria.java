package Clases;

import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Secretaria {
    
    private int cedula;
    private String nombre;
   
    private Date fechaNacimiento;
    private int telefono;
    private String correoElectrónico;

    public Secretaria(int cedula, String nombre, Date fechaNacimiento, int telefono, String correoElectrónico) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correoElectrónico = correoElectrónico;
    }

    public Secretaria(){
        this.cedula=0;
        this.correoElectrónico=null;
        this.fechaNacimiento=null;
        this.nombre=null;
        this.telefono=0;
        
        
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public String getCorreoElectrónico() {
        return correoElectrónico;
    }

    public void setCorreoElectrónico(String correoElectrónico) {
        this.correoElectrónico = correoElectrónico;
    }
    
   
}
