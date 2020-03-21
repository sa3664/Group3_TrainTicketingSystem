package edu.drexel.TrainDemo.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.nimbusds.oauth2.sdk.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import edu.drexel.TrainDemo.models.Cart;
import edu.drexel.TrainDemo.models.CartItem;
import edu.drexel.TrainDemo.models.Path;
import edu.drexel.TrainDemo.repositories.StopRepository;
import edu.drexel.TrainDemo.services.CartService;


@Controller
@SessionAttributes(value = {"cart"})
public class CartController {
    private StopRepository stopRepository;

    @Autowired
    private CartService cartService;
    
    @ModelAttribute("cart")
public Cart createCart() {
    return new Cart(new ArrayList<CartItem>());
}
    public CartController(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    

    @RequestMapping("/AddCartItem")
    public String AddCartItem(@SessionAttribute("directpaths") ArrayList<Path> directpaths, @ModelAttribute("CartItem") CartItem cartItem, Model model,HttpSession session) {
        cartItem.setPath(directpaths.get(cartItem.getIndex()));
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart != null)
            cartService.addItem(cart, cartItem);
        else{
            cart =  new Cart(new ArrayList<CartItem>());
            cartService.addItem(cart, cartItem);
        }

      // session.setAttribute("cart", cart);
       model.addAttribute("cart", cart);

        return "Checkout";


    }
    
    // @RequestMapping("/Checkout")
    // public String checkout(@SessionAttribute("cart") Cart cart, Model model,HttpSession session) {
    //               model.addAttribute("cart", cart);
    //         return "Checkout";
    //         }
        
}