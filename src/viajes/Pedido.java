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
public class Pedido {
    
    public int IdPedido;
    public int IdClienteOrigen;
    public int IdClienteDestino;
    public int IdViaje;
    public String Delivery;
    public double Peso;
    public double Piezas;
    public String Estatus;
    public static String Header[] = {"Id","Delivery","Cliente Origen","Cliente Destino","Viaje","Peso","Piezas","Estatus"};
    
    public Pedido(int idpedido,int idclienteo,int idcliented,int idviaje,String delivery, double peso,double piezas,String estatus){
        IdPedido = idpedido;
        IdClienteOrigen = idclienteo;
        IdClienteDestino = idcliented;
        Delivery = delivery;
        Peso = peso;
        Piezas = piezas;
        Estatus = estatus;
    }
    
    public Pedido(int idclienteo,int idcliented,String delivery, double peso,double piezas,String estatus){
        IdClienteOrigen = idclienteo;
        IdClienteDestino = idcliented;
        Delivery = delivery;
        Peso = peso;
        Piezas = piezas;
        Estatus = estatus;
    }
    
    public static String[] GetRow(ResultSet result) throws Exception{
        
        try
        {
            String IdPedido = result.getString("idpedido");
            String ClienteOrigen = result.getString("clienteorigen");
            String ClienteDestino = result.getString("clientedestino");
            String Viaje = result.getString("viaje");
            String Delivery = result.getString("delivery");
            String Peso = result.getString("peso");
            String Piezas = result.getString("piezas");
            String Estatus = result.getString("estatus");
            String row[] = {IdPedido,Delivery,ClienteOrigen,ClienteDestino,Viaje,Peso,Piezas,Estatus};
            return row;
        }
        catch(Exception error){
            String row[] = {};
            return row;
        }
        
        
    }
    
    public static Pedido GetInstance(ResultSet result) throws Exception{
        
        try
        {
            String IdPedido = result.getString("idpedido");
            String IdClienteOrigen = result.getString("idclienteorigen");
            String IdClienteDestino = result.getString("idclientedestino");
            String IdViaje = result.getString("idviaje");
            String Delivery = result.getString("delivery");
            String Peso = result.getString("peso");
            String Piezas = result.getString("piezas");
            String Estatus = result.getString("estatus");

            Pedido pedido = new Pedido(Integer.parseInt(IdPedido),Integer.parseInt(IdClienteOrigen),Integer.parseInt(IdViaje),Integer.parseInt(IdClienteDestino),Delivery,Double.valueOf(Peso),Double.valueOf(Piezas),Estatus);
            return pedido;
        }
        catch(Exception error){
            return null;
        }
    }
    
}
