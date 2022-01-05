package br.com.meli.calculadora_imobiliaria.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comodo {
    private String nome;
    private Double largura;
    private Double comprimento;
}
