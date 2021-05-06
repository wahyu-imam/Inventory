/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniqid;

/**
 *
 * @author imam
 */
public class uniqid {
    
    public String get(){
        String data = "";
        int panjang = 15;
        for(int i = 0; i < panjang; i++){ 
            char karakter = uniqid.buatKarakterDigitAngkaAcak(); 
            if (i == 0) {
                switch(karakter){
                    case '0':
                        data += "A";
                        break;
                    case '1':
                        data += "B";
                        break;
                    case '2':
                        data += "C";
                        break;
                    case '3':
                        data += "D";
                        break;
                    case '4':
                        data += "E";
                        break;
                    case '5':
                        data += "F";
                        break;
                    case '6':
                        data += "G";
                        break;
                    case '7':
                        data += "H";
                        break;
                    case '8':
                        data += "I";
                        break;
                    case '9':
                        data += "J";
                        break;
                }
            }else if (i == panjang) {
                if (karakter == '0') {
                    data += "9";
                }
            }else{
                switch(karakter){
                    case '3':
                        data += "K";
                        break;
                    case '5':
                        data += "L";
                        break;
                    case '7':
                        data += "M";
                        break;
                    default:
                        data += karakter;
                        break;
                }
            }
        }
        return data;
    }
    
    private static char buatKarakterDigitAngkaAcak(){ 
        return buatKarakterAcak('0', '9'); 
    }
    
    private static char buatKarakterAcak(char karakter1, char karakter2){ 
        return (char)(karakter1 + Math.random() * (karakter2 - karakter1 + 1)); 
    }
    
//    public static void main(String[] args) {
//        uniqid u = new uniqid();
//        System.out.println(u.get());
//    }
}
