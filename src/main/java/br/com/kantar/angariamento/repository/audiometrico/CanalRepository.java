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
public class CanalRepository {

    public final String EXPRESSAO_DOMICILIAR = "\\d{11}X";

    public Set obterCanais(String AudienciaCrua) {

        Set Canais = new LinkedHashSet();

        Matcher var_controle_regex = Pattern.compile(EXPRESSAO_DOMICILIAR).matcher(AudienciaCrua);

        while (var_controle_regex.find()) {

            Canais.add(var_controle_regex.group().substring(var_controle_regex.group().length() - 5, var_controle_regex.group().length() - 1));

        }

        return Canais;

    }
}
