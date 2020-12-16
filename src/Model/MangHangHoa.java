/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MangHangHoa {

    private ArrayList<HangHoa> list = new ArrayList<>();

    public void insertNew(HangHoa a) {
        list.add(a);
    }

    public void inputList() throws ParseException {
        Scanner kb = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("Enter to input amountOcommodity");
            n = kb.nextInt();
        } while (n <= 0);

        HangHoa a;
        for (int i = 0; i < n; i++) {
            System.out.println("1. Input value of ElectricCommodity");
            System.out.println("2. Input value of HandmadeCommodity");
            int choose = kb.nextInt();
            if (choose == 1) {
                a = new HangDienMay();
                a.input();
                insertNew(a);
            } else {
                a = new HangThuCong();
                a.input();
                insertNew(a);
            }
        }
    }

    public void findByCommodityId(String id) {
        for (HangHoa hangHoa : list) {
            if (hangHoa.getCommodityID().equals(id)) {
                System.out.println("find commodity succsesful  : ");
                hangHoa.output();
                break;
            } else {
                System.err.println(" sorry not commodity at list");
            }
        }
    }

    public void deleteByCommodityId(String id) {
        for (HangHoa hangHoa : list) {
            if (hangHoa.getCommodityID().equals(id)) {
                System.out.println("delete commodity succsesful  : ");
                list.remove(hangHoa);
                break;
            } else {
                System.err.println(" sorry nothing to erase");
            }
        }
        displayList(" List after data deletion: ");
    }

    public void displayList(String nd) {
        int i = 0;
        System.out.println(nd);
        for (Iterator<HangHoa> iterator = list.iterator(); iterator.hasNext();) {
            HangHoa next = iterator.next();
            i++;
            System.out.println(i + ". " + next.output());

        }
    }

    public void getSumMoneyComodityElectric() {
        double sumItem = 0;
        for (HangHoa h : list) {
            if (h instanceof HangDienMay) {
                    
                sumItem += h.getCalculateMoney();
            }
        }
        System.out.println("Sum of Electric " + sumItem);
    }

    public void getSumMoneyComodityHandmade() {
        double sumItem = 0;
        for (HangHoa h : list) {
            if (h instanceof HangThuCong) {
                sumItem += h.getCalculateMoney();
            }
        }
        System.out.println("Sum of Handmade " + sumItem);
    }

    public static void main(String[] args) throws ParseException {
        MangHangHoa m = new MangHangHoa();
        m.inputList();
        m.displayList("list of data at this project ");
        Scanner kb = new Scanner(System.in);
        System.out.println("input id at this keyBoard ");
        String id = kb.nextLine();
        m.findByCommodityId(id);
         System.out.println("input id at this keyBoard ");
        String idd = kb.nextLine();
        m.deleteByCommodityId(idd);
        m.getSumMoneyComodityElectric();
        m.getSumMoneyComodityHandmade();
    }
}
