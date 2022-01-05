package br.com.meli.calculadora_imobiliaria.dto;

import br.com.meli.calculadora_imobiliaria.model.Casa;
import br.com.meli.calculadora_imobiliaria.model.Comodo;
import br.com.meli.calculadora_imobiliaria.model.Endereco;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CasaDTO {
    private String nome;
    private EnderecoDTO endereco;
    private List<ComodoDTO> comodos;
    private Double valorTotal;
    @Getter
    private static final BigDecimal valorMetroQuadrado = new BigDecimal(800.0);


    public static CasaDTO converte(Casa casa){
        return CasaDTO.builder()
                .nome(casa.getNome())
                .endereco(EnderecoDTO.parseToDTO(casa.getEndereco()))
                .comodos(ComodoDTO.parseToDTO(casa.getComodos()))
                .build();
    }
}
