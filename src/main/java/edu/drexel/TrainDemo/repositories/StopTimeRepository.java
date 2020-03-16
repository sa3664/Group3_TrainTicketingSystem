package edu.drexel.TrainDemo.repositories;

//import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.drexel.TrainDemo.models.StopTime;
import edu.drexel.TrainDemo.models.StopTimeIdentity;

@Repository
public interface StopTimeRepository extends CrudRepository<StopTime, StopTimeIdentity> {
    List<StopTime> findById(String id);
}
