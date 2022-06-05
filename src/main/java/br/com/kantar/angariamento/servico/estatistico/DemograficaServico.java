/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.servico.estatistico;

import br.com.kantar.angariamento.model.target.Domicilio;
import br.com.kantar.angariamento.model.estatistico.Demografica;
import br.com.kantar.angariamento.repository.estatistico.DemograficaRepository;
import java.util.Map;

/**
 *
 * @author eduardo
 */
public class DemograficaServico {
    
    
    public Domicilio obterDemograficaDomiciliar(String AudienciaCrua) {
    
        return  new DemograficaRepository().obterInstanciaDemograficaDomiciliar(AudienciaCrua);
    
    }
    
   
   public Map<String, Demografica> obterDemograficaIndividual(String AudienciaCrua) {
  
       return  new DemograficaRepository().ObterChaveamentoIndividuoDemografica(AudienciaCrua);
   
   }



}