package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.List;
import umc.spring.domain.Review;
import umc.spring.web.dto.StoreRequest;
import umc.spring.web.dto.StoreResponse;

public class StoreConverter {

    public static Review toReview(StoreRequest.ReveiwDTO request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }

    public static StoreResponse.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponse.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreResponse.ReviewPreviewDTO reviewPreViewDTO(Review review){
        return null;
    }
    public static StoreResponse.ReviewPreviewListDTO reviewPreViewListDTO(List<Review> reviewList){
        return null;
    }
}