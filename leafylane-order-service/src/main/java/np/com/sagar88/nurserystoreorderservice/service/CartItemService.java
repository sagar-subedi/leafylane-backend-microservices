package np.com.sagar88.leafylaneorderservice.service;

import np.com.sagar88.leafylaneorderservice.repository.dao.CartItem;
import np.com.sagar88.leafylaneorderservice.web.CartItemRequest;

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
