/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kantar.angariamento.cov;

import br.com.kantar.angariamento.model.audiencia.AudienciaUtil;
import static br.com.kantar.angariamento.cov.TratamentoAudienciaCovUtil.audienciaParaListaIndividual;
import static br.com.kantar.angariamento.cov.TratamentoAudienciaCovUtil.converteMapaDeAudienciaCruaEmConcreta;
import static br.com.kantar.angariamento.cov.TratamentoAudienciaCovUtil.retornaModalidade;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author eduardo
 */
public class TratamentoAudiencia {

    /**
     * Atraves da chave que contem a duplicação (MapaRepeticoes), o metodo le a
     * String (EntradaAudienciaCrua) e devolve uma lista com a audiencia
     * duplicada baseada na chave duplicada
     *
     * recebe -> {01000000100=3} ,
     *
     * 01000000100XA788B2A650F 01000000001XA790B2A68B2A578F
     * 01000000006XA792B1A48B19A2B13A565F 01000000100XA793B5A642F
     * 01000000100XA798B14A628F 01000000045XA812B28A600F
     * 01000000004XA840B1A34B266A299F
     *
     * devolve --> [01000000100XA788B2A650F, 01000000100XA793B5A642F,
     * 01000000100XA798B14A628F]
     *
     *
     * @param EntradaAudienciaCrua
     * @param MapaRepeticoes
     * @return List
     */
    public List insereAudienciaMapeadaEmLista(String EntradaAudienciaCrua, Map MapaRepeticoes) {

        List Audiencias = new ArrayList();

        String[] AudienciasFatiadas = EntradaAudienciaCrua.split("\n");

        for (Object AudienciaMapeada : MapaRepeticoes.keySet()) {

            for (String AudienciaFatiada : AudienciasFatiadas) {

                if (AudienciaFatiada.startsWith((AudienciaMapeada).toString())) {

                    Audiencias.add(AudienciaFatiada);

                }

            }

        }

        return Audiencias;
    }

    /**
     * Metodo desmembra em chave (canal+tv)e valor (audiencia crua e agrupada)
     *
     * @param Audiencias
     * 01000000184XA96B11A93B74A1166F,01000000184XA95B11A93B74A1166F
     * @return 01000000184 = [A96B11A93B74A1166F,01000000184XA95B11A93B74A1166F]
     */
    public Multimap agrupaAudienciaPorTvCanal(List Audiencias) {

        Multimap AudienciasMapeadas = ArrayListMultimap.create();

        if (!Audiencias.isEmpty()) {

            Set AudienciasNaoDuplicadas = new AudienciaUtil().recuperaChavesSemDuplicacao(Audiencias);

            for (Object AudienciaUnica : AudienciasNaoDuplicadas) {

                for (Object Audiencia : Audiencias) {

                    if (Audiencia.toString().startsWith(AudienciaUnica.toString())) {

                        AudienciasMapeadas.put(AudienciaUnica, Audiencia);
                    }

                }

            }

        }
        return AudienciasMapeadas;
    }

    /**
     * Metodo recebe valor --> 010000000109X [A200b400....] e converte para -->
     * 010000000109X [0,0,0,0,0,0,1,......]
     *
     * @param AudienciasAgrupadas
     * @return Map
     */
    public Map retornaAudienciasDesagrupadasParaValoresDoMapa(Multimap AudienciasAgrupadas) {

        Map AudienciasDesagrupadas = new HashMap<>();

        for (Object AudienciaAgrupada : AudienciasAgrupadas.keySet()) {

            Multimap ReceptorMapeadoAudiencias = converteMapaDeAudienciaCruaEmConcreta(AudienciasAgrupadas, AudienciaAgrupada);

            List audienciasIndexadas = audienciaParaListaIndividual(ReceptorMapeadoAudiencias);

            AudienciasDesagrupadas.put(AudienciaAgrupada, audienciasIndexadas);

        }

        return AudienciasDesagrupadas;
    }

    /**
     * Metodo responsavel por agrupar os resultados, e ficar pronto para ser invocado pelo repository audiencia 
     * @param AudienciaCrua
     * @return Map
     */
    public Map obterAudienciaTratada(String AudienciaCrua) {

        Map Duplicacoes;
        Map Singulares;

        Duplicacoes = new TratamentoAudiencia().retornaAudienciasDesagrupadasParaValoresDoMapa(new TratamentoAudiencia().agrupaAudienciaPorTvCanal(new TratamentoAudiencia().insereAudienciaMapeadaEmLista(
                AudienciaCrua, new TratativaAudienciaDuplicada().mapeiaRepeticoesDuplicadas(AudienciaCrua))));

        Singulares = new TratamentoAudiencia().retornaAudienciasDesagrupadasParaValoresDoMapa(new TratamentoAudiencia().agrupaAudienciaPorTvCanal(new TratamentoAudiencia().insereAudienciaMapeadaEmLista(
                AudienciaCrua, new TratativaAudienciaSingular().mapeiaRepeticoesSingulares(AudienciaCrua))));

        Duplicacoes.putAll(Singulares);

        return Duplicacoes;

    }

}
