package br.com.meli.diploma.diploma.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.meli.diploma.diploma.model.AlunoModel;
import br.com.meli.diploma.diploma.model.DiplomaModel;
import br.com.meli.diploma.diploma.model.DisciplinaModel;

@Service
public class AlunoService {

    @Autowired
    DiplomaModel diploma;

    public ResponseEntity<String> ehAprovado(AlunoModel aluno) {
        double media = 0;
        for (DisciplinaModel disciplina : aluno.getDisciplinas()) {
            media += disciplina.getNota();
        }

        if (media / aluno.getDisciplinas().size() > 9) {
            return ResponseEntity.ok(serializeToJson(diploma, aluno, "Parabéns", media));
        }
        return ResponseEntity.ok(serializeToJson(diploma, aluno, "Reprovado", media));
    }


    private String serializeToJson(DiplomaModel diploma, AlunoModel aluno, String msg, double media) {
        try {
            diploma.setAluno(aluno);
            diploma.setMensagem(msg);
            diploma.setMedia(media);
            return new ObjectMapper().writeValueAsString(diploma);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }
}
