/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dot.controller.estatistico;

import br.com.analise.dot.met.DOTDomiciliar;
import br.com.kantar.angariamento.model.abstrato.DOTServico;
import br.com.kantar.dot.servico.estatistico.PesoDotServico;
import java.util.List;
import java.util.OptionalDouble;

/**
 *
 * @author eduardo
 */
public class PesoDotController {

    public OptionalDouble obterPesoDomiciliarServicoDot(long DomicilioId, List<DOTDomiciliar> AudienciasDomiciliares) {

        return new PesoDotServico().obterPesoDomiciliarServicoDot(DomicilioId, AudienciasDomiciliares);

    }

    public OptionalDouble obterPesoIndividualServicoDot(long IndividuoId, List<? extends DOTServico> AudienciasGerais) {
        return new PesoDotServico().obterPesoIndividualServicoDot(IndividuoId, AudienciasGerais);

    }

}
