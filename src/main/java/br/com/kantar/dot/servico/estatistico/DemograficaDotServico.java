/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dot.servico.estatistico;

import br.com.kantar.angariamento.model.abstrato.DOTServico;
import br.com.kantar.angariamento.model.audiencia.Audiencia;
import br.com.kantar.dot.repository.estatistico.DemograficaDotRepository;
import java.util.List;
import java.util.Set;

/**
 *
 * @author eduardo
 */
public class DemograficaDotServico {

    public int obterTamanhoDemograficaDomiciliarServicoDOT(List<Audiencia> Audiencias) {

        return new DemograficaDotRepository().obterTamanhoDemograficaDomiciliarServicoDOT(Audiencias);

    }

    public int obterTamanhoDemograficaIndividualServicoDOT(List<Audiencia> Audiencias) {

        return new DemograficaDotRepository().obterTamanhoDemograficaIndividualServicoDOT(Audiencias);

    }

    public List<Integer> obterDemograficaDomiciliarServicoDOT(long DomicilioId, List<? extends DOTServico> AudienciasDomiciliares) {

        return new DemograficaDotRepository().obterDemograficasDomiciliarServicoDOT(DomicilioId, AudienciasDomiciliares);

    }

    public List<Integer> obterDemograficaIndividualServicoDOT(long IndividuoId, List<? extends DOTServico> AudienciasIndividuais) {

        return new DemograficaDotRepository().obterDemograficasIndividualServicoDOT(IndividuoId, AudienciasIndividuais);

    }

}
