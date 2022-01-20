package com.ozgursoft.vetapp.config;


import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.repository.OwnerRepository;
import com.ozgursoft.vetapp.repository.PetRepository;
import com.ozgursoft.vetapp.service.OwnerService;
import com.ozgursoft.vetapp.service.PetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;

    public DataLoader(OwnerRepository ownerRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner abbas = Owner.builder()
                .nameSurname("Abbas")
                .email("abbas@mail.com")
                .phone("05458146542")
                .contact("izmir")
                .build();

        Owner safka = Owner.builder()
                .nameSurname("safia")
                .email("safka@mail.com")
                .phone("05458146541")
                .contact("izmir")
                .build();


        Pet dog = Pet.builder()
                .name("pitbul")
                .type("Dog")
                .genus("americano")
                .age("2")
                .description("egitimli")
                .owner(abbas)
                .build();
        Pet dog1 = Pet.builder()
                .name("pitbul1")
                .type("Dog")
                .genus("americano")
                .age("23")
                .description("egitimli")
                .owner(abbas)
                .build();

        Pet cat = Pet.builder()
                .name("iranian")
                .type("cat")
                .genus("i.cat")
                .age("2")
                .description("egitimli")
                .owner(safka)
                .build();
        Pet cat1 = Pet.builder()
                .name("iranian1")
                .type("cat")
                .genus("i.cat")
                .age("21")
                .description("egitimli")
                .owner(safka)
                .build();

        petRepository.save(dog);
        petRepository.save(cat);
        petRepository.save(dog1);
        petRepository.save(cat1);





    }
}
