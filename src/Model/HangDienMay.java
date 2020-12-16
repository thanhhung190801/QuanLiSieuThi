/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.text.html.HTML;
import javax.tools.DocumentationTool;

/**
 *
 * @author Admin
 */
public class HangDienMay extends HangHoa {

    String localtion;

    public HangDienMay() {
        super();
        localtion = "";
    }

    public HangDienMay(String localtion, String commodityID, Date inputdate, double price, int amount) {
        super(commodityID, inputdate, price, amount);
        this.localtion = localtion;
    }

    public String getLocaltion() {
        return localtion;
    }

    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }
    public void input() throws ParseException{
        super.input();
        Scanner kb = new Scanner(System.in);
        System.out.println("enter to input localtion");
        localtion=kb.nextLine();
    }
    @Override
    protected double getCalculateMoney() {
        if (localtion.equals("trong nuoc")) 
            return price * amount;
        
        if (localtion.equals("nhap khau")) 
            return price * amount * 1.2;
        return 0.0;
    }

    @Override
    public String toString() {
        return "HangDienMay{" + "localtion=" + localtion + '}';
    }
    
     public String output(){
         return super.output("Hang Dien May")+" localtion : " + localtion +" , CalculateMoney = "+getCalculateMoney();
     }
     public static void main(String[] args) throws ParseException {
        HangDienMay a = new HangDienMay("trong nuoc", "E001", new SimpleDateFormat("dd/MM/yyyy").parse("19/08/2010"), 200, 10);
         System.out.println(a.output());
    }
}
