/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dot.repository.estatistico;

import br.com.analise.dot.met.DOTDomiciliar;
import br.com.analise.dot.met.DOTIndividual;
import br.com.kantar.angariamento.model.abstrato.DOTServico;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

/**
 *
 * @author eduardo
 */
public class PesoDotRepository {
    
    
   
     public OptionalDouble obterPesoDomiciliarServicoDot(long DomicilioId, List<DOTDomiciliar> AudienciasDomiciliares) {
   
         
            DoubleStream PesoDomiciliar;
 
                    PesoDomiciliar = AudienciasDomiciliares.
                    stream().filter(x -> x.getId_domicilio() == DomicilioId)
                    .mapToDouble(x -> x.getPeso());

            return PesoDomiciliar.min();

    } 
    
     
     
     
    public OptionalDouble obterPesoIndividualServicoDot(long IndividuoId, List<? extends DOTServico> AudienciasGenericas) {
        
            List<DOTIndividual> AudienciasIndividuais = (List<DOTIndividual>) AudienciasGenericas;
        
            DoubleStream PesoIndividual;

            PesoIndividual = AudienciasIndividuais.
                    stream()
                    .filter(x -> x.getId_individuo() == IndividuoId)
                    .mapToDouble(x -> x.getPeso());

            return PesoIndividual.min();


    }   
}
