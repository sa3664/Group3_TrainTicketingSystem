package edu.drexel.TrainDemo.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import ch.qos.logback.core.joran.conditional.ElseAction;
import edu.drexel.TrainDemo.models.Cart;
import edu.drexel.TrainDemo.models.CartItem;
import edu.drexel.TrainDemo.models.Path;
import edu.drexel.TrainDemo.repositories.StopRepository;
import edu.drexel.TrainDemo.services.CartService;

@Controller
@SessionAttributes(value = { "cart" })
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

    @RequestMapping("/Cart")
    public String AddCartItem(@SessionAttribute("directpaths") ArrayList<Path> directpaths,
            @SessionAttribute("connectedpaths") ArrayList<Path> connectedpaths,
            @ModelAttribute("CartItem") CartItem cartItem, Model model, HttpSession session) {
        String index = cartItem.getIndex();
        Integer indexConverted = Integer.parseInt(index.substring(1));
        if (index.substring(0, 1).equals("D"))
        {
            cartItem.setPath(directpaths.get(indexConverted));
            // ToDO : get from pricing service
            cartItem.setPrice(99.99);
        }
            else
        {
            cartItem.setPath((connectedpaths.get(indexConverted)));
            // ToDO : get from pricing service
            cartItem.setPrice(69.99);

        }
        
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null)
            cartService.addItem(cart, cartItem);
        else {
            cart = new Cart(new ArrayList<CartItem>());
            cartService.addItem(cart, cartItem);
        }

        // session.setAttribute("cart", cart);
        model.addAttribute("cart", cart);

        return "Checkout";

    }

}