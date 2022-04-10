/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.cov;

import br.com.kantar.angariamento.model.audiencia.AudienciaUtil;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardo
 */
public class TratamentoAudienciaCovUtil {

    private TratamentoAudienciaCovUtil() {
    }
    
    /**
     * Recebe o entrypoint e retorna um inteiro, com a modalidade: singular ou 
     * duplicado.
     * @param p_entrypoint
     * @return int
     */
      public static int retornaModalidade(String p_entrypoint) {

           
        Map var_controle_mapa_result = new AudienciaUtil().retornaAgrupamentoDaListaRecebida(p_entrypoint);

        for (Object l_result : var_controle_mapa_result.keySet()) {

            if (Integer.parseInt(var_controle_mapa_result.get(l_result).toString()) > 1) {

               return 2;

            }

        }

        return 1;

    }

    public static Multimap converteMapaDeAudienciaCruaEmConcreta(Multimap AudienciaCruaMapeada, Object Audiencia) {


        Multimap AudienciaConcretaMapeada = ArrayListMultimap.create();

        String AudienciaTratamento = AudienciaCruaMapeada.get(Audiencia).toString().replaceAll("\\[|\\]", "").trim().replaceAll("\\s", "");

        String AudienciasEmTratamento[] = AudienciaTratamento.split(",");

        for (String TratamentoAudiencia : AudienciasEmTratamento) {

            if (TratamentoAudiencia.contains("X")) {
                AudienciaConcretaMapeada.put(TratamentoAudiencia, new AudienciaUtil().transformaLinhaEmAudiencia(TratamentoAudiencia));
            }

        }
        return AudienciaConcretaMapeada;

    }
    
    /**
     * 
     * Metodo recebe uma raw audience e retorna em forma de lista de min 0 - 1440
     * 
     * recebe :
     * 01000000006
       {01000000006=[01000000006XA792B1A48B19A2B13A565F]
       * 
     * Retorna:
     * {01000000006XA792B1A48B19A2B13A565F=[[0, 0, 0, 0, 0, 0, 0, 0,
     
     * @param AudienciasConcretasMapeadas
     * @return List
     */
    public static List audienciaParaListaIndividual(Multimap AudienciasConcretasMapeadas) {
        
        List Audiencias = new ArrayList();

        int ContadorLoop = 1;

        for (Object AudienciaConcreta : AudienciasConcretasMapeadas.values()) {

            if (ContadorLoop == 1) {

                List AudienciasIsoladas = (List) AudienciaConcreta;

                for (int i = 0; i < AudienciasIsoladas.size(); i++) {

                    Audiencias.add(AudienciasIsoladas.get(i));

                }

            } else {

                List AudienciasIsoladas = (List) AudienciaConcreta;

                for (int i = 0; i < AudienciasIsoladas.size(); i++) {

                    if ((AudienciasIsoladas.get(i).toString().contains("1"))) {

                        if (Audiencias.get(i).toString().equals("1")) {

                        } else {

                            Audiencias.set(i, AudienciasIsoladas.get(i));
                        }

                    }

                }

            }

            ContadorLoop++;
        }
        
        return Audiencias;
    }


}
