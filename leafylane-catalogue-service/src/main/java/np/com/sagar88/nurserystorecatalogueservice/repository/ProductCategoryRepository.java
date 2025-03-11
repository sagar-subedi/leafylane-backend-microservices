package np.com.sagar88.leafylanecatalogueservice.repository;

import np.com.sagar88.leafylanecatalogueservice.repository.dao.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Sagar Subedi,
 * Date : 2024-06-06
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
}
