package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetDetailResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.api.PetsClienteResponse;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
	private final ClienteService clienteService;
	private final PetRepository petRepository;
	
	@Override
	public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
		log.info("[start] PetApplicationService - criaPet");
		clienteService.buscaClientePeloId(idCliente);
		Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
		log.info("[end] PetApplicationService - criaPet");
		return new PetResponse(pet.getIdPet());
	}

	@Override
	public List<PetsClienteResponse> listarPetsCliente(UUID idCliente) {
		log.info("[start] PetApplicationService - listarPetsCliente");
		clienteService.buscaClientePeloId(idCliente);
		List<Pet> petsClienteList = petRepository.listAllPetsClient(idCliente);
		log.info("[end] PetApplicationService - listarPetsCliente");
		return PetsClienteResponse.convert(petsClienteList);
	}

	@Override
	public PetDetailResponse findPetById(UUID idCliente, UUID idPet) {
		log.info("[start] PetApplicationService - findPetById");
		clienteService.buscaClientePeloId(idCliente);
		Pet pet = petRepository.findPetById(idPet);
		log.info("[end] PetApplicationService - findPetById");

		return new PetDetailResponse(pet);
	}

}
