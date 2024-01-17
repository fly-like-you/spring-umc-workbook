package umc.spring.service;

import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.web.dto.member.MemberRequest;

@Service
public interface MemberQueryService {
    Member joinMember(MemberRequest.JoinDTO request);
}
