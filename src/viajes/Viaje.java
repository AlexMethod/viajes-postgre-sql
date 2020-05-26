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
    
    public int IdTarifa;
    public int IdRuta;
    public int IdUnidad;
    public int IdClienteFiscal;
    public double CostoATransportista;
    public double PrecioACliente;
    public String Estatus;
    public static String Header[] = {"Id","Ruta","Unidad","Cliente Fiscal","Precio","Costo","Estatus"};
    
    public Viaje(int idtarifa,int idruta,int idunidad, int idclientefiscal,double precio, double costo,String estatus){
        IdTarifa = idtarifa;
        IdRuta = idruta;
        IdUnidad = idunidad;
        IdClienteFiscal = idclientefiscal;
        PrecioACliente = precio;
        CostoATransportista = costo;
        Estatus = estatus;
    }
    
    public Viaje(int idruta,int idunidad, int idclientefiscal,String estatus){
        IdRuta = idruta;
        IdUnidad = idunidad;
        IdClienteFiscal = idclientefiscal;
        Estatus = estatus;
    }
    
    public static String[] GetRow(ResultSet result) throws Exception{
        
        try
        {
            String IdTarifa = result.getString("idtarifa");
            String Ruta = result.getString("ruta");
            String Unidad = result.getString("unidad");
            String ClienteFiscal = result.getString("clientefiscal");
            String PrecioACliente = result.getString("precioacliente");
            String CostoATransportista = result.getString("costoatransportista");
            String Estatus = result.getString("estatus");
            String row[] = {IdTarifa,Ruta,Unidad,ClienteFiscal,PrecioACliente,CostoATransportista,Estatus};
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
            String IdTarifa = result.getString("idtarifa");
            String IdRuta = result.getString("idruta");
            String IdUnidad = result.getString("idunidad");
            String IdClienteFiscal = result.getString("idclientefiscal");
            String PrecioACliente = result.getString("precioacliente");
            String CostoATransportista = result.getString("costoatransportista");
            String Estatus = result.getString("estatus");

            Viaje tarifa = new Viaje(Integer.parseInt(IdTarifa),Integer.parseInt(IdRuta),Integer.parseInt(IdUnidad),Integer.parseInt(IdClienteFiscal),Double.valueOf(PrecioACliente),Double.valueOf(CostoATransportista),Estatus);
            return tarifa;
        }
        catch(Exception error){
            return null;
        }
    }
    
}
