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
import model.Product;

/**
 *
 * @author manh3
 */
@WebServlet(name = "StoreProductServlet", urlPatterns = {"/store1"})
public class StoreProductServlet extends HttpServlet {

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
            out.println("<title>Servlet StoreProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StoreProductServlet at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");
        String bid_raw = request.getParameter("bid");//brand id de search
        String key = request.getParameter("search");// content to search
        String[] price = request.getParameterValues("price");
        String sort = request.getParameter("sort");
       // String[] brand_raw = request.getParameterValues("brand");
        ProductDAO pd = new ProductDAO();
        BrandDAO bd = new BrandDAO();
        List<Brand> list_b = bd.getAllBrands();
        List<Product> list_ps = pd.getAllProducts();
        List<Product> list_p3 = pd.getTop3SaleProducts();
        List<Product> products = new ArrayList<>();
        String[] pp = {"500 - 1000", "1000 - 1500", "1500 - 2000", "2000 - 2500", "Up to 3000"};
        boolean[] pb = new boolean[pp.length + 1];
        pb[0] = true;
        boolean[] brands = new boolean[list_b.size() + 1];
        brands[0] = true;
        int[] brand = {0};
        if (key != null) {
            int id = Integer.parseInt(bid_raw);
            ArrayList<Product> list_pSearch = pd.searchProduct(id, key);
            request.setAttribute("list_p", list_pSearch);
        }
        if (id_raw != null) {
            int id = Integer.parseInt(id_raw);
            List<Product> list_p = pd.getAllProductsByCId(id);//hien thi san pham theo category
            request.setAttribute("list_p", list_p);
            if(id==6){
               request.setAttribute("list_p", list_ps);
            }
        }
        if(sort!=null){
           if(sort.equals("1")){
               list_ps = pd.sortProductByPrice();
               
           }else{
                list_ps = pd.sortProductByDiscount();
           }
           request.setAttribute("list_p", products);
        }
        if (price != null) {
            for (int i = 0; i < price.length; i++) {
                List<Product> temp = new ArrayList<>();
                if (price[i].equals("0")) {
                    temp = pd.getAllProducts();
                    products.addAll(temp);
                    pb[0] = true;
                    request.setAttribute("list_p", products);
                    break;
                }
                if (price[i].equals("1")) {
                    temp = pd.getProductByPrice(500, 1000);
                    products.addAll(temp);
                    pb[1] = true;
                    request.setAttribute("list_p", products);
                }
                if (price[i].equals("2")) {

                    temp = pd.getProductByPrice(1000, 1500);
                    products.addAll(temp);
                    pb[2] = true;
                    request.setAttribute("list_p", products);
                }
                if (price[i].equals("3")) {
                    temp = pd.getProductByPrice(1500, 2000);
                    products.addAll(temp);
                    pb[3] = true;
                    request.setAttribute("list_p", products);
                }
                if (price[i].equals("4")) {

                    temp = pd.getProductByPrice(2000, 2500);
                    products.addAll(temp);
                    pb[4] = true;
                    request.setAttribute("list_p", products);
                }
                if (price[i].equals("5")) {

                    temp = pd.getProductByPrice(3000, 10000);
                    products.addAll(temp);
                    pb[5] = true;
                      request.setAttribute("list_p", products);
                }
            }
        }
         if (price == null) {
            pb[0] = true;
        }
         
//           if (brand_raw != null) {
//            brand = new int[brand_raw.length];
//            for (int i = 0; i < brand.length; i++) {
//                brand[i] = Integer.parseInt(brand_raw[i]);
//            }
//            products = pd.getProductBybrandId(brand);
//        }

       

        list_p3 = pd.getTop3SaleProducts();//hien thi top 3 sale
        request.setAttribute("list_p3", list_p3);
        request.setAttribute("pp", pp);
        request.setAttribute("pb", pb);
        request.setAttribute("brands", brands);
        request.setAttribute("list_b", list_b);
        request.getRequestDispatcher("store.jsp").forward(request, response);
    }

    private boolean ischeck(int d, int[] id) {
        if (id == null) {
            return false;
        } else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == d) {
                    return true;
                }
            }
            return false;
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
