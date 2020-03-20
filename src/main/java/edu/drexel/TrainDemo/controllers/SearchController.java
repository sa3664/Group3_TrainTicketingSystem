package edu.drexel.TrainDemo.controllers;

import java.util.ArrayList;
import java.util.List;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//import edu.drexel.TrainDemo.models.Route;
import edu.drexel.TrainDemo.models.SearchModel;
import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.models.CartItem;
import edu.drexel.TrainDemo.models.Path;
//import edu.drexel.TrainDemo.repositories.RouteRepository;
import edu.drexel.TrainDemo.repositories.StopRepository;
import edu.drexel.TrainDemo.services.PathService;

@Controller
@SessionAttributes(value = {"directpaths"})
public class SearchController {
    private StopRepository stopRepository;

    @Autowired
    private PathService pathService;
    
    @ModelAttribute("directpaths")
public List<Path> populatePaths() {
    return new ArrayList<Path>();
}
    public SearchController(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    

    @RequestMapping("/Search")
    public String Search(@ModelAttribute SearchModel searchModel, Model model) {
        Iterable<Stop> stops =  stopRepository.findAll();
        Iterable<Path> directpaths = pathService.getDirectPaths(searchModel.getFromStop(), searchModel.getToStop());

        Optional<Stop> sourceName = stopRepository.findById(searchModel.getFromStop());
        Optional<Stop> destinationName = stopRepository.findById(searchModel.getToStop());
        model.addAttribute("stops", stops);
        model.addAttribute("directpaths", directpaths);
        model.addAttribute("source", sourceName.get().getName());
        model.addAttribute("destination", destinationName.get().getName());
        model.addAttribute("CartItem", new CartItem());
        return "SearchResult";
        }
}