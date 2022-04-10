/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kantar.angariamento.model.afericao;


import br.com.kantar.angariamento.model.componente.audiometrico.Canal;
import br.com.kantar.angariamento.model.componente.audiometrico.Televisor;
import br.com.kantar.angariamento.kantar.model.audiometrico.Audiometria;


/**
 *
 * @author Eduardo.Fernando
 */
public class Afericao {

    private Televisor televisor;
    private Canal canal;
    private Audiometria sintonia;

    public Afericao(Televisor televisor, Canal canal, Audiometria sintonia) {
        this.televisor = televisor;
        this.canal = canal;
        this.sintonia = sintonia;
    }

    @Override
    public String toString() {
        return "Afericao{" + "televisor=" + televisor + ", canal=" + canal + ", sintonia=" + sintonia + '}';
    }

    public Televisor getTelevisor() {
        return televisor;
    }

    public Canal getCanal() {
        return canal;
    }

    public Audiometria getSintonia() {
        return sintonia;
    }

    

}
