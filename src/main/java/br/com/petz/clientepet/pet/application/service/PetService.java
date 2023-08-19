package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetDetailResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.api.PetUpdateRequest;
import br.com.petz.clientepet.pet.application.api.PetsClienteResponse;
import jakarta.validation.Valid;

public interface PetService {

	PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest);

	List<PetsClienteResponse> listarPetsCliente(UUID idCliente);

	PetDetailResponse findPetById(UUID idCliente, UUID idPet);

	void deletePetById(UUID idCliente, UUID idPet);

	void updatePet(UUID idCliente, UUID idPet, PetUpdateRequest petUpdateRequest);

}
