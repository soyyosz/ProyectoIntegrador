/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.conexion;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion singleObject = new Conexion();
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/itic34";
    private static final String USUARIO = "root";
    private static final String CLAVE = "admin";
    private static Connection conexion = null;
    
    private Conexion(){ 
    }
    
    public static synchronized Conexion getInstance(){
        return singleObject;
    }
    
    public Connection abrirConexion(){
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);            
        }catch (ClassNotFoundException e){
            System.out.println("Nose encontro la clase, "+ e.getMessage());
        }catch(SQLException e){
            System.out.println("Error al abrir la conexion, "+ e.getMessage());
        }
        return conexion;
    }
   
}
