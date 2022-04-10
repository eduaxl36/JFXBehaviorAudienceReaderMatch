/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kantar.angariamento.model.audiencia;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author Eduardo.Fernando
 */
public class AudienciaUtil {
    
    
      public static boolean validaCanalEmArray(int[] p_array_canais, int p_canal) 
    {

        
        for (int l_canal : p_array_canais) {

            
            if (l_canal == p_canal) {

                return true;

            }

        }

        return false;

    }
    
    
        public  Set recuperaChavesSemDuplicacao(List p_lista){
    
         Set var_controle_set_retorno = (Set) p_lista.stream()
        .map(x->x.toString().substring(0,11))
        .distinct()
        .collect(Collectors.toSet());
                

//        for(Object l_dados:p_lista)
//        {
//        
//        var_controle_set_retorno.add(l_dados.toString().substring(0,11));
//        
//        
//        }
        
        
        return var_controle_set_retorno;
    }  
    
     
    public List insereLigados(String exp){
    
      List listaTemp = new ArrayList();

        try {
            
            int valorCorrespondenteAudiencia =  Integer.parseInt(exp.replaceAll("B",""));
            String[]arrayTemp = new String[valorCorrespondenteAudiencia];
            Arrays.fill(arrayTemp, 0,valorCorrespondenteAudiencia,"1");
            List t =  Arrays.asList(arrayTemp);

            listaTemp.addAll(t);
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    
        return listaTemp;
    
    }
    
    public List insereDesligados(String exp){
    
        List listaTemp = new ArrayList();

        try {
            
             int valorCorrespondenteAudiencia =  Integer.parseInt(exp.replaceAll("A",""));
            
        
           
            String[]arrayTemp = new String[valorCorrespondenteAudiencia];
            Arrays.fill(arrayTemp, 0,valorCorrespondenteAudiencia,"0");
            List t =  Arrays.asList(arrayTemp);

            listaTemp.addAll(t);
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    
        return listaTemp;
    
    }
    
    
    
     public  List transformaLinhaEmAudiencia(String linhaDeAudiencia)
    {
    
        
        List<Integer> listaTemp = new ArrayList<>();
        
        try {
            
            int indDivior =  linhaDeAudiencia.indexOf("X")+1;
            String linhaColetadaDaAudiencia = linhaDeAudiencia.substring(indDivior,linhaDeAudiencia.length());
           
            
            Matcher exp = Pattern.compile("\\w\\d{1,}").matcher(linhaColetadaDaAudiencia);
            
            while(exp.find()){


            if(exp.group().startsWith("A")){
            
                listaTemp.addAll(insereDesligados(exp.group()));
            
            }    
                
            if(exp.group().startsWith("B")){
            
                listaTemp.addAll(insereLigados(exp.group()));

            }     
            
            }     
          
       
            
        } catch (Exception e) {
        
        e.printStackTrace();
        
        }
    
    
    return listaTemp;
    }
    
    
     
 
      public final String ExpressaoCaptadoraCanalTv = ".*\\d{1,}.*";

    /**
     * Recebe a entrada inicial da audiencia e retorna uma mapa focado na chave,
     * contando as ocorrencias de canal e tv ex:
     *
     * Recebe isto:
     *
     * 01000000590XA107B3A1B1A8B2A1318F 01000000004XA29B67A1344F
     * 01000000007XA283B17A168B296A676F 01000000184XA96B11A93B74A1166F
     * 01000000100XA112B4A46B38A1240F 01000000358XA116B4A154B9A1157F
     * 01000000722XA123B4A1313F 01000000003XA127B35A1278F
     * 01000000006XA764B65A611F 01000000005XA829B21A590F
     *
     * Transforma nisto:
     *
     * {01000000184,01000000590,01000000005,01000000006}
     *
     * @param OcorrenciaInicial
     * @return lista
     */
    public List retornaChaveCanalTv(String OcorrenciaInicial) {

        String[] OcorrenciasInciais = OcorrenciaInicial.split("\n");

        List<String> Chaveamentos = new ArrayList();

        for (String Ocorrencia : OcorrenciasInciais) {

            if (Ocorrencia.matches(ExpressaoCaptadoraCanalTv)) {

                Chaveamentos.add(Ocorrencia.substring(0, 11));

            }

        }

        return Chaveamentos;

    }

    /**
     * Realiza um agrupamento das chaves, contando os valores
     *
     * recebe isto:
     *
     * 01000000590XA107B3A1B1A8B2A1318F 01000000004XA29B67A1344F
     * 01000000007XA283B17A168B296A676F 01000000184XA96B11A93B74A1166F
     * 01000000100XA112B4A46B38A1240F 01000000358XA116B4A154B9A1157F
     * 01000000722XA123B4A1313F 01000000003XA127B35A1278F
     * 01000000006XA764B65A611F 01000000005XA829B21A590F
     *
     * retorna isto
     *
     * {01000000184=1, 01000000590=1, 01000000005=1, 01000000006=1,
     * 01000000358=1, 01000000722=1, 01000000007=1, 01000000100=1,
     * 01000000003=1, 01000000004=1}
     *
     *
     *
     * @param EntradaAudiencia
     * @return
     */
    public Map retornaAgrupamentoDaListaRecebida(String EntradaAudiencia) {

        List<String> Chaveamentos = retornaChaveCanalTv(EntradaAudiencia);

        Map<String, Long> var_controle_mapa_retorno
                = Chaveamentos.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        return var_controle_mapa_retorno;

    }

    public Multimap converteMapaEmList(String Ocorrencia, Multimap ChaveamentosParam) {

        Multimap Chaveamentos = ArrayListMultimap.create();
        String Ocorrencias = ChaveamentosParam.get(Ocorrencia).toString().replaceAll("\\[|\\]", "").trim().replaceAll("\\s", "");

        String var_controle_array_st[] = Ocorrencias.split(",");

        for (String l_val : var_controle_array_st) {

            if (l_val.contains("X")) {

                Chaveamentos.put(Ocorrencia, new AudienciaUtil().transformaLinhaEmAudiencia(l_val));

            }

        }

        return Chaveamentos;
    }

    public Map geraMapaFinal(Multimap p_map_entrypoint, String p_entrada_st) {

        Map var_controle_mapa_retorno = new HashMap<>();

        List var_controle_lista = new ArrayList();

        int var_controle_voltas = 1;

        for (Object l_mapa : p_map_entrypoint.values()) {

            if (var_controle_voltas == 1) {

                List var_controle_lst_tp = (List) l_mapa;

                for (int i = 0; i < var_controle_lst_tp.size(); i++) {

                    var_controle_lista.add(var_controle_lst_tp.get(i));

                }

            } else {

                List var_controle_lst_tp = (List) l_mapa;

                for (int i = 0; i < var_controle_lst_tp.size(); i++) {

                    if ((var_controle_lst_tp.get(i).toString().contains("1"))) {

                        if (var_controle_lista.get(i).toString().equals("1")) {

                        } else {

                            var_controle_lista.set(i, var_controle_lst_tp.get(i));
                        }

                    }

                }

            }

            var_controle_voltas++;
        }

        var_controle_mapa_retorno.put(p_entrada_st, var_controle_lista);

        return var_controle_mapa_retorno;

    }
       
       
}
