package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.web.dto.StoreRequest;
import umc.spring.web.dto.StoreResponse;
import umc.spring.web.dto.StoreResponse.ReviewPreviewDTO;

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

    public static StoreResponse.ReviewPreviewDTO reviewPreviewDTO(Review review){

        return StoreResponse.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static StoreResponse.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList){
        List<ReviewPreviewDTO> previewDTOs = reviewList.stream()
                .map(StoreConverter::reviewPreviewDTO).toList();

        return StoreResponse.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(previewDTOs.size())
                .reviewList(previewDTOs)
                .build();
    }
}