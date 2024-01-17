package umc.spring.web.dto.member;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

public class MemberResponse {

    @Builder
    public static class JoinResultDTO{
        private Long memberId;
        private LocalDateTime createdAt;
    }
}
