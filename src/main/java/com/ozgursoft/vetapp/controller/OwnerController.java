package com.ozgursoft.vetapp.controller;


import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.request.OwnerCreateRequest;
import com.ozgursoft.vetapp.model.request.PetCreateRequest;
import com.ozgursoft.vetapp.service.OwnerService;
import com.ozgursoft.vetapp.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @ModelAttribute("owner")
    public OwnerCreateRequest ownerCreateRequest(){
        return new OwnerCreateRequest();
    }

    @GetMapping()
    public String getAllOwners(Model model){

        List<OwnerDto> ownerDtos = ownerService.getAllOwners();
        model.addAttribute("owners",ownerDtos);
        return "owners/owners";

    }

    @GetMapping("/add")
    public String getOwnerAddPage(){
        return "owners/addOwner";
    }

    @PostMapping("/add")
    public String ownerAddPage(@ModelAttribute("owner") OwnerCreateRequest ownerCreateRequest){
        ownerService.createOwner(ownerCreateRequest);
        return "redirect:/owners?success";
    }

    @GetMapping("/edit")
    public String getOwnerEditPage(){
        return "owners/updateOwner";
    }


}
