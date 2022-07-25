/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import problema.Calificaciones;

/**
 *
 * @author maisc
 */
public class Enlace {
     private Connection conn;

    public void establecerConexion() {

        try {
            String url = "jdbc:sqlite:bd/base001.base";
            conn = DriverManager.getConnection(url); 

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }


    public ArrayList<Calificaciones> obtenerDataCalificaciones() {
        ArrayList<Calificaciones> lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from estudiante;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                Calificaciones miC = new Calificaciones(rs.getString("nombre"),
                        rs.getString("apellido"), rs.getDouble("calificacion1"),
                        rs.getDouble("calificacion2"), rs.getDouble("calificacion3"));
                miC.calcularPromedio();
                lista.add(miC);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarCalificaciones");
            System.out.println(e.getMessage());

        }
        return lista;
    }
}
