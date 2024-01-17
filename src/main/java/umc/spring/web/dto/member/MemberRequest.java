package umc.spring.web.dto.member;

import java.util.List;
import lombok.Getter;
import umc.spring.domain.mapping.MemberPrefer;

public class MemberRequest {

    @Getter
    public static class JoinDTO{
        private String name;
        private String address;
        private Integer gender;
        private List<Long> preferList;
    }
}
