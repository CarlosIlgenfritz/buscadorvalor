package com.sbf.buscadorvalor.produto.aplicacao;

import com.sbf.buscadorvalor.produto.aplicacao.dtos.ValorCalculadoDto;
import com.sbf.buscadorvalor.produto.dominio.Cotacao;
import com.sbf.buscadorvalor.produto.dominio.Produto;

import java.util.List;

public interface CalcularCotacao {
    List<ValorCalculadoDto> calcular(Produto produto, List<Cotacao> valorCotacao);
}
