package br.edu.ifsp.lp2a2.comparex.unitarios.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Produto;

public class ProdutoTest{
    private List<Produto> produtos;

    public ProdutoTest(){
        this.produtos = new ArrayList<Produto>();    
        this.produtos.add(new Produto((long)1, "Cano",(long) 6)); 
        this.produtos.add(new Produto((long)2, "Pá", (long) 3));
        this.produtos.add(new Produto((long)2, "iPhone", (long) 7));
        this.produtos.add(new Produto((long)2, "Computador", (long) 5));
        this.produtos.add(new Produto((long)2, "Moto G", (long) 4));
        
    }
    public void adicionarPontuacao(){
        Produto produto = new Produto();
        produto.adicionarPontuacao();

    }
    @Test
    public void compareTo(){
        List<Produto> actual = this.produtos.stream().sorted().collect(Collectors.toList());
        List<Produto> expected = new ArrayList<Produto>();
        expected.add(new Produto((long)2, "Pá", (long) 3));
        expected.add(new Produto((long)2, "Moto G", (long) 4));
        expected.add(new Produto((long)2, "Computador", (long) 5));
        expected.add(new Produto((long)1, "Cano",(long) 6));
        expected.add(new Produto((long)2, "iPhone", (long) 7));
        assertEquals(expected, actual);
    }
    

}