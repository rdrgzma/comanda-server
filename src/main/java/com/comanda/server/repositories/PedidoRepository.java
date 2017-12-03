package com.comanda.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comanda.server.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
