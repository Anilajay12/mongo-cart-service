package com.learning.cartservice.service;

import com.learning.cartservice.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Cart addCartItem(Cart cart);
    Optional<List<Cart>> getAllCartDetails();

    Cart getCartDetailsByCartId(int id);

    List<Cart> getCartDetailsByPremiumMember(String isPremium);

    boolean deleteCartByCartId(int id);

    Cart updateCartItemDetails(Cart cart);
}
