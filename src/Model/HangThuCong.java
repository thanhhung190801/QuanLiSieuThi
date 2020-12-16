/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class HangThuCong extends HangHoa{
    String producer;

    public HangThuCong() {
        super();
        producer="";
    }

    public HangThuCong(String producer, String commodityID, Date inputdate, double price, int amount) {
        super(commodityID, inputdate, price, amount);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    protected double getCalculateMoney() {
        return price*amount;
    }
  public void input() throws ParseException{
        super.input();
        Scanner kb = new Scanner(System.in);
        System.out.println("enter to input producer");
        producer=kb.nextLine();
    }
    @Override
    public String toString() {
        return "HangThuCong{" + "producer=" + producer + '}';
    }
    public String output(){
        return super.output("Hang Thu Cong ")+ "producer : " + producer+" CalculateMoney = "+getCalculateMoney();
    }
}
