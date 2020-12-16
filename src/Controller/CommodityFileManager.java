/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HangThuCong;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CommodityFileManager {
    public static  ArrayList<HangThuCong> readFileHangThuCongs(String file){
        ArrayList<HangThuCong> list = new ArrayList<>();
        File f = new File(file);
        
        try {
            //TC002 20/20/2020 9876.6 10 Mai Thanh Hung
              //TC002 20/20/2020 9876.6 10 Mai Thanh Hung
              Scanner read = new Scanner(f);
              if(f.exists()){
                  System.out.println("file da ton tai bat dau ghifile");
              }
              while (read.hasNextLine()) {                
                  String id = read.next();
                  String date = read.next();
                  float price = read.nextFloat();
                  int amount = read.nextInt();
                  String producer = read.nextLine();
                  HangThuCong htc = new HangThuCong(producer, id, new SimpleDateFormat("dd/MM/yyyy").parse(date), price, amount);
                  list.add(htc);
              }
            
        } catch (Exception e) {
        }
        return list;
    }
    public static void wrireFileHangThuCongs(ArrayList<HangThuCong> list ,String tenfile){
        try (PrintWriter pw = new PrintWriter(new File(tenfile))){
            for (HangThuCong h : list) {
                pw.print(h);
            }
        } catch (Exception e) {
        }
    }
}
