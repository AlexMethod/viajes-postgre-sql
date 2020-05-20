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
public class Ruta {
    public int IdRuta;
    public String EstadoOrigen;
    public String EstadoDestino;
    public int CPOrigen;
    public int CPDestino;
    public String Estatus;
    public static String[] Header = {"Id","Estado Origen","Estado Destino","CP Origen","CP Destino","Estatus"};
    
    public Ruta(int idruta,String estadoorigen,String estadodestino,int cporigen,int cpdestino, String estatus){
        IdRuta = idruta;
        EstadoOrigen = estadoorigen;
        EstadoDestino = estadodestino;
        CPOrigen = cporigen;
        CPDestino = cpdestino;
        Estatus = estatus;
    }
    
    public Ruta(String estadoorigen,String estadodestino,int cporigen,int cpdestino, String estatus){
        EstadoOrigen = estadoorigen;
        EstadoDestino = estadodestino;
        CPOrigen = cporigen;
        CPDestino = cpdestino;
        Estatus = estatus;
    }
    
    public static String[] GetRow(ResultSet result) throws Exception{
        try
        {
            String IdRuta = result.getString("idruta");
            String EstadoOrigen = result.getString("nombre");
            String EstadoDestino = result.getString("direccion");
            String CPOrigen = result.getString("cporigen");
            String CPDestino = result.getString("cpdestino");
            String Estatus = result.getString("estatus");
            String row[] = {IdRuta,EstadoOrigen,EstadoDestino,CPOrigen,CPDestino,Estatus};
            return row;
        }
        catch(Exception error){
            String row[] = {};
            return row;
        }
    }
    
    public static Ruta GetInstance(ResultSet result) throws Exception{
        try
        {
            String IdRuta = result.getString("idruta");
            String EstadoOrigen = result.getString("estadoorigen");
            String EstadoDestino = result.getString("estadodestino");
            String CPOrigen = result.getString("cporigen");
            String CPDestino = result.getString("cpdestino");
            String Estatus = result.getString("estatus");

            Ruta ruta = new Ruta(Integer.parseInt(IdRuta),EstadoOrigen,EstadoDestino,Integer.parseInt(CPOrigen),Integer.parseInt(CPDestino),Estatus);
            return ruta;
        }
        catch(Exception error){
            return null;
        }
    }
}
