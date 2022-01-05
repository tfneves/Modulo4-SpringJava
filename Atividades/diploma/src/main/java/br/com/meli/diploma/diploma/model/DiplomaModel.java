package br.com.meli.diploma.diploma.model;

import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class DiplomaModel {

    private String mensagem;
    private double media;
    private AlunoModel aluno;
}
