/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes;
import java.sql.ResultSet;
/**
 *
 * @author USUARIO DELL
 */
public class Sucursal {
    public int IdSucursal;
    public String Nombre;
    public String Direccion;
    public String Estatus;
    public static String[] Header = {"Id","Nombre","Dirección","Estatus"};
    
    public Sucursal(int idsucursal,String nombre, String direccion, String estatus){
        IdSucursal = idsucursal;
        Nombre = nombre;
        Direccion = direccion;
        Estatus = estatus;
    }
    
    public Sucursal(String nombre, String direccion, String estatus){
        Nombre = nombre;
        Direccion = direccion;
        Estatus = estatus;
    }
    
    public static String[] getRow(ResultSet result) throws Exception{
        try
        {
            String IdSucursal = result.getString("idsucursal");
            String Nombre = result.getString("nombre");
            String Direccion = result.getString("direccion");
            String Estatus = result.getString("estatus");
            String row[] = {IdSucursal,Nombre,Direccion,Estatus};
            return row;
        }
        catch(Exception error){
            String row[] = {};
            return row;
        }
    }
    
    public static Sucursal getSucursal(ResultSet result) throws Exception{
        try
        {
            String IdSucursal = result.getString("idsucursal");
            String Nombre = result.getString("nombre");
            String Direccion = result.getString("direccion");
            String Estatus = result.getString("estatus");

            Sucursal sucursal = new Sucursal(Integer.parseInt(IdSucursal),Nombre,Direccion,Estatus);
            return sucursal;
        }
        catch(Exception error){
            return null;
        }
    }
}
