package com.meli.numeros_romanos.numeors_romanos.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumRomanosController {

    private HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    @GetMapping("/convert/{num}")
    private String decimalToRoman(@PathVariable Integer num){
        String response = "";
        populaMap();

        for(Map.Entry<String, Integer> m : map.entrySet()){
            int qtdRepeticao = num/m.getValue();
            response += m.getKey().repeat(qtdRepeticao);
            num = num%m.getValue();
        }
        return response;
    }

    private void populaMap(){
        this.map.put("M", 1000);
        this.map.put("M", 1000);
        this.map.put("CM", 900);
        this.map.put("D", 500);
        this.map.put("CD", 400);
        this.map.put("C", 100);
        this.map.put("XC", 90);
        this.map.put("L", 50);
        this.map.put("XL", 40);
        this.map.put("X", 10);
        this.map.put("IX", 9);
        this.map.put("V", 5);
        this.map.put("IV", 4);
        this.map.put("I", 1);
    }
}
