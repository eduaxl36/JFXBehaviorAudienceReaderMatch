/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.repository.estatistico;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author eduardo
 */
public class PesoRepository {

    public final String EXP_COLETA_INT_ATE_PESO = "I\\d{1,}\n\\w{1,}.*\nW\\d{1,}\\.\\d{1,}";
    public final String EXP_COLETA_PESO = "W\\d{1,}\\.\\d{1,}";
    public final String EXP_COLETA_PESO_ATE_AUD = "Z\\d{1,}\n.*\n.*\n[\\d{11}X[A|B\\d{1,}]{1,}F\n]{1,}";
    public final String EXP_COLETA_ID_IND = "Z\\d{1,}";

    public String obterPesoDomiciliar(String AudienciaCrua) {

        String Peso = "";

        Matcher ColetaIndPeso
                = Pattern.compile(EXP_COLETA_INT_ATE_PESO).matcher(AudienciaCrua);

        while (ColetaIndPeso.find()) {

            Matcher ColetaPeso
                    = Pattern.compile(EXP_COLETA_PESO).matcher(ColetaIndPeso.group());

            if (ColetaPeso.find()) {

                Peso = ColetaPeso.group();

            }

        }

        return Peso;
    }

    public Map obterPesoIndividual(String AudienciaCrua) {

        Map Pesos = new LinkedHashMap();

        String IndividuoId = "";

        Matcher ColetaPesoAud = Pattern.compile(EXP_COLETA_PESO_ATE_AUD)
                .matcher(AudienciaCrua);

        while (ColetaPesoAud.find()) {

            Matcher var_controle_regex_dom = Pattern.compile(EXP_COLETA_ID_IND)
                    .matcher(ColetaPesoAud.group());

            IndividuoId = var_controle_regex_dom.find() ? var_controle_regex_dom.group() : "";

            Matcher ColetaPeso = Pattern.compile(EXP_COLETA_PESO).matcher(ColetaPesoAud.group());

            StringBuilder Peso = new StringBuilder();

            while (ColetaPeso.find()) {

                Peso.append(ColetaPeso.group()).append("\n");

            }

            Pesos.put(IndividuoId, Peso.toString());

        }

        return Pesos;
    }

}
