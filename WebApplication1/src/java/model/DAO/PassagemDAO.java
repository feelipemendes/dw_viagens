/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import controller.ConnectionFactory;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entidades.Passagem;
import model.entidades.Passagem;


/**
 *
 * @author Bernardo
 */
public class PassagemDAO {
    
    private Connection connect;
    
    
    public PassagemDAO() {
        connect =  new ConnectionFactory().getConnection();
    }
 
    public List<Passagem> buscaPassagem(Passagem passagem) {
        List<Passagem> passagens = new ArrayList<Passagem>();
       
        String sql = "Select * from passagem "+ 
                "where AEROPORTO_IDA = ? OR AEROPORTO_VOLTA = ? OR ASSENTOS >= ?"; 
       
        
        if(passagem.getDataIda() != null){
            sql += " and DATA_IDA >= ?"; 
            
        }
        if(passagem.getDataVolta() != null) {
            sql += " and DATA_VOLTA <= ?"; 
        }
        
        try {     
            PreparedStatement stmt = connect.prepareStatement(sql);
            
            stmt.setString(1, passagem.getAeroportoIda());
            stmt.setString(2, passagem.getAeroportoVolta());  
            stmt.setString(3, passagem.getAssentos());
            
            
//            String dataIda = DateUtils.toStringDate(passagem.getDataIda());
//            System.out.println(dataIda);
//
//            String dataVolta = DateUtils.toStringDate(passagem.getDataVolta());
//            System.out.println(dataVolta);
//            
//            stmt.setString(4, dataIda);
//            stmt.setString(5, dataVolta);
//            
            ResultSet rs = stmt.executeQuery();
                       
            while(rs.next()) {
          
                Passagem p = new Passagem();
                p.setAeroportoIda(rs.getString("AEROPORTO_IDA"));
                p.setAeroportoVolta(rs.getString("AEROPORTO_VOLTA"));
                p.setAssentos(rs.getString("ASSENTOS"));
              
                passagens.add(p);
//                java.sql.Date dataIdaRes = rs.getDate("DATA_IDA");
//                p.setDataIda(new Date(dataIdaRes.getTime()));  
            }
                       
            stmt.execute();           
            stmt.close(); 
             return passagens;
            
        } catch (SQLException u) {
            System.out.println("Falha ao retornar lista de passagens");
            throw new RuntimeException(u);         
        }
    }

    public List<Passagem> getTodasPassagens() {
        String sql = "Select * from passagem ";
        ArrayList<Passagem> passagens = new ArrayList<>();
        
         try {     
            PreparedStatement stmt = connect.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
              
                Passagem p = new Passagem();
                p.setAeroportoIda(rs.getString("AEROPORTO_IDA"));
                p.setAeroportoVolta(rs.getString("AEROPORTO_VOLTA"));
                p.setAssentos(rs.getString("ASSENTOS"));
              
                passagens.add(p);
            }
            
            return passagens;
             
         }catch (SQLException u) {
            System.out.println("Falha ao retornar lista com todas as passagens");
            throw new RuntimeException(u);   
         }
    }
}
