package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.pet.application.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetApi {
	private final PetService petService;
	
	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[start] PetController - postPet");
		log.info("[idCliente] {}", idCliente);
		PetResponse pet = petService.criaPet(idCliente, petRequest);
		log.info("[end] PetController - postPet");
		return pet;
	}

	@Override
	public List<PetsClienteResponse> getPetsCliente(UUID idCliente) {
		log.info("[start] PetController - getPetsCliente");
		log.info("[idCliente] {}", idCliente);
		List<PetsClienteResponse> pets  = petService.listarPetsCliente(idCliente);
		log.info("[end] PetController - getPetsCliente");
		return pets;
	}

	@Override
	public PetDetailResponse getPetById(UUID idCliente, UUID idPet) {
		log.info("[start] PetController - getPetById");
		PetDetailResponse pet = petService.findPetById(idCliente, idPet);
		log.info("[start] PetController - getPetById");
		return pet;
	}

	@Override
	public void deletePetById(UUID idCliente, UUID idPet) {
		log.info("[start] PetController - deletePetById");
		petService.deletePetById(idCliente, idPet);
		log.info("[end] PetController - deletePetById");
	}

}
