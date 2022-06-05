/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dot.repository.estatistico;

import br.com.analise.dot.met.DOTDomiciliar;
import br.com.analise.dot.met.DOTIndividual;
import br.com.kantar.angariamento.model.abstrato.DOTServico;
import br.com.kantar.angariamento.model.audiencia.Audiencia;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author eduardo
 */
public class DemograficaDotRepository {

    public int obterTamanhoDemograficaDomiciliarServicoDOT(List<Audiencia> Audiencias) {

        return Audiencias.get(0).getInfo_domiciliares().getDemografica().getListaDemograficas().size();

    }

    public int obterTamanhoDemograficaIndividualServicoDOT(List<Audiencia> Audiencias) {

        return Audiencias.get(0).getInfo_domiciliares().getDemografica().getListaDemograficas().size();

    }

    public List<Integer> obterDemograficasDomiciliarServicoDOT(long DemograficaId, List<? extends DOTServico> DOTAudiencias) {

        List<DOTDomiciliar> AudienciasDomiciliares = (List<DOTDomiciliar>) DOTAudiencias;

        Set ConjuntoDemograficas = AudienciasDomiciliares.
                stream()
                .filter(x -> x.getId_domicilio() == DemograficaId)
                .distinct()
                .map(x -> x.getDemografica())
                .collect(Collectors.toSet());

        return new ArrayList<>(ConjuntoDemograficas);

    }

    public List<Integer> obterDemograficasIndividualServicoDOT(long IndividuoId, List<? extends DOTServico> DOTAudiencias) {

        List<DOTIndividual> AudienciasIndividuais = (List<DOTIndividual>) DOTAudiencias;

        Set ConjuntoDemograficas = AudienciasIndividuais.
                stream()
                .filter(x -> x.getId_individuo() == IndividuoId)
                .distinct()
                .map(x -> x.getDemografica())
                .collect(Collectors.toSet());

        return new ArrayList<>(ConjuntoDemograficas);

    }

}
