package br.com.petz.clientepet.cliente.application.api;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Value;

@Value
public class ClienteDetalhadoResponse {
	private UUID idCliente;
	private String nomeCompleto;
	private String email;
	private String celular;
	private String cpf;
	private String sexo;
	private Boolean aceitaTermos;
	private LocalDate dataHoraDoCadastro;
}
