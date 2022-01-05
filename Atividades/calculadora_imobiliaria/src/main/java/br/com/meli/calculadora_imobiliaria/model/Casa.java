package br.com.meli.calculadora_imobiliaria.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Casa {
    private String nome;
    private Endereco endereco;
    private List<Comodo> comodos;
}
