package br.com.wellington.vasconcelos.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wellington.vasconcelos.model.Cliente;
import br.com.wellington.vasconcelos.model.ClienteRepository;
import br.com.wellington.vasconcelos.model.Endereco;
import br.com.wellington.vasconcelos.model.EnderecoRepository;
import br.com.wellington.vasconcelos.service.ClienteService;
import br.com.wellington.vasconcelos.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	// TODO Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Cliente> buscarTodos() {
		// FIXME Buscar todos os Clientes.
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// FIXME Buscar  os Clientes por ID.
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);		
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
			
		}
	}
	
	@Override
	public void delete(Long id) {
		// Deletar Cliente por ID.
		clienteRepository.deleteById(id);
		
	}
	
	private void salvarClienteComCep(Cliente cliente) {
		// Verifica se o Endereco do Cliente já existe (pelo CEP).
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCep e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
	});	
		cliente.setEndereco(endereco);
		// Inserir Cliente, vinculando o endereco (novo opu existente).
		clienteRepository.save(cliente);
	}

}
