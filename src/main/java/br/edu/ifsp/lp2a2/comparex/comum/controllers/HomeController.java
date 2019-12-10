package br.edu.ifsp.lp2a2.comparex.comum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;
/*import br.edu.ifsp.lp2a2.comparex.comum.services.ComparadorProdutosService;*/

@Controller
public class HomeController {
    
private ProdutosRespository repository;
	
    public HomeController(ProdutosRespository repository){
        this.repository = repository;
    }
   
    @GetMapping("/")
	public String index(Model model) {
		/*model.addAttribute("produtos", repository.findAll()); */
		return "comum/index";
	}

   @GetMapping(value = "/search", params = {"pesquisar"})
   public String resultado(Model model, String pesquisar) {
	   model.addAttribute("produtos", repository.findByNomeContaining(pesquisar)); 
		return "comum/resultado";
	}
}