/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.DAO.UsuarioDao;
import java.sql.SQLException;
import model.entidades.Usuario;

public class TestaInsere {
    public static void main(String[] args) throws SQLException {
        Usuario usuario = new Usuario();
        //seta valores no hard
        usuario.setEmail("Ronaldo@111");
        usuario.setSenha("1111");
        
        usuario.toString();
        //cria o dao
        UsuarioDao dao = new UsuarioDao();
        //adiciona o novo contato no dao que vai inserir no banco
        dao.adiciona(usuario);
    }
}
