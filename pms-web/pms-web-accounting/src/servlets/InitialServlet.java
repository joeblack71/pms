/*
 * InitialServlet.java
 *
 * Created on February 6, 2003, 7:01 PM
 */

package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;

import java.sql.*;

import dispatchers.ConnectionPool;
/*import dispatchers.DesUbigeo;
import lists.ListaDepartamentos;*/

public class InitialServlet extends HttpServlet {

    /** Initializes the servlet.
    */
    public void init() throws ServletException {
        try{
            ConnectionPool pool = new ConnectionPool();
            getServletContext().setAttribute("pool",pool);
            /*ListaDepartamentos departamentos = new ListaDepartamentos();
            DesUbigeo du = new DesUbigeo();
            Connection c = pool.getConnection();
            du.setConnection(c);
            du.cargarDepartamentos(departamentos);
            config.getServletContext().setAttribute("departamentos",departamentos);
            pool.free(c);*/
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /** Destroys the servlet.
    */
    public void destroy() {

    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, java.io.IOException {
        response.sendRedirect("access_control.html");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods">
    /** Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /** Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /** Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>

}
