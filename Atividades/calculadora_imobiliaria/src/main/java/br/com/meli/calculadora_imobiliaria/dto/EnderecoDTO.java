package br.com.meli.calculadora_imobiliaria.dto;

import br.com.meli.calculadora_imobiliaria.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;


    public static EnderecoDTO parseToDTO(Endereco endereco){
        return EnderecoDTO.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .build();
    }
}
