package com.comanda.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comanda.server.models.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
