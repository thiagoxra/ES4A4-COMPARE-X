package br.edu.ifsp.lp2a2.comparex.unitarios.controller;

import br.edu.ifsp.lp2a2.comparex.comum.controllers.HomeController;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.LojasProdutosRepository;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.LojasRepository;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Produto;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest {
    ProdutosRespository pRepository;
    LojasRepository lRepository;
    LojasProdutosRepository lpRepository;
    HomeController homeController;
    List<Produto> list;
    public HomeControllerTest(){
        this.pRepository = Mockito.mock(ProdutosRespository.class);
        this.lRepository = Mockito.mock(LojasRepository.class);
        this.lpRepository = Mockito.mock(LojasProdutosRepository.class);
        this.homeController = new HomeController(pRepository, lpRepository, lRepository);
        this.list = new ArrayList<>();
    }
    @Test
    public void resultado_right_address_resultTest(){
        ModelAndView actualmv = homeController.resultado("massa");
        String actual = actualmv.getViewName();
        String expected = "comum/resultado";
        assertEquals(expected , actual);
    }
    @Test
    public void resultado_objects_not_null(){
        assertNotNull(homeController.resultado("Massa").getModel().get("produtos"));
    }

    @Test
    public void index_right_address(){
        String expected = "comum/index";
        String actual = homeController.index().getViewName();
        assertEquals(expected, actual);
    }
    @Test
    public void ver_precos_right_address(){
        String expected = "comum/verprecos";
        String actual = homeController.verprecos(3).getViewName();
        assertEquals(expected, actual);
    }
    @Test
    public void lojas_right_address(){
        String expected = "comum/loja";
        String actual = homeController.lojas(3).getViewName();    
        assertEquals(expected, actual);
    }

    @Test
    public void endereco_lojas_correto() {
        String esperado = "comum/loja";
        String atual = homeController.lojas(1).getViewName();
        assertEquals(esperado, atual);
    }
}