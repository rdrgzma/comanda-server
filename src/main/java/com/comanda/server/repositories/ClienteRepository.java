package com.comanda.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comanda.server.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
