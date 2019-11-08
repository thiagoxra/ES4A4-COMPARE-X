package br.edu.ifsp.lp2a2.comparex.unitarios.controller;

import br.edu.ifsp.lp2a2.comparex.comum.controllers.HomeController;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class HomeControllerTest {

    @Test
    public void index_return_template() {
        // Configuracao
        ProdutosRespository repository = Mockito.mock(ProdutosRespository.class);
        HomeController controller = new HomeController();
        String actual = controller.list(repository);
        String expected = "comum/index";
        assertEquals(expected, actual);
    }

}