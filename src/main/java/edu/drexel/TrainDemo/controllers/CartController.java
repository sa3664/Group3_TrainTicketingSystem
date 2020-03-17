package edu.drexel.TrainDemo.controllers;

//import org.springframework.web.bind.annotation.*;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//import edu.drexel.TrainDemo.models.Route;
import edu.drexel.TrainDemo.models.SearchModel;
import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.models.CartItem;
import edu.drexel.TrainDemo.models.Path;
//import edu.drexel.TrainDemo.repositories.RouteRepository;
import edu.drexel.TrainDemo.repositories.StopRepository;
import edu.drexel.TrainDemo.services.PathService;

@Controller
public class CartController {
    private StopRepository stopRepository;

    @Autowired
    private PathService pathService;
    
    public CartController(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }


    @RequestMapping("/AddCartItem")
    public String AddCartItem(@ModelAttribute CartItem cartItem, Model model) {
        Iterable<Stop> stops =  stopRepository.findAll();
        model.addAttribute("stops", stops);
        return "AddCartItemResult";
        }
}