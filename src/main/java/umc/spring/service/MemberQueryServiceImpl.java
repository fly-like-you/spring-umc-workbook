package umc.spring.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.apiPayLoad.exception.handler.FoodCategoryHandler;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.web.dto.member.MemberRequest;

@Service
@AllArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final FoodCategoryRepository foodCategoryRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequest.JoinDTO request) {
        Member member = MemberConverter.toMember(request);
        List<FoodCategory> categories = request.getPreferList().stream()
                .map(category -> foodCategoryRepository.findById(category)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.TEMP_EXCEPTION)))
                .toList();

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(categories);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(member);});

        return memberRepository.save(member);
    }
}
