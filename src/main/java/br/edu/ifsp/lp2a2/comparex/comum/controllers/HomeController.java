package br.edu.ifsp.lp2a2.comparex.comum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController{
   @GetMapping("/")
   public String index(Model model){
        return "comum/index";
   }
   @GetMapping(value = "/search", params = {"pesquisar"})
   public @ResponseBody String search(@RequestParam(value = "pesquisar") String pesquisar){

       return pesquisar;
   }
}