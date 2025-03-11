package np.com.sagar88.leafylanecatalogueservice.repository.dao;

import np.com.sagar88.leafylanecatalogueservice.commons.DateAudit;
import np.com.sagar88.leafylanecatalogueservice.web.ProductResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author: Sagar Subedi,
 * Date : 2024-06-04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "PRODUCT")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PRODUCT_ID", updatable = false, nullable = false)
    private String productId;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "PRODUCT_IMAGE_ID")
    private String imageId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_CATEGORY_ID")
    private ProductCategory productCategory;

    @Column(name = "AVAILABLE_ITEM_COUNT")
    private int availableItemCount;

    public String getProductCategory() {
        return productCategory.getProductCategoryName();
    }

    public static ProductResponse fromEntity(Product product) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.convertValue(product, ProductResponse.class);
    }
}
