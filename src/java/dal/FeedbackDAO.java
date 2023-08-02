/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Feedback;
import model.User;

/**
 *
 * @author manh3
 */
public class FeedbackDAO extends DBContext{
      public List<Feedback> getFeedbackById(int id) {
        List<Feedback> list = new ArrayList<>();
        String sql = "select * from Feedback\n"
                + "where product_id = " + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Feedback f = new Feedback();
                f.setId(rs.getInt("id"));
                f.setRating(rs.getInt("rating"));
                f.setNote(rs.getString("note"));
                f.setDate(rs.getString("date"));
                UserDAO ud = new UserDAO();
                User u = ud.getUserById(rs.getInt("user_id"));
                f.setUser(u);
                f.setProduct_id(rs.getInt("product_id"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }

    public void insertFeedback(User u, String note, int rating, int product_id) {
        LocalDateTime curDate = java.time.LocalDateTime.now();
        String date = curDate.toString();
        String sql = "insert into Feedback values (?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, rating);
            st.setString(2, note);
            st.setString(3, date);
            st.setInt(4, u.getId());
            st.setInt(5, product_id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        FeedbackDAO f = new FeedbackDAO();
        Feedback fb = new Feedback();
        List<Feedback> list =f.getFeedbackById(275);
        System.out.println(list.get(0).getId());
    }
    
}
