/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema;

import java.util.Scanner;
import java.sql.SQLException;
import paquete1.Enlace;

/**
 *
 * @author maisc
 */
public class Ejecutor {

    public static void main(String[] args) throws SQLException {
        Enlace c = new Enlace();
        
        Scanner sc = new Scanner(System.in);
        
        String ci, nom, correo , mes, cadena = "";
        double sueldo;
        
        boolean cont = true;
        
        c.establecerConexion();
        
        do{
            System.out.println("Ingrese la cédula de identidad: ");
            ci = sc.nextLine();
            System.out.println("Ingrese el nombre del trabajador: ");
            nom = sc.nextLine();
            System.out.println("Ingrese el correo del trabajador: ");
            correo = sc.nextLine();
            System.out.println("Ingrese el sueldo mensual: ");
            sueldo = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese el mes del sueldo recibido: ");
            mes = sc.nextLine();
            
            Trabajador trab = new Trabajador(ci, nom, correo, sueldo, mes);
            c.insertarTrabajador(trab);
            
            System.out.println("Si desea agregar otro trabajador ingrese Si\n"
                    + "Si desea salir ingrese No");
            String opc = sc.nextLine();
            cadena = String.format("%s%s\n",cadena, trab);
            
            if("No".equals(opc) || "no".equals(opc)){
                cont = false;
                System.out.println(cadena);
            }
            
        }while(cont);
    }
    
}
