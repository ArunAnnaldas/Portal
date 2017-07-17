package com.TIAA;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class authenticator extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("Inside Authenticator");
        HttpSession session = request.getSession(false);
        if (session == null) {
            request.getRequestDispatcher("/login").forward(request, response);
        } else {
            if (request.getAttribute("username") != null) {
                request.getRequestDispatcher("/welcome").forward(request, response);
            } else {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println("UserName : " + username);
                System.out.println("password : " + password);
                if (username != null && password != null
                        && username.equals("tom") && password.equals("cat")) {
                    session.setAttribute("username", username);
                    String redirect = (String) session.getAttribute("redirect");
                    if (redirect != null) {
                        session.removeAttribute("redirect");
                        request.getRequestDispatcher(redirect).
                                forward(request, response);
                    } else {
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("login").forward(request, response);
                }
            }
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