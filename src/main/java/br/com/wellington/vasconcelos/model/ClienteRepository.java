package br.com.wellington.vasconcelos.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
}
