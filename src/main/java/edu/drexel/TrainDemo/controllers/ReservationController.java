package edu.drexel.TrainDemo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.drexel.TrainDemo.models.Cart;
import edu.drexel.TrainDemo.models.CartItem;
import edu.drexel.TrainDemo.models.Path;
import edu.drexel.TrainDemo.models.Reservation;
import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.repositories.ReservationRepository;
import edu.drexel.TrainDemo.repositories.StopRepository;
import edu.drexel.TrainDemo.services.CartService;

@Controller
@SessionAttributes(value = { "cart" })
public class ReservationController {
    
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private ReservationRepository reservationRepository;


    @ModelAttribute("cart")
    public Cart createCart() {
        return new Cart(new ArrayList<CartItem>());
    }

    @RequestMapping("/Ticket")
    public String generateTicket(@ModelAttribute("cart") Cart cart, Model model,  @RequestParam(value = "name") String name,  @RequestParam(value = "email") String email) {
        
        List<Reservation> reservations = new ArrayList<Reservation>();
        for (CartItem item : cart.getItems()) {
            
            Path path = item.getPath();

            Reservation res = new Reservation(name, path.getFromStop(), path.getToStop(),
                                 path.getArrivalTime(), path.getDepartureTime(), email);
            reservationRepository.save(res);
            reservations.add(res);
        }
     
       model.addAttribute("reservations", reservations);
       

        return "Ticket";

    }
}