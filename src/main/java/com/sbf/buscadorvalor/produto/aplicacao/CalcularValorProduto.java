package com.sbf.buscadorvalor.produto.aplicacao;

import com.sbf.buscadorvalor.produto.aplicacao.dtos.ValorCalculadoDto;
import com.sbf.buscadorvalor.produto.dominio.Cotacao;
import com.sbf.buscadorvalor.produto.dominio.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcularValorProduto implements CalcularCotacao {

    @Override
    public List<ValorCalculadoDto> calcular(Produto produto, List<Cotacao> cotacoes) {
        List<ValorCalculadoDto> valoresCalculados = new ArrayList<>();
        Float valorProduto = produto.getValor();

        for (Cotacao cotacao : cotacoes) {
            ValorCalculadoDto valorCalculadoDto = new ValorCalculadoDto();

            valorCalculadoDto.valor = valorProduto / cotacao.getValorCotacao();
            valorCalculadoDto.moeda = cotacao.getNomeMoeda();

            valoresCalculados.add(valorCalculadoDto);
        }
        return valoresCalculados;
    }
}
