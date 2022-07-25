/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema;

/**
 *
 * @author maisc
 */
public class Trabajador {
    
    private String ci;
    private String nombre;
    private String correo;
    private double sueldo;
    private String mesSueldo;
    
    public Trabajador(String c, String nom, String co, double s, String m){
        ci = c;
        nombre = nom;
        correo = co;
        sueldo = s;
        mesSueldo = m;
    }
    
    public void establecerCedula(String c){
        ci = c;
    }
    public void establecerNombre(String n){
        nombre = n;
    }
    public void establecerCorreo(String c){
        correo = c;
    }
    public void establecerSueldo(double s){
        sueldo = s;
    }
    public void establecerMesSueldo(String m){
        mesSueldo = m;
    }
    
    public String obtenerCedula(){
        return ci;
    }
    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerCorreo(){
        return correo;
    }
    public double obtenerSueldo(){
        return sueldo;
    }
    public String obtenerMesSueldo(){
        return mesSueldo;
    }
    
    @Override
    public String toString() {
        String data = String.format("Nombre: %s\n"
                + "Cédula: %s\n"
                + "Correo: %s\n"
                + "Sueldo: %.2f\n"
                + "Mes del Sueldo: %s\n",
                obtenerNombre(),
                obtenerCedula(),
                obtenerCorreo(),
                obtenerSueldo(),
                obtenerMesSueldo()
        );
        return data;
    }
}
