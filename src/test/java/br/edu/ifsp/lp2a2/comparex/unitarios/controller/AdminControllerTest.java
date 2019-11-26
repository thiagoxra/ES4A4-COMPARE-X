package br.edu.ifsp.lp2a2.comparex.unitarios.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.ifsp.lp2a2.comparex.admin.controllers.AdminController;

public class AdminControllerTest {
	@Test
	public void admin_retornar_template() {
		// configuração
		AdminController controller = new AdminController();
		String esperado = "admin/admin";
		
		// Execução
		String atual = controller.exibir();
		
		// Comparação
		assertEquals(esperado, atual);
		
	}
}
