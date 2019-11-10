package br.edu.ifsp.lp2a2.comparex.comum.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Produto;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;

@Controller
public class HomeController {
    @Autowired
    private ProdutosRespository repository;
    @GetMapping("/")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("comum/index");
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        repository.findAll().forEach(produtos::add);


        mv.addObject("produtos", produtos);
        return mv;
    }
   @GetMapping(value = "/search", params = {"pesquisar"})
   public String search(String pesquisar){

       return "comum/resultado_busca";
   }
   /**
    * @return the repository
    */
   public ProdutosRespository getRepository() {
       return repository;
   }
}