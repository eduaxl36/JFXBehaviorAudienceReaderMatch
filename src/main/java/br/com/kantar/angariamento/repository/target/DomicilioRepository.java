/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.repository.target;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author eduardo
 */
public class DomicilioRepository {

    public final String EXP_COLETA_ID_INDIVIDUO="I\\d{1,}";
    
    public String obterDomicilioId(String AundienciaCrua) {

        Matcher ColetorDomiciliar = Pattern.compile(EXP_COLETA_ID_INDIVIDUO).matcher(AundienciaCrua);

        return ColetorDomiciliar.find() ? ColetorDomiciliar.group().substring(1, 9) : "-";

    }

}
