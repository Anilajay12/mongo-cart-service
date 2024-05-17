package com.learning.cartservice.repo;

import com.learning.cartservice.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends MongoRepository<Cart,Integer> {
    List<Cart> findCartByCustomer_isPremium(Boolean isPremium);
}
