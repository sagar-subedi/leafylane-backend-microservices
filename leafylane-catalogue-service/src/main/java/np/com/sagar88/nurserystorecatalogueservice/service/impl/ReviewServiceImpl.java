package np.com.sagar88.leafylanecatalogueservice.service.impl;

import np.com.sagar88.leafylanecatalogueservice.feign.feign.AccountFeignClient;
import np.com.sagar88.leafylanecatalogueservice.repository.ReviewRepository;
import np.com.sagar88.leafylanecatalogueservice.repository.dao.Review;
import np.com.sagar88.leafylanecatalogueservice.service.ProductService;
import np.com.sagar88.leafylanecatalogueservice.service.ReviewService;
import np.com.sagar88.leafylanecatalogueservice.web.CreateOrUpdateReviewRequest;
import np.com.sagar88.leafylanecatalogueservice.web.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static np.com.sagar88.leafylanecatalogueservice.commons.util.CommonUtilityMethods.getUserIdFromToken;
import static np.com.sagar88.leafylanecatalogueservice.commons.util.CommonUtilityMethods.getUserNameFromToken;


/**
 * @author Sagar Subedi, Date : 08-Nov-2024
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    AccountFeignClient accountFeignClient;

    @Autowired
    ProductService productService;

    @Override
    public void createOrUpdateReview(CreateOrUpdateReviewRequest createOrUpdateReviewRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = getUserIdFromToken(authentication);
        String userNameFromToken = getUserNameFromToken(authentication);

        //check whether product exists.
        ProductResponse product = productService.getProduct(createOrUpdateReviewRequest.getProductId());
        if (product == null) {
            throw new RuntimeException("Product doesn't exist!");
        }

        Optional<Review> review = reviewRepository.findByUserIdAndProductId(userIdFromToken, createOrUpdateReviewRequest.getProductId());

        if (review.isPresent()) {
            Review updatedReview = review.get();
            updatedReview.setRatingValue(createOrUpdateReviewRequest.getRatingValue());
            updatedReview.setReviewMessage(createOrUpdateReviewRequest.getReviewMessage());
            reviewRepository.save(updatedReview);
        } else {
            Review newReview = Review.builder()
                    .reviewMessage(createOrUpdateReviewRequest.getReviewMessage())
                    .ratingValue(createOrUpdateReviewRequest.getRatingValue())
                    .userId(userIdFromToken)
                    .userName(userNameFromToken)
                    .productId(createOrUpdateReviewRequest.getProductId())
                    .build();
            reviewRepository.save(newReview);
        }
    }

    @Override
    public List<Review> getReviewsForProduct(String productId) {

        Optional<List<Review>> reviewsForProduct = reviewRepository.findAllByProductId(productId);
        return reviewsForProduct.orElseGet(ArrayList::new);

    }
}
