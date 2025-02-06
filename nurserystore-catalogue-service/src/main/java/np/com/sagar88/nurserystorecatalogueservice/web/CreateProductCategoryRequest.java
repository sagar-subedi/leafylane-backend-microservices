package np.com.sagar88.nurserystorecatalogueservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


/**
 * @author: Sagar Subedi,
 * Date : 2024-06-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductCategoryRequest {

    @NotNull(message = "productCategoryName should not be null!")
    @NotEmpty(message = "productCategoryName should not be empty!")
    private String productCategoryName;
    private String description;

}
