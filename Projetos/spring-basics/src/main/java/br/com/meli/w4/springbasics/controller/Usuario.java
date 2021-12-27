package br.com.meli.w4.springbasics.controller;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {
    
    private String nome;
    private LocalDate dataNascimento;
    private char sexo;
}
