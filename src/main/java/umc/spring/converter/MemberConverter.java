package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import umc.spring.domain.Member;
import umc.spring.web.dto.member.MemberRequest;
import umc.spring.web.dto.member.MemberResponse;

public class MemberConverter {
    public static MemberResponse.JoinResultDTO toMemberResponse(Member member) {
        return MemberResponse.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequest.JoinDTO request ) {
        return Member.builder()
                .address(request.getAddress())
                .memberPreferList(new ArrayList<>())
                .build();
    }

}
