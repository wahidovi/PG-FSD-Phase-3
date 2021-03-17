package com.sportyshoes.site.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.site.entity.Cart;
import com.sportyshoes.site.entity.CartItem;
import com.sportyshoes.site.entity.Product;
import com.sportyshoes.site.repository.CartDAO;
import com.sportyshoes.site.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CartController {
	
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/rest/cart/{cartId}")
	public Cart read(@PathVariable(value = "cartId") String cartId) {
		return cartDAO.read(cartId);
	}
	
	@PutMapping("/rest/cart/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart ) {
		cartDAO.update(cartId, cart);
	}
	
	@DeleteMapping("/rest/cart/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "cartId") String cartId) {
		cartDAO.delete(cartId);
	}
	
	
	@PutMapping(value="/rest/cart//add/{productId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable (value = "productId") Integer productId, HttpServletRequest request) {
        System.out.println("Add product is called");
		String sessionId = request.getSession(true).getId();
        Cart cart = cartDAO.read(sessionId);

        if(cart == null) {
            cart = cartDAO.create(new Cart(sessionId));
        }

        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            throw new IllegalArgumentException(new Exception());
        }

        cart.addCartItem(new CartItem(product));

        cartDAO.update(sessionId, cart);
    }

	@PutMapping(value="/rest/cart//remove/{productId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable (value = "productId") Integer productId, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
        Cart cart = cartDAO.read(sessionId);

        if(cart == null) {
            cart = cartDAO.create(new Cart(sessionId));
        }

        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            throw new IllegalArgumentException(new Exception());
        }

        cart.removeCartItem(new CartItem(product));

        cartDAO.update(sessionId, cart);
    }
	
	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server")
    public void handleServerErrors(Exception e){}

}
