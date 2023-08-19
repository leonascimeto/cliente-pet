package br.com.petz.clientepet.cliente.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicationService - criaCliente");
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteApplicationService - criaCliente");
		return ClienteResponse.builder()
				.idCliente(cliente.getIdCliente())
				.build();
	}

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		log.info("[inicia] ClienteApplicationService - buscaTodosClientes");
		List<Cliente> clientes =  clienteRepository.buscaTodosCliente();
		log.info("[finaliza] ClienteApplicationService - buscaTodosClientes");
		return ClienteListResponse.converte(clientes);
	}

	@Override
	public ClienteDetalhadoResponse buscaClientePeloId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - buscaClientePeloId");
		Cliente cliente = clienteRepository.buscaClientePeloId(idCliente);
		log.info("[finaliza] ClienteApplicationService - buscaClientePeloId");
		return new ClienteDetalhadoResponse(cliente);
	}

	@Override
	public void deletaClientePeloId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - deletaClientePeloId");
		Cliente cliente = clienteRepository.buscaClientePeloId(idCliente);
		clienteRepository.deletaCliente(cliente);
		log.info("[finaliza] ClienteApplicationService - deletaClientePeloId");
	}

}
