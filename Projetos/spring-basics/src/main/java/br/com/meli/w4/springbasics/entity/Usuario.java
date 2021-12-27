package br.com.meli.w4.springbasics.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Usuario {
    
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private char sexo;
    private String senha;
    private LocalDate dataCriacao;
}
