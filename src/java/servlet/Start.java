/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GetMutterListLogicM;
import model.GetMutterListLogicW;
import model.MutterM;
import model.MutterW;
import model.PostMutterLogicM;
import model.PostMutterLogicW;
import model.User;

/**
 *
 * @author g16934os
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Start</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Start at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
        GetMutterListLogicM getMutterListLogicM = new GetMutterListLogicM();
        List<MutterM> mutterListM = getMutterListLogicM.execute();
        request.setAttribute("mutterListM", mutterListM);
        
        GetMutterListLogicW getMutterListLogicW = new GetMutterListLogicW();
        List<MutterW> mutterListW = getMutterListLogicW.execute();
        request.setAttribute("mutterListW", mutterListW);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher ("/start.jsp");
         dispatcher.forward(request, response); 
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
        //processRequest(request, response);
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String income = request.getParameter("income");
        String sex = request.getParameter("sex");
        //System.out.println(sex + "a");
        
        ServletContext application = this.getServletContext();
            List<MutterM>mutterListM = (List<MutterM>)application.getAttribute("mutterListM");
            List<MutterW>mutterListW = (List<MutterW>)application.getAttribute("mutterListW");
            
            //HttpSession session = request.getSession();
            //User loginUser = (User)session.getAttribute("loginUser");
        
        if(sex.equals("0")){
        MutterM mutterM = new MutterM(name,age,income);
        
        PostMutterLogicM postMutterLogicM = new PostMutterLogicM();
        //postMutterLogicM.execute(mutterM, mutterListM);
        postMutterLogicM.execute(mutterM);
        application.setAttribute("mutterListM", mutterListM);
        }else{
            MutterW mutterW = new MutterW(name,age,income);
        PostMutterLogicW postMutterLogicW = new PostMutterLogicW();
        //postMutterLogicM.execute(mutterM, mutterListM);
        postMutterLogicW.execute(mutterW);
        application.setAttribute("mutterListW", mutterListW);
        }
        
        GetMutterListLogicM getMutterListLogicM = new GetMutterListLogicM();
        mutterListM = getMutterListLogicM.execute();
        request.setAttribute("mutterListM", mutterListM);
        
        GetMutterListLogicW getMutterListLogicW = new GetMutterListLogicW();
        mutterListW = getMutterListLogicW.execute();
        request.setAttribute("mutterListW", mutterListW);
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher ("/start.jsp");
         dispatcher.forward(request, response); 
        
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
