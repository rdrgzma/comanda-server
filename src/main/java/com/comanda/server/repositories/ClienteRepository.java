package com.comanda.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comanda.server.models.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
