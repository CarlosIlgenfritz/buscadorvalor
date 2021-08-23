package com.sbf.buscadorvalor.produto.aplicacao;

import com.github.javafaker.Faker;
import com.sbf.buscadorvalor.produto.aplicacao.dtos.ValorCalculadoDto;
import com.sbf.buscadorvalor.produto.dominio.Cotacao;
import com.sbf.buscadorvalor.produto.dominio.Produto;
import com.sbf.buscadorvalor.produto.dominio.repositorio.CotacaoRepositorio;
import com.sbf.buscadorvalor.produto.dominio.repositorio.ProdutoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CalcularValorProdutoTest {

    private CotacaoRepositorio cotacaoRepositorio;
    private ProdutoRepositorio produtoRepositorio;
    private Faker faker;

    @BeforeEach
    void init(){
        faker = new Faker();
        produtoRepositorio = mock(ProdutoRepositorio.class);
        cotacaoRepositorio = mock(CotacaoRepositorio.class);
    }

    @Test
    void deve_calcular_cotacao(){
        Produto produto = new Produto(faker.witcher().character(), 10.0F);
        List<Cotacao> listaCotacao = new ArrayList<>();
        Cotacao cotacao = new Cotacao(faker.witcher().character(), 5.0F);
        listaCotacao.add(cotacao);
        CalcularValorProduto calcularValorProduto = new CalcularValorProduto();
        Float ValorEsperado = 2.0F;

        List<ValorCalculadoDto> cotacaoCalculada = calcularValorProduto.calcular(produto, listaCotacao);

        assertEquals(cotacaoCalculada.get(0).valor, ValorEsperado);
    }
}
