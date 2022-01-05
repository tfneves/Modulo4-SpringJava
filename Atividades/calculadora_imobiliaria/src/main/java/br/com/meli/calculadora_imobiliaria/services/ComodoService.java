package br.com.meli.calculadora_imobiliaria.services;

import br.com.meli.calculadora_imobiliaria.dto.ComodoDTO;
import br.com.meli.calculadora_imobiliaria.model.Casa;
import br.com.meli.calculadora_imobiliaria.model.Comodo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ComodoService {


    /**
     * Calcula a area de todos os comodos da casa e os retorna
     * @param casa
     * @return ResponseEntity
     */
    public ResponseEntity<List<ComodoDTO>> calculaAreaComodos(Casa casa) {
        List<ComodoDTO> comodos = ComodoDTO.parseToDTO(casa.getComodos());
        for(ComodoDTO c : comodos){
            c.setAreaTotal(c.getComprimento() * c.getLargura());
        }
        return ResponseEntity.ok().body(comodos);
    }


    /**
     * Acha maior comodo da casa
     * @param casa
     * @return ResponseEntity
     */
    public ResponseEntity<Comodo> findMaiorComodo(Casa casa) {
        Comodo tmpComodo = Comodo.builder().comprimento(0.0).largura(0.0).build();

        for(Comodo c : casa.getComodos()){
            double areaTmpComodo = tmpComodo.getComprimento() * tmpComodo.getLargura();
            double areaCurrentComodo = c.getComprimento() * c.getLargura();

            if(areaCurrentComodo >= areaTmpComodo)
                tmpComodo = c;
        }
        return ResponseEntity.ok().body(tmpComodo);
    }
}
