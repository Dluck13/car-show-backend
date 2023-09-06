package com.carshow.exotics.service;

import com.carshow.exotics.entity.Car;
import com.carshow.exotics.entity.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OwnerService {

    List<Owner> getOwners();

    Owner retrieveOwner(Long id);

    void deleteOwner(Long id);

    Owner createOwner(Owner owner);

    Owner updateOwner(Long id, Owner owner) ;
}
