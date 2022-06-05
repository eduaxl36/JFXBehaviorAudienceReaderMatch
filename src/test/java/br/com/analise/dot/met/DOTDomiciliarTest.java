/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.analise.dot.met;

import br.com.kantar.angariamento.controller.audiencia.ControllerAudiencia;
import br.com.kantar.angariamento.model.audiencia.Audiencia;
import com.google.common.collect.Multimap;
import java.io.File;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author eduax
 */
public class DOTDomiciliarTest {
    
    @Test
    public void test1() throws Exception{
    
            
        File[] arquivos = new File[]{new File("sourcefiles/20211128.MET")};

        List<Audiencia> lstAud = new ControllerAudiencia().fornecerListaAudiencia(new DOTDomiciliar().geraCaminhosOrdenadosPorData(arquivos),new int[]{100});

        DOTDomiciliar dot = new DOTDomiciliar(new int[]{100}, 0, 1000, lstAud);


        Multimap mapa = dot.cronogramaDeImpressao();
//        
        for (Object x : mapa.keySet()) {

            System.out.println(x + ";" + mapa.get(x).toString().replaceAll("\\[|\\]", "").replaceAll(",", ";").replaceAll("\\s", ""));

        }
    
    }
    
}
