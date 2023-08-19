package br.com.petz.clientepet.pet.infra.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.clientepet.pet.domain.Pet;

public interface PetSpringJPARepository extends JpaRepository<Pet, UUID> {

}
