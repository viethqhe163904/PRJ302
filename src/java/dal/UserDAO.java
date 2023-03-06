/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author manh3
 */
public class UserDAO extends DBContext{
    public boolean check(String username,String password){
        String sql="SELECT *\n" +
"  FROM [dbo].[User] where username =? and password =?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs =st.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
     public boolean checkAccountExist(String username){
        String sql="SELECT *\n" +
"  FROM [dbo].[User] where username =?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            
            ResultSet rs =st.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
}
