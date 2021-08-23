package com.sbf.buscadorvalor.produto.dominio;

import com.sbf.buscadorvalor.produto.comun.dominio.ExcecaoDeDominio;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "PRODUTO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private Float valor;

    public Produto(String nome, Float valor) {
        validarCamposObrigatorios(nome, valor);
        this.nome = nome;
        this.valor = valor;
    }

    private void validarCamposObrigatorios(String nome, Float valor) {
        ExcecaoDeDominio.quandoTextoVazioOuNulo(nome, "Um produto deve ter um nome.");
        ExcecaoDeDominio.quandoValorMenorIgualZero(valor, "O preco de um produto não pode ser menor ou igual a zero");
    }
}
