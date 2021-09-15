package mostafa.springframework.mzRgpetClinic.bootstrap;

import mostafa.springframework.mzRgpetClinic.model.*;
import mostafa.springframework.mzRgpetClinic.services.OwnerService;
import mostafa.springframework.mzRgpetClinic.services.PetTypeService;
import mostafa.springframework.mzRgpetClinic.services.SpecialityService;
import mostafa.springframework.mzRgpetClinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count==0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogType = petTypeService.save(dog);
        PetType cat = new PetType();
        dog.setName("cat");
        PetType saveCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology= specialityService.save(radiology);
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry= specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("mostafa");
        owner1.setLastName("zayed");
        owner1.setAdress("123 wafa");
        owner1.setCity("wafa");
        owner1.setTelephone("02122222");


        Pet mostafaPet = new Pet();
        mostafaPet.setPetType(saveCatType);
        mostafaPet.setOwner(owner1);
        mostafaPet.setBirtDate(LocalDate.now());
        mostafaPet.setName("basbos");
        owner1.getPets().add(mostafaPet);

        ownerService.save(owner1);


        Owner owner2 =new Owner();
        owner2.setFirstName("rafif");
        owner2.setLastName("abdo");
        owner2.setTelephone("12223234");
        owner2.setCity("cairo");
        owner2.setAdress("123 cairo");

        Pet rafifPet = new Pet();
        rafifPet.setPetType(saveDogType);
        rafifPet.setOwner(owner2);
        rafifPet.setBirtDate(LocalDate.now());
        rafifPet.setName("pubsi");
        ownerService.save(owner2);
        owner2.getPets().add(rafifPet);
        System.out.println("owner are loaded");


        Vet vet1 = new Vet();
        vet1.setFirstName("ahmed");
        vet1.setLastName("ali");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("bakr");
        vet2.setLastName("omar");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);
        System.out.println("vet are loaded");
    }
}
