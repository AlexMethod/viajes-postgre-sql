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
public class Cliente {
    
    public int IdCliente;
    public String RazonSocial;
    public String NombreComercial;
    public String Tipo;
    public String Direccion;
    public double PorcentajeVenta;
    public String Estatus;
    public static String Header[] = {"Razón Social","razonsocial"};
    
    public Cliente(int idcliente,String razonsocial, String nombrecomercial,String tipo,String direccion,double porcentajeventa,String estatus){
        IdCliente = idcliente;
        RazonSocial = razonsocial;
        NombreComercial = nombrecomercial;
        Tipo = tipo;
        Direccion = direccion;
        PorcentajeVenta = porcentajeventa;
        Estatus = estatus;
    }
    
    public Cliente(String razonsocial, String nombrecomercial,String tipo,String direccion,double porcentajeventa,String estatus){
        RazonSocial = razonsocial;
        NombreComercial = nombrecomercial;
        Tipo = tipo;
        Direccion = direccion;
        PorcentajeVenta = porcentajeventa;
        Estatus = estatus;
    }
    
    public static String[] GetRow(ResultSet result) throws Exception{
        
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
    
}
