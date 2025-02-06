package np.com.sagar88.nurserystorecatalogueservice.repository;

import np.com.sagar88.nurserystorecatalogueservice.repository.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Sagar Subedi,
 * Date : 2024-06-06
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
