package br.com.petz.clientepet.cliente.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {
	private final ClienteService clienteService;

	@Override
	public ClienteResponse postCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteController - postCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteController - postCliente");
		return clienteCriado;
	}

	@Override
	public List<ClienteListResponse> getClientes() {
		log.info("[inicia] ClienteController - getClientes");
		List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
		log.info("[finaliza] ClienteController - getClientes");
		return clientes;
	}

	@Override
	public ClienteDetalhadoResponse getClienteById(UUID idCliente) {
		log.info("[inicia] ClienteController - getClienteById");
		log.debug("[idCliente] {}", idCliente);
		ClienteDetalhadoResponse cliente = clienteService.buscaClientePeloId(idCliente);
		log.info("[finaliza] ClienteController - getClienteById");
		return cliente;
	}

	@Override
	public ClienteDetalhadoResponse deleteClienteById(UUID idCliente) {
		log.info("[inicia] ClienteController - deleteClienteById");
		log.debug("[idCliente] {}", idCliente);
		clienteService.deletaClientePeloId(idCliente);
		log.info("[finaliza] ClienteController - deleteClienteById");
		return null;
	}

	@Override
	public void patchCliente(UUID idCliente, @Valid ClienteUpdateRequest clienteUpdateRequest) {
		log.info("[inicia] ClienteController - patchCliente");
		log.info("[finaliza] ClienteController - patchCliente");
	}
}
