package br.com.meli.diploma.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.diploma.diploma.dto.AlunoDTO;
import br.com.meli.diploma.diploma.model.AlunoModel;
import br.com.meli.diploma.diploma.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;
    
    @PostMapping("/calculamedia")
    private ResponseEntity<String> calculaMedia(@RequestBody AlunoDTO aluno){
        AlunoModel a = AlunoDTO.converte(aluno);
        return alunoService.ehAprovado(a);
   }
}