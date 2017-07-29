package com.TIAA;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet {

    boolean userLoggedin=false;
    String userName;
    
    public boolean isUserLoggedIn()
    {
       return userLoggedin;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.setAttribute("index", 0);
        if (session.getAttribute("username") != null) {
            userLoggedin=true;
            userName = (String)session.getAttribute("username");
            request.getRequestDispatcher("welcome").forward(request, response);
        }

         String redirect = (String) request.getAttribute("redirect");
        if ( redirect != null ) session.setAttribute("redirect", redirect);
        
        
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>TIAA Login</h1>");
            out.println("<form action='/Portal/authenticator' method ='post'>"
                    + "  <div style='padding:30px'>"
                    + "  <label>Username</label>"
                    + "  <input type='text' size='30' name='username'/>"
                    + "  <br>"
                    + "  <br>"
                    + "  <label>Password</label>"
                    + "  <input type='password' size='30' name='password'/>"
                    + "  <br>"
                    + "  <br>"
                    + "  <input type='submit' value='Go'/>"
                    + "  </div>"
                    + "  </form>");
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
