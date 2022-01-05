package br.com.meli.calculadora_imobiliaria.controller;

import br.com.meli.calculadora_imobiliaria.model.Casa;
import br.com.meli.calculadora_imobiliaria.services.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CasaController {

    @Autowired
    CasaService casaService;

    /**
     * Retorna area total da casa em metros
     * @param casa
     * @return ResponseEntity
     */
    @PostMapping("/area/nomeDaCasa")
    private ResponseEntity<Map<String, Double>> getAreaTotalCasa(@RequestBody Casa casa){
        return casaService.calculaAreaTotalCasa(casa);
    }


    /**
     * Retorna valor total da casa
     * @param casa
     * @return ResponseEntity
     */
    @PostMapping("/valor/nomeDaCasa")
    private ResponseEntity<Map<String, Double>> getValorTotalCasa(@RequestBody Casa casa){
        return casaService.calculaValorTotalCasa(casa);
    }
}
