package br.edu.ifsp.lp2a2.comparex.comum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.LojasProdutosRepository;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.LojasRepository;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.AcabamentosRepository;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.CoresRepository;

@Controller
public class HomeController {

	private ProdutosRespository produtosRepository;
	private LojasProdutosRepository lojasProdutosRepository;
	private LojasRepository lojasRepository;
	private AcabamentosRepository acabamentosRepository;
	private CoresRepository coresRepository;

	public HomeController(ProdutosRespository produtosRepository, LojasProdutosRepository lojasProdutosRepository, LojasRepository lojasRepository, AcabamentosRepository acabamentosRepository, CoresRepository coresRepository) {
		this.produtosRepository = produtosRepository;
		this.lojasProdutosRepository = lojasProdutosRepository;
		this.lojasRepository = lojasRepository;
		this.acabamentosRepository = acabamentosRepository;
		this.coresRepository = coresRepository;
	}

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("comum/index");
		mv.addObject("produtos", produtosRepository.findTop3ByOrderByNomeAsc());
		mv.addObject("lojas", lojasRepository.findAll());
		return mv;
	}

	@GetMapping(value = "/search", params = {"pesquisar"})
	public ModelAndView resultado(String pesquisar) {
		ModelAndView mv = new ModelAndView("comum/resultado");
		mv.addObject("lojas", lojasRepository.findAll());
		mv.addObject("produtos", produtosRepository.findByNomeContaining(pesquisar));
		mv.addObject("precos", lojasProdutosRepository.menorPreco());
		mv.addObject("quantidades", lojasProdutosRepository.quantidadeLojas());
		return mv;
	}

	@GetMapping("/verprecos/{id}")
	public ModelAndView verprecos(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("comum/verprecos");
		mv.addObject("lojas", lojasRepository.findAll());
		mv.addObject("produtos", lojasProdutosRepository.listarPorProduto(id));
		return mv;
	}

	@GetMapping(value = "/verprecos/{id}", params = {"ordenacao"})
	public ModelAndView ordenarEmVerPrecos(@PathVariable int id, String ordenacao) {
		ModelAndView mv = new ModelAndView("comum/verprecos");
		mv.addObject("lojas", lojasRepository.findAll());
		if (ordenacao.equals("relevancia")) {
			mv.addObject("produtos", lojasProdutosRepository.listarPorProduto(id));
		} else if (ordenacao.equals("menorpreco")) {
			mv.addObject("produtos", lojasProdutosRepository.ordenarPorMenorPrecoEmVerPrecos(id));
		} else if (ordenacao.equals("maiorpreco")) {
			mv.addObject("produtos", lojasProdutosRepository.ordenarPorMaiorPrecoEmVerPrecos(id));
		} else if (ordenacao.equals("maiornomeloja")) {
			mv.addObject("produtos", lojasProdutosRepository.ordenarPorMaiorNomeLojaEmVerPrecos(id));
		} else if (ordenacao.equals("menornomeloja")) {
			mv.addObject("produtos", lojasProdutosRepository.ordenarPorMenorNomeLojaEmVerPrecos(id));
		}
		return mv;
	}

	@GetMapping("/loja/{id}")
	public ModelAndView lojas(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("comum/loja");
		mv.addObject("lojas", lojasRepository.findAll());
		mv.addObject("produtos", lojasProdutosRepository.listarPorLoja(id));
		mv.addObject("acabamentos", acabamentosRepository.findAll());
		mv.addObject("cores", coresRepository.findAll());
		return mv;
	}

	@GetMapping(value = "/loja/{id}", params = {"ordenacao"})
	public ModelAndView ordenarEmLojas(@PathVariable int id, String ordenacao) {
		ModelAndView mv = new ModelAndView("comum/loja");
		mv.addObject("lojas", lojasRepository.findAll());
		mv.addObject("cores", coresRepository.findAll());
		mv.addObject("acabamentos", acabamentosRepository.findAll());
		if (ordenacao.equals("relevancia")) {
			mv.addObject("produtos", lojasProdutosRepository.listarPorLoja(id));
		} else if (ordenacao.equals("menorpreco")) {
			mv.addObject("produtos", lojasProdutosRepository.ordenarPorMenorPrecoEmLoja(id));
		} else if (ordenacao.equals("maiorpreco")) {
			mv.addObject("produtos", lojasProdutosRepository.ordenarPorMaiorPrecoEmLoja(id));
		} else if (ordenacao.equals("maiornome")) {
			mv.addObject("produtos", lojasProdutosRepository.ordenarPorMaiorNomeEmLoja(id));
		} else if (ordenacao.equals("menornome")) {
			mv.addObject("produtos", lojasProdutosRepository.ordenarPorMenorNomeEmLoja(id));
		}
		return mv;
	}

	@GetMapping(value = "/loja/{id}", params = {"acabamento"})
	public ModelAndView filtrarPorAcabamento(@PathVariable int id, int acabamento) {
		ModelAndView mv = new ModelAndView("comum/loja");
		mv.addObject("lojas", lojasRepository.findAll());
		mv.addObject("cores", coresRepository.findAll());
		mv.addObject("acabamentos", acabamentosRepository.findAll());
		mv.addObject("produtos", acabamentosRepository.filtrarAcabamento(id, acabamento));
		return mv;
	}

	@GetMapping(value = "/loja/{id}", params = {"cor"})
	public ModelAndView filtrarPorCor(@PathVariable int id, int cor) {
		ModelAndView mv = new ModelAndView("comum/loja");
		mv.addObject("lojas", lojasRepository.findAll());
		mv.addObject("cores", coresRepository.findAll());
		mv.addObject("produtos", coresRepository.filtrarCor(id, cor));
		return mv;
	}
}