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

        Owner abbas = new Owner("abbas","05459149870","abbas@mail.com","izmir",null);
        Owner safka = new Owner("safka","05459149871","safka@mail.com","konya",null);
        Owner qorya = new Owner("qorya","05459149872","qorya@mail.com","ankara",null);

        Pet dog = new Pet("pitbul","americano","dog","iyi huylu","2",abbas);
        Pet cat = new Pet("pasha","iranian","cat","iyi huylu","2",safka);
        Pet kush = new Pet("papagan","papagn01","bird","iyi huylu","2",qorya);
        Pet kush2 = new Pet("papagan2","papagn01","bird","iyi huylu","2",qorya);

        ownerRepository.save(abbas);
        ownerRepository.save(safka);
        ownerRepository.save(qorya);
        petRepository.save(dog);
        petRepository.save(cat);
        petRepository.save(kush);
        petRepository.save(kush2);





    }
}
