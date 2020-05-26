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
public class Tarifa {
    
    public int IdCliente;
    public String RazonSocial;
    public String NombreComercial;
    public String Tipo;
    public String Direccion;
    public double PorcentajeVenta;
    public String Estatus;
    public static String Header[] = {"Id","Razón Social","Nombre Comercial","Tipo","Dirección","Porcentaje Venta","Estatus"};
    
    public Tarifa(int idcliente,String razonsocial, String nombrecomercial,String tipo,String direccion,double porcentajeventa,String estatus){
        IdCliente = idcliente;
        RazonSocial = razonsocial;
        NombreComercial = nombrecomercial;
        Tipo = tipo;
        Direccion = direccion;
        PorcentajeVenta = porcentajeventa;
        Estatus = estatus;
    }
    
    public Tarifa(String razonsocial, String nombrecomercial,String tipo,String direccion,double porcentajeventa,String estatus){
        RazonSocial = razonsocial;
        NombreComercial = nombrecomercial;
        Tipo = tipo;
        Direccion = direccion;
        PorcentajeVenta = porcentajeventa;
        Estatus = estatus;
    }
    
    public static String[] GetRow(ResultSet result) throws Exception{
        
        try
        {
            String IdCliente = result.getString("idcliente");
            String RazonSocial = result.getString("razonsocial");
            String NombreComercial = result.getString("nombrecomercial");
            String Tipo = result.getString("tipo");
            String Direccion = result.getString("direccion");
            String PorcentajeVenta = result.getString("porcentajeventa");
            String Estatus = result.getString("estatus");
            String row[] = {IdCliente,RazonSocial,NombreComercial,Tipo,Direccion,PorcentajeVenta,Estatus};
            return row;
        }
        catch(Exception error){
            String row[] = {};
            return row;
        }
        
        
    }
    
    public static Tarifa GetInstance(ResultSet result) throws Exception{
        
        try
        {
            String IdCliente = result.getString("idcliente");
            String RazonSocial = result.getString("razonsocial");
            String NombreComercial = result.getString("nombrecomercial");
            String Tipo = result.getString("tipo");
            String Direccion = result.getString("direccion");
            String PorcentajeVenta = result.getString("porcentajeventa");
            String Estatus = result.getString("estatus");

            Tarifa cliente = new Tarifa(Integer.parseInt(IdCliente),RazonSocial,NombreComercial,Tipo,Direccion,Double.valueOf(PorcentajeVenta),Estatus);
            return cliente;
        }
        catch(Exception error){
            return null;
        }
    }
    
}
