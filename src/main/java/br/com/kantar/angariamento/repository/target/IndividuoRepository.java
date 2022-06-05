/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.repository.target;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author eduardo
 */
public class IndividuoRepository {

    public final String EXP_COLETOR_NUM_INDIVIDUO = "Z\\d{1,}";

    public Set ObterIdIndividuo(String AudienciaCrua) {

        Set ConjuntoIndividuos = new LinkedHashSet();

        Matcher ColetorIndividuos = Pattern.compile(EXP_COLETOR_NUM_INDIVIDUO)
                .matcher(AudienciaCrua);

        while (ColetorIndividuos.find()) {

            ConjuntoIndividuos.add(ColetorIndividuos.group().substring(ColetorIndividuos.group().length() - 3, ColetorIndividuos.group().length()));

        }

        return ConjuntoIndividuos;

    }

    public int obterQtdIndividuos(String AudienciaCrua) {

        return ObterIdIndividuo(AudienciaCrua).size();

    }

}
