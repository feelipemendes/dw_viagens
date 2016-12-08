package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.PassagemDAO;
import model.Passagem;
import util.DateUtils;


/**
 *
 * @author Bernardo
 */
 @WebServlet("/CompraPassagem")
public class CompraPassagemServlet extends HttpServlet {

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
           
             // pegando os parâmetros do request
            String viagemDe = request.getParameter("viagemDe");
            String viagemPara = request.getParameter("viagemPara");
            String dataIdaStr = request.getParameter("dataIda");
            String dataVoltaStr = request.getParameter("dataVolta");
            String assentos = request.getParameter("assentos");
            
            // monta um objeto contato
            
            Passagem passagem = new Passagem();
            passagem.setAeroportoIda(viagemDe);
            passagem.setAeroportoVolta(viagemPara);
            passagem.setAssentos(assentos);
            
            passagem.setDataIda(DateUtils.toDateString(dataIdaStr));
            passagem.setDataVolta(DateUtils.toDateString(dataVoltaStr));
            
            
                    
            PassagemDAO dao = new PassagemDAO();
            List<Passagem> passagens = dao.buscaPassagem(passagem);

            out.println(passagens.get(1));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de passagens</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(Arrays.toString(passagens.toArray()) + " ");
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
