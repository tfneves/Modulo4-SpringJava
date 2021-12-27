package br.com.meli.w4.springbasics.service;

import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Service;
import br.com.meli.w4.springbasics.entity.Usuario;

@Service
public class UsuarioService {
    
    public void salvar(Usuario usuario){
        if(maiorIdade(usuario)){
            System.out.println("Persistindo usuário");
        }else{
            throw new RuntimeException("Usuário deve ser maior de idade");
        }
    }

    private boolean maiorIdade(Usuario usuario){
        LocalDate dataAtual = LocalDate.now();
        int years = Period.between(usuario.getDataNascimento(), dataAtual).getYears();
        return years > 18;
    }
}
