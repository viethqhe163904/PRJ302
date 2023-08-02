/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import model.Cart;
import model.Item;
import model.User;

/**
 *
 * @author manh3
 */
public class OrderDAO extends DBContext {

    public void addOrders(User u, Cart cart, String note, String email, String name, String address, String country, String phone) {
        LocalDateTime curDate = java.time.LocalDateTime.now();
        String date = curDate.toString();
        try {
            String sql = "insert into Orders values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, u.getId());
            st.setString(2, date);
            st.setDouble(3, cart.getTotalMoney());
            st.setString(4, note);
            st.setString(5, email);
            st.setString(6, name);
            st.setString(7, address);
            st.setString(8, country);
            st.setString(9, phone);
            st.executeUpdate();
            String sql1 = "select top 1 id from Orders order by id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            if (rs.next()) {
                int order_id = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into Order_Details values (?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, order_id);
                    st2.setInt(2, i.getProduct().getId());
                    st2.setDouble(3, i.getPrice());
                    st2.setInt(4, i.getQuantity());
                    st2.executeUpdate();
                }
            }
            String sql3 = "update Product set quantity = quantity - ?\n"
                    + "where id = ?";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            for (Item i : cart.getItems()) {
                st3.setInt(1, i.getQuantity());
                st3.setInt(2, i.getProduct().getId());
                st3.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public int numberOfOrder() {
        String sql = " select count(o.id) as total from Orders o";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
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

    
}
