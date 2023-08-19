package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;

import br.com.petz.clientepet.pet.domain.Pet;
import br.com.petz.clientepet.pet.domain.Porte;
import br.com.petz.clientepet.pet.domain.SexoPet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import lombok.Value;

@Value
public class PetDetailResponse {
	private String nome;
	private Porte porte;
	private TipoPet tipo;
	private String microchip;
	private String raca;
	private SexoPet sexo;
	private String pelagemCor;
	private String rga;
	private Integer peso;
	private LocalDate dataNascimento;
	
	public PetDetailResponse(Pet pet) {
		this.nome = pet.getNome();
		this.porte = pet.getPorte();
		this.tipo = pet.getTipo();
		this.microchip = pet.getMicrochip();
		this.raca = pet.getRaca();
		this.sexo = pet.getSexo();
		this.pelagemCor = pet.getPelagemCor();
		this.rga = pet.getRga();
		this.peso = pet.getPeso();
		this.dataNascimento = pet.getDataNascimento();
	}
	
	
}
