package com.learning.cartservice.controller;

import com.learning.cartservice.model.Cart;
import com.learning.cartservice.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")
@Slf4j
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getAllCarts(){
        final Optional<List<Cart>> carts = this.cartService.getAllCartDetails();
        return carts.orElse(null);
    }

    @PostMapping
    public ResponseEntity<?> addCart(@RequestBody Cart cart){
        log.info("received post request details: {}", cart);
        return new ResponseEntity<>(this.cartService.addCartItem(cart), HttpStatus.CREATED);
    }


    @GetMapping("/{cartId}")
    public ResponseEntity<?> getCartDetailsByCartId(@PathVariable("cartId") int id){
        Cart cart = cartService.getCartDetailsByCartId(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/prime")
    public ResponseEntity<List<Cart>> getCartDetailsByPremiumCustomer(@RequestParam(value = "premium") String isPremium ){
        List<Cart> carts = cartService.getCartDetailsByPremiumMember(isPremium);
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<String> deleteCartByCartId(@PathVariable("cartId") int id){
        cartService.deleteCartByCartId(id);
        return new ResponseEntity<>("deleted the cart with given cart id: " + id , HttpStatus.ACCEPTED);
    }


    @PutMapping
    public ResponseEntity<Cart> updateCartDetails(@RequestBody Cart cart){
        Cart updatedCart = cartService.updateCartItemDetails(cart);
        return new ResponseEntity<>(updatedCart, HttpStatus.ACCEPTED);
    }
}
