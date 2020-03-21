package edu.drexel.TrainDemo.services;

import edu.drexel.TrainDemo.models.Cart;
import edu.drexel.TrainDemo.models.CartItem;
import org.springframework.stereotype.Service;


@Service
public interface CartService {
  
  void addItem(Cart cart, CartItem cartItem);
  void removeItem(Cart cart ,CartItem cartItem);
}

