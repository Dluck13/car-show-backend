package com.carshow.exotics.controller;

import com.carshow.exotics.entity.Owner;
import com.carshow.exotics.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/allOwners")
    public ResponseEntity<List<Owner>> getOwners(){
        return new ResponseEntity<>(ownerService.getOwners(), HttpStatus.OK);
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable Long id){
        return new ResponseEntity<>(ownerService.retrieveOwner(id), HttpStatus.OK);
    }

    @DeleteMapping("/owner/{id}")
    public ResponseEntity<HttpStatus> deleteOwner(@PathVariable Long id){
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/owners")
    public ResponseEntity<Owner> createNewOwner(@RequestBody Owner owner){
        return new ResponseEntity<>(ownerService.createOwner(owner), HttpStatus.CREATED);
    }

    @PutMapping("/owner/{id}")
    public ResponseEntity<Owner> updateOwnerById(@RequestBody Owner owner, @PathVariable Long id){
        return new ResponseEntity<>(ownerService.updateOwner(id, owner), HttpStatus.OK);




    }
}
