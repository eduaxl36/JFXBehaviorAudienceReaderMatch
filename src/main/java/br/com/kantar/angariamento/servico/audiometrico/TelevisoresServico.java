/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.servico.audiometrico;

import br.com.kantar.angariamento.repository.audiometrico.TelevisoresRepository;
import java.util.Set;

/**
 *
 * @author eduardo
 */
public class TelevisoresServico {
    
    
     public Set obterTelevisores(String AudienciaCrua){
     
     return new TelevisoresRepository().obterTelevisores(AudienciaCrua);
     
     }
    
     public int obterQtdTelevisores(String AudienciaCrua) {
     
     return new TelevisoresRepository().obterQtdTelevisores(AudienciaCrua);
         
     }
     
    
}
