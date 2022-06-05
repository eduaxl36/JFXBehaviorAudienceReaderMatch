/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.repository.estatistico;

import br.com.kantar.angariamento.model.target.Domicilio;
import br.com.kantar.angariamento.controller.estatistico.PesoController;
import br.com.kantar.angariamento.controller.target.DomicilioController;
import br.com.kantar.angariamento.model.estatistico.Demografica;
import br.com.kantar.angariamento.model.estatistico.Peso;
import java.util.*;
import java.util.regex.*;


/**
 *
 * @author eduardo
 */
public class DemograficaRepository {

    public final String REGEX_OBTENCAO_AUDIENCIA_INDIVIDUAL = "Z\\d{1,}\n.*\n.*\n[\\d{11}X[A|B\\d{1,}]{1,}F\n]{1,}";
    public final String REGEX_OBTENCAO_ID_INDIVIDUAL = "Z\\d{1,}";
    public final String REGEX_OBTENCAO_DEMOGRAFICAS = "D.*";
    public final String REGEX_OBTENCAO_DOM_DEMOGRAFICA = "I\\d{1,}\nD.*";
    public final String REGEX_OBTENCAO_DEMOGRAFICA_DOMICILIAR = "D.*";

    /**
     * Recebe isto:
     *
     * I11010675202111280600202111290600 D,3,2,1,2,3,4,1,5,1,2 W5197.32
     * Z11010675001 D,3,2,1,2,3,4,1,5,1,2,2,6,1,2,2,82,2,6,1,7 W5652.32
     * 01000000590XA107B3A1B1A8B2A1318F 01000000004XA29B67A1344F
     * 01000000007XA283B17A168B296A676F 01000000184XA96B11A93B74A1166F
     * 01000000100XA112B4A46B38A1240F 01000000358XA116B4A154B9A1157F
     * 01000000722XA123B4A1313F 01000000003XA127B35A1278F
     * 01000000006XA764B65A611F 01000000005XA829B21A590F
     *
     * devolve isto:
     *
     * {Z11010675001=D,3,2,1,2,3,4,1,5,1,2,2,6,1,2,2,82,2,6,1,7 }
     *
     * @param AudienciaCrua
     * @return Map
     */
    public Map ObterChaveamentoIndividuoDemografica(String AudienciaCrua) {

        Map DemograficasIndividuais = new LinkedHashMap();

        String IndividuoId;

        Matcher ColetorAudienciaIndividual = Pattern.compile(REGEX_OBTENCAO_AUDIENCIA_INDIVIDUAL).matcher(AudienciaCrua);

        while (ColetorAudienciaIndividual.find()) {

            Matcher ColetorIndividual = Pattern.compile(REGEX_OBTENCAO_ID_INDIVIDUAL).matcher(ColetorAudienciaIndividual.group());

            IndividuoId = ColetorIndividual.find() ? ColetorIndividual.group() : null;

            Matcher ColetorDemograficas = Pattern.compile(REGEX_OBTENCAO_DEMOGRAFICAS).matcher(ColetorAudienciaIndividual.group());

            StringBuilder ConcatenadorAudiencia = new StringBuilder();

            while (ColetorDemograficas.find()) {

                ConcatenadorAudiencia.append(ColetorDemograficas.group()).append("\n");

            }

            DemograficasIndividuais.put(IndividuoId, ConcatenadorAudiencia.toString());

        }

        return DemograficasIndividuais;
    }

    public String ObterDemograficaDomiciliar(String AudienciaCrua) {

        String DemograficaDomiciliar = null;

        Matcher ColetorDomDemografica = Pattern.compile(REGEX_OBTENCAO_DOM_DEMOGRAFICA).matcher(AudienciaCrua);

        while (ColetorDomDemografica.find()) {

            Matcher ColetorDemograficadDomiciliar = Pattern.compile(REGEX_OBTENCAO_DEMOGRAFICA_DOMICILIAR).matcher(ColetorDomDemografica.group());

            while (ColetorDemograficadDomiciliar.find()) {

                DemograficaDomiciliar = ColetorDemograficadDomiciliar.group();

            }

        }

        return DemograficaDomiciliar;

    }

    public Domicilio obterInstanciaDemograficaDomiciliar(String AudienciaCrua) {

        Domicilio Domicilio = null;

        String[] Demograficas = ObterDemograficaDomiciliar(AudienciaCrua).split(",");
        List<Integer> var_controle_lista = new ArrayList<>();
        for (String Demografica : Demograficas) {

            if (!(Demografica.equals("D"))) {
                var_controle_lista.add(Integer.parseInt(Demografica));
            }

        }
        Domicilio = new Domicilio(Integer.parseInt(
                new DomicilioController().obterDomicilioId(AudienciaCrua)),
                new Demografica(var_controle_lista),
                new Peso(Double.parseDouble(new PesoController().obterPesoDomiciliar(AudienciaCrua).replaceAll("W", "").trim())));

        return Domicilio;

    }

    public Map<String, Demografica> obterInstanciaDemograficaIndividual(String AudienciaCrua) {

        Map<String, Demografica> MapeamentoDemograficasIndividuais = new LinkedHashMap();

        Map DemograficasIndividuais = ObterChaveamentoIndividuoDemografica(AudienciaCrua);

        for (Object DemograficaIndividual : DemograficasIndividuais.keySet()) {

            String[] DemograficaFatiada = DemograficasIndividuais.get(DemograficaIndividual).toString().split(",");

            List<Integer> var_controle_list = new ArrayList();

            for (String l_st : DemograficaFatiada) {

                if (l_st.equals("D")) {
                } else {

                    var_controle_list.add(Integer.parseInt(l_st.trim()));

                }

            }

            MapeamentoDemograficasIndividuais.put(DemograficaIndividual.toString(), new Demografica(var_controle_list));

        }

        return MapeamentoDemograficasIndividuais;

    }

}
