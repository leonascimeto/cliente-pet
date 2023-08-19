package br.com.petz.clientepet.cliente.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
	private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[inicializa] ClienteInfraRepository - salva");
		clienteSpringDataJPARepository.save(cliente);
		log.info("[finaliza] ClienteInfraRepository - salva");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosCliente() {
		log.info("[inicializa] ClienteInfraRepository - buscaTodosCliente");
		List<Cliente> clientes =  clienteSpringDataJPARepository.findAll();
		log.info("[finaliza] ClienteInfraRepository - buscaTodosCliente");
		return clientes;
	}

	@Override
	public Cliente buscaClientePeloId(UUID idCliente) {
		log.info("[inicializa] ClienteInfraRepository - buscaClientePeloId");
		Cliente cliente =  clienteSpringDataJPARepository.findById(idCliente)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
		log.info("[finaliza] ClienteInfraRepository - buscaClientePeloId");
		return cliente;
	}

}
