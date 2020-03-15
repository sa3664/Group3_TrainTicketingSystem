package edu.drexel.TrainDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.drexel.TrainDemo.models.SearchModel;
import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.repositories.StopRepository;


@Controller
public class HomeController {
    private StopRepository stopRepository;
    
    public HomeController(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }


    @RequestMapping("/")
    public String home(Model model) {
        Iterable<Stop> stops =  stopRepository.findAll();
        SearchModel searchModel = new SearchModel();
        model.addAttribute("stops", stops);
        model.addAttribute("SearchModel", searchModel);

        return "home";
    }
}