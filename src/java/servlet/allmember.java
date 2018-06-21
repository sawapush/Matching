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
import model.Income;
import model.MutterM;
import model.MutterW;
import model.User;

/**
 *
 * @author g16934os
 */
@WebServlet("/allmember")
public class allmember extends HttpServlet {
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
            out.println("<title>Servlet allmember</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet allmember at " + request.getContextPath() + "</h1>");
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
        List<MutterM> mutterList = getMutterListLogicM.execute();
        request.setAttribute("mutterList", mutterList);
        
        GetMutterListLogicW getMutterListLogicW = new GetMutterListLogicW();
        List<MutterW> mutterListW = getMutterListLogicW.execute();
        request.setAttribute("mutterListW", mutterListW);
        
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        
        if (loginUser == null) {
            response.sendRedirect("/SoftM/");
        } else {
        RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/allmember.jsp");
            dispatcher.forward(request, response);
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
        //processRequest(request, response);
        
        request.setCharacterEncoding("UTF-8");
        String income = request.getParameter("income");//希望収入jspから参照
        
        Income hopeincome = new Income(income);//後で比較するためのもの
        
        if(income!=null && income.length()!=0){
            
            ServletContext application = this.getServletContext();
            List<MutterM>mutterList = (List<MutterM>)application.getAttribute("mutterList");
            List<MutterW>mutterListW = (List<MutterW>)application.getAttribute("mutterListW");
            HttpSession session = request.getSession();
            User loginUser = (User)session.getAttribute("loginUser");
            
            //MutterM mutterM = new MutterM(name,income);
           // PostMutterLogic postMutterLogic = new PostMutterLogic();
            //postMutterLogic.execute(mutter, mutterList);
            //postMutterLogic.execute(mutter);
            //application.setAttribute("mutterList", mutterList);*/
        }else{
            request.setAttribute("errorMsg", "希望収入が入力されていません");
        }
        RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/allmember.jsp");
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