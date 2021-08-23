package com.sbf.buscadorvalor.produto.dominio.repositorio;

import com.sbf.buscadorvalor.produto.dominio.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepositorio extends JpaRepository<Cotacao,Long> {
}
