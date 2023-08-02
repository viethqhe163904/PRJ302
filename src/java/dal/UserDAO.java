/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author manh3
 */
public class UserDAO extends DBContext {

    public boolean check(String username, String password) {
        String sql = "SELECT *\n"
                + "  FROM [dbo].[User] where username =? and password =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean checkAccountExist(String username) {
        String sql = "SELECT *\n"
                + "  FROM [dbo].[User] where username =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public User checkUser(String username, String password) {
        User u;
        String sql = "SELECT *\n"
                + "  FROM [dbo].[User] where username =? and password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                u = new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getInt("role_id")
                );
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertUser(String username, String password, String email, String phone_number, String adress, int role_id) {
        String sql = "insert into [User]\n"
                + "values (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3,email);
            st.setString(4, phone_number);
            st.setString(5, adress);
            st.setInt(6,role_id );
            st.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateUser(int id, String email, String phone, String address) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET \n"
                + "      [email] = ?\n"
                + "      ,[phone_number] = ?\n"
                + "      ,[address] = ?\n"
                + "      \n"
                + " WHERE id=" + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, phone);
            st.setString(3, address);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public User getUserById(int id) {
        String sql = "select * from [User]\n"
                + "where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhone_number(rs.getString("phone_number"));
                u.setAddress(rs.getString("address"));
                u.setRole_id(rs.getInt("role_id"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public int numberOfAccount(int roleid) {
        String sql = "select count(u.id) as total from [User] u where u.role_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, roleid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int sum = rs.getInt("total");
                return sum;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public static void main(String[] args) {
        User u = new User();
        UserDAO ud = new UserDAO();
        ud.insertUser("viettq26", "viettq22", "manh3btq@gmail.com","1234567899","Tuyen Quang ", 2);
       
        
    }
}
