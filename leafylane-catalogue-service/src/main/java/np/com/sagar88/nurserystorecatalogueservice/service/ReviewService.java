package np.com.sagar88.leafylanecatalogueservice.service;

import np.com.sagar88.leafylanecatalogueservice.repository.dao.Review;
import np.com.sagar88.leafylanecatalogueservice.web.CreateOrUpdateReviewRequest;

import java.util.List;

/**
 * @author Sagar Subedi, Date : 08-Nov-2024
 */
public interface ReviewService {

    void createOrUpdateReview(CreateOrUpdateReviewRequest createOrUpdateReviewRequest);

    List<Review> getReviewsForProduct(String productId);

}
