/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Brand;
import model.Category;

/**
 *
 * @author manh3
 */
public class BrandDAO extends DBContext{
     public ArrayList<Brand> getAllBrands(){
        ArrayList<Brand> list = new ArrayList<>();
        String sql ="Select*from Brands";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Brand b= new Brand(rs.getInt("id"),rs.getString("name"));
                list.add(b);
            }
            }catch(SQLException e){
                    System.out.println(e);
                    }
        
        return list;
    }
      public ArrayList<Brand> getBrandByProductId(int id){
        ArrayList<Brand> list = new ArrayList<>();
        String sql ="Select*from Brands where id =?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Brand b= new Brand(rs.getInt("id"),rs.getString("name"));
                list.add(b);
            }
            }catch(SQLException e){
                    System.out.println(e);
                    }
        
        return list;
    }
     public static void main(String[] args) {
        BrandDAO b = new BrandDAO();
        Brand list =b.getBrandById(2);
         System.out.println(list.getName());
    }
      public Brand getBrandById(int id){
       Brand b = new Brand();
        String sql ="Select*from Brands where id =?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
           if(rs.next()){
                 b= new Brand(rs.getInt("id"),rs.getString("name"));
            }
            }catch(SQLException e){
                    System.out.println(e);
                    }
        
        return b;
    }
        public void insertBrand(Brand c) {
        String sql = "insert into Brand values(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, c.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
