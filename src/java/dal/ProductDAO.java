/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Brand;
import model.Product;

/**
 *
 * @author manh3
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> list = new ArrayList();
        String sql = "select * from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), rs.getInt("category_id"), b.getBrandById(rs.getInt("brand_id")), c.getCategoryById(rs.getInt("category_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getInt("brand_id"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getAllProductsById(int id) {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT *\n"
                + "  FROM [dbo].[Product]\n"
                + "  where category_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), rs.getInt("category_id"), b.getBrandById(rs.getInt("brand_id")), c.getCategoryById(rs.getInt("category_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getInt("brand_id"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getTopProducts() {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT TOP 10 * FROM Product order by id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), rs.getInt("category_id"), b.getBrandById(rs.getInt("brand_id")), c.getCategoryById(rs.getInt("category_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getInt("brand_id"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getTopSaleProducts() {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT TOP 7 * FROM Product order by discount desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), rs.getInt("category_id"), b.getBrandById(rs.getInt("brand_id")), c.getCategoryById(rs.getInt("category_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getInt("brand_id"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> searchProduct(int brand_id, String title) {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT * from Product p inner join Brands b on p.brand_id=" + brand_id + " and b.id =" + brand_id + " and p.[title] like '%" + title + "%'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), rs.getInt("category_id"), b.getBrandById(rs.getInt("brand_id")), c.getCategoryById(rs.getInt("category_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getInt("brand_id"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getTop3SaleProducts() {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT TOP 3 * FROM Product order by discount desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), rs.getInt("category_id"), b.getBrandById(rs.getInt("brand_id")), c.getCategoryById(rs.getInt("category_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getInt("brand_id"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getProductsByPrice(int min, int max) {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT  * FROM Product Where price between ? and ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, min);
            st.setInt(2, max);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), rs.getInt("category_id"), b.getBrandById(rs.getInt("brand_id")), c.getCategoryById(rs.getInt("category_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getInt("brand_id"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getProductById(int id) {
        Product p = new Product();
        String sql = "SELECT *\n"
                + "  FROM [dbo].[Product]\n"
                + "  where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                p = new Product(rs.getInt("id"), rs.getInt("category_id"), b.getBrandById(rs.getInt("brand_id")), c.getCategoryById(rs.getInt("category_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getInt("brand_id"), rs.getString("image"));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return p;
    }
    private Product getProductId(int id) {
        Product p  = new Product();
        String sql = "SELECT *\n"
                + "  FROM [dbo].[Product]\n"
                + "  where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
              p = new Product(rs.getInt("id"), rs.getInt("category_id"), b.getBrandById(rs.getInt("brand_id")), c.getCategoryById(rs.getInt("category_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getInt("brand_id"), rs.getString("image"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return p;
    }
     public ArrayList<Product> getRelatedByProductId(int id) {
         Product p1 = getProductId(id);
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT *\n"
                + "  FROM [dbo].[Product]\n"
                + "  where brand_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p1.getBrand_id());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), rs.getInt("category_id"), b.getBrandById(rs.getInt("brand_id")), c.getCategoryById(rs.getInt("category_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getInt("brand_id"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

//    public static void main(String[] args) {
//        ArrayList<Product> list = new ArrayList<>();
//        ProductDAO p = new ProductDAO();
//        list = p.getRelatedProductsByBrand(2);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.size() + "  ===== " + list.get(i).getPrice());
//
//        }
//    }

}
