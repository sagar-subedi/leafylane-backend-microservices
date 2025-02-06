package np.com.sagar88.nurserystorecatalogueservice.service;

import np.com.sagar88.nurserystorecatalogueservice.repository.dao.ProductCategory;
import np.com.sagar88.nurserystorecatalogueservice.web.CreateProductCategoryRequest;
import np.com.sagar88.nurserystorecatalogueservice.web.UpdateProductCategoryRequest;
import org.springframework.data.domain.Page;

import jakarta.validation.Valid;

/**
 * @author: Sagar Subedi, Date : 2024-08-27
 */
public interface ProductCategoryService {

  String createProductCategory(@Valid CreateProductCategoryRequest createProductCategoryRequest);

  ProductCategory getProductCategory(String productCategoryId);

  void deleteProductCategory(String productCategoryId);

  void updateProductCategory(UpdateProductCategoryRequest updateProductCategoryRequest);

  Page<ProductCategory> getAllProductCategories(String sort, Integer page, Integer size);
}
