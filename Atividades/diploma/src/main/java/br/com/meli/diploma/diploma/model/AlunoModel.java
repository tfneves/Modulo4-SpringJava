package br.com.meli.diploma.diploma.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AlunoModel {
    
    private String nome;
    private ArrayList<DisciplinaModel> disciplinas;
}
