package br.edu.ifsp.lp2a2.comparex.comum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;


@Controller
public class HomeController {
    
private ProdutosRespository repository;
	
    public HomeController(ProdutosRespository repository){
        this.repository = repository;
    }
   
    @GetMapping("/")
	public String index() {
		return "comum/index";
	}

   @GetMapping(value = "/search", params = {"pesquisar"})
   public ModelAndView resultado(String pesquisar) {
	   ModelAndView mv = new ModelAndView("comum/resultado");
	   mv.addObject("produtos", repository.findByNomeContaining(pesquisar)); 
	   return mv;
	}
}