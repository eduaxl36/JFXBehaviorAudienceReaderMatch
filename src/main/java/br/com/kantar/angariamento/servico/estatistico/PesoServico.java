/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.servico.estatistico;

import br.com.kantar.angariamento.repository.estatistico.PesoRepository;
import java.util.Map;

/**
 *
 * @author eduardo
 */
public class PesoServico {
    
    
    
       public String obterPesoDomiciliar(String AudienciaCrua){
       
       return new PesoRepository().obterPesoDomiciliar(AudienciaCrua);
       
       }
    
    
        public  Map obterPesoIndividual(String AudienciaCrua){
        
        return new PesoRepository().obterPesoIndividual(AudienciaCrua);
        
        }
       
       
       
}
