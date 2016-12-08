package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            //Conectando
            Connection conn = new ConnectionFactory().getConnection();

            try {
                //cria a query
                //cria um preparedStatement
                PreparedStatement sql = conn.prepareStatement("SELECT * FROM usuarios WHERE email=? AND senha=?");

                //requisição dos campos
                String email = request.getParameter("email");
                sql.setString(1, email);
                String senha = request.getParameter("senha");
                sql.setString(2, senha);

                String flagLogin = "true";
                //executa a query e pegar os resultados e poe em rs
                ResultSet rs = sql.executeQuery();
                HttpSession session = request.getSession();
                //System.out.println(nome);
                //Mostra na tela o resultado do que foi digita, caso contrario retorna null
                if (rs.next()) {

                    String nome = rs.getString("nome");

                    //Cria a sessão e seta o atributo email da variavel sessio
                    String str = request.getParameter("email");
                    
                    session.setAttribute("email", str);
                    session.setAttribute("nome", nome); //setAttribute to get a name of the current user and show in a homepage;

                    //Redireciona para pagina home
                    request.getRequestDispatcher("home.jsp").forward(request, response);

                } else {
                    flagLogin = "false";
                    session.setAttribute("flagLogin", flagLogin);
                    request.getRequestDispatcher("signin.jsp").forward(request, response);
                }
                //fecha conexao
                sql.close();
                conn.close();
            } catch (SQLException e) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

}
