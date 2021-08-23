package com.sbf.buscadorvalor.produto.dominio;

import com.github.javafaker.Faker;
import com.sbf.buscadorvalor.produto.comun.dominio.ExcecaoDeDominio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CotacaoTest {
    private Faker faker;

    @BeforeEach
    void init(){
        faker = new Faker();
    }

    @Test
    void nao_deve_ser_possivel_informar_um_valor_negativo_para_cotacao(){
        Float cotacao = -1.0F;
        String nome = faker.witcher().character();

        ExcecaoDeDominio excecaoDeDominio = assertThrows(ExcecaoDeDominio.class, () -> {
            new Cotacao(nome, cotacao);
        });

        assertEquals("O valor da cotacao não pode ser menor ou igual a zero", excecaoDeDominio.getMessage());
    }

    @Test
    void nao_deve_ser_possivel_informar_um_nome_vazio_para_cotacao(){
        Float cotacao = 10.0F;
        String nome = "";

        ExcecaoDeDominio excecaoDeDominio = assertThrows(ExcecaoDeDominio.class, () -> {
            new Cotacao(nome, cotacao);
        });

        assertEquals("Uma moeda deve ter um nome.", excecaoDeDominio.getMessage());
    }
}
