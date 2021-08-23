package com.sbf.buscadorvalor.produto.dominio;

import com.github.javafaker.Faker;
import com.sbf.buscadorvalor.produto.comun.dominio.ExcecaoDeDominio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProdutoTest {

    private Faker faker;

    @BeforeEach
    void init(){
        faker = new Faker();
    }

    @Test
    void nao_deve_ser_possivel_informar_um_valor_negativo_para_produto(){
        Float valor = -1.0F;
        String nome = faker.witcher().character();

        ExcecaoDeDominio excecaoDeDominio = assertThrows(ExcecaoDeDominio.class, () -> {
            new Produto(nome, valor);
        });

        assertEquals("O preco de um produto não pode ser menor ou igual a zero", excecaoDeDominio.getMessage());
    }

    @Test
    void nao_deve_ser_possivel_informar_um_nome_vazio_para_produto(){
        Float valor = 10.0F;
        String nome = "";

        ExcecaoDeDominio excecaoDeDominio = assertThrows(ExcecaoDeDominio.class, () -> {
            new Produto(nome, valor);
        });

        assertEquals("Um produto deve ter um nome.", excecaoDeDominio.getMessage());
    }
}
