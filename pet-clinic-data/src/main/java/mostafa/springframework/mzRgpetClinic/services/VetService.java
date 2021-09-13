package mostafa.springframework.mzRgpetClinic.services;

import mostafa.springframework.mzRgpetClinic.model.Owner;
import mostafa.springframework.mzRgpetClinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
