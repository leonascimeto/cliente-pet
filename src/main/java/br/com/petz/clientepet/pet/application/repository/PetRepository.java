package br.com.petz.clientepet.pet.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.pet.domain.Pet;

public interface PetRepository {
	Pet salvaPet(Pet pet);

	List<Pet> listAllPetsClient(UUID idCliente);

	Pet findPetById(UUID idPet);

	void deleteById(Pet pet);
}
