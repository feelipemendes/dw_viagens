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
import model.entidade.Passagem;
import util.DataUtil;


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
        boolean idaVolta = false;
        boolean ida = false;
        boolean volta = false;
        
        String sql = "Select * from passagem "+ 
                "where AEROPORTO_IDA = ? OR AEROPORTO_VOLTA = ? OR ASSENTOS >= ?"; 
       
        if( (passagem.getDataIda() != null) && (passagem.getDataVolta() != null) ) {
             sql += " and DATA_IDA >= ?" + " and DATA_VOLTA <= ?";
             idaVolta = true;
        }else if(passagem.getDataIda() != null){
                sql += " and DATA_IDA >= ?"; 
                ida = true;
            }else if(passagem.getDataVolta() != null) {
                sql += " and DATA_VOLTA <= ?"; 
                volta = true;
            }
        
        try {     
            PreparedStatement stmt = connect.prepareStatement(sql);
            
            stmt.setString(1, passagem.getAeroportoIda());
            stmt.setString(2, passagem.getAeroportoVolta());  
            stmt.setString(3, passagem.getAssentos());
            
            if(idaVolta){
                stmt.setString(4, DataUtil.converteSqlDateToString(passagem.getDataIda()));
                stmt.setString(5, DataUtil.converteSqlDateToString(passagem.getDataVolta()));
            }else if(ida){
                stmt.setString(4, DataUtil.converteSqlDateToString(passagem.getDataIda()));
            }else if(volta){
                stmt.setString(4, DataUtil.converteSqlDateToString(passagem.getDataVolta()));
            }
            
            ResultSet rs = stmt.executeQuery();
                       
            while(rs.next()) {
          
                Passagem p = new Passagem();
                p.setId(rs.getInt("ID"));
                p.setAeroportoIda(rs.getString("AEROPORTO_IDA"));
                p.setAeroportoVolta(rs.getString("AEROPORTO_VOLTA"));
                p.setAssentos(rs.getString("ASSENTOS"));   
                passagens.add(p);
//               
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
                p.setId(rs.getInt("ID"));
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
    
    public List<Passagem> buscaPrecoPassagemPorId(Passagem p) {
          String sql = "Select * from precos_passagem WHERE passagem_id = ? ";
        ArrayList<Passagem> passagens = new ArrayList<>();
        
        try {     
            PreparedStatement stmt = connect.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
            
            }   
            
            return passagens;
     
        }  catch (SQLException ex) {
                System.out.println("Falha ao retornar lista com todas as passagens");
            throw new RuntimeException(ex);   
        }

    }
}