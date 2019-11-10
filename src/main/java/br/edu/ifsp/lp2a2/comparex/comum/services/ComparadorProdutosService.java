package br.edu.ifsp.lp2a2.comparex.comum.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Produto;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ProdutosRespository;

public class ComparadorProdutosService{

    private ProdutosRespository repository;
    public ComparadorProdutosService(ProdutosRespository repository){
        this.repository = repository;
    }


    public List<Produto> comparadorPontuacao(){
        // Tem que optimizar
        List<Produto> result= new ArrayList<Produto>();
        repository.findAll().forEach(result::add);        
        return result.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
    public List<Produto> comparadorPontuacao(int quant){
        try{
            return this.comparadorPontuacao().subList(0, quant);
        }catch(IndexOutOfBoundsException ex){
            return this.comparadorPontuacao();
        }
    }
}