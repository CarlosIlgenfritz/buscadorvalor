package com.sbf.buscadorvalor.produto.portaadaptador.rest;

import com.sbf.buscadorvalor.produto.aplicacao.BuscaValorProdutos;
import com.sbf.buscadorvalor.produto.aplicacao.dtos.ValoresProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/produto/buscarvalor")
public class ProdutoRest {

    @Autowired
    private BuscaValorProdutos buscaValorProdutos;

    @GetMapping
    public ValoresProdutoDto buscarValorProduto(@PathParam("produtoIdprodutoId") Long produtoId){
        return buscaValorProdutos.BuscarValorDosProdutos(produtoId);
    }
}
