package com.sbf.buscadorvalor.produto.dominio.repositorio;

import com.sbf.buscadorvalor.produto.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
}
