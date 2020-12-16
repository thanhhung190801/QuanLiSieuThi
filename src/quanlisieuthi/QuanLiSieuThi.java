/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisieuthi;

import Model.HangDienMay;
import Model.HangThuCong;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class QuanLiSieuThi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner read = new Scanner(new Scanner(System.in).nextLine());
        String namsinh = read.next();
        System.out.println(" nam sinh "+namsinh);
        Model.HangDienMay a = new HangDienMay("trong nuoc", "E001", new SimpleDateFormat("dd/MM/yyyy").parse("19/08/2010"), 200, 10);
         System.out.println(a.output());
    }
    
}
