/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BrandDAO;
import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Brand;
import model.Category;
import model.Product;

/**
 *
 * @author manh3
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("uid");
        String cid_raw = request.getParameter("ucid");
        String bid_raw = request.getParameter("ubid");
        ProductDAO pd = new ProductDAO();
        CategoryDAO cd = new CategoryDAO();
        BrandDAO bd = new BrandDAO();
        List<Product> listp = pd.getAllProducts();
        List<Category> listc = cd.getAllCategory();
        List<Brand> listb = bd.getAllBrands();
        
        if(cid_raw!=null){
            int cid = Integer.parseInt(cid_raw);
            Category c = cd.getCategoryById(cid);
            request.setAttribute("c", c);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }else if(id_raw!=null){
          int id = Integer.parseInt(id_raw);
        Product p = pd.getProductById(id);
        request.setAttribute("productid", p);
        request.setAttribute("products", listp);
        request.setAttribute("category", listc);
        request.setAttribute("brands", listb);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }else if(bid_raw !=null){
            int bid = Integer.parseInt(bid_raw);
            Brand b = bd.getBrandById(bid);
            request.setAttribute("b", b);
             request.getRequestDispatcher("update.jsp").forward(request, response);
        }
        
        

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO pd = new ProductDAO();
        String id_raw = request.getParameter("pid");
        String cid_raw = request.getParameter("ucid");
        String title = request.getParameter("title");
        String category_id_raw = request.getParameter("category_id");
        String price_raw = request.getParameter("price");
        String quantity_raw = request.getParameter("quantity");
        String discount_raw = request.getParameter("discount");
        String description = request.getParameter("description");
        String status_raw = request.getParameter("status");
        String brand_raw = request.getParameter("brand_id");
        String image = request.getParameter("image");
        int id;
        int category_id;
        double price;
        int quantity;
        int discount;
        int status;
        int brand;
        if(cid_raw!=null){
            id = Integer.parseInt(cid_raw);
             String imagec = request.getParameter("image");
             String name = request.getParameter("name");
             CategoryDAO c = new CategoryDAO();
             c.updateCategory(new Category(id, name, imagec));
              response.sendRedirect("crud_category");
        }else{
            id = Integer.parseInt(id_raw);
        category_id = Integer.parseInt(category_id_raw);
        price = Double.parseDouble(price_raw);
        quantity = Integer.parseInt(quantity_raw);
        discount = Integer.parseInt(discount_raw);
        status = Integer.parseInt(status_raw);
        brand = Integer.parseInt(brand_raw);
        pd.updateProduct(id, category_id, title, price, quantity, discount, description, status, brand, image);
        response.sendRedirect("crud");
        }
        

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
