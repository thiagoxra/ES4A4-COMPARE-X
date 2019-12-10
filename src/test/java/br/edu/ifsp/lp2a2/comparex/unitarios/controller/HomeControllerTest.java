package br.edu.ifsp.lp2a2.comparex.unitarios.controller;

import br.edu.ifsp.lp2a2.comparex.comum.controllers.HomeController;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Produto;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest {
    ProdutosRespository repository;
    HomeController homeController;
    List<Produto> list;
    public HomeControllerTest(){
        this.repository = Mockito.mock(ProdutosRespository.class);
        this.homeController = new HomeController(repository);
        this.list = new ArrayList<>();
        this.list.add(new Produto(1, "Massa"));
        this.list.add(new Produto(2, "Cimento"));
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
        String actual = homeController.index();
        assertEquals(expected, actual);
    }
}