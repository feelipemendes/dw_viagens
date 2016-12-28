/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.sql.Date;


/**
 *
 * @author Bernardo
 */
public class Passagem {
    private long id;
    private String assento;
    private Date dataIda;
    private Date dataVolta;
    private String aeroportoIda;
    private String aeroportoVolta;

    public String getAssentos() {
        return assento;
    }

    public void setAssentos(String Assento) {
        this.assento = Assento;
    }

    public String getAeroportoIda() {
        return aeroportoIda;
    }

    public void setAeroportoIda(String aeroportoIda) {
        this.aeroportoIda = aeroportoIda;
    }

    public String getAeroportoVolta() {
        return aeroportoVolta;
    }

    public void setAeroportoVolta(String aeroportoVolta) {
        this.aeroportoVolta = aeroportoVolta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataIda() {
        return dataIda;
    }

    public void setDataIda(Date data) {
        this.dataIda = data;
    }
    
    public Date getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(Date data) {
        this.dataVolta = data;
    }

       
    
}
