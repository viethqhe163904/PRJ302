/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.FeedbackDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Feedback;
import model.Product;
import model.User;

/**
 *
 * @author manh3
 */
@WebServlet(name="ProductServlet", urlPatterns={"/product"})
public class ProductServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_raw = request.getParameter("pid");
        int id = Integer.parseInt(id_raw);
        ProductDAO p = new ProductDAO();
        FeedbackDAO fd = new FeedbackDAO();
        Product detail_product = p.getProductById(id);
         List<Feedback> listf = fd.getFeedbackById(id);
        List<Product> list_related =p.getRelatedByProductId(id);// theo brand
        request.setAttribute("list_related", list_related);
         request.setAttribute("listf", listf);
         request.setAttribute("total", listf.size());
        request.setAttribute("detail_product", detail_product);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    } 
   

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String review = request.getParameter("review");
        String rating_raw = request.getParameter("rating");
        String id_raw = request.getParameter("id");
        User account = (User) session.getAttribute("user");
        FeedbackDAO fd = new FeedbackDAO();
        int rating, id;
        if (session.getAttribute("user") != null) {
            try {
                rating = Integer.parseInt(rating_raw);
                id = Integer.parseInt(id_raw);
                fd.insertFeedback(account, review, rating, id);
            } catch (Exception e) {
                System.out.println(e);
            }
            response.sendRedirect("product?pid=" + id_raw);
        } else {
            response.sendRedirect("login");
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
