package np.com.sagar88.leafylanecatalogueservice.web;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Sagar Subedi,
 * Date : 2023-08-29
 */
@Data
public class ProductsPagedResponse {

    Page<ProductResponse> page;
    Map<String, String> _links = new HashMap<>();
    
}
