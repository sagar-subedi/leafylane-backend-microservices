package np.com.sagar88.nurserystoreorderservice.service;

import np.com.sagar88.nurserystoreorderservice.repository.dao.Cart;

/**
 * @author: Sagar Subedi,
 * Date : 2019-06-17
 */
public interface CartService {

    Cart getCart();
    
    Cart getCartByCartId(String cartId);

    String createCart();

    Cart getCartByUserName(String userName);

}
