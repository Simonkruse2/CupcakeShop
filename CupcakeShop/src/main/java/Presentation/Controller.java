/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.CakeBottom;
import Data.CakeToppings;
import Data.Customer;
import Data.User;
import Logic.DataAccessObject_Impl;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vince
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DataAccessObject_Impl d = new DataAccessObject_Impl();
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        ArrayList<CakeBottom> listBottom = d.getBottom();
        session.setAttribute("listBottom",listBottom );
        ArrayList<CakeToppings> listToppings = d.getToppings();
        session.setAttribute("listToppings", listToppings);
        response.setContentType("text/html;charset=UTF-8");
        

        String origin = request.getParameter("origin");
        switch (origin) {
            case "index":
                index(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "createCustomer":
                createCustomer(request, response);
                break;
            case "makeCustomer":
                makeCustomer(request, response);
                break;
            case "checkLogin":
                checkLogin(request, response);
                break;
            case "shop":
                shop(request, response);
                break;
            case "admin":
                admin(request, response);
                break;
            case "Invoice":
                Invoice(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
    }

    private void shop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        


        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    private void admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    private void Invoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Invoice.jsp").forward(request, response);
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = d.getUser(username);
        Customer customer = d.getCustomer(username);
        
        session.setAttribute("user", user);
        session.setAttribute("customer", customer);

        boolean valid = d.checkLogin(username, password);

        if (valid && username != null && password != null && !("".equals(username))
                && !("".equals(password))) {
            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void makeCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        d.createCustomer(email);
        d.createUser(username, password, email);

        request.getRequestDispatcher("index.jsp").forward(request, response);
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
        processRequest(request, response);
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
