package edu.drexel.TrainDemo.repositories;

import edu.drexel.TrainDemo.models.Agency;
import org.springframework.data.repository.CrudRepository;

public interface AgencyRepository extends CrudRepository<Agency, Long> { }
