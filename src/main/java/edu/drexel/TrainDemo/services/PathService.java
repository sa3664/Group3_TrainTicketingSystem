package edu.drexel.TrainDemo.services;

import java.util.List;
import edu.drexel.TrainDemo.models.Path;
import org.springframework.stereotype.Service;


@Service
public interface PathService {
  
    List<Path> getDirectPaths(String fromStop, String toStop);
  //  List<Path> getConnectedPaths(String fromStop, String toStop);
	
}