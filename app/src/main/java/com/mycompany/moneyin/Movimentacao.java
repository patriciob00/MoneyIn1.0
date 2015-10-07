package com.mycompany.moneyin;

import java.util.Date;

/**
 * Created by home on 03/05/2015.
 */
public class Movimentacao {
    Double valor ;
    Date data ;
    String coment ;

    public Movimentacao(Double valor, Date data, String coment) {
        this.valor = valor;
        this.data = data;
        this.coment = coment;
    }

    public Double getValor() {
        return valor;
    }

    public String getComent() {
        return coment;
    }

    public Date getData() {
        return data;
    }
}
