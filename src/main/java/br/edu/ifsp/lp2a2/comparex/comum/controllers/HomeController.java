package br.edu.ifsp.lp2a2.comparex.comum.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;



@Controller
public class HomeController{
<<<<<<< HEAD
    @GetMapping("/")
    public String list(ProdutosRespository repository){
=======
   @GetMapping("/")
   public String index(Model model){
>>>>>>> cb3eda79c340ec1a9aa65ba8e411a0cf225af394
        return "comum/index";
    }
   @GetMapping(value = "/search", params = {"pesquisar"})
   public String search(String pesquisar){

       return "comum/resultado_busca";
   }
}