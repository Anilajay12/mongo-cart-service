package com.learning.cartservice.controller;

import com.learning.cartservice.model.Cart;
import com.learning.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getAllCarts(){
        final Optional<List<Cart>> carts = this.cartService.getAllCartDetails();
        if(carts.isPresent()){
            return carts.get();
        }
        else{
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<?> addCart(@RequestBody Cart cart){
        return new ResponseEntity<>(this.cartService.addCartItem(cart), HttpStatus.CREATED);
    }
}
