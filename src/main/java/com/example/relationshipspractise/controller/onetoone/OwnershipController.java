package com.example.relationshipspractise.controller.onetoone;

import com.example.relationshipspractise.exception.OwnerExeption;
import com.example.relationshipspractise.model.onetoone.House;
import com.example.relationshipspractise.model.onetoone.Owner;
import com.example.relationshipspractise.model.onetoone.Pet;
import com.example.relationshipspractise.repository.onetoone.HouseRepository;
import com.example.relationshipspractise.repository.onetoone.OwnerRepository;
import com.example.relationshipspractise.repository.onetoone.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/ownership")
public class OwnershipController {
    HouseRepository houseRepository;
    OwnerRepository ownerRepository;
    PetRepository petRepository;

    @PostMapping("/owner/create")
    public String createOwner(@Valid @RequestBody Owner owner) {
        ownerRepository.save(owner);
        return "Created an owner";
    }
    @PostMapping("/house/create")
    public String createHouse(@Valid @RequestBody House house) {
        houseRepository.save(house);
        return "Created a house";
    }
    @PostMapping("/pet/create")
    public String createPet(@RequestBody Pet pet) {
        petRepository.save(pet);
        return "Created a pet";
    }
    @GetMapping("/owners")
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
    @GetMapping("/houses")
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }
    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @DeleteMapping("/owner/delete/{ownerId}")
    public void deleteOwnerById(@Min(30) @PathVariable int ownerId) {
        ownerRepository.deleteById(ownerId);
    }
    @DeleteMapping("/pet/delete/{petId}")
    public void deletePetById(@PathVariable int petId) {
        petRepository.deleteById(petId);
    }
    @DeleteMapping("/house/delete/{houseId}")
    public void deleteHouseById(@PathVariable int houseId) {
        houseRepository.deleteById(houseId);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/owner/find/{ownerId}")
    public Owner findOwnerById(@PathVariable int ownerId) throws Exception {
        return ownerRepository.findById(ownerId).orElseThrow(()->new OwnerExeption("No such owner " + ownerId));
    }
}
