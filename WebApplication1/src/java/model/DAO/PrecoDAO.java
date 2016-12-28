/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import model.entidade.Preco;
import controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import model.entidade.Passagem;


/**
 *
 * @author Bernardo
 */
public class PrecoDAO {
    
    private Connection connect;
    
    
    public PrecoDAO() {
        connect =  new ConnectionFactory().getConnection();
    }
   public List<Preco> getTodasPassagens() {
        
         ArrayList<Preco> precos = new ArrayList<>();
        
        String sql = "Select * from PRECOS_PASSAGEM ";
        
         try {     
            PreparedStatement stmt = connect.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
              
                Preco p = new Preco();
                p.setId(rs.getInt("ID"));
                p.setExecutiva(rs.getDouble("EXECUTIVA"));
                p.setPrimeiraClasse(rs.getDouble("PRIMEIRA_CLASSE"));
              
                precos.add(p);
            }
            
            return precos;
             
         }catch (SQLException u) {
            System.out.println("Falha ao retornar lista precos das passagens");
            throw new RuntimeException(u);   
         }
    }
}
