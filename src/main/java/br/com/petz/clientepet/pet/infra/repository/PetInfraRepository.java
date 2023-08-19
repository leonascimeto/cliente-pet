package br.com.petz.clientepet.pet.infra.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
	private final PetSpringJPARepository petSpringDataJPARepository;
	@Override
	public Pet salvaPet(Pet pet) {
		log.info("[start] PetInfraRepository - salvaPet");
		petSpringDataJPARepository.save(pet);
		log.info("[end] PetInfraRepository - salvaPet");
		return pet;
	}
	@Override
	public List<Pet> listAllPetsClient(UUID idCliente) {
		log.info("[start] PetInfraRepository - listAllPetsClient");
		List<Pet> pets = petSpringDataJPARepository.findByIdClienteTutor(idCliente);
		log.info("[end] PetInfraRepository - listAllPetsClient");
		return pets;
	}

}
