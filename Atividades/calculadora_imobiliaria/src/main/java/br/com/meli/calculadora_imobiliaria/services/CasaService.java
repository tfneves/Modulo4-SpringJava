package br.com.meli.calculadora_imobiliaria.services;

import br.com.meli.calculadora_imobiliaria.dto.CasaDTO;
import br.com.meli.calculadora_imobiliaria.dto.ComodoDTO;
import br.com.meli.calculadora_imobiliaria.model.Casa;
import br.com.meli.calculadora_imobiliaria.model.Comodo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CasaService {

    /**
     * Retorna a área total da casa em metros
     * @param casa
     * @return ResponseEntity
     */
    public ResponseEntity<Map<String, Double>> calculaAreaTotalCasa(Casa casa) {
        Map<String, Double> response = new HashMap<String, Double>();
        response.put("areaTotal", calculaAreaTotal(casa));
        return ResponseEntity.ok().body(response);
    }


    /**
     * Calcula area total da casa
     * @param casa
     * @return areaTotal
     */
    private Double calculaAreaTotal(Casa casa){
        double areaTotal = 0;
        for(Comodo c : casa.getComodos()){
            areaTotal+=c.getComprimento()*c.getLargura();
        }
        return areaTotal;
    }


    /**
     * Calcula e retorna valor total da casa
     * @param casa
     * @return ResponseEntity
     */
    public ResponseEntity<Map<String, Double>> calculaValorTotalCasa(Casa casa) {
        Map<String, Double> response = new HashMap<String, Double>();
        double valorTotal = calculaAreaTotal(casa) * CasaDTO.getValorMetroQuadrado().doubleValue();
        response.put("valorTotal", valorTotal);
        return ResponseEntity.ok().body(response);
    }
}
