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
@WebServlet(name = "StoreServlet", urlPatterns = {"/store"})
public class StoreServlet extends HttpServlet {

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
//        String id_raw = request.getParameter("id");
//        ProductDAO p = new ProductDAO();
//        ArrayList<Product> list_p = new ArrayList<>();
//        ArrayList<Product> list_ps;
//        ArrayList<Product> list_p3;
//        int id = Integer.parseInt(id_raw);
//        list_p = p.getAllProductsByCId(id);//hien thi san pham theo category
//       
//        list_ps = p.getAllProducts();//hienj thi all san pham
//        list_p3 = p.getTop3SaleProducts();//hien thi top 3 sale
//        request.setAttribute("list_p", list_p);
//        request.setAttribute("ids", id);
//        request.setAttribute("list_ps", list_ps);
//        request.setAttribute("list_p3", list_p3);
//        request.getRequestDispatcher("store.jsp").forward(request, response);
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
        ProductDAO pd = new ProductDAO();
        BrandDAO bd = new BrandDAO();
        List<Brand> list_b = bd.getAllBrands();
        List<Product> list_p3 = pd.getTop3SaleProducts();
        String[] pp = {"500 - 1000", "1000 - 1500", "1500 - 2000", "2000 - 2500", "Up to 3000"};
        boolean[] pb = new boolean[pp.length + 1];
        pb[0] = true;
        boolean[] brands = new boolean[list_b.size() + 1];
        brands[0] = true;
        if (page_raw == null) {
            page_raw = "1";

        }
        int id_page = Integer.parseInt(page_raw);
        ArrayList<Product> list_p = pd.getProductsPaging(id_page); //hienj thi all san pham theo paging
        request.setAttribute("list_p", list_p);
        int page = pd.numberOfProduct();
        int end_page = page / 6;
        if (page % 6 != 0) {
            end_page++;
        }
        request.setAttribute("list_p3", list_p3);
        request.setAttribute("end_page", end_page);
         request.setAttribute("list_b", list_b);
        request.setAttribute("pp", pp);
        request.setAttribute("pb", pb);
         request.setAttribute("brands", brands);
          request.setAttribute("cid", 0);
        request.getRequestDispatcher("store.jsp").forward(request, response);
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
        processRequest(request, response);
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
