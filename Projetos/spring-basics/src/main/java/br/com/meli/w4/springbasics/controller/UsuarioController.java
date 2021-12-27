package br.com.meli.w4.springbasics.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.w4.springbasics.dto.UsuarioDTO;
import br.com.meli.w4.springbasics.entity.Usuario;
import br.com.meli.w4.springbasics.service.UsuarioService;


@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    private static List<Usuario> usuarios = Arrays.asList(
        Usuario.builder().nome("Thomaz").dataNascimento(LocalDate.parse("1999-05-07")).sexo('M').build(),
        Usuario.builder().nome("Gulherme").dataNascimento(LocalDate.parse("1999-12-10")).sexo('M').build(),
        Usuario.builder().nome("Maria").dataNascimento(LocalDate.parse("1995-07-23")).sexo('F').build()
    );


    @GetMapping("/ping")
    @ResponseBody
    public String meuMetodo(){
        return "pong";
    }

    @GetMapping("/usuario/{p}")
    @ResponseBody
    public String teste(@PathVariable String p){
        return "O usuário é " + p;
    }


    @GetMapping("/usuario/{ano}/{s}")
    public Usuario getUsuario(@PathVariable Integer ano, @PathVariable(name = "s") char sexo){
        return filtra(ano, sexo);
    }

    @GetMapping("/usuario")
    public Usuario getUsuarioRequestParam(@RequestParam Integer ano, @RequestParam(name = "s") char sexo){
        return filtra(ano, sexo);
    }

    private Usuario filtra(Integer ano, char sexo){
        Optional<Usuario> op = usuarios.stream().filter(u -> u.getDataNascimento().getYear() == ano).filter(u -> u.getSexo() == sexo).findFirst();
        return op.orElse(null);
    }

    @GetMapping("/usuario/list/{ano}/{s}")
    private List<Usuario> busca(@PathVariable Integer ano, @PathVariable(name = "s") char sexo){
        List<Usuario> lista = usuarios.stream()
            .filter(u -> u.getDataNascimento().getYear() == ano)
            .filter(u -> u.getSexo() == sexo)
            .collect(Collectors.toList());
        return lista;
    }


    //REQUISIÇÃO POST
    @PostMapping("/usuario/cadastra")
    public ResponseEntity<UsuarioDTO> cadastra(@RequestBody UsuarioDTO dto){
        Usuario usuario = UsuarioDTO.parseToUsuario(dto);
        usuarioService.salvar(usuario);
        return ResponseEntity.ok(UsuarioDTO.parseToDTO(usuario));
    }
}
