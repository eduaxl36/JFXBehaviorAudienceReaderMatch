/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.cov;

import static br.com.kantar.angariamento.cov.TratamentoAudienciaCovUtil.retornaModalidade;
import br.com.kantar.angariamento.model.audiencia.AudienciaUtil;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author eduax
 */
public class TratativaAudienciaDuplicada {
    
         public Map mapeiaRepeticoesDuplicadas(String EntradaAudienciaCrua) {

        Map Audiencias = new HashMap<>();

        Map AudienciasDTO = new AudienciaUtil().retornaAgrupamentoDaListaRecebida(EntradaAudienciaCrua);

        for (Object Audiencia : AudienciasDTO.keySet()) {

            if (retornaModalidade(EntradaAudienciaCrua) == 1) {

                Audiencias.put(Audiencia, Integer.parseInt(AudienciasDTO.get(Audiencia).toString()));

            }

        }

        return Audiencias;

    }
    
    
}
