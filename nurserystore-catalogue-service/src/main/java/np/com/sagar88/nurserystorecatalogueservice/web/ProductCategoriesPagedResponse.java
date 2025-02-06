package np.com.sagar88.nurserystorecatalogueservice.web;

import np.com.sagar88.nurserystorecatalogueservice.repository.dao.ProductCategory;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Sagar Subedi,
 * Date : 2023-08-29
 */
@Data
public class ProductCategoriesPagedResponse {
    
    Page<ProductCategory> page;
    Map<String, String> _links = new HashMap<>();
    
}
