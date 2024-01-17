package umc.spring.controller;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.service.MemberQueryService;
import umc.spring.web.dto.member.MemberRequest;
import umc.spring.web.dto.member.MemberResponse;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberRestController {
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponse.JoinResultDTO> joining(@Valid @RequestBody MemberRequest.JoinDTO request) {
        Member member = memberQueryService.joinMember(request);

        return ApiResponse.onSuccess(MemberConverter.toMemberResponse(member));

    }
}

