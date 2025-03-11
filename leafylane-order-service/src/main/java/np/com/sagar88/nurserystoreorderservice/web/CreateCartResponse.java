package np.com.sagar88.leafylaneorderservice.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Sagar Subedi,
 * Date : 2019-07-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCartResponse {
    private String cartId;
}
