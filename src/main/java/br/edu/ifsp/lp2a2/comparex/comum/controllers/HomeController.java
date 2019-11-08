package br.edu.ifsp.lp2a2.comparex.comum.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;



@Controller
public class HomeController{
    @GetMapping("/")
    public String list(ProdutosRespository repository){
        return "comum/index";
    }
   @GetMapping(value = "/search", params = {"pesquisar"})
   public String search(String pesquisar){

       return "comum/resultado_busca";
   }
}