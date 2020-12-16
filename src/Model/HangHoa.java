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

/**
 *
 * @author Admin
 */
public abstract class HangHoa {
    String commodityID;
    Date inputdate;
    double price;
    int amount;
    protected abstract double getCalculateMoney();

    public HangHoa(String commodityID, Date inputdate, double price, int amount) {
        this.commodityID = commodityID;
        this.inputdate = inputdate;
        this.price = price;
        this.amount = amount;
    }

    public HangHoa() {
    }

    public String getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(String commodityID) {
        this.commodityID = commodityID;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void input() throws ParseException{
        Scanner kb = new Scanner(System.in);
        System.out.println("enter to input  commodityID ");
        commodityID =kb.nextLine();
        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("enter to input  inputdate ");
        inputdate = simple.parse(kb.nextLine());
        System.out.println("enter to input  price ");
        price =kb.nextDouble();
         System.out.println("enter to input  amount ");
        amount =kb.nextInt();
                
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "HangHoa{" + "commodityID=" + commodityID + ", inputdate=" + sdf.format(inputdate)+ ", price=" + price + ", amount=" + amount + '}';
    }
    public String output(String nd){
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return nd+" {" + "commodityID=" + commodityID + ", inputdate=" +  sdf.format(inputdate) + ", price=" + price + ", amount=" + amount ;
    }
    public String output(){
        return " ";
    }
   
}
