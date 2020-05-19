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
public class Transportista {
    
    public int IdTransportista;
    public String RazonSocial;
    public String NombreComercial;
    public double Comision;
    public String Estatus;
    public static String Header[] = {"Id","Razón Social","Nombre Comercial","Comisión","Estatus"};
    
    public Transportista(int idtransportista,String razonsocial, String nombrecomercial,double comision,String estatus){
        IdTransportista = idtransportista;
        RazonSocial = razonsocial;
        NombreComercial = nombrecomercial;
        Comision = comision;
        Estatus = estatus;
    }
    
    public Transportista(String razonsocial, String nombrecomercial,double comision,String estatus){
        RazonSocial = razonsocial;
        NombreComercial = nombrecomercial;
        Comision = comision;
        Estatus = estatus;
    }
    
    public static String[] GetRow(ResultSet result) throws Exception{
        
        try
        {
            String IdTransportista = result.getString("idtransportista");
            String RazonSocial = result.getString("razonsocial");
            String NombreComercial = result.getString("nombrecomercial");
            String Comision = result.getString("comision");
            String Estatus = result.getString("estatus");
            String row[] = {IdTransportista,RazonSocial,NombreComercial,Comision,Estatus};
            return row;
        }
        catch(Exception error){
            String row[] = {};
            return row;
        }
        
        
    }
    
    public static Transportista GetInstance(ResultSet result) throws Exception{
        
        try
        {
            String IdTransportista = result.getString("idtransportista");
            String RazonSocial = result.getString("razonsocial");
            String NombreComercial = result.getString("nombrecomercial");
            String Comision = result.getString("comision");
            String Estatus = result.getString("estatus");

            Transportista transportista = new Transportista(Integer.parseInt(IdTransportista),RazonSocial,NombreComercial,Double.valueOf(Comision),Estatus);
            return transportista;
        }
        catch(Exception error){
            return null;
        }
    }
    
}
