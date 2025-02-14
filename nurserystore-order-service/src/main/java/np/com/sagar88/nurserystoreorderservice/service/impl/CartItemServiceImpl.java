package np.com.sagar88.nurserystoreorderservice.service.impl;

import np.com.sagar88.nurserystoreorderservice.feign.feign.AccountFeignClient;
import np.com.sagar88.nurserystoreorderservice.feign.feign.CatalogFeignClient;
import np.com.sagar88.nurserystoreorderservice.feign.web.GetProductResponse;
import np.com.sagar88.nurserystoreorderservice.repository.CartItemRepository;
import np.com.sagar88.nurserystoreorderservice.repository.dao.Cart;
import np.com.sagar88.nurserystoreorderservice.repository.dao.CartItem;
import np.com.sagar88.nurserystoreorderservice.service.CartItemService;
import np.com.sagar88.nurserystoreorderservice.service.CartService;
import np.com.sagar88.nurserystoreorderservice.web.CartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: Sagar Subedi,
 * Date : 2019-07-13
 */
@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartService cartService;

    @Autowired
    CatalogFeignClient catalogFeignClient;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    AccountFeignClient accountFeignClient;

    @Override
    public void addCartItem(CartItemRequest cartItemRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        Cart cartByUserName = cartService.getCartByUserName(userName);

        synchronized (CartServiceImpl.class) {
            if (cartByUserName == null) {
                //create cart for user if not exists.
                cartService.createCart();
                cartByUserName = cartService.getCartByUserName(userName);
            }
        }
    
        GetProductResponse getProductResponse = catalogFeignClient.getProduct(cartItemRequest.getProductId());

        if (cartItemRequest.getQuantity() > getProductResponse.getAvailableItemCount()) {
            throw new RuntimeException("Quantity is greater than available item count!");
        }

        //If the product already exists in the cart, update its quantity and itemPrice.

        if (cartByUserName.getCartItems() != null) {
            for (CartItem ci : cartByUserName.getCartItems()) {
    
                if (getProductResponse.getProductId().equals(ci.getProductId())) {
                    ci.setQuantity(cartItemRequest.getQuantity());
                    ci.setItemPrice(getProductResponse.getPrice());
                    ci.setExtendedPrice(ci.getQuantity() * getProductResponse.getPrice());
                    cartItemRepository.save(ci);
                    return;
                }
            }
        }

        //If cart doesn't have any cartItems, then create cartItems.
        CartItem cartItem = CartItem.builder()
                                    .cart(cartByUserName)
                                    .itemPrice(getProductResponse.getPrice())
                                    .extendedPrice(cartItemRequest.getQuantity() * getProductResponse.getPrice())
                                    .quantity(cartItemRequest.getQuantity())
                                    .productId(getProductResponse.getProductId())
                                    .productName(getProductResponse.getProductName())
                                    .build();

        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(String cartItemId) {
        CartItem cartItem = this.getCartItem(cartItemId);
        cartItemRepository.delete(cartItem);
    }

    @Override
    public CartItem getCartItem(String cartItemId) {
        Optional<CartItem> byCartItemId = cartItemRepository.findByCartItemId(cartItemId);
        return byCartItemId.orElseThrow(()-> new RuntimeException("CartItem doesn't exist!!"));
    }

    @Override
    public void removeAllCartItems(String cartId) {

        Cart cart = cartService.getCartByCartId(cartId);
        List<String> cartItemIds = cart.getCartItems().stream().map(cartItem -> cartItem.getCartItemId()).collect(Collectors.toList());
        if (!cartItemIds.isEmpty()) {
            cartItemIds.forEach(this::removeCartItem);
        }
    }
}
