package mostafa.springframework.mzRgpetClinic.services;

import mostafa.springframework.mzRgpetClinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
