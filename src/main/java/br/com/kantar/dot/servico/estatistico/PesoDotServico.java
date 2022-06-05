/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dot.servico.estatistico;

import br.com.analise.dot.met.DOTDomiciliar;
import br.com.kantar.angariamento.model.abstrato.DOTServico;
import br.com.kantar.dot.repository.estatistico.PesoDotRepository;
import java.util.List;
import java.util.OptionalDouble;

/**
 *
 * @author eduardo
 */
public class PesoDotServico {

    public OptionalDouble obterPesoDomiciliarServicoDot(long DomicilioId, List<DOTDomiciliar> AudienciasDomiciliares) {

        return new PesoDotRepository().obterPesoDomiciliarServicoDot(DomicilioId, AudienciasDomiciliares);

    }

    public OptionalDouble obterPesoIndividualServicoDot(long IndividuoId, List<? extends DOTServico> AudienciasIndividuais) {

        return new PesoDotRepository().obterPesoIndividualServicoDot(IndividuoId, AudienciasIndividuais);

    }

}
