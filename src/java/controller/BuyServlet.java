/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import dal.ShoppingCardDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Cart;
import model.Item;
import model.Product;
import model.ShoppingCard;
import model.User;

/**
 *
 * @author manh3
 */
@WebServlet(name = "BuyServlet", urlPatterns = {"/buy"})
public class BuyServlet extends HttpServlet {

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
            out.println("<title>Servlet BuyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuyServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        User u =(User)session.getAttribute("user");
        String check = request.getParameter("check");
        ShoppingCardDAO sc = new ShoppingCardDAO();
        
        if (check.equals("2")) {
            int cid = Integer.parseInt(request.getParameter("cid"));
            int id = Integer.parseInt(request.getParameter("id"));
            Object o = session.getAttribute("cart");
            int num = 1;
            ProductDAO pd = new ProductDAO();
            Cart cart = null;
            if (o != null) {
                cart = (Cart) o;
            } else {
                cart = new Cart();
            }
            double price = 0;

            Product p = pd.getProductById(id);
            if (p.getDiscount() != 0) {
                price = p.getPrice() - (p.getPrice() * p.getDiscount() / 100);
            } else {
                price = p.getPrice();
            }
            Item s = new Item(p, num, price);
            cart.addItem(s);
            sc.addToCart(u,s);
            session.setAttribute("cart", cart);
            response.sendRedirect("store?id=" + cid);

        } else if (check.equals("3")){
            int id = Integer.parseInt(request.getParameter("id"));
           
            Object o = session.getAttribute("cart");
            int num = 1;
            ProductDAO pd = new ProductDAO();
            Cart cart = null;
            if (o != null) {
                cart = (Cart) o;
            } else {
                cart = new Cart();
            }
            double price = 0;

            Product p = pd.getProductById(id);
            if (p.getDiscount() != 0) {
                price = p.getPrice() - (p.getPrice() * p.getDiscount() / 100);
            } else {
                price = p.getPrice();
            }
            Item s = new Item(p, num, price);
            cart.addItem(s);
            sc.addToCart(u,s);
            session.setAttribute("cart", cart);
            response.sendRedirect("product?pid="+id);

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
        HttpSession session = request.getSession();
        User u =(User)session.getAttribute("user");
        String check = request.getParameter("check");
        ShoppingCardDAO sc = new ShoppingCardDAO();
        if (check.equals("1")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Object o = session.getAttribute("cart");
            int num = 1;
            ProductDAO pd = new ProductDAO();
            Cart cart = null;
            if (o != null) {
                cart = (Cart) o;
            } else {
                cart = new Cart();
            }
            double price = 0;

            Product p = pd.getProductById(id);
            if (p.getDiscount() != 0) {
                price = p.getPrice() - (p.getPrice() * p.getDiscount() / 100);
            } else {
                price = p.getPrice();
            }
            Item s = new Item(p, num, price);
            cart.addItem(s);
            sc.addToCart(u,s);
            session.setAttribute("cart", cart);

            response.sendRedirect("home");

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
