/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.servico.target;

import br.com.kantar.angariamento.repository.target.DomicilioRepository;

/**
 *
 * @author eduardo
 */
public class DomicilioServico {
    
    
    public String obterDomicilioId(String AudienciaCrua){
    
    return new DomicilioRepository().obterDomicilioId(AudienciaCrua);
    
    }
    
    
    
    
}
