package mostafa.springframework.mzRgpetClinic.services;

import mostafa.springframework.mzRgpetClinic.model.Owner;
import mostafa.springframework.mzRgpetClinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
