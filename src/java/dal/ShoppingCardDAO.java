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
import model.User;

/**
 *
 * @author manh3
 */
public class ShoppingCardDAO extends DBContext {

    public void addToCart(User user, Item item) {
        String sql = " INSERT INTO [dbo].[Cart]\n"
                + "           ([user_id]\n"
                + "           ,[product_id]\n"
                + "           ,[quantity]\n"
                + "           ,[total])\n"
                + "     VALUES\n"
                + "           (?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, item.getProduct().getId());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(3, item.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Cart getCartByUsername(String username) {
        Cart cart = new Cart();
        String sql = "        SELECT *"
                + "  FROM [Cart] where [user_id]=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDAO p = new ProductDAO();
                Item item = new Item(p.getProductById(rs.getInt("product_id")), rs.getInt("quantity"), rs.getInt("total"));
                cart.addItem(item);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cart;
    }

}
