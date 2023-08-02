/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cart;
import model.Item;

/**
 *
 * @author manh3
 */
public class CardDAO extends DBContext {

    public Cart getCartByUsername(int id) {
        Cart cart = new Cart();
        String sql = "    SELECT *   FROM [Cart] where [user_id]=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ProductDAO p = new ProductDAO();
            while (rs.next()) {
                Item i = new Item(p.getProductById(rs.getInt("product_id")), rs.getInt("quantity"), rs.getInt("total"));
                cart.addItem(i);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cart;
    }
}
