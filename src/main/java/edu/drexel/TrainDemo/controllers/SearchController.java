package edu.drexel.TrainDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import edu.drexel.TrainDemo.models.Route;
import edu.drexel.TrainDemo.models.SearchModel;
import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.repositories.RouteRepository;
import edu.drexel.TrainDemo.repositories.StopRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class SearchController {
    private StopRepository stopRepository;
    
    public SearchController(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }


    @RequestMapping("/Search")
    public String Search(@ModelAttribute SearchModel searchModel, Model model) {
        Iterable<Stop> stops =  stopRepository.findAll();

        model.addAttribute("stops", stops);

        return "SearchResult";
    }
}