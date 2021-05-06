/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import com.opencsv.ICSVWriter;
import com.opencsv.CSVWriterBuilder;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.nio.file.Paths;
import setting.tanggal;
/**
 *
 * @author imam
 */
public class report {
    private List<String[]> data(String[] header, String[][] data){
        List<String[]> dataList = new ArrayList<>();
        dataList.add(header);
        for (int i = 0; i < data.length; i++) {
            String[] record = new String[header.length];
            for (int j = 0; j < data[i].length; j++) {
                record[j] = data[i][j];
            }
            dataList.add(record);
        }
        return dataList;
    }
    
    public void get(String[] header, String[][] data, String namaFile){
        tanggal tanggal = new tanggal();
        try {
            int jmlKolomHeader = header.length;
            int jmlKolomData = data[0].length;
            if (jmlKolomHeader == jmlKolomData) {
                String tgl = tanggal.tglSekarang("dd-MM-yyyy");
                List<String[]> csvData = data(header, data);
                String path = Paths.get("").toAbsolutePath().toString();
                path += "/src/file_report/Export "+namaFile+" "+tgl+".csv";
                try (ICSVWriter writer = new CSVWriterBuilder(new FileWriter(path)).withSeparator('|').build()){
                    writer.writeAll(csvData);
                    JOptionPane.showMessageDialog(null, "Berhasil download\nPath : "+path);
                }catch (FileNotFoundException j){
                    JOptionPane.showMessageDialog(null, "error : "+j);
                }catch (UnsupportedClassVersionError ex){
                    JOptionPane.showMessageDialog(null, "harus menggunakan jdk 8 link download : "
                            + "https://www.filepuma.com/download/java_development_kit_64bit_8.0.2310.11-23639/download/");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error csv : "+e);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Salah koding!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Tidak ada data!");
        }
    }
}
