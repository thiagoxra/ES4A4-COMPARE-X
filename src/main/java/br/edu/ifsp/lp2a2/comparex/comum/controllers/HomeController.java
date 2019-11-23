package br.edu.ifsp.lp2a2.comparex.comum.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Produto;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;
import br.edu.ifsp.lp2a2.comparex.comum.services.ComparadorProdutosService;

@Controller
public class HomeController {
    
    public HomeController(ProdutosRespository repository){
        this.repository = repository;
    }



    private ProdutosRespository repository;
    @GetMapping("/")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("comum/index");
        ComparadorProdutosService comparador = new ComparadorProdutosService(repository);
        // Deve ser optimizado
        mv.addObject("produtos", comparador.comparadorPontuacao(5));
        return mv;
    }
   @GetMapping(value = "/search", params = {"pesquisar"})
   public String search(String pesquisar){

       return "comum/resultado";
   }
   /**
    * @return the repository
    */
   public ProdutosRespository getRepository() {
       return repository;
   }
}