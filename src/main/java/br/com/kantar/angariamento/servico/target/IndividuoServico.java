/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.angariamento.servico.target;

import br.com.kantar.angariamento.repository.target.IndividuoRepository;
import java.util.Set;

/**
 *
 * @author eduardo
 */
public class IndividuoServico {

    public Set ObterIdIndividuo(String AudienciaCrua) {

        return new IndividuoRepository().ObterIdIndividuo(AudienciaCrua);

    }

    public int obterQtdIndividuos(String AudienciaCrua) {

        return new IndividuoRepository().obterQtdIndividuos(AudienciaCrua);

    }

}
