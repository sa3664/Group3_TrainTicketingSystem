package edu.drexel.TrainDemo.services;

import java.util.ArrayList;
import java.util.List;
import edu.drexel.TrainDemo.models.Cart;
import edu.drexel.TrainDemo.models.CartItem;

import edu.drexel.TrainDemo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {

  @Autowired
  private StopRepository stopRepository;
  @Autowired
  private StopTimeRepository stopTimeRepository;
  @Autowired
  private TripRepository tripRepository;

  @Override
  public void addItem(Cart cart, CartItem cartItem) {

List<CartItem> items = cart.getItems();
items.add(cartItem);
cart.setItems(items);
  }

  @Override
  public void removeItem(Cart cart, CartItem cartItem) {
  
    cart.getItems().remove(cartItem);

  }

  
}