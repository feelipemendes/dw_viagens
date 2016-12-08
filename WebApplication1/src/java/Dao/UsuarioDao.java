/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author vostro
 */
public class UsuarioDao {
    
    private Connection conn;
    //toda classe dao deve abrir conexao com o bd para poder usar o statement
    //contrutor que seta a conexao
    public UsuarioDao(){
        this.conn = new ConnectionFactory().getConnection();
    }
    //metodo de adcionar contatos
    public void adiciona(Usuario usuario) throws SQLException{
        String sql = "insert into Usuarios (email, senha) values (?,?)";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            //seta os valores 
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            
            stmt.execute();
            stmt.close();
            
            System.out.println("Inserido no bando! Conexão Fechada");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
}
