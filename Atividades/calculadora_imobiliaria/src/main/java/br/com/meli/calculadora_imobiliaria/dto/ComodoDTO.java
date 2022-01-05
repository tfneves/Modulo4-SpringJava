package br.com.meli.calculadora_imobiliaria.dto;

import br.com.meli.calculadora_imobiliaria.model.Comodo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComodoDTO {
    private String nome;
    private Double largura;
    private Double comprimento;
    private Double areaTotal;


    public static List<ComodoDTO> parseToDTO(List<Comodo> comodos){
        return comodos.stream().map(c -> ComodoDTO.builder()
                .nome(c.getNome())
                .largura(c.getLargura())
                .comprimento(c.getComprimento())
                .build()).collect(Collectors.toList());
    }
}
