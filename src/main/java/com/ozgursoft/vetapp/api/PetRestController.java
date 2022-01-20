package com.ozgursoft.vetapp.api;


import com.ozgursoft.vetapp.model.dto.PetDto;
import com.ozgursoft.vetapp.model.request.PetCreateRequest;
import com.ozgursoft.vetapp.service.OwnerService;
import com.ozgursoft.vetapp.service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetRestController {

    private final PetService petService;
    private final OwnerService ownerService;
    private final ModelMapper modelMapper;

    public PetRestController(PetService petService, OwnerService ownerService, ModelMapper modelMapper) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public ResponseEntity<List<PetDto>> getAllPets(){
        return null;
    }

    public ResponseEntity<PetDto> createPet(PetCreateRequest request){
        return new ResponseEntity<>(petService.createPet(request), HttpStatus.CREATED);
    }


}
