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
public class Unidad {
    
    public int IdUnidad;
    public int IdTransportista;
    public String Nombre;
    public String Placas;
    public double PesoMaximo;
    public double CostoxKilometro;
    public String Estatus;
    public static String Header[] = {"Id","Nombre","Placas","Peso máximo","Costo Kilometro","Transportista","Estatus"};
    
    public Unidad(int idunidad,int idtransportista,String nombre,String placas,double pesomaximo,double costoxkilometro,String estatus){
        IdUnidad = idunidad;
        IdTransportista = idtransportista;
        Nombre = nombre;
        Placas = placas;
        PesoMaximo = pesomaximo;
        CostoxKilometro = costoxkilometro;
        Estatus = estatus;
    }
    
    public Unidad(int idtransportista,String nombre,String placas,double pesomaximo,double costoxkilometro,String estatus){
        IdTransportista = idtransportista;
        Nombre = nombre;
        Placas = placas;
        PesoMaximo = pesomaximo;
        CostoxKilometro = costoxkilometro;
        Estatus = estatus;
    }
    
    public static String[] GetRow(ResultSet result) throws Exception{
        
        try
        {
            String IdUnidad = result.getString("idunidad");
            String Transportista = result.getString("transportista");
            String Nombre = result.getString("nombre");
            String Placas = result.getString("placas");
            String PesoMaximo = result.getString("pesomaximo");
            String CostoxKilometro = result.getString("costoxkilometro");
            String Estatus = result.getString("estatus");
            String row[] = {IdUnidad,Nombre,Placas,PesoMaximo,CostoxKilometro,Transportista,Estatus};
            return row;
        }
        catch(Exception error){
            String row[] = {};
            return row;
        }
        
        
    }
    
    public static Unidad GetInstance(ResultSet result) throws Exception{
        
        try
        {
            String IdUnidad = result.getString("idunidad");
            String IdTransportista = result.getString("idtransportista");
            String Nombre = result.getString("nombre");
            String Placas = result.getString("placas");
            String PesoMaximo = result.getString("pesomaximo");
            String CostoxKilometro = result.getString("costoxkilometro");
            String Estatus = result.getString("estatus");

            Unidad unidad = new Unidad(Integer.parseInt(IdUnidad),Integer.parseInt(IdTransportista),Nombre,Placas,Double.valueOf(PesoMaximo),Double.valueOf(CostoxKilometro),Estatus);
            return unidad;
        }
        catch(Exception error){
            return null;
        }
    }
    
}
