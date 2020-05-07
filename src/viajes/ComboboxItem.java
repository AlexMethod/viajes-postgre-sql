/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes;

/**
 *
 * @author USUARIO DELL
 */
public class ComboboxItem {
    
    private String key;
    private int value;

    public ComboboxItem(String key, int value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getText()
    {
        return key;
    }

    public int getValue()
    {
        return value;
    }
}
