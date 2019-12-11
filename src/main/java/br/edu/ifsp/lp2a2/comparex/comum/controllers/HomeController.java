package br.edu.ifsp.lp2a2.comparex.comum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.LojasProdutosRepository;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.LojasRepository;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;


@Controller
public class HomeController {
    
	private ProdutosRespository produtosRepository;
	private LojasProdutosRepository lojasProdutosRepository;
	private LojasRepository lojasRepository;
	
    public HomeController(ProdutosRespository produtosRepository, LojasProdutosRepository lojasProdutosRepository, LojasRepository lojasRepository){
		this.produtosRepository = produtosRepository;
		this.lojasProdutosRepository = lojasProdutosRepository;
		this.lojasRepository = lojasRepository;
    }
   
    @GetMapping("/")
	public String index(Model model) {
		model.addAttribute("produtos", produtosRepository.findTop3ByOrderByNomeAsc());
		model.addAttribute("lojas", lojasRepository.findAll());
		return "comum/index";
	}

	@GetMapping(value = "/search", params = {"pesquisar"})
	public String resultado(Model model, String pesquisar) {
		 model.addAttribute("lojas", lojasRepository.findAll());
		 model.addAttribute("produtos", produtosRepository.findByNomeContaining(pesquisar));
		 model.addAttribute("precos", lojasProdutosRepository.menorPreco());
		 model.addAttribute("quantidades", lojasProdutosRepository.quantidadeLojas());
		 return "comum/resultado";
	 }

	@GetMapping("/verprecos/{id}")
	public String verprecos(@PathVariable int id, Model model) {
		model.addAttribute("lojas", lojasRepository.findAll());
		model.addAttribute("produtos", lojasProdutosRepository.listarPorProduto(id));
		return "comum/verprecos";
	}

	@GetMapping("/loja/{id}")
	public String lojas(@PathVariable int id, Model model) {
		model.addAttribute("lojas", lojasRepository.findAll());
		model.addAttribute("produtos", lojasProdutosRepository.listarPorLoja(id));
		return "comum/loja";
	}
}