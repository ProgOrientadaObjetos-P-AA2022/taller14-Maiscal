/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema;

/**
 *
 * @author maisc
 */
public class Calificaciones {
    
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    private double nota3;
    private double promedio;

    public Calificaciones(String n, String a,double c1, double c2, double c3) {
        nombre = n;
        apellido = a;
        nota1 = c1;
        nota2 = c2;
        nota3 = c3;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }
    public void establecerApellido(String ape) {
        apellido = ape;
    }
    public void establecerCalificacion1(double c) {
        nota1 = c;
    }
    public void establecerCalificacion2(double c) {
        nota2 = c;
    }
    public void establecerCalificacion3(double c) {
        nota3 = c;
    }

    public void calcularPromedio() {
        promedio = (nota1 + nota2 + nota3) / 3;
    }
    
    public String obtenerNombre() {
        return nombre;
    }
    public String obtenerApellido() {
        return apellido;
    }
    public double obtenerNota1() {
        return nota1;
    }
    public double obtenerNota2() {
        return nota2;
    }
    public double obtenerNota3() {
        return nota3;
    }
    public double obtenerPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        String data = String.format("%s %s\n"
                + "  \tCalificaciones:\n"
                + "  \t%.2f\n"
                + "  \t%.2f\n"
                + "  \t%.2f\n"
                + "  \tPromedio: %.2f\n",
                nombre,
                apellido,
                nota1,
                nota2,
                nota3,
                promedio);
        return data;

    }
}
