package br.edu.ifsp.lp2a2.comparex.unitarios.controller;

import br.edu.ifsp.lp2a2.comparex.comum.controllers.HomeController;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Produto;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;
import br.edu.ifsp.lp2a2.comparex.comum.services.ComparadorProdutosService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

public class HomeControllerTest {
    ProdutosRespository repository;
    public HomeControllerTest(){
        this.repository = Mockito.mock(ProdutosRespository.class);
    }
    @Test
    public void index_return_template() {
        // Configuracao
        HomeController controller = new HomeController(this.repository);
        String expected = "comum/index";
        // Execução
        String actual = controller.list().getViewName();
        //Comparacao
        assertEquals(expected, actual);
    }

    @Test
    public void index_return_model(){
        // Configuração
        HomeController controller = new HomeController(repository);
        ComparadorProdutosService comp = new ComparadorProdutosService(repository);
        Map<String, Object> expected = new HashMap();
        // Execução
        expected.put("produtos", comp.comparadorPontuacao(5));
        Map<String, Object> actual  = controller.list().getModel();
        // Comparação
        assertEquals(expected, actual);
    }

}