package umc.spring.web.dto.member;

import java.util.List;
import lombok.Getter;
import umc.spring.domain.mapping.MemberPrefer;

public class MemberRequest {

    @Getter
    public static class JoinDTO{
        String name;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        List<Long> preferList;
    }
}
