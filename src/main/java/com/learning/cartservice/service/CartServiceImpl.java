package com.learning.cartservice.service;

import com.learning.cartservice.exception.ItemNotFoundException;
import com.learning.cartservice.model.Cart;
import com.learning.cartservice.repo.CartRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class CartServiceImpl implements CartService{
    private final CartRepo cartRepo;
    @Autowired
    public CartServiceImpl(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    @Override
    public Cart addCartItem(Cart cart) {
        log.info("received post request details: {}", cart);
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

    @Override
    public Cart getCartDetailsByCartId(int id) {
        boolean existsById = cartRepo.existsById(id);
        if(existsById){
            return cartRepo.findById(id).get();
        }
        throw new ItemNotFoundException("The Cart Id You're looking for is not exists currently. Please try again later");
    }

    @Override
    public List<Cart> getCartDetailsByPremiumMember(String isPremium) {
        if(!(isPremium.equalsIgnoreCase("true") || isPremium.equalsIgnoreCase("false"))){
            throw new ItemNotFoundException("Please Select Valid Option for Premium, it should be either true or false");
        }
        Boolean res = isPremium.equalsIgnoreCase("true");
        return cartRepo.findCartByCustomer_isPremium(res);
    }

    @Override
    public boolean deleteCartByCartId(int id) {
        boolean existsById =  cartRepo.existsById(id);
        if (existsById){
            cartRepo.deleteById(id);
            return true;
        }
        throw new ItemNotFoundException("Given Cart Id not exists. Unable to Perform delete");

    }

    @Override
    public Cart updateCartItemDetails(Cart cart) {
        boolean existsById = cartRepo.existsById(cart.getCartId());
        if(existsById){
            return cartRepo.save(cart);
        }
        throw new ItemNotFoundException("Unable to perform the update because the given cart id not exists");
    }
}
