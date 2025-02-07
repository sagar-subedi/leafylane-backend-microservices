package np.com.sagar88.nurserystoreorderservice.feign.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Sagar Subedi,
 * Date : 2024-06-04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {

    private String productId;
    private String productName;
    private String description;
    private double price;
    private String productCategory;
    private int availableItemCount;

}
