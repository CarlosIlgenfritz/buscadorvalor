package com.sbf.buscadorvalor.produto.aplicacao;

import com.sbf.buscadorvalor.produto.aplicacao.dtos.ProdutoDto;
import com.sbf.buscadorvalor.produto.aplicacao.dtos.ValorCalculadoDto;
import com.sbf.buscadorvalor.produto.aplicacao.dtos.ValoresProdutoDto;
import com.sbf.buscadorvalor.produto.dominio.Cotacao;
import com.sbf.buscadorvalor.produto.dominio.Produto;
import com.sbf.buscadorvalor.produto.dominio.repositorio.CotacaoRepositorio;
import com.sbf.buscadorvalor.produto.dominio.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuscaValorProdutos {

    private ProdutoRepositorio produtoRepositorio;
    private CotacaoRepositorio cotacaoRepositorio;
    private CalcularValorProduto calcularValorProduto;

    @Autowired
    public BuscaValorProdutos(ProdutoRepositorio produtoRepositorio, CotacaoRepositorio cotacaoRepositorio,
                              CalcularValorProduto calcularValorProduto) {
        this.produtoRepositorio = produtoRepositorio;
        this.cotacaoRepositorio = cotacaoRepositorio;
        this.calcularValorProduto = calcularValorProduto;
    }


    public ValoresProdutoDto BuscarValorDosProdutos(Long produtoId){
        Optional<Produto> produtoEncontrado = produtoRepositorio.findById(produtoId);

        if(produtoEncontrado.isEmpty()){
            return new ValoresProdutoDto(HttpStatus.INTERNAL_SERVER_ERROR, "Produto não encontrado.");
        }

        Produto produto = produtoEncontrado.get();
        List<Cotacao> listaDeCotacoes = cotacaoRepositorio.findAll();

        List<ValorCalculadoDto> valorCalculado = calcularValorProduto.calcular(produto, listaDeCotacoes);

        return montarDto(produto.getNome(), valorCalculado);
    }

    private ValoresProdutoDto montarDto(String nome, List<ValorCalculadoDto> valoresCalculados) {
        ValoresProdutoDto valoresProdutoDto = new ValoresProdutoDto(HttpStatus.OK, "Valores calculados com sucesso!");

        valoresProdutoDto.nomeProduto = nome;
        valoresProdutoDto.valoresCalculados = valoresCalculados;

        return  valoresProdutoDto;
    }
}
