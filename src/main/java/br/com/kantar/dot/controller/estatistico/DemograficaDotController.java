/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dot.controller.estatistico;

import br.com.kantar.angariamento.model.abstrato.DOTServico;
import br.com.kantar.angariamento.model.audiencia.Audiencia;
import br.com.kantar.dot.servico.estatistico.DemograficaDotServico;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class DemograficaDotController {

    public int obterTamanhoDemograficaDomiciliarServicoDOT(List<Audiencia> Audiencias) {

        return new DemograficaDotServico().obterTamanhoDemograficaDomiciliarServicoDOT(Audiencias);

    }

    public int obterTamanhoDemograficaIndividualServicoDOT(List<Audiencia> Audiencias) {

        return new DemograficaDotServico().obterTamanhoDemograficaIndividualServicoDOT(Audiencias);

    }

    public List<Integer> obterDemograficaDomiciliarServicoDOT(long DomicilioId, List<? extends DOTServico> AudienciasGerais) {

        return new DemograficaDotServico().obterDemograficaDomiciliarServicoDOT(DomicilioId, AudienciasGerais);

    }

    public List<Integer> obterDemograficaIndividualServicoDOT(long IndividuoId, List<? extends DOTServico> AudienciasGerais) {

        return new DemograficaDotServico().obterDemograficaIndividualServicoDOT(IndividuoId, AudienciasGerais);

    }

}
