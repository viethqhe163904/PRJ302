/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;

/**
 *
 * @author manh3
 */
public class CategoryDAO extends DBContext{
    public ArrayList<Category> getAllCategory(){
        ArrayList<Category> list = new ArrayList<>();
        String sql =" select * from Category";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Category c= new Category(rs.getInt("id"),rs.getString("name"),rs.getString("image"));
                list.add(c);
            }
            }catch(SQLException e){
                    System.out.println(e);
                    }
        
        return list;
    }
     public Category getCategoryById(int id){
        
        String sql =" select * from Category where id=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                Category c= new Category(rs.getInt("id"),rs.getString("name"),rs.getString("image"));
                 return c;
            }
           
            }catch(SQLException e){
                    System.out.println(e);
                    }
        
        return null;
    }
     public void insertCategory(Category c) {
        String sql = "insert into Category values(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, c.getName());
            st.setString(3, c.getImage());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
      public void updateCategory(Category c) {
        String sql = "UPDATE [dbo].[Category]\n"
                + "   SET [name] = ?\n"
                + "      ,[image] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getImage());
            st.setInt(3, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
     public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
                System.out.println(c.getCategoryById(1).getName());
                        
    }
}
