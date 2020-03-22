package edu.drexel.TrainDemo.repositories;


import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import edu.drexel.TrainDemo.models.Reservation;


public interface ReservationRepository extends CrudRepository<Reservation, BigInteger> {
   
}