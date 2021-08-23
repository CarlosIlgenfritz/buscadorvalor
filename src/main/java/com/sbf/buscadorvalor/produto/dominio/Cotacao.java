package com.sbf.buscadorvalor.produto.dominio;

import com.sbf.buscadorvalor.produto.comun.dominio.ExcecaoDeDominio;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "COTACAO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nomeMoeda;

    @Column
    private Float valorCotacao;

    public Cotacao(String nomeMoeda, Float valorCotacao) {
        validarCamposObrigatorios(nomeMoeda, valorCotacao);
        this.nomeMoeda = nomeMoeda;
        this.valorCotacao = valorCotacao;
    }

    private void validarCamposObrigatorios(String nomeMoeda, Float valorCotacao) {
        ExcecaoDeDominio.quandoTextoVazioOuNulo(nomeMoeda, "Uma moeda deve ter um nome.");
        ExcecaoDeDominio.quandoValorMenorIgualZero(valorCotacao, "O valor da cotacao não pode ser menor ou igual a zero");
    }
}
