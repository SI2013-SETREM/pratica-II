/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import cfg.dao.RepositorioDAO;
import cfg.model.Repositorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dinei A. Rockenbach
 */
public class DirectServlet extends HttpServlet {

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet DirectServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet DirectServlet at " + request.getContextPath() + "</h1>");
//
//            out.println("<h2>Method: " + request.getParameter("method") + "</h2>");
//            out.println("<h2>Id: " + request.getParameter("id") + "</h2>");
//            
//            
////            Enumeration params = request.getParameterNames();
////            String paramName = null;
////            String[] paramValues = null;
////            while (params.hasMoreElements()) {
////                paramName = (String) params.nextElement();
////                paramValues = request.getParameterValues(paramName);
////                System.out.println("\nParameter name is " + paramName);
////                for (int i = 0; i < paramValues.length; i++) {
////                    System.out.println(", value " + i + " is "
////                            + paramValues[i].toString());
////                }
////            }
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

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
        switch (request.getParameter("method")) {
            case "image":
                RepositorioDAO dao = new RepositorioDAO();
                Repositorio r = dao.findById(Integer.parseInt(request.getParameter("id")));
                
                switch(r.getRep_extensao().toLowerCase()) {
                    case "jpg":
                    case "jpeg":
                    case "png":
                        response.setContentType("image/" + r.getRep_extensao().toLowerCase());
                        break;
                    case "zip":
                        response.setContentType("application/x-compressed");
                        break;
                    case "pdf":
                        response.setContentType("application/pdf");
                        break;
                    case "txt":
                        response.setContentType("text/plain");
                        break;
                    default:
                        response.setContentType("application/octet-stream");
                        break;
                }
                response.getOutputStream().write(r.getRep_arquivo());
                response.getOutputStream().flush();
                response.getOutputStream().close();
                break;
        }
    }

//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para conexões diretas";
    }

}
