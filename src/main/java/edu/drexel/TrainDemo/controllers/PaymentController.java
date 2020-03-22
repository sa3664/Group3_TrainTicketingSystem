package edu.drexel.TrainDemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.drexel.TrainDemo.models.Response;
import edu.drexel.TrainDemo.services.StripeService;

@Controller
public class PaymentController {

    @Value("${stripe.keys.public}")
    private String API_PUBLIC_KEY;

    private StripeService stripeService;

    public PaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @GetMapping("/Payment")
    public String chargePage(Model model, @RequestParam(value = "cartTotal") String cartTotal) {
        model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
        model.addAttribute("cartTotal",  cartTotal);
        
        return "Payment";
    }

   
    @PostMapping("/create-charge")
    public @ResponseBody
    Response createCharge(String email, String token) {
        //validate data
        if (token == null) {
            return new Response(false, "Stripe payment token is missing. Please, try again later.");
        }

        //create charge
        String chargeId = stripeService.createCharge(email, token, 999); //$9.99 USD
        if (chargeId == null) {
            return new Response(false, "An error occurred while trying to create a charge.");
        }

        // You may want to store charge id along with order information

        return new Response(true, "Success! Your charge id is " + chargeId);
    }
}