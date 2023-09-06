package com.carshow.exotics.service;

import com.carshow.exotics.entity.Owner;
import com.carshow.exotics.exceptions.ResourceNotFoundException;
import com.carshow.exotics.repo.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    OwnerRepo ownerRepo;

    public List<Owner> getOwners() {

        return (List<Owner>) ownerRepo.findAll();
    }

    @Override
    public Owner retrieveOwner(Long id) {
        Optional<Owner> optionalOwner = ownerRepo.findById(id);

        if (optionalOwner.isPresent()) {
            return optionalOwner.get();
        } else {
            throw new ResourceNotFoundException("Owner with " + id + " not found");
        }
    }

    @Override
    public void deleteOwner(Long id) {
        Optional<Owner> optionalOwner = ownerRepo.findById(id);

        if (optionalOwner.isPresent()) {
            ownerRepo.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Owner with " + id + " not found");

        }


    }

    @Override
    public Owner createOwner(Owner owner) {
        return ownerRepo.save(owner);
    }

    @Override
    public Owner updateOwner(Long id, Owner owner) {
        Optional<Owner> ownerOptional = ownerRepo.findById(id);
        if (ownerOptional.isPresent()) {
            ownerOptional.get().setFirstName(owner.getFirstName());
            ownerOptional.get().setLastName(owner.getLastName());
            ownerOptional.get().setCars(owner.getCars());
            ownerRepo.save(ownerOptional.get());
            return ownerOptional.get();
        } else {
            throw new ResourceNotFoundException("Owner with " + id + " not found");


        }
    }
}
