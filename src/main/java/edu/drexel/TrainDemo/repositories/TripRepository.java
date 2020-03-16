package edu.drexel.TrainDemo.repositories;


import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;


import edu.drexel.TrainDemo.models.Trip;

public interface TripRepository extends CrudRepository<Trip, BigInteger> {
   
}