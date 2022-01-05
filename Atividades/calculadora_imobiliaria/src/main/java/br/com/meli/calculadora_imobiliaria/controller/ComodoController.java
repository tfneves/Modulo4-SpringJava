package br.com.meli.calculadora_imobiliaria.controller;

import br.com.meli.calculadora_imobiliaria.dto.ComodoDTO;
import br.com.meli.calculadora_imobiliaria.model.Casa;
import br.com.meli.calculadora_imobiliaria.model.Comodo;
import br.com.meli.calculadora_imobiliaria.services.ComodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ComodoController {

    @Autowired
    ComodoService comodoService;

    /**
     * Retorna todos os comodos da casa e suas respectivas areas em metros
     * @param casa
     * @return ResponseEntity
     */
    @PostMapping("/areaComodos/nomeDaCasa")
    private ResponseEntity<List<ComodoDTO>> getAreaPorComodo(@RequestBody Casa casa){
        return comodoService.calculaAreaComodos(casa);
    }


    /**
     * Retorna o maior comodo da casa
     * @param casa
     * @return ResponseEntity
     */
    @PostMapping("/maiorComodo/nomeDaCasa")
    private ResponseEntity<Comodo> getMaiorComodo(@RequestBody Casa casa){
        return comodoService.findMaiorComodo(casa);
    }
}
