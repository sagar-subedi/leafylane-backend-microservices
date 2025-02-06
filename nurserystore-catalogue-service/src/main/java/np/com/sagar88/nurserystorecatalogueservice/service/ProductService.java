package np.com.sagar88.nurserystorecatalogueservice.service;

import np.com.sagar88.nurserystorecatalogueservice.repository.dao.Product;
import np.com.sagar88.nurserystorecatalogueservice.web.CreateProductRequest;
import np.com.sagar88.nurserystorecatalogueservice.web.ProductResponse;
import np.com.sagar88.nurserystorecatalogueservice.web.UpdateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.validation.Valid;

/**
 * @author: Sagar Subedi, Date : 2024-08-27
 */
public interface ProductService {

  String createProduct(@Valid CreateProductRequest createProductRequest);

  ProductResponse getProduct(String productId);

  void deleteProduct(String productId);

  void updateProduct(UpdateProductRequest updateProductRequest);

  Page<Product> findAllProducts(Pageable pageable);

  Page<ProductResponse> getAllProducts(String sort, Integer page, Integer size);
}
