package Clases;

import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Tecnico {

    private int cedula;
    private String nombre;
    private Date fechaNacimiento;
    private int telefono;
    private String correoElectronico;
    private double salario;

    public Tecnico(int cedula, String nombre, Date fechaNacimiento, int telefono, String correoElectronico, double salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.salario = salario;
    }
    
    public Tecnico(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    
    public Tecnico(int cedula) {
        this.cedula = cedula;
    }

    public Tecnico() {
        this.cedula = 0;
        this.nombre = null;
        this.fechaNacimiento = null;
        this.telefono = 0;
        this.correoElectronico = null;
        this.salario = 0;
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
        return correoElectronico;
    }

    public void setCorreoElectrónico(String correoElectrónico) {
        this.correoElectronico = correoElectrónico;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public double calcularDeducciones(double salario){
        return (double) ((salario * 0.055) + (salario * 0.0384) + (salario * 0.01) + (salario * 0.033));
    }
    
    public double calcularRenta(double salario){
        double renta;
        if (salario > 817000 && salario <= 1226000) {
            renta = (salario - 817001) * 0.10;
            return (double)(renta + calcularDeducciones(salario));
        } else if (salario > 1226000) {
            renta = (salario - 1226001) * 0.15 + 40899.9;
            return (double) (renta + calcularDeducciones(salario));
        } else {
            return (double) (calcularDeducciones(salario));
        }
    }
    
    public double calcularSalario(){
        double neto = this.calcularRenta(salario);
        return (double) (salario - neto) ;
    }

    @Override
    public String toString() {
        return "<Tecnico>" + "<Cedula>" + cedula + "</Cedula>" + "<Nombre>" + nombre + "</Nombre>" + "</Tecnico>";
    }
    
    
}
