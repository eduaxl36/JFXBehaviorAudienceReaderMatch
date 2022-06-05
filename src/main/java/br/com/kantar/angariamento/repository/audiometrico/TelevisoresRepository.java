/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.repository.audiometrico;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author eduardo
 */
public class TelevisoresRepository {

    private final String EXPRESSAO_DOM = "\\d{11}X";

    public Set obterTelevisores(String AudienciaCrua) {

        Set Televisores = new LinkedHashSet();

        Matcher RegexDomicilio = Pattern.compile(EXPRESSAO_DOM).matcher(AudienciaCrua);

        while (RegexDomicilio.find()) {

            Televisores.add(RegexDomicilio.group().substring(0, 2));

        }

        return Televisores;

    }

    public int obterQtdTelevisores(String AudienciaCrua) {

        return obterTelevisores(AudienciaCrua).size();

    }

}
