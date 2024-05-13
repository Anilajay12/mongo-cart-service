package com.learning.cartservice.service;

import com.learning.cartservice.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Cart addCartItem(Cart cart);
    Optional<List<Cart>> getAllCartDetails();
}
