/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setting;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author imam
 */
public class tanggal {
    public String tglSekarang(String format){
        Date ys = new Date();
        SimpleDateFormat s = new SimpleDateFormat(format);
        String data = s.format(ys);
        return data;
    }
}
