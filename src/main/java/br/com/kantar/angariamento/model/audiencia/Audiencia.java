/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kantar.angariamento.model.audiencia;

import br.com.kantar.angariamento.model.arquivo.ArquivoMet;
import br.com.kantar.angariamento.model.target.Individuo;

import br.com.kantar.angariamento.model.target.Domicilio;
import br.com.kantar.angariamento.model.afericao.Afericao;
import java.util.List;




/**
 *
 * @author Eduardo.Fernando
 */
public class Audiencia {

    private ArquivoMet info_audiometrica;
    private Domicilio info_domiciliares;
    private int total_tv_dom;
    private int total_ind_dom;
    private List<Afericao> lista_afericao_domiciliar;
    private List<Individuo> lista_afericao_individuo;

    public Audiencia() {
    }

    public Audiencia(ArquivoMet p_info_audiometrica, Domicilio p_info_domiciliares, int p_total_tv_dom, int p_total_ind_dom, List<Afericao> p_lista_afericao_domiciliar, List<Individuo> p_lista_afericao_individuo) {
        this.info_audiometrica = p_info_audiometrica;
        this.info_domiciliares = p_info_domiciliares;
        this.total_tv_dom = p_total_tv_dom;
        this.total_ind_dom = p_total_ind_dom;
        this.lista_afericao_domiciliar = p_lista_afericao_domiciliar;
        this.lista_afericao_individuo = p_lista_afericao_individuo;
    }

    public ArquivoMet getInfo_audiometrica() {
        return info_audiometrica;
    }

    public Domicilio getInfo_domiciliares() {
        return info_domiciliares;
    }

    public int getTotal_tv_dom() {
        return total_tv_dom;
    }

    public int getTotal_ind_dom() {
        return total_ind_dom;
    }

    public List<Afericao> getLista_afericao_domiciliar() {
        return lista_afericao_domiciliar;
    }

    public List<Individuo> getLista_afericao_individuo() {
        return lista_afericao_individuo;
    }

}
