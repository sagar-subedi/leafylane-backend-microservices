package np.com.sagar88.leafylane.orderservice.service.impl;

import np.com.sagar88.leafylane.orderservice.repository.CartRepository;
import np.com.sagar88.leafylane.orderservice.repository.dao.Cart;
import np.com.sagar88.leafylane.orderservice.repository.dao.CartItem;
import np.com.sagar88.leafylane.orderservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author: Sagar Subedi,
 * Date : 2019-07-08
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCart() {
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
    
        Cart cartByUserName = cartRepository.findCartByUserName(userName);

        synchronized (CartServiceImpl.class){
            if (cartByUserName == null) {
                createCart();
                cartByUserName = cartRepository.findCartByUserName(userName);
            }
        }
    
        double totalPrice = cartByUserName.getCartItems()
                                          .stream()
                                          .mapToDouble(CartItem::getExtendedPrice)
                                          .sum();
    
        cartByUserName.setTotalPrice(totalPrice);
    
        return cartByUserName;
    }
    
    @Override
    public Cart getCartByCartId(String cartId) {
        Optional<Cart> byCartId = cartRepository.findByCartId(cartId);
        return byCartId.orElseThrow(() -> new RuntimeException("Cart doesn't exist!!"));
    }

    @Override
    public String createCart() {

        //Get the userName from the token.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        Cart cartByUserName = cartRepository.findCartByUserName(userName);

        if (cartByUserName != null) {
            return cartByUserName.getCartId();
        }

        Cart cart = Cart.builder()
                .cartItems(new ArrayList<>())
                .userName(userName)
                .build();

        Cart savedCart = cartRepository.save(cart);

        return savedCart.getCartId();

    }


    public Cart getCartByUserName(String userName) {

        Cart cartByUserName = cartRepository.findCartByUserName(userName);
        return cartByUserName;
    }
}
