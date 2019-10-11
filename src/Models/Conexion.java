package Models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String servidor ="localhost";
    private static String puerto= "3306";
    private static String usuario ="admin";
    private static String password ="hola123";
    private static String cadconx= "jdbc:mariadb://"+servidor+":"+puerto+"/fashiondb";// en caso de que sea un error ssl    "?useSSL=false"

    public   static Connection conexion = null; // se llaman con get y set
    public static void  getConexion(){
    if (conexion==null){
        try {
        Class.forName("org.mariadb.jdbc.Driver");
        conexion = DriverManager.getConnection(cadconx,usuario,password);
            System.out.println("Conexion Exitosa!!");
        }catch (Exception e){
        e.printStackTrace();
        }

    }

    }
    public void closeConexion(){
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Se cerro conexion bd");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

