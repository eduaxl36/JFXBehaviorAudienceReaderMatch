/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.servico.arquivo;

import br.com.kantar.angariamento.model.abstrato.ModeloArquivo;
import br.com.kantar.angariamento.repository.arquivo.ArquivoMetRepository;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author eduardo
 */
public class ArquivoMetServico {

    public LocalDate obterData(String AudienciaCrua) {

        return new ArquivoMetRepository().obterDataRepository(AudienciaCrua);

    }

    public LocalTime obterHora(String AudienciaCrua) {

        return new ArquivoMetRepository().obterHoraRepository(AudienciaCrua);

    }

    public ModeloArquivo retornarObjeto(String AudienciaCrua) {

        return new ArquivoMetRepository().retornarObjetoRepository(AudienciaCrua);

    }

}
