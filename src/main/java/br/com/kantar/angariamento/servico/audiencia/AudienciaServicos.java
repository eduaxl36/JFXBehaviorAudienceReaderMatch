/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.servico.audiencia;

import br.com.kantar.angariamento.model.afericao.Afericao;
import br.com.kantar.angariamento.model.audiencia.Audiencia;
import br.com.kantar.angariamento.model.target.Individuo;
import br.com.kantar.angariamento.repository.audiencia.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eduardo
 */
public class AudienciaServicos {

    public List<Individuo> obterAudienciaIndividual(String AudienciaCrua, int[] Canais) {

        return new AudienciaRepository().obterAudienciaIndividual(AudienciaCrua, Canais);

    }

    public List<Afericao> obterAudienciaDomiciliar(String AudienciaCrua, int[] Canais) {

        return new AudienciaRepository().obterAudienciaDomiciliar(AudienciaCrua, Canais);

    }

    public List<Audiencia> fornecerListaAudiencia(Map<LocalDate, File> MapContent, int[] Canais) throws FileNotFoundException, IOException {

        return new AudienciaRepository().fornecerListaAudiencia(MapContent, Canais);

    }

}
