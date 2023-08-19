package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.stream.Collectors;

import br.com.petz.clientepet.pet.domain.Pet;
import br.com.petz.clientepet.pet.domain.Porte;
import br.com.petz.clientepet.pet.domain.SexoPet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class PetsClienteResponse {
	private String nome;
	private Porte porte;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPet tipo;
	@NotBlank
	private String raca;
	@NotNull
	private SexoPet sexo;
	
	public static List<PetsClienteResponse> convert(List<Pet> petsClienteList) {
		return petsClienteList.stream()
				.map(PetsClienteResponse::new)
				.collect(Collectors.toList());
	}

	public PetsClienteResponse(Pet pet) {
		this.nome = pet.getNome();
		this.porte = pet.getPorte();
		this.tipo = pet.getTipo();
		this.raca = pet.getRaca();
		this.sexo = pet.getSexo();
	}
	
	
}
