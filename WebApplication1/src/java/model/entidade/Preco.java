/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

/**
 *
 * @author Bernardo
 */
public class Preco {
    private long id;
    private long id_passagem;
    private double executiva;
    private double primeiraClasse;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_passagem() {
        return id_passagem;
    }

    public void setId_passagem(long id_passagem) {
        this.id_passagem = id_passagem;
    }

    public double getExecutiva() {
        return executiva;
    }

    public void setExecutiva(double executiva) {
        this.executiva = executiva;
    }

    public double getPrimeiraClasse() {
        return primeiraClasse;
    }

    public void setPrimeiraClasse(double primeiraClasse) {
        this.primeiraClasse = primeiraClasse;
    }
   
}
