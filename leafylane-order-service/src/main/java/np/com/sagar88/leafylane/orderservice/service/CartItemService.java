package np.com.sagar88.leafylane.orderservice.service;

import np.com.sagar88.leafylane.orderservice.repository.dao.CartItem;
import np.com.sagar88.leafylane.orderservice.web.CartItemRequest;

/**
 * @author: Sagar Subedi,
 * Date : 2019-06-17
 */
public interface CartItemService {

    void addCartItem(CartItemRequest cartItemRequest);
    void removeCartItem(String cartItemId);
    CartItem getCartItem(String cartItemId);
    void removeAllCartItems(String cartId);

}
