/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HangDienMay;
import Model.HangThuCong;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.jar.Attributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DaoCommodity {
    public static ArrayList<HangDienMay>GetdataDienMays(){
        ArrayList<HangDienMay>list = new ArrayList<>();
        Statement statement =null;
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QlST;username=sa;password=1234;");
            statement=connection.createStatement();
            String sql ="select * from tblDienMay";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                HangDienMay h = new HangDienMay();
                h.setCommodityID(rs.getString("id"));
                h.setInputdate(rs.getDate("dateinput"));
                h.setPrice(rs.getFloat("price"));
                h.setAmount(rs.getInt("amount"));
                h.setLocaltion("producer");
                list.add(h);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCommodity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommodity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static ArrayList<HangThuCong> getDataThucongs(){
        ArrayList<HangThuCong> list = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QlST;username=sa;password=1234;");
                  Statement s =  connection.createStatement();
                  String sql ="select * from tblThuCong1";
                  ResultSet rs = s.executeQuery(sql);
                  while(rs.next()){
                      HangThuCong h = new HangThuCong();
                    h.setCommodityID(rs.getString("id"));
                    h.setInputdate(rs.getDate("dateinput"));
                    h.setPrice(rs.getFloat("price"));
                    h.setAmount(rs.getInt("amount"));
                    h.setProducer(rs.getString("producer"));
                    list.add(h);
                  }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCommodity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommodity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static ArrayList<HangThuCong> findByID(String id){
         ArrayList<HangThuCong> list = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QLST;username=sa;password=1234");
            String sql ="select * from tblThuCong1 where id like ? ";
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setString(1, "%"+id+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                HangThuCong htc = new HangThuCong();
                htc.setCommodityID(rs.getString(1));
                htc.setInputdate(rs.getDate(2));
                htc.setPrice(rs.getFloat(3));
                htc.setAmount(rs.getInt(4));
                htc.setProducer(rs.getString(5));
                list.add(htc);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCommodity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommodity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
