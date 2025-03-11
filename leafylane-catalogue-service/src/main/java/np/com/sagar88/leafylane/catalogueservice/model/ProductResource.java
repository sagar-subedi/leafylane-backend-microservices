package np.com.sagar88.leafylane.catalogueservice.model;

import np.com.sagar88.leafylane.catalogueservice.repository.dao.Product;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;


/**
 * @author: Sagar Subedi,
 * Date : 2023-08-27
 */
@Data
public class ProductResource extends EntityModel<Product> {
    
    private Pageable pageable;
    
    public ProductResource(Product content, Link... links) {
        EntityModel.of(content, links);
    }
}
