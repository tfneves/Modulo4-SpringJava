package br.com.meli.w4.springbasics.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import br.com.meli.w4.springbasics.entity.Usuario;

@Data
@Builder
@AllArgsConstructor
public class UsuarioDTO {

    private String nome;
    private LocalDate dataNascimento;
    private char sexo;
    @JsonProperty(access = Access.WRITE_ONLY)
    private String senha;
    private LocalDate dataCriacao;

    public static Usuario parseToUsuario(UsuarioDTO dto){
        Usuario usuario =  Usuario.builder()
            .nome(dto.getNome())
            .dataNascimento(dto.getDataNascimento())
            .sexo(dto.getSexo())
            .senha(dto.getSenha())
            .dataCriacao(LocalDate.now())
            .build();

        return usuario;
    }

    
    public static UsuarioDTO parseToDTO(Usuario u){
        return UsuarioDTO.builder()
            .nome(u.getNome())
            .dataNascimento(u.getDataNascimento())
            .sexo(u.getSexo())
            .senha(u.getSenha())
            .dataCriacao(u.getDataCriacao())
            .build();
    }
}
