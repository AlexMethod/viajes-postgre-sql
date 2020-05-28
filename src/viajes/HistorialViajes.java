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
public class HistorialViajes {
    
    public int IdViaje;
    public String Fecha;
    public String Estatus;
    public static String Header[] = {"Id","Folio","Fecha Alta","Estatus"};
    
    public static String[] GetRow(ResultSet result) throws Exception{
        
        try
        {
            String IdViaje = result.getString("idviaje");
            String FechaAlta = result.getString("FechaAlta");
            String Folio = result.getString("Folio");
            String Estatus = result.getString("estatus");
            String row[] = {IdViaje,Folio,FechaAlta,Estatus};
            return row;
        }
        catch(Exception error){
            String row[] = {};
            return row;
        }
        
        
    }
    
}
