package controller;


import model.DAO.PrecoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entidade.Preco;

@WebServlet("/Passagem")
public class PassagemServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        PrecoDAO dao = new PrecoDAO();
        List<Preco> precos = new ArrayList<Preco>();
        precos  = dao.getTodasPassagens();
                
        request.setAttribute("precos", precos);
        RequestDispatcher rd = request.getRequestDispatcher("/tabelaPrecos.jsp");
         rd.forward(request, response);
        }   
 }

