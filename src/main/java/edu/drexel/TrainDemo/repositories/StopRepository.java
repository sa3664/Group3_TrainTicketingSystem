package edu.drexel.TrainDemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import edu.drexel.TrainDemo.models.Stop;

public interface StopRepository extends CrudRepository<Stop, String> {
   
}
