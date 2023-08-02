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
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getAllProductsByCId(int id) {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT *\n"
                + "  FROM [dbo].[Product]\n"
                + "  where category_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                BrandDAO b = new BrandDAO();
                CategoryDAO c = new CategoryDAO();
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
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

                BrandDAO b = new BrandDAO();
                CategoryDAO c = new CategoryDAO();
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
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
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
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
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
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
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getProductsByPrice(double min, double max) {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT  * FROM Product Where price between ? and ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, min);
            st.setDouble(2, max);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductBybrandId(int[] brand_id) {
        List<Product> list = new ArrayList<>();
        String sql = "select *  from Product\n"
                + "where 1=1 ";
        if (brand_id != null && brand_id[0] != 0) {
            sql += " and brand_id in(";
            for (int i = 0; i < brand_id.length; i++) {
                sql += brand_id[i] + ",";
            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));

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
                p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return p;
    }

    private Product getProductId(int id) {
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
                p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return p;
    }

    public ArrayList<Product> getRelatedByProductId(int id) {
        Product p1 = getProductId(id);
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT TOP 4 *\n"
                + "  FROM [dbo].[Product]\n"
                + "  where brand_id=? order by id asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p1.getBrand().getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertProduct(int category_id, String title, double price, int quantity, int discount, String description, int status, int brand_id, String image) {

        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([category_id]\n"
                + "           ,[title]\n"
                + "           ,[price]\n"
                + "           ,[quantity]\n"
                + "           ,[discount]\n"
                + "           ,[description]\n"
                + "           ,[status]\n"
                + "           ,[brand_id]\n"
                + "           ,[image])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,'?'\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,'?'\n"
                + "           ,1\n"
                + "           ,?\n"
                + "           ,'?')";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, category_id);
            st.setString(2, title);
            st.setDouble(3, price);
            st.setInt(4, quantity);
            st.setInt(5, discount);
            st.setString(6, description);
            st.setInt(7, status);
            st.setInt(8, brand_id);
            st.setString(9, image);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void deleteProductByid(int id) {
        String sql = "delete \n"
                + "  FROM [dbo].[Product]\n"
                + "  where id=";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateProduct(int id, int cid, String title, double price, int quantity, int discount, String description, int status, int brand_id, String image) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [category_id] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[discount] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[brand_id] = ?\n"
                + "      ,[image] = ?\n"
                + " WHERE id = " + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            st.setString(2, title);
            st.setDouble(3, price);
            st.setInt(4, quantity);
            st.setInt(5, discount);
            st.setString(6, description);
            st.setInt(7, status);
            st.setInt(8, brand_id);
            st.setString(9, image);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public ArrayList<Product> getProductByPrice(double max, double min) {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT  * FROM Product Where price between ? and ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, max);
            st.setDouble(2, min);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> sortProductByPrice() {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT  * FROM Product order by price asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
        
    }
    public ArrayList<Product> sortProductByDiscount() {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT  * FROM Product order by discount asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO c = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
        
    }
    public ArrayList<Product> getAllProductsByBId(int id) {
        ArrayList<Product> list = new ArrayList();
        String sql = "SELECT *\n"
                + "  FROM [dbo].[Product]\n"
                + "  where brand_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                BrandDAO b = new BrandDAO();
                CategoryDAO c = new CategoryDAO();
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getProductsPaging(int page) {
        ArrayList<Product> list = new ArrayList();
        String sql = "select * from Product order by id\n"
                + "\n"
                + "Offset ? rows fetch next 6 rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (page - 1) * 3);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                BrandDAO b = new BrandDAO();
                CategoryDAO c = new CategoryDAO();
                Product p = new Product(rs.getInt("id"), c.getCategoryById(rs.getInt("category_id")), b.getBrandById(rs.getInt("brand_id")), rs.getString("title"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("discount"), rs.getString("description"), rs.getInt("status"), rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int numberOfProduct() {
        String sql = " select count(p.id) as total from Product p";
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
    public double sumOfIncome() {
        String sql = "select sum((p.price-(p.price*p.discount)/100)*od.quantity) as total from Product p , \n"
                + "Order_Details od where p.id =od.product_id ";
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
        return -1;
    }
     public List<Product> getTopSale5() {
        List<Product> list = new ArrayList<>();
        String sql = "select top 5 p.id,p.category_id,p.title,p.price,p.quantity as num,p.discount,p.description,p.status,p.brand_id,p.image,sum(od.quantity) as quantity\n"
                + "FROM [Order_Details] od join Product p \n"
                + "on p.id = od.product_id \n"
                + "group by p.id,p.category_id,p.title,p.price,p.quantity,p.discount,p.description,p.status,p.brand_id,p.image\n"
                + "order by quantity desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                CategoryDAO cd = new CategoryDAO();
                BrandDAO b = new BrandDAO();
                Category c = cd.getCategoryById(rs.getInt("category_id"));
                p.setCategory(c);
                p.setTitle(rs.getString("title"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDiscount(rs.getInt("discount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));
                p.setBrand(b.getBrandById(rs.getInt("brand_id")));
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("e");
        }
        return list;
    }
      public List<Integer> numberOfProductByBrand() {
          List<Integer> list = new ArrayList<>();
        String sql = "select COUNT(brand_id) as total from Product group by brand_id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int sum = rs.getInt("total");
                list.add(sum);
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        ProductDAO p = new ProductDAO();
        List<Integer> l = p.numberOfProductByBrand();
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.size());
        }
    }

}
