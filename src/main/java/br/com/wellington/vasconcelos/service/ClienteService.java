package br.com.wellington.vasconcelos.service;

import br.com.wellington.vasconcelos.model.Cliente;

/**
 * Interface que define o padrao <b>Strategy</b> no domínio de cliente.com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author WellingtonVasconcelos
 */

public interface  ClienteService {
	
	Iterable<Cliente> buscarTodos();
	
	Cliente buscarPorId(Long id);
	
	void inserir(Cliente cliente);
	
	void atualizar(Long id, Cliente cliente);
	
	void delete(Long id);

}
