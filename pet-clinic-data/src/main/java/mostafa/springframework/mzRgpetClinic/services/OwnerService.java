package mostafa.springframework.mzRgpetClinic.services;

import mostafa.springframework.mzRgpetClinic.model.Owner;



public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastname);

}
