package br.com.petz.clientepet.pet.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetUpdateRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idPet;
	@NotNull
	@Column(columnDefinition = "uuid", name = "idClienteTutor", nullable = false)
	private UUID idClienteTutor;
	@NotBlank
	private String nome;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Porte porte;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPet tipo;
	private String microchip;
	@NotBlank
	private String raca;
	@NotNull
	private SexoPet sexo;
	private String pelagemCor;
	private String rga;
	private Integer peso;
	@NotNull
	private LocalDate dataNascimento;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHotaDaUltimaAlteracao;
	
	public Pet(UUID idCliente, @Valid PetRequest petRequest) {
		this.idClienteTutor = idCliente;
		this.nome = petRequest.getNome();
		this.porte = petRequest.getPorte();
		this.tipo = petRequest.getTipo();
		this.microchip = petRequest.getMicrochip();
		this.raca = petRequest.getRaca();
		this.sexo = petRequest.getSexo();
		this.pelagemCor = petRequest.getPelagemCor();
		this.rga = petRequest.getRga();
		this.peso = petRequest.getPeso();
		this.dataNascimento = petRequest.getDataNascimento();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void update(PetUpdateRequest petUpdateRequest) {
		this.nome = petUpdateRequest.getNome();
		this.porte = petUpdateRequest.getPorte();
		this.tipo = petUpdateRequest.getTipo();
		this.microchip = petUpdateRequest.getMicrochip();
		this.raca = petUpdateRequest.getRaca();
		this.sexo = petUpdateRequest.getSexo();
		this.pelagemCor = petUpdateRequest.getPelagemCor();
		this.rga = petUpdateRequest.getRga();
		this.peso = petUpdateRequest.getPeso();
		this.dataNascimento = petUpdateRequest.getDataNascimento();
		this.dataHotaDaUltimaAlteracao = LocalDateTime.now();
	}

}
