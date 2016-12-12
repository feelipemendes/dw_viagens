package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DataUtil;
import model.entidades.Passagem;
import model.DAO.PassagemDAO;




/**
 *
 * @author Bernardo
 */
 @WebServlet("/Passagem")
public class PassagemServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            
            passagem.setDataIda(DataUtil.converteParaSQLDate(dataIdaStr));
            passagem.setDataVolta(DataUtil.converteParaSQLDate(dataVoltaStr));
            
                            
            PassagemDAO dao = new PassagemDAO();
            List<Passagem> passagens = dao.getTodasPassagens();
            
            request.setAttribute("passagens", passagens);
            
            RequestDispatcher rd = request.getRequestDispatcher("/tabelas.jsp");
            rd.forward(request, response);
            
           
        }   
 }

