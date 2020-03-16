package edu.drexel.TrainDemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.drexel.TrainDemo.models.Connection;
import edu.drexel.TrainDemo.models.Path;
import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.models.StopTime;
import edu.drexel.TrainDemo.models.Trip;
import edu.drexel.TrainDemo.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PathServiceImpl implements PathService {

  @Autowired
  private StopRepository stopRepository;
  @Autowired
  private StopTimeRepository stopTimeRepository;
  @Autowired
  private TripRepository tripRepository;

  @Override
  public List<Path> getDirectPaths(String fromStop, String toStop) {

    Iterable<StopTime> tripsfromStop = stopTimeRepository.findAll();
    List<Path> pathsList = new ArrayList<Path>();

    for (StopTime stopTime : tripsfromStop) {
      Optional<StopTime> otoStopTime = stopTimeRepository.findById(new StopTimeIdentity(stopTime.getTrip_id(), toStop));

        if (otoStopTime.value != null){
          StopTime toStopTime = otoStopTime.get();
          if( stopTime.getStop_Sequence() < toStopTime.getStop_Sequence()) {

          Stop fromstop = stopRepository.findById(fromStop).get();
          Stop tostop = stopRepository.findById(toStop).get();

          Trip trip = tripRepository.findById(stopTime.getTrip_id()).get();
          List<Connection> cList = new ArrayList<Connection>();
          cList.add(new Connection( trip, fromstop, tostop));
          pathsList.add(new Path(fromstop.getName(), tostop.getName(), stopTime.getDeparture_Time(), toStopTime.getArrival_Time(), cList ));
        }
      }
    }

    return null;
  }
}