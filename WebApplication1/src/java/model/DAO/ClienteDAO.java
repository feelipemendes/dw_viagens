/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.entidades.Cliente;

/**
 *
 * @author Bernardo
 */
public class ClienteDAO {
    
    private Connection connect;
    
    public ClienteDAO() {
        connect =  new ConnectionFactory().getConnection();
    }
 
    public void adiciona(Cliente cliente) {
       
        String sql = "INSERT INTO usuarios (nome,email,senha) VALUES(?,?,?)"; 
        
        try { 
            
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());  
            stmt.setString(3, cliente.getSenha());
            stmt.execute();           
            stmt.close(); 
            
        } catch (SQLException u) {
            System.out.println("Falha ao inserir usuário!");
            throw new RuntimeException(u);         
        }
    }
}
