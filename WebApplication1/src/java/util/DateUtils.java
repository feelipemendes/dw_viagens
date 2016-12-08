/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Bernardo
 */
public class DateUtils {
    
    public static String toStringDate(Date data) {
        if(data != null) {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            return df.format(data);
        }
        return "";
    }
    
    public static Date toDateString (String dataStr) {
        
        if(!dataStr.equals("")) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = null;
            try {
                date = format.parse(dataStr);
            } catch (ParseException ex) {
                Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new java.sql.Date(date.getTime());
        }
        return null;
    } 
}
