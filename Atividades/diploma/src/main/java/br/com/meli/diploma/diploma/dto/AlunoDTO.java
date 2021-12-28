package br.com.meli.diploma.diploma.dto;

import java.util.ArrayList;

import br.com.meli.diploma.diploma.model.AlunoModel;
import br.com.meli.diploma.diploma.model.DisciplinaModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AlunoDTO {
    
    private String nome;
    private ArrayList<DisciplinaModel> disciplinas;

    
    /* Converte DTO em model */
    public static AlunoModel converte(AlunoDTO dto){
        return AlunoModel.builder()
            .nome(dto.getNome())
            .disciplinas(dto.getDisciplinas())
            .build();
    }

    /* Converte Model em DTO - Cria DTO */
    public static AlunoDTO converte(AlunoModel aluno){
        return AlunoDTO.builder()
        .nome(aluno.getNome())
        .disciplinas(aluno.getDisciplinas())
        .build();
    }
}