package com.learning.cartservice.service;

import com.learning.cartservice.model.Cart;
import com.learning.cartservice.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CartServiceImpl implements CartService{
    private CartRepo cartRepo;
    @Autowired
    public CartServiceImpl(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    @Override
    public Cart addCartItem(Cart cart) {
        return this.cartRepo.save(cart);
    }

    @Override
    public Optional<List<Cart>> getAllCartDetails() {
        List<Cart> cartList = this.cartRepo.findAll();
        if(cartList.isEmpty())
            return Optional.empty();
        else
            return Optional.of(cartList);
    }
}
