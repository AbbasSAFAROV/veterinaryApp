package com.ozgursoft.vetapp.controller;


import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.service.OwnerService;
import com.ozgursoft.vetapp.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final PetService petService;
    private final OwnerService ownerService;

    public OwnerController(PetService petService, OwnerService ownerService) {
        this.petService = petService;
        this.ownerService = ownerService;
    }


    @GetMapping()
    public String getAllOwners(Model model){

        List<OwnerDto> ownerDtos = ownerService.getAllOwners();
        model.addAttribute("owners",ownerDtos);
        return "owners/owners";

    }

    @GetMapping("/add")
    public String getOwnerAdPage(){
        return "owners/addOwner";
    }

    @GetMapping("/edit")
    public String getOwnerEditPage(){
        return "owners/updateOwner";
    }


}
