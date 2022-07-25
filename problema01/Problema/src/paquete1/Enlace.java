
package paquete1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import problema.Trabajador;

/**
 *
 * @author maisc
 */
public class Enlace {
    private Connection conn;
       
    public void establecerConexion() {  

        try {  
            String url = "jdbc:sqlite:bd/Trabajador.bd";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
        
    } 
    
    public Connection obtenerConexion(){
        return conn;
    }
    
    public void insertarTrabajador(Trabajador trabajador) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO traba (ci, nombre, "
                    + "correo,  mesSueldo, sueldo) "
                    + "VALUES ('%s', '%s', '%s', '%s', '%s')", 
                    trabajador.obtenerCedula(),
                    trabajador.obtenerNombre(),
                    trabajador.obtenerSueldo(),
                    trabajador.obtenerMesSueldo(),
                    trabajador.obtenerCorreo());
            //System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarTraba");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public ArrayList<Trabajador> obtenerDataTrabajador() {  
        ArrayList<Trabajador> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from traba;";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                Trabajador trab = new Trabajador(
                    rs.getString("ci"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getDouble("sueldo"),
                    rs.getString("mesSueldo"));
                lista.add(trab);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: obtenerTraba");
             System.out.println(e.getMessage());  
             
        }  
        return lista;
    }
}
