package edu.drexel.TrainDemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.function.Supplier;
import java.util.stream.Collectors;

import edu.drexel.TrainDemo.models.Connection;
import edu.drexel.TrainDemo.models.Path;
import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.models.StopTime;
import edu.drexel.TrainDemo.models.Trip;
import edu.drexel.TrainDemo.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.drexel.TrainDemo.models.StopTimeIdentity;

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
      if (stopTime.getId().getStop_id().equals(fromStop)) {
        Optional<StopTime> otoStopTime = stopTimeRepository
            .findById(new StopTimeIdentity(stopTime.getTrip_id(), toStop));
        StopTime toStopTime = otoStopTime.isPresent() ? otoStopTime.get() : null;

        if (toStopTime != null) {
          if (stopTime.getStop_Sequence() < toStopTime.getStop_Sequence()) {

            Stop fromstop = stopRepository.findById(fromStop).orElseThrow(RuntimeException::new);
            Stop tostop = stopRepository.findById(toStop).orElseThrow(RuntimeException::new);

            Trip trip = tripRepository.findById(stopTime.getTrip_id()).get();
            List<Connection> cList = new ArrayList<Connection>();
            cList.add(new Connection(trip, fromstop, tostop));
            pathsList.add(new Path(fromstop.getName(), tostop.getName(), stopTime.getDeparture_Time(),
                toStopTime.getArrival_Time(), cList));

          }
        }
      }

    }
    return pathsList;
  }

  @Override
  public List<Path> getConnectedPaths(String fromStop, String toStop) {
    Iterable<StopTime> tripsfromStop = stopTimeRepository.findAll();
    List<Path> pathsList = new ArrayList<Path>();
    List<Path> connectedpathsList = new ArrayList<Path>();

    for (StopTime stopTime : tripsfromStop) {
      if (stopTime.getId().getStop_id().equals(fromStop)) {
        Optional<StopTime> otoStopTime = stopTimeRepository
            .findById(new StopTimeIdentity(stopTime.getTrip_id(), toStop));
        StopTime toStopTime = otoStopTime.isPresent() ? otoStopTime.get() : null;

        if (toStopTime == null) {
          Iterable<StopTime> stopsOnTrip = stopTimeRepository.findAll();
          for (StopTime stop : stopsOnTrip) {
            if (stop.getId().getTrip_Id().equals(stopTime.getId().getTrip_Id())) {
              if (!stop.getId().getStop_id().equals(stopTime.getId().getStop_id())) {
                List<Path> connections = getDirectPaths(stop.getId().getStop_id(), toStop);
                List<Path> uConnections = connections.stream().distinct().collect(Collectors.toList());
                Stop fromstop = stopRepository.findById(fromStop).orElseThrow(RuntimeException::new);
                if (uConnections.size() > 0){
                  uConnections.get(0).setFromStop(fromstop.getName());
                  uConnections.get(0).setDepartureTime(stopTime.getDeparture_Time());
                  connectedpathsList.addAll(uConnections);
                }
              }
            }
          }

        }
      }

    }
    pathsList = connectedpathsList.stream().distinct().collect(Collectors.toList());
    return pathsList;
  }

}