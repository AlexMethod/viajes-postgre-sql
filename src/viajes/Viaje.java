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
public class Viaje {
    
    public int IdViaje;
    public int IdRuta;
    public int IdSucursal;
    public int IdTarifa;
    public String Folio;
    public double PesoTotal;
    public String Estatus;
    public static String Header[] = {"Id","Folio","Ruta","Sucursal","Precio","Costo","PesoTotal","Estatus"};
    
    public Viaje(int idviaje,int idruta,int idsucursal, int idtarifa,String folio, double pesototal,String estatus){
        IdViaje = idviaje;
        IdRuta = idruta;
        IdSucursal = idsucursal;
        IdTarifa = idtarifa;
        Folio = folio;
        PesoTotal = pesototal;
        Estatus = estatus;
    }
    
    public Viaje(int idruta,int idsucursal,String folio, double pesototal,String estatus){
        IdRuta = idruta;
        IdSucursal = idsucursal;
        Folio = folio;
        PesoTotal = pesototal;
        Estatus = estatus;
    }
    
    public static String[] GetRow(ResultSet result) throws Exception{
        
        try
        {
            String IdViaje = result.getString("idviaje");
            String Folio = result.getString("folio");
            String Ruta = result.getString("ruta");
            String Sucursal = result.getString("sucursal");
            String Precio = result.getString("precio");
            String Costo = result.getString("costo");
            String PesoTotal = result.getString("pesototal");
            String Estatus = result.getString("estatus");
            String row[] = {IdViaje,Folio,Ruta,Sucursal,Precio,Costo,PesoTotal,Estatus};
            return row;
        }
        catch(Exception error){
            String row[] = {};
            return row;
        }
        
        
    }
    
    public static Viaje GetInstance(ResultSet result) throws Exception{
        
        try
        {
            String IdViaje = result.getString("idviaje");
            String Folio = result.getString("folio");
            String IdRuta = result.getString("idruta");
            String IdSucursal = result.getString("idsucursal");
            String IdTarifa = result.getString("idtarifa");
            String PesoTotal = result.getString("pesototal");
            String Estatus = result.getString("estatus");

            Viaje viaje = new Viaje(Integer.parseInt(IdViaje),Integer.parseInt(IdRuta),Integer.parseInt(IdSucursal),Integer.parseInt(IdTarifa),Folio,Double.valueOf(PesoTotal),Estatus);
            return viaje;
        }
        catch(Exception error){
            return null;
        }
    }
    
}
