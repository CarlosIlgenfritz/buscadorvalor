package com.sbf.buscadorvalor.produto.aplicacao.dtos;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ValoresProdutoDto {

    public HttpStatus httpStatus;
    public String mensagemResposta;
    public String nomeProduto;
    public List<ValorCalculadoDto> valoresCalculados;

    public ValoresProdutoDto(HttpStatus httpStatus, String mensagemResposta) {
        this.httpStatus = httpStatus;
        this.mensagemResposta = mensagemResposta;
    }
}
