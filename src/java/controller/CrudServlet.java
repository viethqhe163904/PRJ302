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
import java.util.ArrayList;
import java.util.List;
import model.Brand;
import model.Category;
import model.Product;

/**
 *
 * @author manh3
 */
@WebServlet(name = "CrudServlet", urlPatterns = {"/crud"})
public class CrudServlet extends HttpServlet {

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
            out.println("<title>Servlet CrudServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrudServlet at " + request.getContextPath() + "</h1>");
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
        String page_raw = request.getParameter("page");
        ProductDAO p = new ProductDAO();
        CategoryDAO c = new CategoryDAO();
        BrandDAO b = new BrandDAO();
        List<Category> listc = c.getAllCategory();
        List<Brand> listb = b.getAllBrands();
       // load tat ca product len

        if (page_raw == null) {
            page_raw = "1";

        }
         int id_page = Integer.parseInt(page_raw);
        int page = p.numberOfProduct();
         ArrayList<Product> list = p.getProductsPaging(id_page);
         request.setAttribute("list", list);
        int end_page = page / 6;
        if (page % 6 != 0) {
            end_page++;
        }
        
        
        request.setAttribute("listc", listc);
        request.setAttribute("listb", listb);
        request.setAttribute("end_page", end_page);
        request.getRequestDispatcher("crud_product.jsp").forward(request, response);
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
        String title = request.getParameter("title");
        String category_id_raw = request.getParameter("category_id");
        String price_raw = request.getParameter("price");
        String quantity_raw = request.getParameter("quantity");
        String discount_raw = request.getParameter("discount");
        String description = request.getParameter("description");
        int status = 1;
        String brand_raw = request.getParameter("brand_id");
        String image = request.getParameter("image");
        int category_id;
        double price;
        int quantity;
        int discount;
        int brand;
        ProductDAO pd = new ProductDAO();
        category_id = Integer.parseInt(category_id_raw);
        price = Double.parseDouble(price_raw);
        quantity = Integer.parseInt(quantity_raw);
        discount = Integer.parseInt(discount_raw);
        brand = Integer.parseInt(brand_raw);
        pd.insertProduct(category_id, title, price, quantity, discount, description, status, brand, image);
        response.sendRedirect("crud");

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
